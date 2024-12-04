package UD2.EL1A6UD2;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement()
public class Empresas {
    private ArrayList <Empresa> lista;
    public Empresas() {
        lista = new ArrayList<>();
    }
    public ArrayList<Empresa> getLista() { return lista; }
    public void setLista(ArrayList<Empresa> lista) { this.lista = lista; }
}
