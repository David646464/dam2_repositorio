from odoo import api, fields, models

class RamoFlor(models.Model):
    _name = "ramospersonalizados.ramoflor"
    _description = "Relación entre Ramo y Flor"
    
    ramo_id = fields.Many2one('ramospersonalizados.ramo', string="Ramo", required=True)  # Relación con ramo
    flor_id = fields.Many2one('ramospersonalizados.flor', string="Flor", required=True)  # Relación con flor
    cantidad = fields.Integer(string="Cantidad", default=1, required=True)  # Cantidad de flores
    precio_total = fields.Float(string="Precio Total", compute="_compute_precio_total", store=True)  # Precio total de esta flor en el ramo

    @api.depends('flor_id.precio', 'cantidad')  # Dependiendo del precio de la flor y la cantidad
    def _compute_precio_total(self):
        for record in self:
            record.precio_total = record.flor_id.precio * record.cantidad  # Calcular el precio total
