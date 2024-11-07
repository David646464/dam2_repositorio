package com.example.elecciones.Views;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

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
    private static final int MAX_SELECTIONS = 3;
    private ArrayList<Integer> selectedCandidates = new ArrayList<>();
    private ArrayList<Candidato> candidatosListEntero;
    private CandidatosAdapter adapter;
    private ListView listView;

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

        cargarLista(candidatosList);

        // Set custom OnItemClickListener
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Candidato candidato = candidatosList.get(position);
            if (selectedCandidates.contains(candidato.getId())) {
                selectedCandidates.remove(Integer.valueOf(candidato.getId()));
            } else {
                if (selectedCandidates.size() < MAX_SELECTIONS) {
                    selectedCandidates.add(candidato.getId());
                } else {
                    Toast.makeText(ViewVotacion.this, "You can only select up to " + MAX_SELECTIONS + " items.", Toast.LENGTH_SHORT).show();
                    listView.setItemChecked(position, false);
                }
            }
            adapter.notifyDataSetChanged();
        });

        Spinner spinner = findViewById(R.id.comboPartidos);
        spinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, DatabaseManager.getPartidos()));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ArrayList<Candidato> candidatosList = DatabaseManager.getCandidatosByPartido(position + 1);
                cargarLista(candidatosList);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ArrayList<Candidato> candidatosList = DatabaseManager.getCandidatos();
                cargarLista(candidatosList);
            }
        });
    }

    private void cargarLista(ArrayList<Candidato> candidatosList) {
        candidatosList = candidatosList;
        adapter = new CandidatosAdapter(this, candidatosList);
        listView = findViewById(R.id.listView);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(adapter);

        // Mark selected candidates
        for (int i = 0; i < candidatosList.size(); i++) {
            if (selectedCandidates.contains(candidatosList.get(i).getId())) {
                listView.setItemChecked(i, true);
            }
        }
    }
}