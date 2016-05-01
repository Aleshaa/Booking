package by.bsuir.booking.client.web;

import by.bsuir.booking.client.model.Reservation;
import by.bsuir.booking.client.model.Room;
import by.bsuir.booking.client.model.User;
import by.bsuir.booking.client.service.ReservationService;
import by.bsuir.booking.client.service.RoomService;
import by.bsuir.booking.client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@Controller
public class ReservationListController {

    @Autowired
    ReservationService reservationService;
    @Autowired
    RoomService roomService;
    @Autowired
    UserService userService;

    @RequestMapping(value="/reservList")
    public ModelAndView listReserv(ModelAndView model) throws IOException, ParseException {
        List<Reservation> listContact = reservationService.getAll();
        model.addObject("listReserv", listContact);
        model.setViewName("reservList");

        return model;
    }

    @RequestMapping(value = "/reservEdit", method = RequestMethod.GET)
    public String editReserv(HttpServletRequest request, Model model) throws IOException, ParseException {
        int id = Integer.parseInt(request.getParameter("id"));
        Reservation reservation = reservationService.getReservationByID(id);
        List<Room> roomList = roomService.getAllRooms();
        model.addAttribute("reservForm", reservation);
        model.addAttribute("RoomList", roomList);
        return "reservAdd";
    }

    @RequestMapping(value = "/reservEdit", method = RequestMethod.POST)
    public String editReserv(@ModelAttribute("reservForm") Reservation reservForm, BindingResult bindingResult, Model model) throws IOException, ParseException {

        Room room = roomService.getByRoomN(reservForm.getRoomByIdRoomR().getnRoom());
        User user = userService.getByID(reservForm.getIdUser());
        reservForm.setIdRoom(room.getIdRoom());
        reservForm.setUserByIdUser(user);
        reservForm.setRoomByIdRoomR(room);
        reservationService.update(reservForm);

        return "redirect: reservList";
    }

    @RequestMapping(value = "/reservAdd", method = RequestMethod.GET)
    public String addReserv(Model model) throws IOException, ParseException {

        List<Room> roomList = roomService.getAllRooms();
        model.addAttribute("RoomList", roomList);
        model.addAttribute("reservForm", new Reservation());
        return "reservAdd";
    }

    @RequestMapping(value = "/reservAdd", method = RequestMethod.POST)
    public String addReserv(@ModelAttribute("reservForm") Reservation reservForm, BindingResult bindingResult, Model model) throws IOException, ParseException {
        Room room = roomService.getByRoomN(reservForm.getRoomByIdRoomR().getnRoom());
        User user = userService.getByID(reservForm.getIdUser());
        reservForm.setIdRoom(room.getIdRoom());
        reservForm.setUserByIdUser(user);
        reservForm.setRoomByIdRoomR(room);
        reservationService.save(reservForm);

        return "redirect: reservList";
    }

    @RequestMapping(value = "/deleteReserv", method = RequestMethod.GET)
    public ModelAndView deleteReserv(HttpServletRequest request) throws IOException {
        int ReservID = Integer.parseInt(request.getParameter("id"));
        reservationService.delete(ReservID);
        return new ModelAndView("redirect:/reservList");
    }
}
