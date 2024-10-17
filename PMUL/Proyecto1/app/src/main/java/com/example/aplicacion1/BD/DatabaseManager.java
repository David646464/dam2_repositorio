package com.example.aplicacion1.BD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mydatabase.db";
    // Versión de la base de datos (cambiarlo cada vez que se realice un cambio en el esquema)
    private static final int DATABASE_VERSION = 1;

    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    // Este método se llama la primera vez que se crea la base de datos
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Aquí creas las tablas de la base de datos
        String CREATE_TABLE = "CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, age INTEGER)";
        db.execSQL(CREATE_TABLE);
    }

    // Este método se llama cuando se actualiza la base de datos (cuando cambia la versión)
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Aquí puedes eliminar las tablas antiguas y crear las nuevas
        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);
    }
}
