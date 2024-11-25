package com.example.pruebadeexamen;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Fragment1.CargarDatosALaLista  {
    private Fragment1 fragment1;
    private TextView textView;

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

        fragment1 = (Fragment1) getSupportFragmentManager().findFragmentById(R.id.fragmento1);
        fragment1.setObjects(cargarDatos());
        textView = findViewById(R.id.textView1);


        
    }

    private List<String> cargarDatos() {
        List<String> names = new ArrayList<>();
        try {
            InputStream is = getAssets().open("palabras.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine()) != null) {
                names.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return names;
    }


    @Override
    public void cargarDatosALaLista() {
        textView.setText(fragment1.getInfo());
    }
}