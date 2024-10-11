package com.example.aplicacion1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Ajustes extends AppCompatActivity {
    private EditText nombre;
    private EditText apellido1;
    private EditText apellido2;
    private EditText edad;
    private EditText telefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ajustes);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nombre = findViewById(R.id.nombre);
        apellido1 = findViewById(R.id.apellido1);
        apellido2 = findViewById(R.id.apellido2);
        edad = findViewById(R.id.edad);
        telefono = findViewById(R.id.telefono);

    }

    public void saveData(String value) {
        SharedPreferences prefs = getSharedPreferences(MainActivity.class.getName(), MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(String.valueOf(prefs.getAll().size() + 1), value.toString());
        editor.apply();
    }

    public void guardar(View view){
        saveData(nombre.getText() + " " +
                apellido1.getText() + " " +
                apellido2.getText() + " " +
                edad.getText() + " " +
                telefono.getText()
        );
        cambiarEscena();

    }

    public void cambiarEscena(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}