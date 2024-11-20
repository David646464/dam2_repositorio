package org.example.Mareas;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URL;

public class MainObjectPOJO {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {

            String urlString = "https://servizos.meteogalicia.gal/mgrss/predicion/mareas/jsonMareas.action";
            URL url = new URL(urlString);
            MareasWrapper mareasWrapper = objectMapper.readValue(url, MareasWrapper.class);
            mareasWrapper.imprimirmareas();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
