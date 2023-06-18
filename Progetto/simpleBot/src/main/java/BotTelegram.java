import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class BotTelegram extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {

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

            List<KeyboardRow> keyboardRowList = new ArrayList<>();
            KeyboardRow row1 = new KeyboardRow();
            KeyboardRow row2 = new KeyboardRow();
            KeyboardRow row3 = new KeyboardRow();


            KeyboardButton keyboardButton1 = new KeyboardButton();
            KeyboardButton keyboardButton2 = new KeyboardButton();
            KeyboardButton keyboardButton3 = new KeyboardButton();
            KeyboardButton keyboardButton4 = new KeyboardButton();
            KeyboardButton keyboardButton5 = new KeyboardButton();
            KeyboardButton keyboardButton6 = new KeyboardButton();

            keyboardButton1.setText("/nuovavita");
            keyboardButton2.setText("Soldi");
            keyboardButton3.setText("Felicità");
            keyboardButton4.setText("Lavoro");
            keyboardButton5.setText("Status");
            keyboardButton6.setText("Esci");

            row1.add(keyboardButton1);
            row1.add(keyboardButton2);
            row2.add(keyboardButton3);
            row2.add(keyboardButton4);
            row3.add(keyboardButton5);
            row3.add(keyboardButton6);

            keyboardRowList.add(row1);
            keyboardRowList.add(row2);
            keyboardRowList.add(row3);

            replyKeyboardMarkup.setKeyboard(keyboardRowList);

            messaggio.setReplyMarkup(replyKeyboardMarkup);

            replyKeyboardMarkup.setResizeKeyboard(true);
            replyKeyboardMarkup.setOneTimeKeyboard(true);
            /////////////////////////////////////////////////////////////////////


            if (comando.equals("/nuovavita")) {
                testo = "Comincia una nuova *vita*!";
                messaggio.setChatId(update.getMessage().getChatId().toString());
                messaggio.setText(testo);
                messaggio.setParseMode("Markdown");


                try {
                    execute(messaggio);

                } catch ( TelegramApiException e ) {
                    e.printStackTrace();
                }


            } else if (comando.equals("Status")) {
                testo = "Sei fantastico";
                messaggio.setChatId(update.getMessage().getChatId().toString());
                messaggio.setText(testo);
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
    public String getBotUsername() {
        // TODO
        return "progettoshatani_bot";
    }

    @Override
    public String getBotToken() {
        // TODO
        return "6295448198:AAEFJiqSwT8UVIJ8GLp9R-V5l_7NghaXVJE";
    }


}
