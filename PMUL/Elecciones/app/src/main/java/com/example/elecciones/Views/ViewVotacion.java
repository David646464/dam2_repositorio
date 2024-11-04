package com.example.elecciones.Views;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.elecciones.BD.DatabaseManager;
import com.example.elecciones.Objetos.Candidato;
import com.example.elecciones.R;
import com.example.elecciones.adapters.CandidatosAdapter;

import java.util.ArrayList;

public class ViewVotacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_votacion);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Retrieve the list of candidates from the DatabaseManager
        ArrayList<Candidato> candidatosList = DatabaseManager.getCandidatos();

        // Initialize the CandidatosAdapter with the list of candidates
        CandidatosAdapter adapter = new CandidatosAdapter(this, candidatosList);

        // Set the adapter to the ListView
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }


}