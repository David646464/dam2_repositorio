//David Sánchez peso 77465294Y
package examen.Mains;

import examen.DataBaseManager.DataBasemanager;
import examen.Objects.CasaRural;
import examen.Objects.Hotel;
import examen.Objects.HotelSpa;

import java.sql.SQLException;

public class EJERCICIO1 {
    public static void main(String[] args) throws SQLException {
        DataBasemanager dataBasemanager = new DataBasemanager();
        dataBasemanager.crearFuncionNombreExiste();
        CasaRural casaRural = new CasaRural("pruebaCasaRural", "direccionPrueba1", "localidadPrueba1", "123456789", 200.55, 30.88, 5, 'S');
        CasaRural casaRural2 = new CasaRural("pruebaCasaRural1", "direccionPrueba1", "localidadPrueba1", "123456789", 200.55, 30.88, 5, 'S');
        Hotel hotel = new Hotel("pruebaHotel", "direccionPrueba2", "localidadPrueba2", "123456789", 200.55, 30.88, 5, 4, 10);
        Hotel hotel2 = new Hotel("pruebaHotel1", "direccionPrueba2", "localidadPrueba2", "123456789", 200.55, 30.88, 5, 4, 10);

        HotelSpa hotelSpa = new HotelSpa("pruebaHotelSpa2", "direccionPrueba3", "localidadPrueba3", "123456789", 200.55, 30.88, 5, 3, 15, 'N', 30);
        HotelSpa hotelSpaErr = new HotelSpa("pruebaHotelSpa3", "direccionPrueba3", "localidadPrueba3", "123456789", 200.55, 30.88, 5, 3, 123456, 'N', 30);

        dataBasemanager.insertarAlojamiento(casaRural);
        dataBasemanager.insertarAlojamiento(casaRural2);
        dataBasemanager.insertarAlojamiento(hotel);
        dataBasemanager.insertarAlojamiento(hotel2);

        dataBasemanager.insertarAlojamiento(hotelSpa);
        dataBasemanager.insertarAlojamiento(hotelSpaErr);

    }
}
