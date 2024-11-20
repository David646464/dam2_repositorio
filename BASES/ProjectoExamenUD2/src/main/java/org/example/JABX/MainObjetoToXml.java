package org.example.JABX;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.*;
import java.util.ArrayList;

public class MainObjetoToXml {

    public static void main(String[] args) throws FileNotFoundException {
        Pesca pesca = new Pesca();
        Xornada xornada = new Xornada();
        xornada.setLugar("Ría de Vigo");
        xornada.setData("2021-10-10");
        xornada.setDescricion("Pesca de xurelos");
        xornada.setCapturas(new ArrayList<>());
        Captura captura1 = new Captura();
        captura1.setEspecie("Xurelo");
        captura1.setPeso(0.3);

        Captura captura2 = new Captura();
        captura2.setEspecie("Sargo");
        captura2.setPeso(0.5);

        xornada.getCapturas().add(captura1);
        xornada.getCapturas().add(captura2);

        pesca.setXornadas(new ArrayList<>());
        pesca.getXornadas().add(xornada);

        //Guardar en pesca.dat
        try (FileOutputStream fileOut = new FileOutputStream("src/main/resources/pesca.dat");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(pesca);
            System.out.println("Datos guardados en pesca.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Leer de pesca.dat
        Pesca pesca2;
        try (FileInputStream fileIn = new FileInputStream("src/main/resources/pesca.dat");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
             pesca2 = (Pesca) in.readObject();
            System.out.println("Datos leídos de pesca.dat");
            System.out.println(pesca2);
        } catch (IOException | ClassNotFoundException e ) {
            throw new RuntimeException(e);
        }




        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Pesca.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(pesca2, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
