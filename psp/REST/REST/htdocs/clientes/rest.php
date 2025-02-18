<?php

$verbo=$_SERVER['REQUEST_METHOD'];
if(isset($_SERVER['PATH_INFO']))
	$uri=$_SERVER['PATH_INFO'];
else
	$uri='';
require 'conexionBD.php';

if($uri=='/clientes')
	switch($verbo){
		case 'GET':
			$sql='SELECT * FROM clientes ORDER BY nombre';
			$cursor=$con->query($sql);
			$clientes=[];
			while($cliente=$cursor->fetchObject())
				$clientes[]=$cliente;
			echo json_encode($clientes);
			break;
		case 'POST':
			parse_str(file_get_contents('php://input',true), $datos);
			$nombre=$datos['nombre'];
			$codProvincia=$datos['codProvincia'];
			$vip=$datos['vip'];
			$sql="INSERT INTO clientes (nombre,codProvincia,vip)
				  VALUES ('$nombre',$codProvincia,$vip)";
			$stmt=$con->query($sql);
			if($stmt->rowCount()==1) {
				$id=$con->lastInsertId();
				echo json_encode(['id'=>$id]);
				http_response_code(201);
			}
			else
				http_response_code(400);
			break;
		case 'DELETE':
			http_response_code(405);
			break;
	}
elseif(preg_match('#^/clientes/(\d+)/?$#',$uri,$g)) {
	$codCliente=$g[1];
  switch($verbo) {
	case 'GET':
	  $sql="SELECT * FROM clientes WHERE codCliente=$codCliente";
	  $cursor=$con->query($sql);
	  if($cliente=$cursor->fetchObject()) {
		http_response_code(200);
		echo json_encode($cliente);
	  }
	  else {
		http_response_code(404);
	  }
	  break;
	case 'POST':
	  http_response_code(405);
	  break;
	case 'DELETE':
		$sql="DELETE FROM clientes WHERE codCliente=$codCliente";
		$cursor=$con->query($sql);
		if($cursor->rowCount()==1)
			http_response_code(204);
		else
			http_response_code(404);
		break;
  }
}

?>
