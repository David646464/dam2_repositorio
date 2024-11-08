package com.example.elecciones.Database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.elecciones.Objects.Candidato;
import com.example.elecciones.Objects.Partido;
import com.example.elecciones.Objects.Usuario;
import com.example.elecciones.Utils.Hash;

import java.util.ArrayList;

public class DatabaseManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mydatabase2.db";
    // Versión de la base de datos (cambiarlo cada vez que se realice un cambio en el esquema)
    private static final int DATABASE_VERSION = 1;
    private static DatabaseManager instance;
    private static  SQLiteDatabase db;

    private DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }




    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE2 = "CREATE TABLE partido (id INTEGER PRIMARY KEY AUTOINCREMENT, nombrePartido TEXT, siglas TEXT,color TEXT)";
        sqLiteDatabase.execSQL(CREATE_TABLE2);
        String CREATE_TABLE3 = "CREATE TABLE candidato (id INTEGER PRIMARY KEY AUTOINCREMENT,nif TEXT, password TEXT, nombre TEXT, apellido1 TEXT, apellido2 TEXT, edad INTEGER, partido_id INTEGER,votos int, votosReaelizados int, FOREIGN KEY(partido_id) REFERENCES partido(id))";
        sqLiteDatabase.execSQL(CREATE_TABLE3);
        String CREATE_TABLE = "CREATE TABLE usuario (id INTEGER PRIMARY KEY AUTOINCREMENT,nif TEXT, password TEXT, nombre TEXT, apellido1 TEXT, apellido2 TEXT, edad INTEGER,votosReaelizados int)";
        sqLiteDatabase.execSQL(CREATE_TABLE);

        //Partidos
        sqLiteDatabase.execSQL("INSERT INTO partido (nombrePartido, siglas, color) VALUES ('Partido Popular', 'PP', 'Azul')");
        sqLiteDatabase.execSQL("INSERT INTO partido (nombrePartido, siglas, color) VALUES ('Partido Socialista Obrero Español', 'PSOE', 'Rojo')");
        sqLiteDatabase.execSQL("INSERT INTO partido (nombrePartido, siglas, color) VALUES ('Unidas Podemos', 'UP', 'Morado')");

        //Candidatos
        sqLiteDatabase.execSQL("INSERT INTO candidato (nif, password, nombre, apellido1, apellido2, edad, partido_id, votos, votosReaelizados) VALUES ('12345678A', '" + Hash.hash("12345678A")+"', 'Pablo', 'Casado', 'Blanco', 40, 1, 0, 0)");
        sqLiteDatabase.execSQL("INSERT INTO candidato (nif, password, nombre, apellido1, apellido2, edad, partido_id, votos, votosReaelizados) VALUES ('87654321B', '" + Hash.hash("87654321B") + "', 'Pedro', 'Sánchez', 'Pérez-Castejón', 49, 2, 0, 0)");
        sqLiteDatabase.execSQL("INSERT INTO candidato (nif, password, nombre, apellido1, apellido2, edad, partido_id, votos, votosReaelizados) VALUES ('12348765C', '" + Hash.hash("12348765C") + "', 'Pablo', 'Iglesias', 'Turrión', 42, 3, 0, 0)");
        sqLiteDatabase.execSQL("INSERT INTO candidato (nif, password, nombre, apellido1, apellido2, edad, partido_id, votos, votosReaelizados) VALUES ('12345678D', '" + Hash.hash("12345678D") + "', 'Albert', 'Rivera', 'Díaz', 41, 1, 0, 0)");
        sqLiteDatabase.execSQL("INSERT INTO candidato (nif, password, nombre, apellido1, apellido2, edad, partido_id, votos, votosReaelizados) VALUES ('87654321E', '" + Hash.hash("87654321E") + "', 'Inés', 'Arrimadas', 'García', 38, 2, 0, 0)");
        sqLiteDatabase.execSQL("INSERT INTO candidato (nif, password, nombre, apellido1, apellido2, edad, partido_id, votos, votosReaelizados) VALUES ('12348765F', '" + Hash.hash("12348765F") + "', 'Santiago', 'Abascal', 'Conde', 44, 3, 0, 0)");

        //Usuarios
        sqLiteDatabase.execSQL("INSERT INTO usuario (nif, password, nombre, apellido1, apellido2, edad, votosReaelizados) VALUES ('12345678A', '"+Hash.hash("12348765C")+"', 'Pablo', 'Casado', 'Blanco', 40, 0)");
        sqLiteDatabase.execSQL("INSERT INTO usuario (nif, password, nombre, apellido1, apellido2, edad, votosReaelizados) VALUES ('87654321B', '"+Hash.hash("87654321B")+"', 'Pedro', 'Sánchez', 'Pérez-Castejón', 49, 0)");
        sqLiteDatabase.execSQL("INSERT INTO usuario (nif, password, nombre, apellido1, apellido2, edad, votosReaelizados) VALUES ('12348765C', '"+Hash.hash("12348765C")+"', 'Pablo', 'Iglesias', 'Turrión', 42, 0)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS partido");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS candidato");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS usuario");
        onCreate(sqLiteDatabase);
    }

    public static synchronized DatabaseManager getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseManager(context.getApplicationContext());
            db = instance.getWritableDatabase();
        }
        return instance;
    }

    public static synchronized SQLiteDatabase getDatabase() {
        return db;
    }

    public Boolean login(String nif, String password) {
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("SELECT * FROM usuario WHERE nif = ? AND password = ?", new String[]{nif, Hash.hash(password)});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            @SuppressLint("Recycle") Cursor cursor2 = db.rawQuery("SELECT * FROM candidato WHERE nif = ? AND password = ?", new String[]{nif, Hash.hash(password)});
            return cursor2.getCount() > 0;
        }
    }

    public static ArrayList<Candidato> getCandidatosByPartido(int i) {
        ArrayList<Candidato> candidatos = new ArrayList<>();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("SELECT * FROM candidato WHERE partido_id = ?", new String[]{String.valueOf(i)});
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                candidatos.add(new Candidato(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getInt(6), cursor.getInt(7), cursor.getInt(8), cursor.getInt(9)));
            } while (cursor.moveToNext());
        }
        return candidatos;

    }

    public int getNumVotosUsuario(String nif) {
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("SELECT votosRealizados FROM usuario WHERE nif = ?", new String[]{nif});
       if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            return cursor.getInt(0);
        } else {
           @SuppressLint("Recycle") Cursor cursor2 = db.rawQuery("SELECT votosRealizados FROM candidato WHERE nif = ?", new String[]{nif});
            if (cursor2.getCount() > 0) {
                cursor2.moveToFirst();
                return cursor2.getInt(0);
            }
            return 0;
        }
    }

    public static String getNombrePartidoID(int ID){
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("SELECT nombrePartido FROM partido WHERE id = ?", new String[]{String.valueOf(ID)});
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            return cursor.getString(0);
        } else {
            return null;
        }

    }

    public static ArrayList<Candidato> getCandidatos() {
        ArrayList<Candidato> candidatos = new ArrayList<>();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("SELECT * FROM candidato order by partido_id", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                candidatos.add(new Candidato(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getInt(6), cursor.getInt(7), cursor.getInt(8), cursor.getInt(9)));
            } while (cursor.moveToNext());
        }
        return candidatos;
    }

    public static ArrayList<Partido> getPartidos() {
        ArrayList<Partido> partidos = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT id, nombrePartido, siglas, color FROM partido", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                Partido partido = new Partido(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3)
                );
                partidos.add(partido);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return partidos;
    }

    public static Usuario getUsuario(String usuario) {
        Cursor cursor = db.rawQuery("SELECT * FROM usuario WHERE nif = ?", new String[]{usuario});
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            Usuario user = new Usuario(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getInt(6), cursor.getInt(7));
            cursor.close();
            return user;
        } else {
            cursor.close();
            return null;
        }
    }

    public static void votar(Usuario usuario, ArrayList<Integer> selectedCandidates) {
        String id = String.valueOf(usuario.getId());
        db.execSQL("UPDATE usuario SET votosReaelizados = 3 WHERE id = ?", new String[]{id});
        for (int i = 0; i < selectedCandidates.size(); i++) {
            db.execSQL("UPDATE candidato SET votos = votos + 1 WHERE id = ?", new String[]{String.valueOf(selectedCandidates.get(i))});
        }
    }


    public void nuevaVotacion() {
        //Poner todos los votos a 0
        db.execSQL("UPDATE candidato SET votos = 0");
        //Poner los votos realizados a 0
        db.execSQL("UPDATE usuario SET votosReaelizados = 0");

    }

    public static ArrayList<Candidato> getGanadoresConEmpates(){
        ArrayList<Candidato> candidatos = new ArrayList<>();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("SELECT * FROM candidato WHERE votos = (SELECT MAX(votos) FROM candidato) order by partido_id", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                candidatos.add(new Candidato(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getInt(6), cursor.getInt(7), cursor.getInt(8), cursor.getInt(9)));
            } while (cursor.moveToNext());
        }
        return candidatos;
    }
}
