package com.example.proyectoexamenpmul.Code;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

import com.example.proyectoexamenpmul.Database.DatabaseManager;
import com.example.proyectoexamenpmul.Fragments.CniSensorIA;
import com.example.proyectoexamenpmul.Objects.MiniAlert;
import com.example.proyectoexamenpmul.Objects.Textos;
import com.example.proyectoexamenpmul.Objects.Tokens;
import com.example.proyectoexamenpmul.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CniSensorIA.OnFrgCniSensorIA {
    public static List<CniSensorIA> cniSensorIAList;
    private int ids[] = {R.id.fragmentPara, R.id.fragmentAsunto, R.id.fragmentPara};
    private DatabaseManager databaseManager;
    //Tokens
    private String[] tokensPara ;
    private String[] tokensAsunto;
    private String[] PatternCuerpo ;

    //Bloqueador de tokens
    private HashMap<String, String> tokensQueBloqueanOtrosTokensAsunto = tokensBloqueanAsunto();

    private ListView listView;
    private AdaptadorAlertas adaptadorAlertas;



    private HashMap<String, String> tokensBloqueanAsunto() {
        HashMap<String, String> tokensQueBloqueanOtrosTokensAsunto = new HashMap<>();
        tokensQueBloqueanOtrosTokensAsunto.put("desactiva", "ascensor");
        return tokensQueBloqueanOtrosTokensAsunto;
    }


    @SuppressLint("MissingInflatedId")
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
        Textos.getInstance();
        Tokens.getInstance();
        tokensPara = Tokens.getTokensPara();
        tokensAsunto = Tokens.getTokensAsunto();
        PatternCuerpo = Tokens.getPatternCuerpo();
        databaseManager = DatabaseManager.getInstance(this);

        listView = findViewById(R.id.listview);
        ArrayList<MiniAlert> miniAlerts =databaseManager.getAlertas();
        adaptadorAlertas = new AdaptadorAlertas(this, miniAlerts);
        listView.setAdapter(adaptadorAlertas);

        cniSensorIAList = new ArrayList<>();
        FragmentManager fragmentManager = getSupportFragmentManager();

        CniSensorIA cniSensorIA1 = (CniSensorIA) fragmentManager.findFragmentById(R.id.fragmentPara);
        cniSensorIA1.setOnFrgCniSensorIA(this, tokensPara, null, null, 0,Textos.getTextos()[0]);
        CniSensorIA cniSensorIA2 = (CniSensorIA) fragmentManager.findFragmentById(R.id.fragmentAsunto);
        cniSensorIA2.setOnFrgCniSensorIA(this, tokensAsunto, null, tokensQueBloqueanOtrosTokensAsunto, 1,Textos.getTextos()[0]);

        CniSensorIA cniSensorIA3 = (CniSensorIA) fragmentManager.findFragmentById(R.id.fragmentCuerpo);
        cniSensorIA3.setOnFrgCniSensorIA(this, null, PatternCuerpo, null, 2,Textos.getTextos()[0]);

        cniSensorIAList.add(cniSensorIA1);
        cniSensorIAList.add(cniSensorIA2);
        cniSensorIAList.add(cniSensorIA3);

        Button button = findViewById(R.id.button5);
        button.setOnClickListener(v -> {
           resetear();
        });



    }

    private void resetear() {
        adaptadorAlertas.clear();
        databaseManager.borrarAlertas();
    }


    @Override
    public void mandarAviso(String texto, String token, int id) {
        Intent intent = new Intent(this, PantallaDecmbio.class);
        guardartextos();
        intent.putExtra("token", token);
        intent.putExtra("text", texto);
        intent.putExtra("id", id);
        startActivity(intent);
    }

    private void guardartextos() {
        Textos.setTextos(cniSensorIAList.get(0).getText(),cniSensorIAList.get(1).getText(),cniSensorIAList.get(2).getText());
    }
    @Override
    protected void onResume() {
        super.onResume();
        cniSensorIAList.get(0).setEsperarUno(true);
        cniSensorIAList.get(0).setText(Textos.getTextos()[0]);
        cniSensorIAList.get(1).setEsperarUno(true);
        cniSensorIAList.get(1).setText(Textos.getTextos()[1]);
        cniSensorIAList.get(2).setEsperarUno(true);
        cniSensorIAList.get(2).setText(Textos.getTextos()[2]);

    }
}