package com.example.dado;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import java.util.Random;

public class FrgDado extends Fragment {

    private Button boton;
    private Spinner lista;
    private OnFrgDado listener;
    private Random random=new Random();

    static final int MIN_NUMERO=0, MAX_NUMERO=9;
    int minNumero,maxNumero;
    StringBuilder numeros=new StringBuilder();
    int racha=0;


    public interface OnFrgDado {
        boolean onDadoLanzado(FrgDado frgDado, int numero, int racha, int totalLanzamientos);
    }

    public void setOnFrgDado(OnFrgDado listener, int minNumero, int maxNumero) {
        if(minNumero<MIN_NUMERO) throw new IllegalArgumentException("MIN no permitido");
        if(maxNumero>MAX_NUMERO) throw new IllegalArgumentException("MAX no permitido");
        if(minNumero>=maxNumero) throw new  IllegalArgumentException("MIN mayor o igual que MAX");
        this.listener = listener;
        this.minNumero=minNumero;
        this.maxNumero=maxNumero;
        lista.setAdapter(getAdapter());
    }

    public void reset() {
        numeros.setLength(0);
    }
    public int getNumero(int posicion) {
        return (int)numeros.charAt(posicion);
    }

    private ArrayAdapter<String> getAdapter() {
        int cantidadDeNumeros=maxNumero-minNumero+1;
        String[] listaNumeros=new String[cantidadDeNumeros];
        for(int i=0;i<cantidadDeNumeros;i++)
            listaNumeros[i]=(i+minNumero)+"";

        ArrayAdapter<String> adapter= new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                listaNumeros);
        return adapter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout=inflater.inflate(R.layout.frg_dado,container,false);
        boton = layout.findViewById(R.id.boton);
        lista = layout.findViewById(R.id.lista);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { tiraDadoAleatorio(); }
        });

        lista.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                haSalido(Integer.parseInt(parent.getItemAtPosition(position).toString()));
            }
            @Override public void onNothingSelected(AdapterView<?> parent) {}
        });
        return layout;
    }

    private void tiraDadoAleatorio () {
        haSalido(random.nextInt(maxNumero-minNumero+1)+minNumero);
    }

    private void haSalido(int numero) {
        int numNumeros=numeros.length();
        if(numNumeros>0) {
            racha=(numero!=Integer.parseInt(numeros.charAt(numNumeros-1)+""))?0:racha+1;
        }
        numeros.append(numero);
        if(!listener.onDadoLanzado(this,numero,racha,++numNumeros)) {
            numeros.deleteCharAt(numNumeros-1);
            // mejor deshaciendo que actualizar aquí, por si en el callback interroga al fragment con algún get y no estaría  actualizado
        }
    }
}
