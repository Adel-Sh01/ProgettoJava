import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;


public class Personaggio extends Persona{


    int puntiSoldi;
    int puntiSalute;
    int puntiFelicita;
    int puntiLavoro;
    int puntiRelazioni;

    private String nome;
    private String cognome;
    private String eta;

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEta() {
        return eta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }


}
