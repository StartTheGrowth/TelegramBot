package skillfactory;

import lombok.Getter;
import lombok.Setter;

import java.sql.*;

public class ConnectDB {
    private static final String URL = "jdbc:postgresql://localhost/postgres?user=postgres&password=29111983";
    private static String connectionSuccessfull = "connect to database";
    private Connection connection;
    public ConnectDB(){
        connect();
    }
    @Setter
    @Getter
    private int chatId;
    @Setter
    @Getter
    private String botUsername;
    @Setter
    @Getter
    private String botToken;

    void connect() {
        try {
            connection = DriverManager.getConnection(URL);
            Statement statement = connection.createStatement();
            statement.execute("SELECT*from bot");
            ResultSet resultSet = statement.getResultSet();
            System.out.println(connectionSuccessfull);
            while (resultSet.next()){
                setChatId(resultSet.getInt("chat_id"));
                setBotUsername(resultSet.getString("bot_user_name"));
                setBotToken(resultSet.getString("bot_token"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
