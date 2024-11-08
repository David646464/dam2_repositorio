package com.example.elecciones.Views;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.elecciones.Database.DatabaseManager;
import com.example.elecciones.Objects.Candidato;
import com.example.elecciones.R;
import com.example.elecciones.adapters.CandidatosAdapter;

import java.util.ArrayList;

public class Ganadores extends AppCompatActivity {
    private CandidatosAdapter adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ganadores);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ArrayList<Candidato> candidatos = DatabaseManager.getGanadoresConEmpates();
        adapter = new CandidatosAdapter(this, candidatos);
        listView = findViewById(R.id.listView2);
        listView.setAdapter(adapter);
    }

    public void volver(View view){
        finish();
    }
}