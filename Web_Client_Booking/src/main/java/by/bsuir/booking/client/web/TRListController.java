package by.bsuir.booking.client.web;

import by.bsuir.booking.client.model.Typeroom;
import by.bsuir.booking.client.service.SecurityService;
import by.bsuir.booking.client.service.TyperoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@Controller
public class TRListController {

    @Autowired
    private TyperoomService typeroomService;

    @Autowired
    private SecurityService securityService;

    @RequestMapping(value="/trList")
    public ModelAndView listUser(ModelAndView model) throws IOException, ParseException {
        List<Typeroom> listContact = typeroomService.getAllTypeRoom();
        model.addObject("listTR", listContact);
        model.setViewName("trList");

        return model;
    }

}
