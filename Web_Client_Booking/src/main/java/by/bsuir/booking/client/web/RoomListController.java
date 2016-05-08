package by.bsuir.booking.client.web;

import by.bsuir.booking.client.model.Room;
import by.bsuir.booking.client.model.Typeroom;
import by.bsuir.booking.client.service.RoomService;
import by.bsuir.booking.client.service.TyperoomService;
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
public class RoomListController {
    @Autowired
    RoomService roomService;
    @Autowired
    TyperoomService trService;

    @RequestMapping(value="/roomList")
    public ModelAndView listRoom(ModelAndView model) throws IOException, ParseException {
        List<Room> listContact = roomService.getAllRooms();
        model.addObject("listRoom", listContact);
        model.setViewName("roomList");

        return model;
    }

    @RequestMapping(value = "/roomEdit", method = RequestMethod.GET)
    public String editRoom(HttpServletRequest request, Model model) throws IOException, ParseException {
        int id = Integer.parseInt(request.getParameter("id"));
        Room room = roomService.getRoomByID(id);
        List<Typeroom> trList = trService.getAllTypeRoom();
        model.addAttribute("roomForm", room);
        model.addAttribute("TRList", trList);
        return "roomAdd";
    }

    @RequestMapping(value = "/roomEdit", method = RequestMethod.POST)
    public String editRoom(@ModelAttribute("roomForm") Room roomForm, BindingResult bindingResult, Model model) throws IOException, ParseException {

        System.out.println(roomForm.getTyperoomByIdTRoomTR().getNameTRoom());
        Typeroom tr = trService.getTypeRoomByName(roomForm.getTyperoomByIdTRoomTR().getNameTRoom());
        roomForm.setIdTRoom(tr.getIdTRoom());
        roomForm.setTyperoomByIdTRoomTR(tr);
        roomService.update(roomForm);

        return "redirect:/roomList";
    }

    @RequestMapping(value = "/roomAdd", method = RequestMethod.GET)
    public String addRoom(Model model) throws IOException, ParseException {

        List<Typeroom> trList = trService.getAllTypeRoom();
        model.addAttribute("TRList", trList);
        model.addAttribute("roomForm", new Room());
        return "roomAdd";
    }

    @RequestMapping(value = "/roomAdd", method = RequestMethod.POST)
    public String addRoom(@ModelAttribute("roomForm") Room roomForm, BindingResult bindingResult, Model model) throws IOException, ParseException {
        System.out.println(roomForm.getTyperoomByIdTRoomTR().getNameTRoom());
        Typeroom tr = trService.getTypeRoomByName(roomForm.getTyperoomByIdTRoomTR().getNameTRoom());
        roomForm.setIdTRoom(tr.getIdTRoom());
        roomForm.setTyperoomByIdTRoomTR(tr);
        roomService.save(roomForm);

        return "redirect:/roomList";
    }

    @RequestMapping(value = "/deleteRoom", method = RequestMethod.GET)
    public ModelAndView deleteContact(HttpServletRequest request) throws IOException {
        int RoomID = Integer.parseInt(request.getParameter("id"));
        roomService.delRoom(RoomID);
        return new ModelAndView("redirect:/roomList");
    }
}
