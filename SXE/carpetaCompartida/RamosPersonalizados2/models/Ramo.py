from odoo import api, fields, models

class Ramo(models.Model):
    _name = "ramospersonalizados.ramo"
    _description = "Ramos personalizados"
    _rec_name = "IDRamo"

    IDRamo = fields.Integer(string="IDRamo", copy=False, default=0)
    #FloresID = fields.Many2many("ramos_personalizados.flor", string="Flores")
    #CreadorRamo = fields.Many2one("hr.employee", string="Creador Ramo")
    FechaCreacion = fields.Datetime(string="Fecha Creacion",  default=fields.Datetime.now)
    PrecioRamo = fields.Float(string="Precio Total")


