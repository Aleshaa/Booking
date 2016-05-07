package by.bsuir.booking.client.service;

import by.bsuir.booking.client.Util.ParseUtil;
import by.bsuir.booking.client.model.Reservation;
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
public class ReservationServiceImpl implements ReservationService {

    public static final String SERVER_URI_RESERVATION = "http://booking.mycloud.by/rest/reservation";

    @Override
    public void save(Reservation reservation) throws IOException {
        URL url = new URL(SERVER_URI_RESERVATION);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);
            urlConnection.connect();

            JSONObject jo = ParseUtil.parseReservationToJson(reservation);

            System.out.println("Reservation save: " + jo.toString());
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
    public void update(Reservation reservation) throws IOException, ParseException {
        URL url = new URL(SERVER_URI_RESERVATION + "/" + reservation.getIdReserv());
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestMethod("PUT");
            urlConnection.setDoOutput(true);
            urlConnection.connect();

            JSONObject jo = new JSONObject();
            jo = ParseUtil.parseReservationToJson(reservation);

            System.out.println("Reservation update: " + jo.toString());
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
    public Reservation getReservationByID(int id) throws IOException, ParseException {
        URL url_upd = new URL(SERVER_URI_RESERVATION + "/" + id);
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

        Reservation reservation = ParseUtil.parseJsonToReservation(obj);

        conn.disconnect();

        return reservation;
    }

    @Override
    public List<Reservation> getAll() throws IOException, ParseException {
        URL url_upd = new URL(SERVER_URI_RESERVATION + "s");
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
        List<Reservation> reservations = new ArrayList<Reservation>();
        JSONArray jsonarray = new JSONArray(jsonData);
        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject obj = jsonarray.getJSONObject(i);
            Reservation reservation = ParseUtil.parseJsonToReservation(obj);
            reservations.add(reservation);
        }
        conn.disconnect();

        return reservations;
    }

    @Override
    public void delete(int id) throws IOException {
        URL url = new URL(SERVER_URI_RESERVATION + "/" + id);
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
