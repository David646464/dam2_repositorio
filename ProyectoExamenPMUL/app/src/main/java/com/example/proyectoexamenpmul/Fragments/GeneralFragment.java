package com.example.proyectoexamenpmul.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.proyectoexamenpmul.R;


public class GeneralFragment extends Fragment {
    private int id;
    private OnFrgGeneral listener;
    private TextView textView;
    private Button button;
    private boolean activado = false;

    public boolean isActivado() {
        return activado;
    }

    public GeneralFragment() {


    }

    public void setOnFrgGeneral(int id, OnFrgGeneral listener) {
        this.id=id;
        this.listener=listener;

    }

    private void cambiaractivado() {
        if (listener.generico1(activado)) {
            textView.setText("Fragmento " + id + " activado");
            activado = true;
        } else {
            textView.setText("Fragmento " + id + " desactivado");
            activado = false;
        }
    }


    //Interfaz
    public interface OnFrgGeneral {
        boolean generico1(boolean activado);
    }


    public static GeneralFragment newInstance(String param1, String param2) {
        GeneralFragment fragment = new GeneralFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Initialize your views here
    }

    private OnFrgGeneral callback;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_general, container, false);
        textView = v.findViewById(R.id.texto);
        button = v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiaractivado();
            }
        });
        return v;
    }
}