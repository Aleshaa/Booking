package by.bsuir.booking.client.web;


import by.bsuir.booking.client.model.Check_r;
import by.bsuir.booking.client.model.Reservation;
import by.bsuir.booking.client.model.Room;
import by.bsuir.booking.client.model.Typeroom;
import by.bsuir.booking.client.service.Check_rService;
import by.bsuir.booking.client.service.ReservationService;
import by.bsuir.booking.client.service.RoomService;
import by.bsuir.booking.client.service.TyperoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@Controller
public class ChartController {

    @Autowired
    private TyperoomService typeroomService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private Check_rService check_rService;

    @RequestMapping(value="/TypeStat")
    public ModelAndView listReserv(ModelAndView model) throws IOException, ParseException {
        List<Typeroom> trlist = typeroomService.getAllTypeRoom();
        List<Room> roomList = roomService.getAllRooms();
        String str = "";
        int flag = 0;
        for(Typeroom tr:trlist){
            if(flag==0) {
                str += tr.getNameTRoom();
                flag = 1;
            }
            else{
                str+="," + tr.getNameTRoom();
            }
            int count = 0;
            for(Room room:roomList){
                if(room.getIdTRoom()==tr.getIdTRoom()){
                    count++;
                }
            }
            str+=":" + count;
        }
        model.addObject("chart", str);
        model.setViewName("TypeStat");

        return model;
    }

    @RequestMapping(value="/BarChart")
    public ModelAndView barChart(ModelAndView model) throws IOException, ParseException {
        List<Typeroom> trlist = typeroomService.getAllTypeRoom();
        List<Room> roomList = roomService.getAllRooms();
        List<Reservation> reservationList = reservationService.getAll();
        String str = "";
        int flag = 0;
        for(Typeroom tr:trlist){
            if(flag==0) {
                str += tr.getNameTRoom();
                flag = 1;
            }
            else{
                str+="," + tr.getNameTRoom();
            }
            int count = 0;
            for(Room room:roomList){
                if(room.getIdTRoom()==tr.getIdTRoom()){
                    for(Reservation reservation:reservationList){
                        if(reservation.getIdRoom() == room.getIdRoom()){
                            count++;
                        }
                    }
                }
            }
            str+=":" + count;
        }
        model.addObject("chart", str);
        model.setViewName("BarChart");

        return model;
    }

    @RequestMapping(value="/BarChartProfit")
    public ModelAndView barChartProfit(ModelAndView model) throws IOException, ParseException {
        List<Typeroom> trlist = typeroomService.getAllTypeRoom();
        List<Room> roomList = roomService.getAllRooms();
        List<Reservation> reservationList = reservationService.getAll();
        List<Check_r> check_rList = check_rService.getAll();
        String str = "";
        int flag = 0;
        for(Typeroom tr:trlist){
            if(flag==0) {
                str += tr.getNameTRoom();
                flag = 1;
            }
            else{
                str+="," + tr.getNameTRoom();
            }
            double count = 0;
            for(Room room:roomList){
                if(room.getIdTRoom()==tr.getIdTRoom()){
                    for(Reservation reservation:reservationList){
                        if(reservation.getIdRoom() == room.getIdRoom()){
                            for (Check_r check_r:check_rList){
                                if (check_r.getIdReserv()==reservation.getIdReserv())
                                    count+=check_r.getPayment().doubleValue();
                            }
                        }
                    }
                }
            }
            str+=":" + count;
        }
        model.addObject("chart", str);
        model.setViewName("BarChartProfit");

        return model;
    }

}
