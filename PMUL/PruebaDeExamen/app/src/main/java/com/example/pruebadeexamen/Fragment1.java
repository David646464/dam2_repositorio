package com.example.pruebadeexamen;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
    AdapterView.OnItemClickListener onItemClickListener = null;


    public Fragment1() {
        super(R.layout.fragment1);
        this.objects = new ArrayList<>();
    }

    public Fragment1(List<String> objects) {
        super(R.layout.fragment1);
        this.objects = objects != null ? objects : new ArrayList<>();
    }

    public void setOnItemClickListener (AdapterView.OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment1,container,false);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                info = listView.getSelectedItem().toString();
                onItemClickListener.;
            }
        });

        cargarLista();

        ViewCompat.setOnApplyWindowInsetsListener(view, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    public interface OnItemClickListener {
        public void cargarDatosALaLista();
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
