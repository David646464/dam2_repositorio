from odoo import fields, models, api


class aeronaves(models.Model):
    _name = 'viajes.aeronaves'
    _description = 'Aviones para volar'
    _rec_name = 'Matricula'

    Nombre = fields.Char(string="Nombre", required=True)
    Matricula = fields.Char(string="Matricula", required=True)
    FechaCompra = fields.Date(string="Fecha_Compra", required=True)
    NumeroKMActual = fields.Float(string="Numero_KM_Actual", default=0, required=True)
    Angar = fields.Many2one('viajes.angares', string = 'Angar', required=True, ondelete='cascade')

    @api.constrains("Matricula")
    def _check_matricula(self):
        for record in self:
            if len(record.Matricula) != 7:
                raise models.ValidationError("La matricula debe tener 7 caracteres")
