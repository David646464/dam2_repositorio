package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {
    private EditText editText1,editText2 ;
    private CheckBox checkBox ;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editText1 = findViewById(R.id.editTextText4);
        editText2 = findViewById(R.id.editTextText5);
        checkBox = findViewById(R.id.checkBox2);

        editText1.setText((String)getData("editText1"));
        editText2.setText((String)getData("editText2"));
        String texto = (String) getData("checkBox");
        checkBox.setText(texto);
        checkBox.setChecked(texto.equals("true"));
    }

    public Object getData(String name) {
        SharedPreferences prefs = getSharedPreferences("MainActivity.java", MODE_PRIVATE);
        return prefs.getString(name, null);
    }

    public void saveData(String name, Object value) {
        SharedPreferences prefs = getSharedPreferences("MainActivity.java", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(name, value.toString());
        editor.apply();
    }

    public void Guardar(View view){

        saveData("editText1", editText1.getText());
        saveData("editText2", editText2.getText());
        saveData("checkBox", checkBox.isChecked());
        Intent intent = new Intent(MainActivity3.this,MainActivity2.class);
        startActivity(intent);


    }
}