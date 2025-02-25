from odoo import api, fields, models

class Pedido(models.Model):
    _name = "ramospersonalizados.pedido"
    _description = "Pedidos de Ramos Personalizados"
    
    name = fields.Char(string="Nombre del Pedido", required=True)
    empleado_id = fields.Many2one('hr.employee', string="Empleado Responsable")  # Relación con el empleado
    ramo_ids = fields.One2many('ramospersonalizados.pedidoramo', 'pedido_id', string="Ramos")  # Relación con los ramos
    total = fields.Float(string="Total", compute="_compute_total", store=True)  # Total del pedido calculado

    @api.depends('ramo_ids.precio_total')  # Dependiendo del precio total de los ramos y las cantidades
    def _compute_total(self):
        for pedido in self:
            pedido.total = sum(ramo.precio_total for ramo in pedido.ramo_ids)  # Sumar todos los precios de los ramos
