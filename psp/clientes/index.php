<?php
$numero = "";
if(isset($_GET['numero']))
    $numero = $_GET['numero'];

?>
<html>
    <h1>
        Tabla de multiplicar numero <?=$numero?>
    </h1>
    <table border=1>
        <?php
        if($numero == ""){
            echo "No se ha introducido ningun numero";
            exit();
        }
        for($i=0; $i<10; $i++){
            $resultado = $numero * $i;
            echo "<tr><td>$numero</td><td> x </td><td>$i</td><td> = </td><td>$resultado</td></tr>";
        }
    ?>
    </table>

</html>