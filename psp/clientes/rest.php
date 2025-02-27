<?php
require 'ConexionBD.php';

function getCursosDeCliente($con, $clienteId): array
{
    $sql = "SELECT c.id, c.nombre, c.numHoras FROM curso c
            INNER JOIN curso_cliente cc ON c.id = cc.curso_id
            WHERE cc.cliente_id = :clienteId";
    $stmt = $con->prepare($sql);
    $stmt->bindParam(':clienteId', $clienteId, PDO::PARAM_INT);
    $stmt->execute();
    return $stmt->fetchAll(PDO::FETCH_OBJ);
}



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
        } elseif (count($rutas) == 3 && $rutas[0] == 'clientes' && $rutas[2] == 'cursos') {
            $clienteId = $rutas[1];
            $cursos = getCursosDeCliente($con, $clienteId);
            http_response_code(200);
            header('Content-Type: application/json');
            echo json_encode($cursos, JSON_PRETTY_PRINT);
        } else {
            exit("No hay datos");
        }
        break;

    case "POST":
        if (count($rutas) == 1 && $rutas[0] == 'clientes') {
            $nombre = $_POST['nombre'];
            $codProvincia = $_POST['codProvincia'];
            $vip = $_POST['vip'];

            $sql = "INSERT INTO clientes (nombre, codProvincia, vip) VALUES (:nombre, :codProvincia, :vip)";
            $stmt = $con->prepare($sql);
            $stmt->bindParam(':nombre', $nombre);
            $stmt->bindParam(':codProvincia', $codProvincia);
            $stmt->bindParam(':vip', $vip);
            $stmt->execute();

            $lastId = $con->lastInsertId();

            http_response_code(201);
            header('Content-Type: application/json');
            echo json_encode(["message" => "Inserción correcta", "codCliente" => $lastId], JSON_PRETTY_PRINT);
        } else {
            exit("Ruta no encontrada o método no permitido");
        }
        break;


   case "DELETE":
    if (count($rutas) == 2 && $rutas[0] == 'clientes') {
        $id = $rutas[1];
        $sql = "DELETE FROM clientes WHERE codCliente = :id";
        $stmt = $con->prepare($sql);
        $stmt->bindParam(':id', $id, PDO::PARAM_INT);
        $stmt->execute();
        if ($stmt->rowCount() > 0) {
            http_response_code(204);
        } else {
            http_response_code(404);
            echo json_encode(["message" => "Cliente no encontrado"], JSON_PRETTY_PRINT);
        }
    } else if (count($rutas) == 4 && $rutas[0] == 'clientes' && $rutas[2] == 'cursos') {
        $clienteId = $rutas[1];
        $cursoId = $rutas[3];
        $sql = "DELETE FROM curso_cliente WHERE cliente_id = :clienteId AND curso_id = :cursoId";
        $stmt = $con->prepare($sql);
        $stmt->bindParam(':clienteId', $clienteId, PDO::PARAM_INT);
        $stmt->bindParam(':cursoId', $cursoId, PDO::PARAM_INT);
        $stmt->execute();
        if ($stmt->rowCount() > 0) {
            http_response_code(204);
        } else {
            http_response_code(404);
            echo json_encode(["message" => "Curso no encontrado para el cliente"], JSON_PRETTY_PRINT);
        }
    } else {
        exit("Ruta no encontrada o método no permitido");
    }
    break;

    default:
        exit("Método no permitido");
}