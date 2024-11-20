package org.example;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class Main {
    public static void main(String[] args) {
        try {
            // Crear un objeto Person
            Person person = new Person();
            person.setName("John Doe");
            person.setAge(30);

            // Convertir el objeto a XML
            JAXBContext context = JAXBContext.newInstance(Person.class);
            Marshaller marshaller = context.createMarshaller();
            StringWriter writer = new StringWriter();
            marshaller.marshal(person, writer);
            String xmlString = writer.toString();
            System.out.println("Objeto a XML:\n" + xmlString);

            // Convertir el XML de vuelta a un objeto
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader reader = new StringReader(xmlString);
            Person personFromXml = (Person) unmarshaller.unmarshal(reader);
            System.out.println("XML a Objeto:\nNombre: " + personFromXml.getName() + ", Edad: " + personFromXml.getAge());

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}