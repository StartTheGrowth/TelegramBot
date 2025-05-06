package skillfactory;

import org.json.JSONObject;

public class Response {
    JSONObject jsonObject = new JSONObject();
    public JSONObject createJson(){
        jsonObject.put("/start", "Наш бот приветствует тебя");
        jsonObject.put("/menu", "Выбери пункт");
        jsonObject.put("/record", "запись");
        return jsonObject;
    }
}
