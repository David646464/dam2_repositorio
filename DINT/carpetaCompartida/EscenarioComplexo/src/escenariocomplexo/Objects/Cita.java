/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escenariocomplexo.Objects;


public class Cita {
    private int codCita;
    private int chip;
    private String data;
    private int hora;

    public Cita(int codCita, int chip, String data, int hora) {
        this.codCita = codCita;
        this.chip = chip;
        this.data = data;
        this.hora = hora;
    }

    public int getCodCita() {
        return codCita;
    }

    public void setCodCita(int codCita) {
        this.codCita = codCita;
    }

    public int getChip() {
        return chip;
    }

    public void setChip(int chip) {
        this.chip = chip;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Cita{" + "codCita=" + codCita + ", chip=" + chip + ", data=" + data + ", hora=" + hora + '}';
    }
    
    
    
}
