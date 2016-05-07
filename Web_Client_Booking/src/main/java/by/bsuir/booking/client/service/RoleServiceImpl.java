package by.bsuir.booking.client.service;

import by.bsuir.booking.client.model.Role;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;

@Service
public class RoleServiceImpl implements RoleService {
    public static final String SERVER_URI_ROLE = "http://booking.mycloud.by/rest/role/";

    @Override
    public Role getRoleByID(int id) throws IOException, ParseException {
        URL url_upd = new URL(SERVER_URI_ROLE + id);
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

        Role role = new Role(obj.getInt("idRole"), obj.getString("nameRole"));

        conn.disconnect();

        return role;
    }
}
