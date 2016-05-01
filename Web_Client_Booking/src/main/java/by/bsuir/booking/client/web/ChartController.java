package by.bsuir.booking.client.web;


import by.bsuir.booking.client.model.Room;
import by.bsuir.booking.client.model.Typeroom;
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

}
