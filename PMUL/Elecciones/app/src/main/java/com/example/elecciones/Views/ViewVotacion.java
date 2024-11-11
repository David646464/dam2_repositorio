// ViewVotacion.java
package com.example.elecciones.Views;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

import com.example.elecciones.Database.DatabaseManager;
import com.example.elecciones.Objects.Candidato;
import com.example.elecciones.Objects.Usuario;
import com.example.elecciones.R;
import com.example.elecciones.adapters.CandidatosAdapter;
import com.example.elecciones.fragments.ButtonFragment;

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

        listView = findViewById(R.id.listView); // Initialize listView here

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

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.button_fragment, new ButtonFragment(R.string.votar, v -> votar()));
        //Atribuir el metodo  limpiarSeleccion al boton 2
        findViewById(R.id.button2).setOnClickListener(v -> limpiarSeleccion());
        //Atribuir el metodo salir al boton 3
        findViewById(R.id.button3).setOnClickListener(v -> salir());transaction.commit();
    }

    private void cargarSpinner() {
        // Spinner setup code remains unchanged
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