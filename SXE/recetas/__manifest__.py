{
    "name": "Recetas", #Nombre del modulo
    "summary": "Herramienta para gestionar recetas y sus ingredientes",
    "description": "Herramienta de Odoo para gestionar las recetas del restaurante y sus ingredientes",
    "version":  "17.0.1.0.0",
    "author": "Eloy Rodal Perez",
    "category": "Tools",
    "license": "AGPL-3",
    "depends": ["base"],  #Modulos con los que voy a interactuar
    "data" : [
        "security/ir.model.access.csv",
        "views/recetario.xml",
        "views/ingredientes.xml",
        "views/menurestaurante.xml"
    ],
    "application": True,
    "installable": True
}