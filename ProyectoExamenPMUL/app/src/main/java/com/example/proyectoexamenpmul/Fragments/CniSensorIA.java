package com.example.proyectoexamenpmul.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.proyectoexamenpmul.R;

import java.io.Serializable;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CniSensorIA extends Fragment implements Serializable {
    private TextView textView;
    private HashMap<String,Boolean> tokens = new HashMap<>();
    private HashMap<String,String> tokensQueBloqueanOtrosTokens = new HashMap<>();
    private HashMap<String,Boolean> patterns = new HashMap<>();
    private OnFrgCniSensorIA listener;
    private boolean esperarUno=false;
    private String texto = "";
    private int id;

    public CniSensorIA() {
    }


    public static CniSensorIA newInstance(String param1, String param2) {
        CniSensorIA fragment = new CniSensorIA();
        return fragment;
    }

    public void quitarToken(String token) {
        if (tokens.containsKey(token)) {
            tokens.remove(token);
        }
        if (patterns.containsKey(token)) {
            patterns.remove(token);
        }
    }

    public void setText(String text) {
        textView.setText(text);
    }

    public void setEsperarUno(boolean b) {
        esperarUno = b;
    }




    public interface OnFrgCniSensorIA {
        void mandarAviso(String texto, String token ,int id);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cni_sensor_i_a, container, false);
        textView = v.findViewById(R.id.edittext);
        textView.setText(texto);
        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                setALLTrue();
                if (!esperarUno){
                    for (String token : s.toString().split(" ")) {
                        if (tokensQueBloqueanOtrosTokens.containsKey(token)) {
                            tokens.put(tokensQueBloqueanOtrosTokens.get(token), false);
                        }
                        for (String pattern : patterns.keySet()) {
                            if (isPattern(token, pattern)) {
                                listener.mandarAviso(textView.getText().toString(),token,id);
                                break;
                            }
                        }
                        if (tokens.containsKey(token) && tokens.get(token)) {
                            listener.mandarAviso(textView.getText().toString(),token,id);
                        }
                    }
                }else{
                    esperarUno = false;
                }
            }
        });
        return v;
    }

    private void setALLTrue() {
        for (String token : tokens.keySet()) {
            tokens.put(token, true);
        }
    }

    public void setOnFrgCniSensorIA(OnFrgCniSensorIA listener,String[] tokens,String[] patterns, HashMap<String,String> tokensQueBloqueanOtrosTokens ,int id, String text) {
        this.listener = listener;
        if (tokens != null) {
            for (String token : tokens) {
                if (token.equals("")){
                    continue;
                }
                this.tokens.put(token, true);
            }
        }
        if (tokensQueBloqueanOtrosTokens != null) {
            this.tokensQueBloqueanOtrosTokens = tokensQueBloqueanOtrosTokens;
        }
        if (patterns != null) {

            for (String pattern : patterns) {
                if (pattern.equals("")){
                    continue;
                }
                this.patterns.put(pattern, true);
            }
        }
        this.id = id;
        texto = text;
    }

    private boolean isPattern(String token, String PATTERN) {
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(token);
        return matcher.matches();
    }

    public String getText(){
        return textView.getText().toString();
    }
}