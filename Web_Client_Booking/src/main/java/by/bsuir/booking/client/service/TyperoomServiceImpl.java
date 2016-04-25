package by.bsuir.booking.client.service;

import by.bsuir.booking.client.Util.ParseUtil;
import by.bsuir.booking.client.model.Typeroom;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TyperoomServiceImpl implements TyperoomService {

    public static final String SERVER_URI_TR= "http://localhost:8080/rest/";


    @Override
    public void save(Typeroom typeroom) throws IOException {

    }

    @Override
    public Typeroom getTypeRoomByID(int id) throws IOException, ParseException {
        return null;
    }

    @Override
    public List<Typeroom> getAllTypeRoom() throws IOException, ParseException {
        URL url_upd = new URL(SERVER_URI_TR + "typesroom");
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
        List<Typeroom> typerooms = new ArrayList<Typeroom>();
        JSONArray jsonarray = new JSONArray(jsonData);
        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject obj = jsonarray.getJSONObject(i);
            Typeroom typeroom = ParseUtil.parseJsonToTypeRoom(obj);
            typerooms.add(typeroom);
        }
        conn.disconnect();

        return typerooms;
    }

    @Override
    public void delTTypeRoom(int id) throws IOException {

    }
}
