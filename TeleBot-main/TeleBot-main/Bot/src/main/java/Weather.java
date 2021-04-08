import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class Weather {

    public static String getWeather(String messeage, Model model) throws IOException {
        URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + messeage + "&units=metric&appid=6f0787c45fb841d2fdbb5308c30956a2");

        Scanner in = new Scanner((InputStream) url.getContent());
        String result = "";
        while (in.hasNext()) {
            result += in.nextLine();
        }

        JSONObject object = new JSONObject(result);
        model.setName(object.getString("name"));

        JSONObject main = object.getJSONObject("main");
        model.setTemp(main.getDouble("temp"));
        model.setHumidity(main.getDouble("humidity"));

        JSONArray getArray = object.getJSONArray("weather");
        for (int i = 0; i < getArray.length(); i++) {
            JSONObject obj = getArray.getJSONObject(i);
            model.setIcon((String) obj.get("icon"));
            model.setMain((String) obj.get("main"));

        }


        return "Город: " + model.getName() + "\n" +
                "Температура: " + model.getTemp() + "°C" +  "\n" +
                "Влажность: " + model.getHumidity() + "%" + "\n" +
                "Погода: " + model.getMain() + "\n" +
                "https://raw.githubusercontent.com/mykytam/weatherTelegramBot/master/img/" + model.getIcon() + ".png";
    }
}


