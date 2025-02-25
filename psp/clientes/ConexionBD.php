<?php

class Conexion extends PDO
{
    const SERVIDOR_BD = 'localhost';
    const USUARIO_BD = 'root';
    const PASSWORD_BD = '';
    const BD = 'clientes';
    const DSN = "mysql:host=" . self::SERVIDOR_BD . ";dbname=" . self::BD . ";charset=utf8";

    public function __construct()
    {
        parent::__construct(self::DSN, self::USUARIO_BD, self::PASSWORD_BD);
    }
//aquí los métodos para el tratamiento de los datos
}

try {
    $con = new Conexion();
} catch (PDOException $ex) {
    exit ("Problemas: {$ex->getMessage()}");
}