package com.example.telefono;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements Telefono.OnFragmentInteractionListener {

    private HashMap<Integer, Telefono> telefonos = new HashMap<>();
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        for (int i = 0; i < 30; i++) {
            addNewFragment(i);
        }
    }

    private void addNewFragment(int index) {
        Telefono telefono = new Telefono(index);
        telefonos.put(index, telefono);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_linear_layout, telefono, "FRAGMENT_TELEFONO_" + index);
        transaction.commit();
    }

    @Override
    public void onFragmentInteraction(Telefono fragment) {
        llamarAOtroTelefono(fragment);
        actualizarImagen(fragment);
    }

    private void actualizarImagen(Telefono fragment) {
        if (!fragment.isLlamando()) {
            fragment.getImageButton().setImageResource(android.R.drawable.stat_sys_speakerphone);

        } else {
            fragment.getImageButton().setImageResource(android.R.drawable.star_on);

        }
    }

    private void llamarAOtroTelefono(Telefono fragment) {
        int num = fragment.getEditText().getText().toString().isEmpty() ? 0 : Integer.parseInt(fragment.getEditText().getText().toString());
        int numeroRestaurar = Integer.valueOf(fragment.getNuemroAnterioLlamado());
        if(!fragment.isLlamando() || !fragment.getNuemroAnterioLlamado().equals(String.valueOf(num))) {
            Telefono telefono = telefonos.get(num);
            if (telefono != null) {
                telefono.setLlamando(true);
                telefono.getTextView().setText(telefono.getNumero() + "<" + fragment.getNumero());
                fragment.setLlamando(true);
                fragment.setNuemroAnterioLlamado(telefono.getNumero());
                telefono.setNuemroAnterioLlamado(fragment.getNumero());
                fragment.getTextView().setText(fragment.getNumero() + ">" + telefono.getNumero());
                actualizarImagen(telefono);
            }
        }else{
            Telefono telefono = telefonos.get(numeroRestaurar);
            if (telefono != null) {
                telefono.setLlamando(false);
                telefono.getTextView().setText(telefono.getNumero());
                fragment.setLlamando(false);
                fragment.setNuemroAnterioLlamado("-1");
                fragment.getTextView().setText(fragment.getNumero());
                actualizarImagen(telefono);
            }
        }
    }
}