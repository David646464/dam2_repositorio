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
        String CREATE_TABLE = "CREATE TABLE alert (id INTEGER PRIMARY KEY AUTOINCREMENT, token TEXT, valid INTEGER)";
        sqLiteDatabase.execSQL(CREATE_TABLE);




    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS alert");
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

