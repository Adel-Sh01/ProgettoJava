import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BotTelegram extends TelegramLongPollingBot
{

    Engine engine = new Engine();
    Personaggio personaggio = new Personaggio();
    Scanner scanner = new Scanner(System.in);


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


        String testo = "Comincia una nuova *vita*!";
        SendMessage messaggio = new SendMessage();
        messaggio.setChatId(update.getMessage().getChatId().toString());
        messaggio.setText(testo);
        messaggio.setParseMode("Markdown");

        //L'input dell'utente
        System.out.println("[ " + update.getMessage().getFrom().getFirstName() + " ]:");
        System.out.println(update.getMessage().getText());


        //Risposta dell'utente
        String comando = update.getMessage().getText();


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


        if (comando.equals("/nuovavita"))
        {
            testo = "Crea il tuo personaggio!";
            messaggio.setChatId(update.getMessage().getChatId().toString());
            messaggio.setText(testo);
            messaggio.setParseMode("Markdown");


            try {
                execute(messaggio);

            } catch ( TelegramApiException e ) {
                e.printStackTrace();
            }



            testo = "Inserisci il nome del tuo personaggio: ";
            messaggio.setChatId(update.getMessage().getChatId().toString());
            messaggio.setText(testo);
            messaggio.setParseMode("Markdown");



            try {
                execute(messaggio);

            } catch ( TelegramApiException e ) {
                e.printStackTrace();
            }

            personaggio.setNome(update.getMessage().getText());




            testo = "Inserisci il cognome del tuo personaggio: ";
            messaggio.setChatId(update.getMessage().getChatId().toString());
            messaggio.setText(testo);
            messaggio.setParseMode("Markdown");


            try {
                execute(messaggio);

            } catch ( TelegramApiException e ) {
                e.printStackTrace();
            }

            personaggio.setCognome(update.getMessage().getText());


            testo = "Ora la tua eta': ";
            messaggio.setChatId(update.getMessage().getChatId().toString());
            messaggio.setText(testo);
            messaggio.setParseMode("Markdown");


            try {
                execute(messaggio);

            } catch ( TelegramApiException e ) {
                e.printStackTrace();
            }

            personaggio.setEta(update.getMessage().getText());



        }
        else if (comando.equals("Personaggio"))
            {

                String testo1 = engine.infoPersonaggio();
                messaggio.setChatId(update.getMessage().getChatId().toString());
                messaggio.setText(testo1);
                messaggio.setParseMode("Markdown");

                try {
                    execute(messaggio);

                } catch ( TelegramApiException e ) {
                    e.printStackTrace();
                }

            }
            else if (comando.equals("Esci"))
            {
                testo = "Grazie per aver giocato!";
                messaggio.setChatId(update.getMessage().getChatId().toString());
                messaggio.setText(testo);
                messaggio.setParseMode("Markdown");

                try {
                    execute(messaggio);

                } catch ( TelegramApiException e ) {
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
