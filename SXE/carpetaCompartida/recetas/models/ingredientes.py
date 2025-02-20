import re
from odoo import models, fields, api
from odoo.exceptions import ValidationError

class Ingredientes(models.Model):
    _name = "recetas.ingredientes"
    _description = "Ingredientes del recetario"
    _rec_name= "nombre"

    codigo = fields.Char(string="Código", required=True)
    nombre = fields.Char(string="Nombre", required=True, unique=True)
    descripcion = fields.Text(string="Descripción")
    categoria = fields.Selection([
        ('vegetal', 'Vegetal'),
        ('fruta', 'Fruta'),
        ('cereal', 'Cereal'),
        ('carne', 'Carne'),
        ('pescado', 'Pescado'),
        ('lacteo', 'Lácteo'),
        ('huevo', 'Huevo'),
        ('legumbre', 'Legumbre'),
        ('condimento', 'Condimento'),
        ('otro', 'Otro')
    ], string="Categoría", required=True)
    unidad_medida = fields.Selection([
        ('gramos', 'Gramos'),
        ('mililitros', 'Mililitros'),
        ('piezas', 'Piezas'),
        ('cucharadas', 'Cucharadas'),
        ('tazas', 'Tazas')
    ], string="Unidad de medida", required=True)
    calorias_por_unidad = fields.Float(string="Calorías por unidad", required=True)
    es_organico = fields.Boolean(string="¿Es orgánico?")
    contiene_gluten = fields.Boolean(string="¿Contiene gluten?")
    es_alergenico = fields.Boolean(string="¿Es un alérgeno?")
    recetas_relacionadas = fields.Many2many("recetas.recetario", string="Usado en recetas")

    @api.constrains('calorias_por_unidad')
    def _check_calorias(self):
        """
        Asegura que las calorías por unidad no sean negativas.
        """
        for ingrediente in self:
            if ingrediente.calorias_por_unidad < 0:
                raise ValidationError("Las calorías no pueden ser negativas.")
            
    @api.constrains('codigo')
    def _check_codigo_format(self):
        """
        Valida que el código cumpla con el formato 'IXX', donde XX son números del 0 al 9.
        """
        for rec in self:
            if not re.fullmatch(r'I\d{2}', rec.codigo):
                raise ValidationError("El código debe seguir el formato 'IXX', donde XX son números del 0 al 9.")