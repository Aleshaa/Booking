package by.bsuir.booking.client.service;

import by.bsuir.booking.client.Util.ParseUtil;
import by.bsuir.booking.client.model.Role;
import by.bsuir.booking.client.model.User;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
public class UserServiceImpl implements UserService {

    public static final String SERVER_URI_USER = "http://booking.mycloud.by/rest/user";

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) throws IOException {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoleByIdRole(new Role(2,"ROLE_USER"));
        URL url = new URL(SERVER_URI_USER);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);
            urlConnection.connect();

            JSONObject jo = ParseUtil.parseUserToJson(user);

            System.out.println(jo.toString());
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
    public void update(User user) throws IOException {
        URL url = new URL(SERVER_URI_USER + "/" + user.getIdUser());
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestMethod("PUT");
            urlConnection.setDoOutput(true);
            urlConnection.connect();

            JSONObject jo = ParseUtil.parseUserToJson(user);

            System.out.println(jo.toString());
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
    public User findByUsername(String username) throws IOException, ParseException {

        URL url_upd = new URL(SERVER_URI_USER + "/search/" + username);
        System.out.println("TEST FIND USER. URI:" + url_upd.toString());
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

        User user = ParseUtil.parseJsonToUser(obj);

        System.out.println(user.getSecondName());
        System.out.println(user.getUsername());
        System.out.println(user.getIdRole());

        conn.disconnect();

        return user;

    }

    @Override
    public User getByID(int id) throws IOException, ParseException {
        URL url_upd = new URL(SERVER_URI_USER + "/" + id);
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

        User user = ParseUtil.parseJsonToUser(obj);

        System.out.println(user.getSecondName());
        System.out.println(user.getUsername());
        System.out.println(user.getIdRole());

        conn.disconnect();

        return user;
    }

    @Override
    public List<User> getAllUsers() throws IOException, ParseException {
        URL url_upd = new URL(SERVER_URI_USER + "s");
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
        List<User> users = new ArrayList<User>();
        JSONArray jsonarray = new JSONArray(jsonData);
        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject obj = jsonarray.getJSONObject(i);
            User user = ParseUtil.parseJsonToUser(obj);
            users.add(user);
        }
        conn.disconnect();

        return users;
    }

    @Override
    public void delUser(int id) throws IOException {
        URL url = new URL(SERVER_URI_USER+"/" + id);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestMethod("DELETE");
            urlConnection.setDoOutput(true);
            urlConnection.connect();
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

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null)
                urlConnection.disconnect();
        }
    }
}
