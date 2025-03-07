package tonteriasMias;

import java.io.*;

public class prueba2 {
    public static void main(String[] args)
            throws FileNotFoundException, IOException {
        double[] precios={1.35, 4.0, 8.90, 6.2, 8.73};
        int[] unidades={5, 7, 12, 8, 30};
        String[] descripciones={"paquetes de papel", "lápices", "bolígrafos",
                "carteras", "mesas"};
        DataOutputStream salida=new DataOutputStream(new FileOutputStream("C:/FicherosJava/pedido.dat"));
        for (int i=0; i<precios.length; i ++) {
            salida.writeBytes(descripciones[i]);
            salida.writeChar('\n');
            salida.writeInt(unidades[i]);
            salida.writeChar('\t');
            salida.writeDouble(precios[i]); }
        double precio;
        int unidad;
        char car;
        String descripcion;
        double total=0.0;
        DataInputStream entrada = new DataInputStream(new
                FileInputStream("C:/FicherosJava/pedido.dat")) ;
        try {
            while (true)
            { //para leer la cadena de caracteres.
                //se podría hacer con readline pero está deprecated.
                descripcion="";
                car=(char)entrada.readUnsignedByte(); //para que lea las vocales
                //acentuadas (lee de 0 a 255, sino leeria de 0 a 128)
                while (car!='\n'){
                    descripcion+=car;
                    car=(char)entrada.readUnsignedByte(); }
                unidad=entrada.readInt();
                entrada.readChar(); //lee el carácter tabulador
                precio=entrada.readDouble();
                System.out.println("has pedido "+unidad+" "+descripcion+" a "+precio+" Euros.");
                        total=total+unidad*precio;
            }
        }
        catch (EOFException e) {
// Es para controlar que se ha llegado al final del archivo }
            System.out.printf("%s %.2f %s\n","por un TOTAL de ",total," pts.");
            entrada.close();
        }

    }
}
