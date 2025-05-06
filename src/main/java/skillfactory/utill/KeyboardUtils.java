package skillfactory.utill;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import skillfactory.ConnectDB;

import java.util.ArrayList;
import java.util.List;

public class KeyboardUtils {


    public SendMessage addButton() {
        ConnectDB connectDB = new ConnectDB();

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(connectDB.getChatId()));
        sendMessage.setText("Запись");

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("Запись");
        button.setCallbackData("Запись");
        row.add(button);
        rows.add(row);
        markup.setKeyboard(rows);
        sendMessage.setReplyMarkup(markup);
        return sendMessage;

    }
}
