package com.example.elecciones.Views;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.elecciones.Database.DatabaseManager;
import com.example.elecciones.Objects.Candidato;
import com.example.elecciones.Objects.Partido;
import com.example.elecciones.Objects.Usuario;
import com.example.elecciones.R;
import com.example.elecciones.adapters.CandidatosAdapter;

import java.util.ArrayList;

public class ViewVotacion extends AppCompatActivity {
    private static final int MAX_SELECTIONS = 3;
    private ArrayList<Integer> selectedCandidates = new ArrayList<>();
    private ArrayList<Candidato> candidatosListPartido;
    private CandidatosAdapter adapter;
    private ListView listView;
    private Usuario usuario;

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



        usuario = DatabaseManager.getUsuario(getIntent().getStringExtra("usuario"));

        ArrayList<Candidato> candidatosList = DatabaseManager.getCandidatos();
        cargarLista(candidatosList);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Candidato candidato = candidatosListPartido.get(position);
            if (selectedCandidates.contains(candidato.getId())) {
                selectedCandidates.remove(Integer.valueOf(candidato.getId()));
            } else {
                if (selectedCandidates.size() < MAX_SELECTIONS) {
                    selectedCandidates.add(candidato.getId());
                } else {
                    Toast.makeText(ViewVotacion.this, "Solo puedes seleccionar " + MAX_SELECTIONS + " candidatos.", Toast.LENGTH_SHORT).show();
                    listView.setItemChecked(position, false);
                }
            }
            adapter.notifyDataSetChanged();
        });

        cargarSpinner();
        Button button = findViewById(R.id.button);
        if (usuario.getVotosRealizados() >= 3) {
            button.setEnabled(false);
        }
        //Atribuir el metodo votar al boton 1
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                votar();
            }
        });
        //Atribuir el metodo  limpiarSeleccion al boton 2
        findViewById(R.id.button2).setOnClickListener(v -> limpiarSeleccion());
        //Atribuir el metodo salir al boton 3
        findViewById(R.id.button3).setOnClickListener(v -> salir());

    }

    private void cargarSpinner() {
        Spinner spinner = findViewById(R.id.comboPartidos);
        Partido partido = new Partido(-1, "Todos", "$$", "Ninguno");
        ArrayList<Partido> partidos = DatabaseManager.getPartidos();
        partidos.add(partido);
        spinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, partidos));
        spinner.setSelection(partidos.size() - 1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == partidos.size() - 1) {
                    candidatosListPartido = DatabaseManager.getCandidatos();
                    cargarLista(candidatosListPartido);
                } else {
                    candidatosListPartido = DatabaseManager.getCandidatosByPartido(position + 1);
                    cargarLista(candidatosListPartido);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                candidatosListPartido = DatabaseManager.getCandidatos();
                cargarLista(candidatosListPartido);
            }
        });
    }

    private void votar() {
        if (usuario.getVotosRealizados() >= 3) {
            Toast.makeText(this, "Ya has votado 3 veces", Toast.LENGTH_SHORT).show();
            return;
        }
        if (selectedCandidates.size() != 3) {
            Toast.makeText(this, "Debes seleccionar 3 candidatos", Toast.LENGTH_SHORT).show();
            return;
        }

        DatabaseManager.votar(usuario, selectedCandidates);

        Toast.makeText(this, "Tus votos han sido almacenados", Toast.LENGTH_SHORT).show();
        finish();

    }

    private void salir() {
        //Volver a la pantalla de login
        finish();
    }

    public void limpiarSeleccion() {
        selectedCandidates.clear();
        cargarLista(candidatosListPartido);
        adapter.notifyDataSetChanged();
    }


    private void cargarLista(ArrayList<Candidato> candidatosList) {
        this.candidatosListPartido = candidatosList;
        adapter = new CandidatosAdapter(this, candidatosList);
        listView = findViewById(R.id.listView);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(adapter);

        // Mark selected candidates
        for (int i = 0; i < candidatosList.size(); i++) {
            listView.setItemChecked(i, selectedCandidates.contains(candidatosList.get(i).getId()));
        }
    }

}