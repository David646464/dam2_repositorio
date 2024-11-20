package org.example.DowWithSax;

public class DescargarXML {
    public void descargar(String url, String fichero) {
        //Descargar un xml de una url y pasarlo a fichero
        try {
            java.net.URL urlXML = new java.net.URL(url);
            java.io.InputStream in = urlXML.openStream();
            java.io.FileOutputStream out = new java.io.FileOutputStream(fichero);
            byte[] buffer = new byte[2048];
            int length = 0;
            while ((length = in.read(buffer)) != -1) {
                out.write(buffer, 0, length);
            }
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
