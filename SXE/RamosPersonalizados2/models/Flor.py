from odoo import api, fields, models

# Modelo Flor
class Flor(models.Model):
    _name = "ramospersonalizados.flor"
    _description = "Flores"
    _rec_name = "name"
    
    name = fields.Char(string="Nombre de la flor", required=True)
    color = fields.Char(string="Color")
    precio = fields.Float(string="Precio por unidad", required=True)  # Precio de cada flor
