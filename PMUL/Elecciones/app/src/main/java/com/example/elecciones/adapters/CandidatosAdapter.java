package com.example.elecciones.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.elecciones.Database.DatabaseManager;
import com.example.elecciones.Objects.Candidato;
import com.example.elecciones.R;

import java.util.ArrayList;
import java.util.Objects;

public class CandidatosAdapter extends ArrayAdapter<Candidato> {

    private ArrayList<Candidato> candidatosList;

    public CandidatosAdapter(@NonNull Context context, @NonNull ArrayList<Candidato> objects) {
        super(context, 0, objects);
        this.candidatosList = new ArrayList<>(objects);
    }

    @NonNull
    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.partidos, parent, false);
        }

        Candidato candidato = getItem(position);

        ImageView partyImageView = convertView.findViewById(R.id.partyImageView);
        switch (Objects.requireNonNull(DatabaseManager.getNombrePartidoID(Objects.requireNonNull(candidato).getPartido_id()))) {
            case "Partido Popular":
                partyImageView.setImageResource(R.drawable.pp);
                break;
            case "Partido Socialista Obrero Español":
                partyImageView.setImageResource(R.drawable.psoe);
                break;
            case "Unidas Podemos":
                partyImageView.setImageResource(R.drawable.up);
                break;
            default:
                partyImageView.setImageResource(R.drawable.up);
                break;
        }

        TextView candidateNameTextView = convertView.findViewById(R.id.candidatoNameTextView);
        candidateNameTextView.setText(candidato.getNombre() + " " + candidato.getApellido1() + " " + candidato.getApellido2());


        ListView listView = (ListView) parent;
        convertView.setBackgroundColor(listView.isItemChecked(position) ? Color.GRAY : Color.TRANSPARENT);

        return convertView;
    }

}