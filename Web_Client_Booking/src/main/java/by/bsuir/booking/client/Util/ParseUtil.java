package by.bsuir.booking.client.Util;

import by.bsuir.booking.client.model.*;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParseUtil {
    //***PARSE DATE***
    public static String parseDateToString(Date date){
        System.out.println("(parseDateToString)Date: " + date);
        String result;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(date!=null) {
            result = sdf.format(date);
        }
        else
            result = "";
        System.out.println("(parseDateToString)String: " + result);
        return result;
    }

    public static Date parseStringToDate(String str) throws ParseException {
        System.out.println("(parseStringToDate)String: " + str);
        Date date;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(str != null) {
            if (!str.equals("")) {
                date = sdf.parse(str);
            }
            else
                date = null;
        }
        else
            date = null;
        System.out.println("(parseStringToDate)Date: " + date.toString());
        return date;
    }

    public static Date parseLongToDate(long date){
        Date d = new Date(date * 1000);
        return d;
    }

    public static long parseDateToLong(Date date){
        return date.getTime();
    }
    //******
    //**PARSE USER***
    public static User parseJsonToUser (JSONObject obj) throws ParseException {

        System.out.println(obj.toString());
        JSONObject obj1= obj.getJSONObject("roleByIdRole");
        Date dob = null;
        if(obj.getInt("idUser")==0)
            dob = parseLongToDate(obj.getLong("dob"));
        else
            dob = parseStringToDate(obj.getString("dob"));

        User user = new User(obj.getInt("idUser"), obj.getInt("idRole"), obj.getString("secondName"), obj.getString("firstName"), obj.getString("patronymic"), obj.getString("username"), obj.getString("password"), dob, (byte) obj.getInt("sex"), obj.getString("passportSeries"), obj.getInt("passportN"), obj.getString("identificationN"), BigDecimal.valueOf(obj.getDouble("cash")), obj1);

        return user;
    }

    public static JSONObject parseUserToJson(User user){
        JSONObject jo = new JSONObject();
        JSONObject joRole = new JSONObject();

        joRole.put("idRole", user.getRoleByIdRole().getIdRole());
        joRole.put("nameRole", user.getRoleByIdRole().getNameRole());
        jo.put("idUser", user.getIdUser());
        jo.put("secondName", user.getSecondName());
        jo.put("firstName", user.getFirstName());
        jo.put("patronymic", user.getPatronymic());
        jo.put("username", user.getUsername());
        jo.put("password", user.getPassword());
        jo.put("dob", parseDateToString(user.getDobDate()));
        jo.put("sex", user.getSex());
        jo.put("passportSeries", user.getPassportSeries());
        jo.put("passportN", user.getPassportN());
        jo.put("identificationN", user.getIdentificationN());
        jo.put("cash", user.getCash());
        jo.put("roleByIdRole", joRole);

        return jo;
    }
    //******
    //***PARSE ROOM***
    public static Room parseJsonToRoom (JSONObject obj) throws ParseException {

        System.out.println(obj.toString());
        JSONObject TRobj= obj.getJSONObject("typeroomByIdTRoom");


        Room room = new Room(obj.getInt("idRoom"), obj.getInt("nRoom"), obj.getInt("idTRoom"), parseJsonToTypeRoom(TRobj));

        return room;
    }

    public static JSONObject parseRoomToJson(Room room){

        JSONObject jo = new JSONObject();
        JSONObject joTypeRoom = parseTypeRoomToJson(room.getTyperoomByIdTRoomTR());

        jo.put("idRoom", room.getIdRoom());
        jo.put("nRoom", room.getnRoom());
        jo.put("idTRoom", room.getIdTRoom());
        jo.put("typeroomByIdTRoom", joTypeRoom);

        return jo;
    }
    //******
    //***PARSE ROOM TYPE***
    public static JSONObject parseTypeRoomToJson(Typeroom typeroom){
        JSONObject jo = new JSONObject();
        JSONObject joPicture = new JSONObject();

        joPicture.put("idPicture", typeroom.getPictureByIdPic().getIdPicture());
        joPicture.put("fileName", typeroom.getPictureByIdPic().getFileName());
        joPicture.put("width", typeroom.getPictureByIdPic().getWidth());
        joPicture.put("height", typeroom.getPictureByIdPic().getHeight());
        joPicture.put("uploadedNname", typeroom.getPictureByIdPic().getUploadedNname());
        jo.put("idTRoom", typeroom.getIdTRoom());
        jo.put("nameTRoom", typeroom.getNameTRoom());
        jo.put("roominess", typeroom.getRoominess());
        jo.put("price", typeroom.getPrice());
        jo.put("idPicture", typeroom.getPictureByIdPic().getIdPicture());
        jo.put("pictureByIdPicture", joPicture);

        return jo;
    }

    public static Typeroom parseJsonToTypeRoom (JSONObject obj) throws ParseException {

        System.out.println(obj.toString());
        JSONObject obj1= obj.getJSONObject("pictureByIdPicture");

        Typeroom typeroom = new Typeroom(obj.getInt("idTRoom"), obj.getString("nameTRoom"), obj.getInt("roominess"), BigDecimal.valueOf(obj.getDouble("price")), obj.getInt("idPicture"), obj1);

        return typeroom;
    }
    //*******
    //***PARSE RESERVATION***
    public static Reservation parseJsonToReservation (JSONObject obj) throws ParseException {

        System.out.println(obj.toString());
        JSONObject RoomObj= obj.getJSONObject("roomByIdRoom");
        JSONObject UserObj= obj.getJSONObject("userByIdUser");
        Date checkIn = null;
        Date checkOut = null;
        if(obj.getInt("idReserv")==0) {
            checkIn = parseLongToDate(obj.getLong("checkInDate"));
            checkOut = parseLongToDate(obj.getLong("checkOutDate"));
        }
        else {
            checkIn = parseStringToDate(obj.getString("checkInDate"));
            checkOut = parseStringToDate(obj.getString("checkOutDate"));
        }

        Reservation reservation = new Reservation(obj.getInt("idReserv"), obj.getInt("idUser"), obj.getInt("idRoom"), checkIn, checkOut, (byte) obj.getInt("complete"), (float)obj.getDouble("interestPayment"), (byte) obj.getInt("arrived"), parseJsonToRoom(RoomObj), parseJsonToUser(UserObj));

        return reservation;
    }

    public static JSONObject parseReservationToJson(Reservation reservation){

        JSONObject jo = new JSONObject();
        JSONObject joRoom = parseRoomToJson(reservation.getRoomByIdRoomR());
        JSONObject joUser = parseUserToJson(reservation.getUserByIdUser());

        jo.put("idReserv", reservation.getIdReserv());
        jo.put("idUser", reservation.getUserByIdUser().getIdUser());
        jo.put("idRoom", reservation.getRoomByIdRoomR().getIdRoom());
        jo.put("checkInDate", parseDateToString(reservation.getCheckInDateR()));
        jo.put("checkOutDate", parseDateToString(reservation.getCheckOutDateR()));
        jo.put("complete", reservation.getComplete());
        jo.put("interestPayment", reservation.getInterestPayment());
        jo.put("arrived", reservation.getArrived());
        jo.put("roomByIdRoom", joRoom);
        jo.put("userByIdUser", joUser);

        return jo;
    }
    //******
    //***PARSE CHECK***
    public static Check_r parseJsonToCheck (JSONObject obj) throws ParseException {

        System.out.println(obj.toString());

        Check_r check_r = new Check_r(obj.getInt("idCheck"), obj.getInt("idReserv"), BigDecimal.valueOf(obj.getDouble("payment")));

        return check_r;
    }

    public static JSONObject parseCheckToJson(Check_r check_r){

        JSONObject jo = new JSONObject();

        jo.put("idCheck", check_r.getIdCheck());
        jo.put("idReserv", check_r.getIdReserv());
        jo.put("payment", check_r.getPayment());

        return jo;
    }
    //******
}
