package by.bsuir.booking.client.service;

import by.bsuir.booking.client.Util.ParseUtil;
import by.bsuir.booking.client.model.Room;
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
public class RoomServiceImpl implements RoomService{

    public static final String SERVER_URI_ROOM = "http://booking.mycloud.by/rest/room";

    @Override
    public void save(Room room) throws IOException {
        URL url = new URL(SERVER_URI_ROOM);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);
            urlConnection.connect();

            JSONObject jo = ParseUtil.parseRoomToJson(room);

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
    public void update(Room room) throws IOException, ParseException {
        URL url = new URL(SERVER_URI_ROOM + "/" + room.getIdRoom());
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestMethod("PUT");
            urlConnection.setDoOutput(true);
            urlConnection.connect();

            JSONObject jo = new JSONObject();
            jo = ParseUtil.parseRoomToJson(room);

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
    public Room getRoomByID(int id) throws IOException, ParseException {
        URL url_upd = new URL(SERVER_URI_ROOM + "/" + id);
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

        Room room = ParseUtil.parseJsonToRoom(obj);

        conn.disconnect();

        return room;
    }

    @Override
    public Room getByRoomN(int N) throws IOException, ParseException {
        URL url_upd = new URL(SERVER_URI_ROOM + "/search/" + N);
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

        Room room = ParseUtil.parseJsonToRoom(obj);

        conn.disconnect();

        return room;
    }

    @Override
    public List<Room> getFreeRooms(String dateFrom, String dateFor) throws IOException, ParseException {
        URL url_upd = new URL(SERVER_URI_ROOM + "/free/" + dateFrom + "/" + dateFor);
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
        List<Room> rooms = new ArrayList<Room>();
        JSONArray jsonarray = new JSONArray(jsonData);
        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject obj = jsonarray.getJSONObject(i);
            Room room = ParseUtil.parseJsonToRoom(obj);
            rooms.add(room);
        }
        conn.disconnect();

        return rooms;
    }

    @Override
    public List<Room> getAllRooms() throws IOException, ParseException {
        URL url_upd = new URL(SERVER_URI_ROOM + "s");
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
        List<Room> rooms = new ArrayList<Room>();
        JSONArray jsonarray = new JSONArray(jsonData);
        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject obj = jsonarray.getJSONObject(i);
            Room room = ParseUtil.parseJsonToRoom(obj);
            rooms.add(room);
        }
        conn.disconnect();

        return rooms;
    }

    @Override
    public void delRoom(int id) throws IOException {
        URL url = new URL(SERVER_URI_ROOM + "/" + id);
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
