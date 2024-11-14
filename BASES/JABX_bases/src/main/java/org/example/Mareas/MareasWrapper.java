package org.example.Mareas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MareasWrapper {
    private List<Mareas> mareas;

    public List<Mareas> getMareas() {
        return mareas;
    }

    public void setMareas(List<Mareas> mareas) {
        this.mareas = mareas;
    }

    public void imprimirmareas() {

        for (Mareas marea : mareas) {
            String fechaPrediccion =marea.getData();
            System.out.println("=====================");
            System.out.println("fecha prediccion: " + fechaPrediccion + " puerto: " + marea.getNomePorto());
            for (Marea detalleMarea : marea.getListaMareas()) {
                System.out.println("estado: " + detalleMarea.getTipoMarea() + " hora: " + detalleMarea.getHora() + " altura: " + detalleMarea.getAltura());
            }
            System.out.println("=====================");
        }
    }
    }

