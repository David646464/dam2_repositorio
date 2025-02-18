from odoo import api, fields, models
class Flor(models.Model):
    _name  = "ramos_personalizados.flor"
    _description = "flores"
    _rec_name = "IDflor"
    
    
    IDflor = fields.Integer(string="IDflor", readonly=True, copy=False, default=0)
    nombre = fields.Char(string="Nombre", required=True)
    color = fields.Selection(
        selection=[
            ('rojo', 'Rojo'),
            ('rosa', 'Rosa'),
            ('amarillo', 'Amarillo'),
            ('blanco', 'Blanco'),
            ('morado', 'Morado'),
            ('azul', 'Azul'),
            ('naranja', 'Naranja'),
            ('verde', 'Verde'),
            ('violeta', 'Violeta'),
            ('magenta', 'Magenta'),
        ],
        string="Color de la Flor"
    )
    precio = fields.Float(string="Precio_Unidad", required=True)
    stock = fields.Boolean(string="Disponible", default=False)
    IDRamo = fields.Many2many("ramos_personalizados.ramo", string="Ramos")



    @api.model
    def create(self, vals):
        vals['IDflor'] = self.env['ir.IDflor'].next_by_code('ramos_personalizados.flor".IDflor') or 0
        return super(Flor, self).create(vals)

    @api.constrains('nombre', 'color','precio')
    def _check_required_fields(self):
        for record in self:
            if not record.nombre or record.precio <= 0 or record.color:
                raise ValidationError("Todos los campos deben estar completos y tener valores válidos.")

    