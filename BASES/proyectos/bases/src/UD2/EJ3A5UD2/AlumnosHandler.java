package UD2.EJ3A5UD2;

import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.HashMap;

public class AlumnosHandler extends DefaultHandler {
    private HashMap<String, Integer> alumnos = new HashMap<>();
    boolean bNombre = false;
    boolean bNota = false;
    private String nombre;
    private Integer nota;

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws org.xml.sax.SAXException {
        if (qName.equalsIgnoreCase("alumno")) {
            bNombre = true;
        } else if (qName.equalsIgnoreCase("nota")) {
            nota = Integer.parseInt(attributes.getValue("valor"));
            bNota = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws org.xml.sax.SAXException {
        if (qName.equalsIgnoreCase("alumno")) {
            alumnos.put(nombre, nota);
        } else if (qName.equalsIgnoreCase("nome")) {
            bNombre = false;
        } else if (qName.equalsIgnoreCase("nota")) {
            bNota = false;

        } else if ( qName.equalsIgnoreCase("notas")) {

            imprimirAlumnosPorNotaDescedente();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws org.xml.sax.SAXException {
        if (bNombre) {
            nombre = new String(ch, start, length);
        }
    }

    private void imprimirAlumnosPorNotaDescedente() {

        System.out.println("NOTAS");
        System.out.println("==========================");

        int totalAlumnos = 0;
        int notaActual = 10;
        for (int i = 10; i >= 0 ; i--) {
            ArrayList<String> alumnosConNota = new ArrayList<>();
            for (String alumno : alumnos.keySet()) {
                if (alumnos.get(alumno) == i) {
                    alumnosConNota.add(alumno);
                    totalAlumnos++;
                }
            }
            if (alumnosConNota.size() > 0) {
                System.out.println(getNota(i) + " " + i);
                for (String alumno : alumnosConNota) {
                    System.out.println(" " + alumno);
                }
                System.out.println("Num. de alumnos " + alumnosConNota.size());
                System.out.println("--------------------------------");
            }

        }



    }

    private String getNota(int i) {
        switch (i) {
            case 10:
                return "Matrícula de Honor";
            case 9:
                return "Sobresaliente";
            case 8:
                return "Notable";
            case 7:
                return "Notable";
            case 6:
                return "Bien";
            case 5:
                return "Suficiente";
            case 4:
                return "Suficiente";
            case 3:
                return "Insuficiente";
            case 2:
                return "Insuficiente";
            case 1:
                return "Deficiente";
            case 0:
                return "Deficiente";
            default:
                return "Sin calificación";
        }
    }


}
