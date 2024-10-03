package com.example.myapplication;

import android.annotation.SuppressLint;
import android.health.connect.datatypes.AppInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView textView; // Añadir una referencia al TextView
    private Button button; // Añadir una referencia al Button
    private ListView listView ;
    private ArrayList<String> lista;
    private ArrayAdapter<String> arrayAdapter;
    private EditText editTextText;
    @SuppressLint("MissingInflatedId")
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

        // Inicializar el TextView y el Button
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        listView = findViewById(R.id.listview);
        editTextText = findViewById(R.id.editTextText);
        // Configurar el OnClickListener para el botón
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cambiar el texto del TextView cuando se haga clic en el botón
                textView.setText("Pulsaste el boton 1");
                textView.setText("Pulsaste el boton 1");
            }
        });

        lista = new ArrayList<>();
        lista.add("Elemento1");
        lista.add("Elemento2");
        lista.add("Elemento3");

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,lista);
        listView.setAdapter(arrayAdapter);



    }

    public void agregarElemento(View view){
        lista.add(editTextText.getText().toString());
        arrayAdapter.notifyDataSetChanged();
    }
    
    public void Boton(View view){
        textView.setText("Pulsaste el boton 2");
    }


}