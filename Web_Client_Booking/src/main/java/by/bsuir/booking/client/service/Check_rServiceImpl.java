package by.bsuir.booking.client.service;

import by.bsuir.booking.client.Util.ParseUtil;
import by.bsuir.booking.client.model.Check_r;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Check_rServiceImpl implements Check_rService{

    public static final String SERVER_URI_CHECK = "http://booking.mycloud.by/rest/check";

    @Override
    public void save(Check_r check_r) throws IOException {
        URL url = new URL(SERVER_URI_CHECK);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);
            urlConnection.connect();

            JSONObject jo = ParseUtil.parseCheckToJson(check_r);

            System.out.println("Check save: " + jo.toString());
            OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream());
            out.write(jo.toString());
            out.close();

            int HttpResult = urlConnection.getResponseCode();
            if (HttpResult == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "utf-8"));
                String line = null;
                String jsonData = "";
                while ((line = br.readLine()) != null) {
                    jsonData += line + "\n";
                    System.out.println(line);
                }
                br.close();
            } else
                System.out.println(urlConnection.getResponseMessage());

        } catch (JSONException | IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null)
                urlConnection.disconnect();
        }

    }

    @Override
    public void update(Check_r check_r) throws IOException, ParseException {
        URL url = new URL(SERVER_URI_CHECK + "/" + check_r.getIdCheck());
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestMethod("PUT");
            urlConnection.setDoOutput(true);
            urlConnection.connect();

            JSONObject jo = new JSONObject();
            jo = ParseUtil.parseCheckToJson(check_r);

            System.out.println("Check update: " + jo.toString());
            OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream());
            out.write(jo.toString());
            out.close();

            int HttpResult = urlConnection.getResponseCode();
            if (HttpResult == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "utf-8"));
                String line = null;
                String jsonData = "";
                while ((line = br.readLine()) != null) {
                    jsonData += line + "\n";
                    System.out.println(line);
                }
                br.close();
            } else
                System.out.println(urlConnection.getResponseMessage());

        } catch (JSONException | IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null)
                urlConnection.disconnect();
        }
    }

    @Override
    public Check_r getByID(int id) throws IOException, ParseException {
        URL url_upd = new URL(SERVER_URI_CHECK + "/" + id);
        HttpURLConnection conn = (HttpURLConnection) url_upd.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode());
        }
        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        String jsonData = "";
        String output;
        while ((output = br.readLine()) != null) {
            jsonData += output + "\n";
        }

        System.out.println(jsonData);

        JSONObject obj = new JSONObject(jsonData);

        Check_r check_r = ParseUtil.parseJsonToCheck(obj);

        conn.disconnect();

        return check_r;
    }

    @Override
    public List<Check_r> getAll() throws IOException, ParseException {
        URL url_upd = new URL(SERVER_URI_CHECK + "s");
        HttpURLConnection conn = (HttpURLConnection) url_upd.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode());
        }
        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        String jsonData = "";
        String output;
        while ((output = br.readLine()) != null) {
            jsonData += output + "\n";
        }
        List<Check_r> check_rs = new ArrayList<Check_r>();
        JSONArray jsonarray = new JSONArray(jsonData);
        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject obj = jsonarray.getJSONObject(i);
            Check_r check_r = ParseUtil.parseJsonToCheck(obj);
            check_rs.add(check_r);
        }
        conn.disconnect();

        return check_rs;
    }

    @Override
    public void delete(int id) throws IOException {
        System.out.println("Заглушка на удаление Чека");
    }
}
