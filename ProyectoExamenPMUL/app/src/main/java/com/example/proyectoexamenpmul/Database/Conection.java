package com.example.proyectoexamenpmul.Database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import java.util.ArrayList;

public class Conection extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mydatabase1.db";
    private static final int DATABASE_VERSION = 1;
    private static Conection instance;
    private static  SQLiteDatabase db;

    private Conection(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }




    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE2 = "CREATE TABLE partido (id INTEGER PRIMARY KEY AUTOINCREMENT, nombrePartido TEXT, siglas TEXT,color TEXT)";
        sqLiteDatabase.execSQL(CREATE_TABLE2);


        //Partidos
        sqLiteDatabase.execSQL("INSERT INTO partido (nombrePartido, siglas, color) VALUES ('Partido Popular', 'PP', 'Azul')");
        sqLiteDatabase.execSQL("INSERT INTO partido (nombrePartido, siglas, color) VALUES ('Partido Socialista Obrero Español', 'PSOE', 'Rojo')");
        sqLiteDatabase.execSQL("INSERT INTO partido (nombrePartido, siglas, color) VALUES ('Unidas Podemos', 'UP', 'Morado')");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS partido");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS candidato");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS usuario");
        onCreate(sqLiteDatabase);
    }

    public static synchronized Conection getInstance(Context context) {
        if (instance == null) {
            instance = new Conection(context.getApplicationContext());
            db = instance.getWritableDatabase();
        }
        return instance;
    }

    public static synchronized SQLiteDatabase getDatabase() {
        return db;
    }



}

