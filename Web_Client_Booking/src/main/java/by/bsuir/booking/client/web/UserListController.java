package by.bsuir.booking.client.web;

import by.bsuir.booking.client.model.User;
import by.bsuir.booking.client.service.SecurityService;
import by.bsuir.booking.client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by User on 25.04.2016.
 */
@Controller
public class UserListController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @RequestMapping(value="/userList")
    public ModelAndView listUser(ModelAndView model) throws IOException, ParseException {
        List<User> listContact = userService.getAllUsers();
        model.addObject("listUser", listContact);
        model.setViewName("userList");

        return model;
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public ModelAndView deleteContact(HttpServletRequest request) throws IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        userService.delUser(userId);
        return new ModelAndView("redirect:/userList");
    }

    /*@RequestMapping(value = "/newContact", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        Contact newContact = new Contact();
        model.addObject("contact", newContact);
        model.setViewName("ContactForm");
        return model;
    }

    @RequestMapping(value = "/saveContact", method = RequestMethod.POST)
    public ModelAndView saveContact(@ModelAttribute Contact contact) {
        contactDAO.saveOrUpdate(contact);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
    public ModelAndView deleteContact(HttpServletRequest request) {
        int contactId = Integer.parseInt(request.getParameter("id"));
        contactDAO.delete(contactId);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/editContact", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int contactId = Integer.parseInt(request.getParameter("id"));
        Contact contact = contactDAO.get(contactId);
        ModelAndView model = new ModelAndView("ContactForm");
        model.addObject("contact", contact);

        return model;
    }*/
}
