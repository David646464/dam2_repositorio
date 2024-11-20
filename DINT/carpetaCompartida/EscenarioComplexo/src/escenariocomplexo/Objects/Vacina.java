/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package escenariocomplexo.Objects;

/**
 *
 * @author DAM IES Chan do Monte
 */
public class Vacina {

    private int codVacina;
    private String nomeVacina;
    private int numTotalDoses;

    public Vacina(int codVacina, String nomeVacina, int numTotalDoses) {
        this.codVacina = codVacina;
        this.nomeVacina = nomeVacina;
        this.numTotalDoses = numTotalDoses;
    }

    @Override
    public String toString() {
        return getNomeVacina();
    }

    /**
     * @return the codVacina
     */
    public int getCodVacina() {
        return codVacina;
    }

    /**
     * @param codVacina the codVacina to set
     */
    public void setCodVacina(int codVacina) {
        this.codVacina = codVacina;
    }

    /**
     * @return the nomeVacina
     */
    public String getNomeVacina() {
        return nomeVacina;
    }

    /**
     * @param nomeVacina the nomeVacina to set
     */
    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    /**
     * @return the numTotalDoses
     */
    public int getNumTotalDoses() {
        return numTotalDoses;
    }

    /**
     * @param numTotalDoses the numTotalDoses to set
     */
    public void setNumTotalDoses(int numTotalDoses) {
        this.numTotalDoses = numTotalDoses;
    }

}
