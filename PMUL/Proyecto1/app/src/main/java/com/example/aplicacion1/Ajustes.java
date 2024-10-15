package com.example.aplicacion1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Ajustes extends AppCompatActivity {
    private int numero = -1;
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
        numero=getIntent().getIntExtra("NumeroUsuario",-1) + 1;
        nombre = findViewById(R.id.nombre);
        apellido1 = findViewById(R.id.apellido1);
        apellido2 = findViewById(R.id.apellido2);
        edad = findViewById(R.id.edad);
        telefono = findViewById(R.id.telefono);

        if (numero != -1){
            getData(numero);
        }

    }

    private void getData(int numero) {
        SharedPreferences prefs = getSharedPreferences(MainActivity.class.getName(), MODE_PRIVATE);

        String info = prefs.getString(String.valueOf(numero), null);


        if (info != null) {
            Toast.makeText(Ajustes.this, "Datos obtenidos: " + info, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(Ajustes.this, "No se encontraron datos.", Toast.LENGTH_LONG).show();
        }


        if (info != null && !info.trim().isEmpty()) {
            String[] infoSplit = info.trim().split("\\s+");

            if (infoSplit.length == 5) {
                nombre.setText(infoSplit[0]);
                apellido1.setText(infoSplit[1]);
                apellido2.setText(infoSplit[2]);
                edad.setText(infoSplit[3]);
                telefono.setText(infoSplit[4]);
            } else {
                Toast.makeText(Ajustes.this, "Formato incorrecto: Se esperaban 5 campos.", Toast.LENGTH_LONG).show();
                for (String dato : infoSplit) {
                    Toast.makeText(Ajustes.this, "Dato: " + dato, Toast.LENGTH_SHORT).show();
                }
            }
        } else {
            Toast.makeText(Ajustes.this, "La cadena está vacía o es nula.", Toast.LENGTH_LONG).show();
        }
    }

    public void saveData(String value) {
        SharedPreferences prefs = getSharedPreferences(MainActivity.class.getName(), MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(String.valueOf(numero != -1 ? String.valueOf(numero) : prefs.getAll().size() + 1), value.toString());
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