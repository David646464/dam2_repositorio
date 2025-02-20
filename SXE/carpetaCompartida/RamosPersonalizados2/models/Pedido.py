from odoo import api, fields, models

class Pedido(models.Model):
    _name  = "ramospersonalizados.pedido"
    _description = "pedidos"



    IDPedido = fields.Integer(string="IDPedido",default=0)
    #ramosID = fields.One2many("ramos_personalizados.ramo",string ="Ramos")
    precioTotal = fields.Float(string= "precio_Total")
