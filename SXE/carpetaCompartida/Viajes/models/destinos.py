from odoo import fields, models

class destinos(models.Model):
    _name = "viajes.destinos"
    _description = "Información sobre las rutas"

    MatriculaAeronave = fields.Many2one('viajes.aeronaves', string = 'MatriculaAeronave', required=True, ondelete='cascade')
    Origen = fields.Char(string = "Origen",required=True)
    Destino = fields.Char(string = "Destino",required=True)
    FechaVuelo  = fields.Date(string ="Fecha_Vuelo",required=True)



