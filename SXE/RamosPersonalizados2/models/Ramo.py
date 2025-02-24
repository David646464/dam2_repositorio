from odoo import api, fields, models

class Ramo(models.Model):
    _name = "ramospersonalizados.ramo"
    _description = "Ramos personalizados"
    _rec_name = "name"
    
    name = fields.Char(string="Nombre del ramo", required=True)
    precio = fields.Float(string="Precio", compute="_compute_precio", store=True)  # Precio total calculado
    flores_ids = fields.One2many('ramospersonalizados.ramoflor', 'ramo_id', string="Flores")  # Relación con flores

    @api.depends('flores_ids.precio_total')  # Dependiendo del precio de las flores y sus cantidades
    def _compute_precio(self):
        for ramo in self:
            ramo.precio = sum(flor.precio_total for flor in ramo.flores_ids)  # Sumar todos los precios de las flores
