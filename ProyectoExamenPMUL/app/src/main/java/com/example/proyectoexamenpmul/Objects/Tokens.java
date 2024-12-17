package com.example.proyectoexamenpmul.Objects;

public class Tokens {
    private static String[] tokensPara = new String[1] ;
    private static String[] tokensAsunto = new String[1];
    private static String[] PatternCuerpo = new String[1];
    private static Tokens instance;
    public static Tokens getInstance() {
        if (instance == null) {
            instance = new Tokens();
        }
        return instance;
    }
    
    public Tokens() {
        tokensPara = new String[]{"@ot.com"};
        tokensAsunto = new String[]{"ascensor", "fuego"};
        PatternCuerpo = new String[]{"\\d{8}[A-Za-z]", "[A-Za-z]{2}\\d{2}-\\d{4}-\\d{4}-\\d{4}-\\d{4}-\\d{4}"};
    }


    public static String[] getTokensPara() {
        return tokensPara;
    }

    public static String[] getTokensAsunto() {
        return tokensAsunto;
    }

    public static String[] getPatternCuerpo() {
        return PatternCuerpo;
    }

    public static void desactivarToken(String token, int idCniSensorIA) {
        if (idCniSensorIA == 0) {
           if (tokensPara.length > 0) {
               for (int i = 0; i < tokensPara.length; i++) {
                   if (tokensPara[i].equals(token)) {
                       tokensPara[i] = "";
                   }
               }
            }
        } else if (idCniSensorIA == 1) {
            if (tokensAsunto.length > 0) {
                for (int i = 0; i < tokensAsunto.length; i++) {
                    if (tokensAsunto[i].equals(token)) {
                        tokensAsunto[i] = "";
                    }
                }
            }
        } else {
            if (PatternCuerpo.length > 0) {
                for (int i = 0; i < PatternCuerpo.length; i++) {
                    if (PatternCuerpo[i].equals(token)) {
                        PatternCuerpo[i] = "";
                    }
                }
            }
        }
    }
}
