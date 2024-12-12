package com.example.proyectoexamenpmul.Database;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;

public class DatabaseManager {

    public Boolean login(String nif, String password) {
        String passWordHash = String.valueOf(password.hashCode());
        try {
            @SuppressLint("Recycle") Cursor cursor = Conection.getDatabase().rawQuery("SELECT * FROM usuario WHERE nif = ? AND password = ?", new String[]{nif, passWordHash});
            if (cursor.getCount() > 0) {
                cursor.close();
                return true;
            } else {
                cursor.close();
                return false;
            }
        } catch (Exception e) {
            Log.e("DatabaseManager", "Error during login", e);
            return false;
        }
    }

    public static ArrayList<Object> ejemploConsulta(){
        ArrayList<Object> objects = new ArrayList<>();
        @SuppressLint("Recycle") Cursor cursor = Conection.getDatabase().rawQuery("SELECT * FROM candidato WHERE votos = (SELECT MAX(votos) FROM candidato) order by partido_id", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                objects.add(new Object(/*cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getInt(6), cursor.getInt(7), cursor.getInt(8), cursor.getInt(9))*/));
            } while (cursor.moveToNext());
        }
        return objects;
    }
}
