package com.example.aplicacion1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private ListView lista;
    private ArrayList<String> listaString;
    private ArrayAdapter<String> arrayAdapter;

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

        lista = findViewById(R.id.lista);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cambiarEscena(position);
            }
        });
        obtenerDatos();
    }





    public  void obtenerDatos(){

        SharedPreferences prefs = getSharedPreferences(this.getClass().getName(), MODE_PRIVATE);
        listaString = new ArrayList<>();
        for (String texto :  prefs.getAll().keySet()){
            listaString.add((String) getData(texto));
        }

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listaString);
        lista.setAdapter(arrayAdapter);

    }
    public Object getData(String name) {
        SharedPreferences prefs = getSharedPreferences(this.getClass().getName(), MODE_PRIVATE);
        return prefs.getString(name, null);
    }

    public void saveData(String name, Object value) {
        SharedPreferences prefs = getSharedPreferences(this.getClass().getName(), MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(name, value.toString());

        editor.apply();
    }
    public void cambiarEscena(View view){

        Intent intent = new Intent(this,Ajustes.class);
        startActivity(intent);
    }

    public void cambiarEscena(int i){
        Intent intent = new Intent(this,Ajustes.class);
        intent.putExtra("NumeroUsuario", i);
        startActivity(intent);
    }
}