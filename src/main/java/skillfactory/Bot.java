package skillfactory;

import org.apache.logging.log4j.simple.internal.SimpleProvider;
import org.json.JSONObject;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import skillfactory.utill.KeyboardUtils;

import java.sql.SQLException;

public class Bot extends TelegramLongPollingBot {
    ConnectDB connectDB = new ConnectDB();
    String message = "Hello";
    Response response = new Response();
    JSONObject jsonObject = response.createJson();
    KeyboardUtils key = new KeyboardUtils();

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageFromBot = update.getMessage().getText();
            switch (messageFromBot) {
                case "/start":
                    message = jsonObject.getString("/start");
                    senMsg();
                    break;
                case "/menu":
                    message = jsonObject.getString("/menu");
                    senMsg();
                    break;
                case "/record":
                    message = jsonObject.getString("record");
                    key.addButton();
                    senMsg();
                    break;
                default:
                    message = "неверно";
                    senMsg();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return connectDB.getBotUsername();
    }

    public String getBotToken() {
        return connectDB.getBotToken();
    }

    public void senMsg() {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(connectDB.getChatId()));
        sendMessage.setText(message);
        try {
            execute(sendMessage);
            System.out.println(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
