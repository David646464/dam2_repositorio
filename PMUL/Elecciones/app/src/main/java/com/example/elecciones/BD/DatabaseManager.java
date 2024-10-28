package com.example.elecciones.BD;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.elecciones.Utils.Hash;

public class DatabaseManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mydatabase.db";
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

        //Usuarios
        sqLiteDatabase.execSQL("INSERT INTO usuario (nif, password, nombre, apellido1, apellido2, edad, votosReaelizados) VALUES ('12345678A', '"+Hash.hash("12348765C")+"', 'Pablo', 'Casado', 'Blanco', 40, 0)");
        sqLiteDatabase.execSQL("INSERT INTO usuario (nif, password, nombre, apellido1, apellido2, edad, votosReaelizados) VALUES ('87654321B', '"+Hash.hash("87654321B")+"', 'Pedro', 'Sánchez', 'Pérez-Castejón', 49, 0)");
        sqLiteDatabase.execSQL("INSERT INTO usuario (nif, password, nombre, apellido1, apellido2, edad, votosReaelizados) VALUES ('12348765C', '"+Hash.hash("12348765C")+"', 'Pablo', 'Iglesias', 'Turrión', 42, 0)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS users");
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
        Cursor cursor = db.rawQuery("SELECT * FROM usuario WHERE nif = ? AND password = ?", new String[]{nif, Hash.hash(password)});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            Cursor cursor2 = db.rawQuery("SELECT * FROM candidato WHERE nif = ? AND password = ?", new String[]{nif, Hash.hash(password)});
            if (cursor2.getCount() > 0) {
                return true;
            }
            return false;
        }
    }

    public int getNumVotosUsuario(String nif) {
        Cursor cursor = db.rawQuery("SELECT votosRealizados FROM usuario WHERE nif = ?", new String[]{nif});
       if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            return cursor.getInt(0);
        } else {
           Cursor cursor2 = db.rawQuery("SELECT votosRealizados FROM candidato WHERE nif = ?", new String[]{nif});
            if (cursor2.getCount() > 0) {
                cursor2.moveToFirst();
                return cursor2.getInt(0);
            }
            return 0;
        }
    }





}
