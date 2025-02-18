from odoo import api, fields, models

class Pedido(models.Model):
    _name  = "ramos_personalizados.pedido"
    _description = "pedidos"

    IDPedido = fields.Integer(string="IDPedido", readonly=True, copy=False, default=0)
    ramosID = fields.One2many("ramos_personalizados.ramo",string ="Ramos")
    precioTotal = fields.Float(string= "precio_Total", compute="_compute_total_price", store = True)


    @api.model
    def create(self, vals):
        vals['IDPedido'] = self.env['ir.IDPedido'].next_by_code('ramos_personalizados.pedido".IDPedido') or 0
        return super(Pedido, self).create(vals)
    
    @api.depends("ramos_personalizados.ramo")
    def _compute_total_price(self):
        for Pedido in self:
            Pedido.precioTotal = sum(Pedido.ramosID.mapped("PrecioRamo"))