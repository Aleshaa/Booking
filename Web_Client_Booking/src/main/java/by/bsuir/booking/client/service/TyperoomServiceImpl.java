package by.bsuir.booking.client.service;

import by.bsuir.booking.client.Util.ParseUtil;
import by.bsuir.booking.client.model.Picture;
import by.bsuir.booking.client.model.Typeroom;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TyperoomServiceImpl implements TyperoomService {

    public static final String SERVER_URI_TR = "http://booking.mycloud.by/rest/";

    @Autowired
    PictureService pictureService;

    @Override
    public void save(Typeroom typeroom) throws IOException, ParseException {
        URL url = new URL(SERVER_URI_TR+"typeroom");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);
            urlConnection.connect();

            JSONObject jo = new JSONObject();
            Picture pic = pictureService.findPicByPath(typeroom.getPictureByIdPic().getUploadedNname());
            if (pic.getIdPicture() == 0) {
                pictureService.save(typeroom.getPictureByIdPic());
                pic = pictureService.findPicByPath(typeroom.getPictureByIdPic().getUploadedNname());
            }
            JSONObject joPic = new JSONObject();

            joPic.put("idPicture", pic.getIdPicture());
            joPic.put("fileName", pic.getFileName());
            joPic.put("uploadedNname", pic.getUploadedNname());
            joPic.put("width", pic.getWidth());
            joPic.put("height", pic.getHeight());

            jo.put("idTRoom", typeroom.getIdTRoom());
            jo.put("nameTRoom", typeroom.getNameTRoom());
            jo.put("roominess", typeroom.getRoominess());
            jo.put("price", typeroom.getPrice());
            jo.put("idPicture", pic.getIdPicture());
            jo.put("pictureByIdPicture", joPic);

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
    public void update(Typeroom typeroom) throws IOException, ParseException {
        URL url = new URL(SERVER_URI_TR+"typeroom/" + typeroom.getIdTRoom());
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestMethod("PUT");
            urlConnection.setDoOutput(true);
            urlConnection.connect();

            JSONObject jo = new JSONObject();
            Picture pic = pictureService.findPicByPath(typeroom.getPictureByIdPic().getUploadedNname());
            if (pic.getIdPicture() == 0) {
                pictureService.save(typeroom.getPictureByIdPic());
                pic = pictureService.findPicByPath(typeroom.getPictureByIdPic().getUploadedNname());
            }

            JSONObject joPic = new JSONObject();

            joPic.put("idPicture", pic.getIdPicture());
            joPic.put("fileName", pic.getFileName());
            joPic.put("uploadedNname", pic.getUploadedNname());
            joPic.put("width", pic.getWidth());
            joPic.put("height", pic.getHeight());

            jo.put("idTRoom", typeroom.getIdTRoom());
            jo.put("nameTRoom", typeroom.getNameTRoom());
            jo.put("roominess", typeroom.getRoominess());
            jo.put("price", typeroom.getPrice());
            jo.put("idPicture", pic.getIdPicture());
            jo.put("pictureByIdPicture", joPic);

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
    public Typeroom getTypeRoomByID(int id) throws IOException, ParseException {
        URL url_upd = new URL(SERVER_URI_TR + "typeroom/" + id);
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

        Typeroom typeroom = ParseUtil.parseJsonToTypeRoom(obj);

        conn.disconnect();

        return typeroom;

    }

    @Override
    public Typeroom getTypeRoomByName(String name) throws IOException, ParseException {
        URL url_upd = new URL(SERVER_URI_TR + "typeroom/search/" + name);
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

        Typeroom typeroom = ParseUtil.parseJsonToTypeRoom(obj);

        conn.disconnect();

        return typeroom;
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
        URL url = new URL(SERVER_URI_TR+"typeroom/" + id);
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
