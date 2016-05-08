package by.bsuir.booking.client.web;

import by.bsuir.booking.client.Util.ParseUtil;
import by.bsuir.booking.client.model.*;
import by.bsuir.booking.client.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ReservController {

    @Autowired
    TyperoomService typeroomService;
    @Autowired
    RoomService roomService;
    @Autowired
    ReservationService reservationService;
    @Autowired
    UserService userService;
    @Autowired
    Check_rService check_rService;

    @RequestMapping(value = "/reserv", method = RequestMethod.GET)
    public String makeReserv(HttpServletRequest request, Model model) throws IOException, ParseException {
            String dateFrom = request.getParameter("yearFrom") + "-" + request.getParameter("monthFrom") + "-" + request.getParameter("dayFrom");
            if(ParseUtil.parseStringToDate(dateFrom).getTime()<(new java.util.Date()).getTime()) {
                model.addAttribute("messageNav", "Некорректная дата");
                return "welcome";
            }
            else {
                model.addAttribute("messageNav", "");
            }
            int count = Integer.parseInt(request.getParameter("count"));
            int countDay = Integer.parseInt(request.getParameter("duration"));
            int dayFor = 0;
            int monthFor = Integer.parseInt(request.getParameter("monthFrom"));
            int yearFor = Integer.parseInt(request.getParameter("yearFrom"));
            if ((countDay + Integer.parseInt(request.getParameter("dayFrom"))) > 30) {
                dayFor = Integer.parseInt(request.getParameter("dayFrom")) % 30;
                monthFor += Integer.parseInt(request.getParameter("dayFrom")) / 30;
                if (monthFor > 12) {
                    monthFor = monthFor - 12;
                    yearFor += monthFor / 12;
                }
            } else {
                dayFor = countDay + Integer.parseInt(request.getParameter("dayFrom"));
            }
            String dateFor;
            if(monthFor<10){
                dateFor = yearFor + "-0" + monthFor;
            }
            else {
                dateFor = yearFor + "-" + monthFor;
            }
            if(dayFor < 10){
                dateFor = dateFor + "-0" + dayFor;
            }
            else {
                dateFor = dateFor + "-" + dayFor;
            }
            model.addAttribute("dateFrom", dateFrom);
            model.addAttribute("dateFor", dateFor);
            List<Room> freeRooms = roomService.getFreeRooms(dateFrom, dateFor);
            List<Typeroom> trList = typeroomService.getAllTypeRoom();
            List<Typeroom> resultTR = new ArrayList<Typeroom>();
            int counter = 0;
            if (freeRooms.size() > 0) {
                for (Typeroom tr : trList) {
                    int flag = 0;
                    for (Room room : freeRooms) {
                        if (tr.getIdTRoom() == room.getIdTRoom() && count == tr.getRoominess()) {
                            counter++;
                            flag = 1;
                        }
                    }
                    if (flag == 1) {
                        resultTR.add(tr);
                    }
                }
            }
            model.addAttribute("count", counter);
            model.addAttribute("roominess", count);
            model.addAttribute("listTR", resultTR);
            return "reserv";
    }

    @RequestMapping(value = "/bookingRoom", method = RequestMethod.GET)
    public String bookingRoom(HttpServletRequest request, Model model) throws IOException, ParseException {
        int TrID = Integer.parseInt(request.getParameter("id"));
        Typeroom tr = typeroomService.getTypeRoomByID(TrID);
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(name);
        int count = Integer.parseInt(request.getParameter("count"));
        String dateFrom = request.getParameter("date");
        String dateFor = ParseUtil.parseDateToString(ParseUtil.parseLongToDate((ParseUtil.parseStringToDate(dateFrom).getTime() + count * 60000 * 1440)/1000));
        if(user.getCash().doubleValue()>count*tr.getPrice().doubleValue()){
            model.addAttribute("count", -1);
            model.addAttribute("message", "Успешно забронировано");
            List<Room> freeRooms = roomService.getFreeRooms(dateFrom,dateFor);
            for (Room room:freeRooms){
                if(tr.getIdTRoom()==room.getIdTRoom()){
                    System.out.println("User cash before set in reserv: " + user.getCash());
                    System.out.println(user.getCash().doubleValue() + "-" + count * tr.getPrice().doubleValue() * 0.5 + "=" + BigDecimal.valueOf(user.getCash().doubleValue() - count * tr.getPrice().doubleValue() * 0.5));
                    user.setCash(BigDecimal.valueOf(user.getCash().doubleValue() - count * tr.getPrice().doubleValue() * 0.5));
                    System.out.println("User cash after set in reserv: " + user.getCash());
                    Reservation reservation = new Reservation(0,user.getIdUser(),room.getIdRoom(),ParseUtil.parseStringToDate(dateFrom),ParseUtil.parseStringToDate(dateFor), (byte)0, (float)0.5, (byte)0, room, user);
                    userService.update(user);
                    reservationService.save(reservation);
                    List<Reservation> list = reservationService.getAll();
                    Reservation res = new Reservation();
                    for(Reservation reserv:list){
                        res=reserv;
                    }
                    Check_r check_r = new Check_r(0,res.getIdReserv(), BigDecimal.valueOf((double)reservation.getInterestPayment()*reservation.getRoomByIdRoomR().getTyperoomByIdTRoomTR().getPrice().doubleValue()), res);
                    System.out.println("CHECK"+check_r.getPayment());
                    check_rService.save(check_r);
                    break;
                }
            }
        }
        else{
            model.addAttribute("count", -1);
            model.addAttribute("message", "Недостаточно средств");
        }
        return "reserv";
    }
}
