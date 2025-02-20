from odoo import models, fields, api

class menurestaurante(models.Model):
    _name = "recetas.menurestaurante"
    _description = "Menús del Restaurante"
    _rec_name= "nombre"

    nombre = fields.Char(string="Nombre del Menú", required=True)
    descripcion = fields.Text(string="Descripción del Menú")
    
    recetas = fields.Many2many("recetas.recetario", string="Recetas Incluidas", required=True)

    precio = fields.Float(string="Precio (€)", required=True)
    en_oferta = fields.Boolean(string="Está en oferta?")
    precio_oferta = fields.Float(string="Precio en Oferta (€)", compute="_compute_precio_oferta", store=True)

    fecha_inicio = fields.Date(string="Fecha de Inicio de Oferta")
    fecha_fin = fields.Date(string="Fecha de Fin de Oferta")

    es_vegetariano = fields.Boolean(string="Menú Vegetariano")
    es_vegano = fields.Boolean(string="Menú Vegano")
    apto_celiacos = fields.Boolean(string="Apto para Celíacos")

    notas = fields.Text(string="Notas Adicionales")

    @api.depends("en_oferta", "precio")
    def _compute_precio_oferta(self):
        """Calcula el precio en oferta si el menú está en oferta."""
        for menu in self:
            if menu.en_oferta:
                menu.precio_oferta = menu.precio * 0.8
            else:
                menu.precio_oferta = menu.precio

    @api.model
    def create(self, vals):
        """Validar que la fecha de inicio no sea posterior a la fecha de fin."""
        if vals.get("fecha_inicio") and vals.get("fecha_fin"):
            if vals["fecha_inicio"] > vals["fecha_fin"]:
                raise ValueError("La fecha de inicio no puede ser posterior a la fecha de fin.")
        return super(menurestaurante, self).create(vals)