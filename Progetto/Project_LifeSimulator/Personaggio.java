package Project_LifeSimulator;

public class Personaggio extends Persona{

    int puntiSoldi;
    int puntiSalute;
    int puntiFelicita;
    int puntiLavoro;
    int puntiRelazioni;

    private String nome;
    private String cognome;
    private int eta;

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getEta() {
        return eta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }
}
