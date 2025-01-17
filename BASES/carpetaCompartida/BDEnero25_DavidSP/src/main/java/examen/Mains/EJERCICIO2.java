//David Sánchez peso 77465294Y
package examen.Mains;

import examen.DataBaseManager.DataBasemanager;

import java.sql.SQLException;

public class EJERCICIO2 {
    public static void main(String[] args) throws SQLException {
        DataBasemanager dataBasemanager = new DataBasemanager();
        dataBasemanager.darDeBajaAlojamiento("Lolailo");
        //Probar con casa rural
        dataBasemanager.darDeBajaAlojamiento("Cachamuiña");
        //Probar con hotel spa
        dataBasemanager.darDeBajaAlojamiento("Muralla Romana");
        //Probar con hotel
        dataBasemanager.darDeBajaAlojamiento("A solaina");



    }
}
