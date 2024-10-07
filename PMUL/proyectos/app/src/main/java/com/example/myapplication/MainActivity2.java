package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    private TextView textView1 ;





    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

         textView1= findViewById(R.id.textView1);



    }

    public void Guardar(View view){

        saveData("editText1", editText1.getText());
        saveData("editText2", editText2.getText());
        saveData("checkBox", checkBox.isChecked());

        Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
        startActivity(intent);


    }

    public void mostrarToast(String mensaje) {
        //Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();

    }

    public void saveData(String name, Object value) {
        SharedPreferences prefs = getSharedPreferences("MainActivity.java", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(name, value.toString());
        editor.apply();
    }

    public Object getData(String name) {
        SharedPreferences prefs = getSharedPreferences("MainActivity.java", MODE_PRIVATE);
        return prefs.getString(name, null);
    }


}