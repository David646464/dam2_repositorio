from odoo import api, fields, models

class Ramo(models.Model):
    _name = "ramos_personalizados.ramo"
    _description = "Ramos personalizados"
    _rec_name = "IDRamo"

    IDRamo = fields.Integer(string="IDRamo", readonly=True, copy=False, default=0)
    FloresID = fields.Many2many("ramos_personalizados.flor", string="Flores")
    CreadorRamo = fields.Many2one("hr.employee", string="Creador Ramo")
    FechaCreacion = fields.Datetime(string="Fecha Creacion", readonly=True, default=fields.Datetime.now)
    PrecioRamo = fields.Float(string="Precio Total", compute="_compute_total_price", store=True)

    @api.model
    def create(self, vals):
        vals['IDRamo'] = self.env['ir.sequence'].next_by_code('ramos_personalizados.ramo') or 0
        return super(Ramo, self).create(vals)

    @api.depends("FloresID")
    def _compute_total_price(self):
        for ramo in self:
            ramo.PrecioRamo = sum(ramo.FloresID.mapped("precio"))
