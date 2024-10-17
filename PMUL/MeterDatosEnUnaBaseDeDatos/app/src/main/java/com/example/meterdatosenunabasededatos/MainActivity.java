package com.example.meterdatosenunabasededatos;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.PrimitiveIterator;

public class MainActivity extends AppCompatActivity {
    private ListView lista;
    private ArrayAdapter<Usuario> arrayAdapter;
    private SQLiteDatabase db = null;
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
        DatabaseManager dbHelper = new DatabaseManager(this);
        db = dbHelper.getWritableDatabase();
        lista = findViewById(R.id.listView);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cambiarEscena(arrayAdapter.getItem(position));
            }
        });
        cargarDatos();
    }

    @Override
    protected void onResume() {
        super.onResume();
        cargarDatos();
    }

    public void cambiarEscena(Usuario item) {
        Intent intent = new Intent(this, DatosUsuario.class);
        intent.putExtra("Usuario", item);
        startActivity(intent);
    }

    public void cambiarEscena(View view) {
        Intent intent = new Intent(this, DatosUsuario.class);
        startActivity(intent);
    }




    private void cargarDatos() {
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios = getUsers();
        for (Usuario usuario : usuarios) {
            arrayAdapter.add(usuario);
        }
        lista.setAdapter(arrayAdapter);
    }

    private ArrayList<Usuario> getUsers() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Cursor cursor = db.query(
                "usuario",
                new String[]{"id", "nombre", "apellido1", "apellido2", "edad", "vip", "provincia_id"},
                null,
                null,
                null,
                null,
                null
        );

        while (cursor.moveToNext()) {
            @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("id"));
            @SuppressLint("Range") String nombre = cursor.getString(cursor.getColumnIndex("nombre"));
            @SuppressLint("Range") String apellido1 = cursor.getString(cursor.getColumnIndex("apellido1"));
            @SuppressLint("Range") String apellido2 = cursor.getString(cursor.getColumnIndex("apellido2"));
            @SuppressLint("Range") int edad = cursor.getInt(cursor.getColumnIndex("edad"));
            @SuppressLint("Range") boolean vip = cursor.getInt(cursor.getColumnIndex("vip")) == 1;
            @SuppressLint("Range") int provincia_id = cursor.getInt(cursor.getColumnIndex("provincia_id"));

            Usuario usuario = new Usuario(id, nombre, apellido1, apellido2, edad, vip, provincia_id);
            usuarios.add(usuario);
        }
        cursor.close();
        return usuarios;
    }
}

