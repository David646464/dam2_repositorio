import re
from odoo import models, fields, api

class recetario(models.Model):
    _name = "recetas.recetario"
    _description = "Recetario del restaurante"
    _rec_name= "nombre"
    
    codigo = fields.Char(string="Código", required=True)
    nombre = fields.Char(string= "Nombre", required=True)
    descripcion = fields.Char(string = "Descripción")
    autoria = fields.Many2one(
        'hr.employee',
        string="Autor",
        domain=[('job_id.name', '=', 'Cocinero')]
    )
    ingredientes = fields.Many2many('recetas.ingredientes', required=True)
    tiempoPreparacion = fields.Integer(string = "Tiempo de preparación", required=True)
    calorias = fields.Integer(string = "Calorías", required=True)
    categoria = fields.Selection([
        ('desayuno', 'Desayuno'),
        ('almuerzo', 'Almuerzo'),
        ('cena', 'Cena'),
        ('postre', 'Postre')], string="Categoría", required=True)
    imagen = fields.Image(string = "Imagen")
    es_vegetariano = fields.Boolean(string="Es vegetariano el plato?")
    es_vegano = fields.Boolean(string="Es vegano el plato?")
    apto_celiacos = fields.Boolean(string="Posee gluten el plato?")
    
    @api.constrains('codigo')
    def _check_codigo_format(self):
        """
        Valida que el código cumpla con el formato 'PXX', donde XX son números del 0 al 9.
        """
        for rec in self:
            if not re.fullmatch(r'P\d{2}', rec.codigo):
                raise ValidationError("El código debe seguir el formato 'PXX', donde XX son números del 0 al 9.")