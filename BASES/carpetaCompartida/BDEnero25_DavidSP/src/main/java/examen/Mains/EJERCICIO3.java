//David Sánchez peso 77465294Y
package examen.Mains;

import examen.DataBaseManager.DataBasemanager;

import java.sql.SQLException;

public class EJERCICIO3 {
    public static void main(String[] args) throws SQLException {
        DataBasemanager dataBasemanager = new DataBasemanager();
        dataBasemanager.actualizarPreciosDesdeJson("src/files/AlojamientosPrecios.json");
    }
}
