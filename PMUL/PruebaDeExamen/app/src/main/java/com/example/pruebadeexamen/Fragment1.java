package com.example.pruebadeexamen;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class Fragment1 extends Fragment {
    private List<String> objects;
    private EditText editText;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private String info;


    public Fragment1() {
        super(R.layout.fragment1);
        this.objects = new ArrayList<>();
    }

    public Fragment1(List<String> objects) {
        super(R.layout.fragment1);
        this.objects = objects != null ? objects : new ArrayList<>();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewCompat.setOnApplyWindowInsetsListener(view, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editText = view.findViewById(R.id.editTextFrag);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No se usa
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // No se usa
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Filtrar la lista
                adapter.getFilter().filter(s);
            }
        });

        listView = view.findViewById(R.id.lista);
        cargarLista();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public String getInfo() {
        return info;
    }

    public interface CargarDatosALaLista {
        void cargarDatosALaLista();
    }


    void cargarLista() {
        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, objects);
        listView.setAdapter(adapter);
    }


        public void setObjects (List <String> objects) {
            this.objects = objects != null ? objects : new ArrayList<>();
            if (adapter != null) {
                adapter.clear();
                adapter.addAll(objects);
                adapter.notifyDataSetChanged();
            }
        }
        
        public ListView getListView () {
            return listView;
        }
    }
