import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class BotTelegram extends TelegramLongPollingBot
{
    private static final int STATE_START = 0;
    private static final int STATE_FIRST_NAME = 1;
    private static final int STATE_LAST_NAME = 2;
    private static final int STATE_AGE = 3;

    // Variabili per memorizzare i dati dell'utente
    private String firstName = "";
    private String lastName = "";
    private int age = 0;

    // Stato corrente dell'input dell'utente
    private int currentState = STATE_START;






    Engine engine = new Engine();
    Personaggio personaggio = new Personaggio();
    Scanner scanner = new Scanner(System.in);
    SendMessage messaggio = new SendMessage();
    HashMap<Long, String> nomiUtenti = new HashMap<>();
    HashMap<Long, String> nomiUtenti2 = new HashMap<>();
    HashMap<String, Integer> nomiUtenti3 = new HashMap<>();
    Situazioni situazioni = new Situazioni();

    @Override
    public void onUpdateReceived(Update update)
    {

        if(update.getMessage().getText().equals("/start"))
        {
            SendMessage messages = new SendMessage();
            String inizio = "Benvenuto nel simulatore di *vita*!\n\nIl tuo obiettivo è fare delle scelte che ti porteranno verso nuove strade.\n\nClicca /nuovavita per iniziare!";
            messages.setChatId(update.getMessage().getChatId().toString());
            messages.setText(inizio);
            messages.setParseMode("Markdown");


            try {
                execute(messages);

            } catch ( TelegramApiException e ) {
                e.printStackTrace();
            }


        }


        /////////////////////////////////////////////////////////////////////
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

        List<KeyboardRow> keyboardRowList1 = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();

        KeyboardButton keyboardButton1 = new KeyboardButton();
        KeyboardButton keyboardButton2 = new KeyboardButton();
        KeyboardButton keyboardButton3 = new KeyboardButton();
        KeyboardButton keyboardButton4 = new KeyboardButton();


        keyboardButton1.setText("Accetta");
        keyboardButton2.setText("Rifiuta");
        keyboardButton3.setText("Personaggio");
        keyboardButton4.setText("Esci");


        row1.add(keyboardButton1);
        row1.add(keyboardButton2);
        row2.add(keyboardButton3);
        row2.add(keyboardButton4);

        keyboardRowList1.add(row1);
        keyboardRowList1.add(row2);

        replyKeyboardMarkup.setKeyboard(keyboardRowList1);

        messaggio.setReplyMarkup(replyKeyboardMarkup);

        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        /////////////////////////////////////////////////////////////////////
        if(personaggio.flag == 0)
        {
            gestisciInfo(update);
        }

    }


    public void gestisciInfo(Update update)
    {
        if (update.hasMessage()) {
            Long chatId = update.getMessage().getChatId();
            String text = update.getMessage().getText();

            SendMessage response = new SendMessage();
            response.setChatId(chatId);

            switch (currentState) {
                case STATE_START:
                    if (text.equals("/nuovavita")) {
                        response.setText("Inizieremo chiedendoti alcune informazioni basilari.");
                        response.setText("Inserisci il nome del tuo personaggio: ");
                        currentState = STATE_FIRST_NAME;
                    }
                    break;
                case STATE_FIRST_NAME:
                    firstName = text;
                    response.setText("Ottimo! Ora nserisci il tuo cognome:");
                    currentState = STATE_LAST_NAME;
                    break;
                case STATE_LAST_NAME:
                    lastName = text;
                    response.setText("Abbiamo quasi finito, inserisci la tua età:");
                    currentState = STATE_AGE;
                    break;
                case STATE_AGE:
                    try {
                        age = Integer.parseInt(text);
                        personaggio.setNome(firstName);
                        personaggio.setCognome(lastName);
                        personaggio.setEta(age);
                        personaggio.setId(chatId);
                        personaggio.flag = 1;

                        response.setText("Perfetto! cominciamo subito..");
                        currentState = STATE_START; // Torniamo allo stato iniziale
                    } catch (NumberFormatException e) {
                        response.setText("Inserisci un'età valida.");
                    }
                    break;
            }

            try {
                execute(response);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }









    @Override
    public String getBotUsername()
    {
        // TODO
        return "progettoshatani_bot";
    }

    @Override
    public String getBotToken()
    {
        // TODO
        return "6295448198:AAEFJiqSwT8UVIJ8GLp9R-V5l_7NghaXVJE";
    }


}