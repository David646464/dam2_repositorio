<?php
$servidor='localhost';
$bd='clientes';
$usuario='root';
$contraseña='';
$dsn = "mysql:host=$servidor;dbname=$bd";
try {
 $con=new PDO($dsn, $usuario, $contraseña);
}
catch (PDOException $ex) {
	exit('No se ha podido conectar con la BD:<br/>'.$ex->getMessage());
}
?>