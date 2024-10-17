package com.example.meterdatosenunabasededatos;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NuevaProvincia extends AppCompatActivity {
    private EditText nombreProvincia;
    private SQLiteDatabase db = null;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nueva_provincia);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        DatabaseManager databaseManager = new DatabaseManager(this);
        db = databaseManager.getWritableDatabase();
        nombreProvincia = findViewById(R.id.campoNombreProvincia);
    }

    public void guardarProvincia(View view) {
        String nombre = nombreProvincia.getText().toString();

        if (!Existe(nombre)){
            db.execSQL("INSERT INTO provincia (nombreProvincia) VALUES ('" + nombre + "')");
        }

        finish();
    }

    private boolean Existe(String nombre) {
        Cursor c = db.rawQuery("SELECT * FROM provincia WHERE nombreProvincia = '" + nombre + "'", null);
        return c.getCount() > 0;

    }
}