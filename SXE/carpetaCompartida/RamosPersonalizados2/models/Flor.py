from odoo import api, fields, models
class Flor(models.Model):
    _name  = "ramospersonalizados.flor"
    _description = "flores"
    _rec_name = "nombre"

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
    #IDRamo = fields.Many2many("ramos_personalizados.ramo", string="Ramos", inverse="true")





    