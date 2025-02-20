from odoo import fields, models, api

class angares(models.Model):
    _name = 'viajes.angares'
    _description = 'Angares de aviones'
    _rec_name = 'Lugar'

    Lugar = fields.Char(string="Lugar", required=True)
    Nombre = fields.Char(string="Nombre", required=True)
    FechaConstruccion = fields.Date(string="Fecha_Construccion", required=True)

