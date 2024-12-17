package com.example.proyectoexamenpmul.Code;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.proyectoexamenpmul.Database.DatabaseManager;
import com.example.proyectoexamenpmul.Fragments.CniSensorIA;
import com.example.proyectoexamenpmul.Objects.Tokens;
import com.example.proyectoexamenpmul.R;

public class PantallaDecmbio extends AppCompatActivity {
    private String token;
    private String texto;
    private int idCniSensorIA;
    private DatabaseManager databaseManager ;
    private CheckBox checkBox;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pantalla_decmbio);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        databaseManager = DatabaseManager.getInstance(this);
        checkBox = findViewById(R.id.checkBox);
        idCniSensorIA = getIntent().getIntExtra("id", 0);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView textView = findViewById(R.id.txttokenencontrado);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView textView2 = findViewById(R.id.txttexto);
        textView.setText("TOKEN "+getString(R.string.encontrado)+":"+getIntent().getStringExtra("token"));
        textView2.setText(getString(R.string.texto)+":" + getIntent().getStringExtra("text"));

        @SuppressLint("WrongViewCast") ImageButton button = findViewById(R.id.imageButton);
        button.setOnClickListener(v -> valido(true));
        @SuppressLint("WrongViewCast") ImageButton button2 = findViewById(R.id.imageButton2);
        button2.setOnClickListener(v -> valido(false));
    }

    private void valido(boolean valido) {
        if (valido) {
            databaseManager.insertAlert(getIntent().getStringExtra("token"), 1);
            if (checkBox.isChecked()) {
                Tokens.desactivarToken(getIntent().getStringExtra("token"),idCniSensorIA);
            }
        } else {
            databaseManager.insertAlert(getIntent().getStringExtra("token"), 0);
        }
        volver();
    }

    private void volver() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}