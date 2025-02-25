<?php
require 'ConexionBD.php';

$verbo = $_SERVER['REQUEST_METHOD'];
$uri = isset($_SERVER['PATH_INFO']) ? trim($_SERVER['PATH_INFO'], '/') : '';

$rutas = $uri == null ? [] : explode('/', $uri);

try {
    $con = new Conexion();
} catch (PDOException $ex) {
    exit ("Problemas: {$ex->getMessage()}");
}

function getClientes($con): array
{
    $sql = "SELECT * FROM clientes";
    $cursor = $con->query($sql);
    return $cursor->fetchAll(PDO::FETCH_OBJ);
}

function getProvincias(Conexion $con): array
{
    $sql = "SELECT * FROM provincias";
    $cursor = $con->query($sql);
    return $cursor->fetchAll(PDO::FETCH_OBJ);
}

switch ($verbo) {
    case "GET":
        if (count($rutas) == 1) {
            if ($rutas[0] == 'clientes') {
                $clientes = getClientes($con);
                http_response_code(200);
                header('Content-Type: application/json');
                echo json_encode($clientes, JSON_PRETTY_PRINT);
            } elseif ($rutas[0] == 'provincias') {
                $provincias = getProvincias($con);
                http_response_code(200);
                header('Content-Type: application/json');
                echo json_encode($provincias, JSON_PRETTY_PRINT);
            } else {
                exit("Ruta no encontrada");
            }
        } else {
            exit("No hay datos");
        }
        break;

    case "POST":
        if (count($rutas) == 1 && $rutas[0] == 'clientes') {
            $datos = json_decode(file_get_contents('php://input'), true);
            $sql = "INSERT INTO clientes (nombre, apellidos, direccion, poblacion, provincia, telefono, email) VALUES (:nombre, :apellidos, :direccion, :poblacion, :provincia, :telefono, :email)";
            $stmt = $con->prepare($sql);
            $stmt->execute($datos);
            http_response_code(201);
            header('Content-Type: application/json');
            echo json_encode($datos, JSON_PRETTY_PRINT);
        } else {
            exit("Ruta no encontrada o método no permitido");
        }
        break;

    default:
        exit("Método no permitido");
}