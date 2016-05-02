package by.bsuir.booking.rest.util;


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
}
