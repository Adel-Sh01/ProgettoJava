
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Engine implements InterfacciaBot
{

    Personaggio personaggio = new Personaggio();

    @Override
    public void inizializzaBot()
    {

        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new BotTelegram());
        } catch ( TelegramApiException e) {
            e.printStackTrace();
        }
    }


    public String infoPersonaggio()
    {
        String info = "Queste sono le informazioni del tuo *Personaggio*:\n\n*Nome*: " + personaggio.getNome() + "\n\n*Cognome*: " + personaggio.getCognome() + "\n\n*Eta'*: " + personaggio.getEta() + "\n\n*Bilancio*: \n\n*Umore*: \n";
        return info;
    }
}
