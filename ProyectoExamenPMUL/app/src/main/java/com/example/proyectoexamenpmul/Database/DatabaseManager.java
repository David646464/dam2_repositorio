package com.example.proyectoexamenpmul.Database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import com.example.proyectoexamenpmul.Objects.MiniAlert;

import java.util.ArrayList;

public class DatabaseManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mydatabase1.db";
    private static final int DATABASE_VERSION = 1;
    private static DatabaseManager instance;
    private static  SQLiteDatabase db;

    private DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }




    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE alerta (id INTEGER PRIMARY KEY AUTOINCREMENT, token TEXT, valid integer)";
        sqLiteDatabase.execSQL(CREATE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS alerta");
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

    public static void insertAlert(String token, int valid) {
        try {
            String query = "INSERT INTO alerta (token, valid) VALUES ('" + token + "', " + valid + ")";
            db.execSQL(query);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
        }
    }

    public ArrayList<MiniAlert> getAlertas() {
        ArrayList<MiniAlert> alertas = new ArrayList<>();
        try {
            String query = "SELECT * FROM alerta";
            Cursor cursor = db.rawQuery(query, null);
            if (cursor.moveToFirst()) {
                do {
                    String token = cursor.getString(1);
                    int valid = cursor.getInt(2);
                    MiniAlert alerta = new MiniAlert(token, valid);
                    alertas.add(alerta);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
        }
        return alertas;
    }

    public void borrarAlertas() {
        try {
            String query = "DELETE FROM alerta";
            db.execSQL(query);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
        }
    }
}
