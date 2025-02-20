{
    "name": "Viajes",  # Nombre del Modulo
    "summary": "Herramienta para gestionar Viajes",  # Module subtitle phrase
    "description": "Herramienta para manejar los Viajes",
    # Supports reStructuredText(RST) format (description is Deprecated)
    "version": "17.0.1.0.0",
    "author": "david Sánchez Peso",
    "category": "Tools",
    "license": "AGPL-3",
    "depends": ["base"],  # Modulos con los que voy a interactuar
    "data": [
        'security/ir.model.access.csv',
        'views/ViewAeronaves.xml',
        'views/ViewDestinos.xml',
        'views/ViewAngares.xml'
    ],
    # This demo data files will be loaded if db initialize with demo data (commented because file is not added in this example)
    # 'demo': [
    #    'demo.xml'
    # ],

}
