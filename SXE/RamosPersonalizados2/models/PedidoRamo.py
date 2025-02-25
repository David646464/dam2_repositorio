from odoo import api, fields, models  # Importación correcta

class PedidoRamo(models.Model):
    _name = "ramospersonalizados.pedidoramo"
    _description = "Relación entre Pedido y Ramo"
    
    pedido_id = fields.Many2one('ramospersonalizados.pedido', string="Pedido", required=True)  # Relación con pedido
    ramo_id = fields.Many2one('ramospersonalizados.ramo', string="Ramo", required=True)  # Relación con ramo
    cantidad = fields.Integer(string="Cantidad", default=1, required=True)  # Cantidad de ramos en el pedido
    precio_total = fields.Float(string="Precio Total", compute="_compute_precio_total", store=True)  # Precio total de los ramos en el pedido

    @api.depends('ramo_id.precio', 'cantidad')  # Dependiendo del precio del ramo y la cantidad
    def _compute_precio_total(self):
        for record in self:
            record.precio_total = record.ramo_id.precio * record.cantidad  # Calcular el precio total de los ramos en el pedido
