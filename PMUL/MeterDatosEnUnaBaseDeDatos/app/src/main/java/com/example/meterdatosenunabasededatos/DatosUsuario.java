package com.example.meterdatosenunabasededatos;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DatosUsuario extends AppCompatActivity {
    private  int id = -1;
    private SQLiteDatabase db = null;
    private Usuario usuario = null;
    private EditText nombre;
    private EditText apellido1;
    private EditText apellido2;
    private EditText edad;
    private CheckBox vip;
    private Spinner provincia;
    private ArrayAdapter<String> arrayAdapterProvincias;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_datos_usuario);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        DatabaseManager dbHelper = new DatabaseManager(this);
        db = dbHelper.getWritableDatabase();
        usuario = (Usuario) getIntent().getSerializableExtra("Usuario");


        nombre = findViewById(R.id.campoNombre);
        apellido1 = findViewById(R.id.campoApellido1);
        apellido2 = findViewById(R.id.campoApellido2);
        edad = findViewById(R.id.campoEdad);
        vip = findViewById(R.id.checkBoxVIP);
        provincia = findViewById(R.id.spinnerProvincia);
        obtenerProvincias();
        obtenerDatos();
    }

    @Override
    protected void onResume() {
        super.onResume();
        obtenerProvincias();
    }

    private void obtenerProvincias() {
        Cursor c = db.rawQuery("SELECT * FROM provincia", null);
        arrayAdapterProvincias = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        arrayAdapterProvincias.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        provincia.setAdapter(arrayAdapterProvincias);
        if(c.moveToFirst()){
            do{
                String provinciaTexto = c.getString(1);
                arrayAdapterProvincias.add(provinciaTexto);
                if (usuario != null && usuario.getProvincia_id() == c.getInt(0)){
                    provincia.setSelection(arrayAdapterProvincias.getPosition(c.getString(1)));
                }
            }while(c.moveToNext());
        }

    }

    private void obtenerDatos() {
        if(usuario != null){
            id = usuario.getId();
            nombre.setText(usuario.getNombre());
            apellido1.setText(usuario.getApellido1());
            apellido2.setText(usuario.getApellido2());
            edad.setText(String.valueOf(usuario.getEdad()));
            vip.setChecked(usuario.isVip());
        }
    }

    public void guardarDatos(View view){
        String nombreTexto = nombre.getText().toString();
        String apellido1Texto = apellido1.getText().toString();
        String apellido2Texto = apellido2.getText().toString();
        int edadTexto = Integer.parseInt(edad.getText().toString());
        boolean vipTexto = vip.isChecked();
        String provinciaTexto = arrayAdapterProvincias.getItem(provincia.getSelectedItemPosition());
        Cursor c = db.rawQuery("SELECT * FROM provincia WHERE nombreProvincia = '"+provinciaTexto+"'", null);
        c.moveToFirst();
        int id_provincia = c.getInt(0);
        if(id == -1){
            db.execSQL("INSERT INTO usuario (nombre, apellido1, apellido2, edad, vip, provincia_id) VALUES ('"+nombreTexto+"','"+apellido1Texto+"','"+apellido2Texto+"',"+edadTexto+","+vipTexto+","+id_provincia+")");
        }else{
            db.execSQL("UPDATE usuario SET nombre = '"+nombreTexto+"', apellido1 = '"+apellido1Texto+"', apellido2 = '"+apellido2Texto+"', edad = "+edadTexto+", vip = "+vipTexto+", provincia_id = "+id_provincia + " WHERE id = " + id);
        }
        finish();

        cambiarEscena();
    }
    public void nuevaProvincia(View view) {
        Intent intent = new Intent(this, NuevaProvincia.class);
        startActivity(intent);
    }
    private void cambiarEscena() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }


}