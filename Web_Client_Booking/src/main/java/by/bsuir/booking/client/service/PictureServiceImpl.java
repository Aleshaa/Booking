package by.bsuir.booking.client.service;

import by.bsuir.booking.client.model.Picture;
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

@Service
public class PictureServiceImpl implements PictureService {

    public static final String SERVER_URI_PIC = "http://localhost:8080/rest/picture";


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
    public Picture findPicByPath(String path) throws IOException, ParseException {
        System.out.println(path);
        URL url_upd = new URL(SERVER_URI_PIC + "/search/" + path.replaceAll(".jpg","").trim());
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

        Picture picture = new Picture(obj.getInt("idPicture"), obj.getString("fileName"), obj.getString("uploadedNname"), obj.getInt("width"), obj.getInt("height"));

        conn.disconnect();

        return picture;

    }

    @Override
    public void save(Picture picture) throws IOException {
        URL url = new URL(SERVER_URI_PIC);
        System.out.println("TEST SAVE PICTURE");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);
            urlConnection.connect();

            JSONObject jo = new JSONObject();

            jo.put("idPicture", picture.getIdPicture());
            jo.put("fileName", picture.getFileName());
            jo.put("uploadedNname", picture.getUploadedNname());
            jo.put("width", picture.getWidth());
            jo.put("height", picture.getHeight());

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
}
