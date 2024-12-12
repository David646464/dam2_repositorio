package com.example.proyectoexamenpmul.Code;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.proyectoexamenpmul.Fragments.GeneralFragment;
import com.example.proyectoexamenpmul.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements GeneralFragment.OnFrgGeneral {
private List<GeneralFragment> generalFragments;
private int ids[] = { R.id.fragmentContainerView2,R.id.fragmentContainerView3,R.id.fragmentContainerView4,R.id.fragmentContainerView};

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
    generalFragments = new ArrayList<>();
    FragmentManager fragmentManager = getSupportFragmentManager();
    for (int i = 0; i < ids.length; i++) {
        GeneralFragment generalFragment = (GeneralFragment) fragmentManager.findFragmentById(ids[i]);
        generalFragment.setOnFrgGeneral(i + 1, this);
        generalFragments.add(generalFragment);

    }
    @SuppressLint({"MissingInflatedId", "LocalSuppress"}) LinearLayout linearLayout = findViewById(R.id.linearLayaout);
    GeneralFragment newGeneralFragment = new GeneralFragment();
    newGeneralFragment.setOnFrgGeneral(5, this);
    FragmentTransaction transaction = fragmentManager.beginTransaction();
    transaction.add(R.id.linearLayaout, newGeneralFragment);
    transaction.commit();


    }

    @Override
    public boolean generico1(boolean activado) {
        return !activado;
    }
}