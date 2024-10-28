package com.example.elecciones.Views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.elecciones.BD.DatabaseManager;
import com.example.elecciones.Objetos.Usuario;
import com.example.elecciones.R;

public class MainActivity extends AppCompatActivity {

    private DatabaseManager databaseManager;
    private Usuario usuario;
    private EditText etUsuario, etContrasena;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        databaseManager = DatabaseManager.getInstance(this);
        etUsuario = findViewById(R.id.editTextNIF);
        etContrasena = findViewById(R.id.editTextNIF);




    }

    public void login(View view){
        String usuario = etUsuario.getText().toString();
        String contrasena = etContrasena.getText().toString();

        if(databaseManager.login(usuario, contrasena)){
            Intent intent = new Intent(this, ViewVotacion.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }
    }
}