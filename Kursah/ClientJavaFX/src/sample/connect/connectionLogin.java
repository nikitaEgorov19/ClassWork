package sample.connect;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class connectionLogin {
    public boolean get(String username, String password) throws IOException, JSONException {
        try {
            URL url = new URL("http://localhost:6969/users");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inp;
            StringBuilder qwe = new StringBuilder();
            while ((inp = bufferedReader.readLine()) != null){
                qwe.append(inp);
            }
            bufferedReader.close();

            JSONArray jsonArray = new JSONArray(qwe.toString());
            int i = 0;
            while (i < jsonArray.length()) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (username.equals(jsonObject.getString("username")) && password.equals(jsonObject.getString("password"))) {

                    return true;
                }
                i++;
            } return false;

        }catch (Exception e) {
            return false;
        }
        }
    }







