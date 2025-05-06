package skillfactory;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.sql.SQLException;

public class Bot extends TelegramLongPollingBot {
    ConnectDB connectDB = new ConnectDB();
    String message = "Hello";

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageFromBot = update.getMessage().getText();
            if (messageFromBot.equals("/start")) {
                message = "Выберите пункт меню";
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
