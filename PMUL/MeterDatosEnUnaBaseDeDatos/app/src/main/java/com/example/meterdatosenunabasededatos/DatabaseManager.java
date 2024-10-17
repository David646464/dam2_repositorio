package com.example.meterdatosenunabasededatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DatabaseManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mydatabase.db";
    // Versión de la base de datos (cambiarlo cada vez que se realice un cambio en el esquema)
    private static final int DATABASE_VERSION = 1;

    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE2 = "CREATE TABLE provincia (id INTEGER PRIMARY KEY AUTOINCREMENT, nombreProvincia TEXT)";
        sqLiteDatabase.execSQL(CREATE_TABLE2);
        String CREATE_TABLE = "CREATE TABLE usuario (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, apellido1 TEXT, apellido2 TEXT, edad INTEGER, vip BOOLEAN,provincia_id INTEGER, FOREIGN KEY(provincia_id) REFERENCES provincia(id))";
        sqLiteDatabase.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS users");
        onCreate(sqLiteDatabase);
    }




}
