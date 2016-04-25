package by.bsuir.booking.client.service;

import by.bsuir.booking.client.model.Picture;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;

/**
 * Created by User on 25.04.2016.
 */
public class PictureServiceImpl implements PictureService {

    public static final String SERVER_URI_PIC= "http://localhost:8080/rest/picture";


    @Override
    public Picture getPictureByID(int id) throws IOException, ParseException {
        URL url_upd = new URL(SERVER_URI_PIC + "/" + id);
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
        JSONObject obj = new JSONObject(jsonData);

        Picture pic = new Picture(obj.getInt("idPicture"), obj.getString("fileName"), obj.getString("uploadedNname"), obj.getInt("width"), obj.getInt("height"));

        conn.disconnect();

        return pic;
    }

    @Override
    public void save(Picture picture) throws IOException {

    }
}
