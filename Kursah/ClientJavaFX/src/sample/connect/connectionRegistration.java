package sample.connect;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class connectionRegistration {
    public String connectreg() throws IOException, JSONException {

        String query_url = "http://localhost:6969/users";
        String json = "";


        URL url = new URL(query_url);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setConnectTimeout(10000);
        connection.setRequestProperty("Content_Type","application/json; charset=UTF-8");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("POST");

        OutputStream outputStream = connection.getOutputStream();
        outputStream.write(json.getBytes("UTF-8"));
        outputStream.close();

        InputStream inputStream = new BufferedInputStream(connection.getInputStream());
        String res = IOUtils.toString(inputStream, "UTF-8");

        JSONObject jsonObject = new JSONObject(res);
        inputStream.close();
        connection.disconnect();

        return res;
}}
