package com.example.telefono;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Telefono extends Fragment {

    private TextView textView;
    private EditText editText;
    private ImageButton imageButton;
    private boolean llamando = false;
    private OnFragmentInteractionListener mListener;
    private String numero = "0";
    private String nuemroAnterioLlamado = "-1";

    public TextView getTextView() {
        return textView;
    }

    public EditText getEditText() {
        return editText;
    }

    public ImageButton getImageButton() {
        return imageButton;
    }

    public boolean isLlamando() {
        return llamando;
    }

    public OnFragmentInteractionListener getmListener() {
        return mListener;
    }

    public String getNumero() {
        return numero;
    }

    public String getNuemroAnterioLlamado() {
        return nuemroAnterioLlamado;
    }

    public Telefono(int numero) {
        this.numero = String.valueOf(numero);


    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    public void setEditText(EditText editText) {
        this.editText = editText;
    }

    public void setImageButton(ImageButton imageButton) {
        this.imageButton = imageButton;
    }

    public void setLlamando(boolean llamando) {
        this.llamando = llamando;
    }

    public void setmListener(OnFragmentInteractionListener mListener) {
        this.mListener = mListener;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setNuemroAnterioLlamado(String nuemroAnterioLlamado) {
        this.nuemroAnterioLlamado = nuemroAnterioLlamado;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Telefono fragment);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.linea_telefono, container, false);

        textView = view.findViewById(R.id.NumeroTelefono);
        textView.setText(String.valueOf(numero));
        editText = view.findViewById(R.id.numeroAllamar);
        imageButton = view.findViewById(R.id.ImagenTelefono);

        // Set OnClickListener for the ImageButton
        imageButton.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.onFragmentInteraction(this);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            System.out.println("Se necesita una instancia de OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}