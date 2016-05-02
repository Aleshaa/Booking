package by.bsuir.booking.client.web;

import by.bsuir.booking.client.model.User;
import by.bsuir.booking.client.service.SecurityService;
import by.bsuir.booking.client.service.UserService;
import by.bsuir.booking.client.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class UserListController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;


    @RequestMapping(value="/userList")
    public ModelAndView listUser(ModelAndView model) throws IOException, ParseException {
        List<User> listContact = userService.getAllUsers();
        model.addObject("listUser", listContact);
        model.setViewName("userList");

        return model;
    }

    @RequestMapping(value="/personalAccount")
    public ModelAndView showAccount(ModelAndView model) throws IOException, ParseException {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User account = userService.findByUsername(name);
        model.addObject("user", account);
        model.setViewName("personalAccount");

        return model;
    }

    @RequestMapping(value = "/editAccount", method = RequestMethod.GET)
    public String editAccount(HttpServletRequest request, Model model) throws IOException, ParseException {
        model.addAttribute("userForm", userService.getByID(Integer.parseInt(request.getParameter("id"))));
        return "editAccount";
    }

    @RequestMapping(value = "/editAccount", method = RequestMethod.POST)
    public String editAccount(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) throws IOException, ParseException {
        /*userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }*/

        User updUser = userService.findByUsername(userForm.getUsername());
        userForm.setCash(updUser.getCash());
        userForm.setPassword(updUser.getPassword());
        userForm.setIdRole(updUser.getIdRole());
        userForm.setRoleByIdRole(updUser.getRoleByIdRole());
        userService.update(userForm);

        return "redirect:/personalAccount";
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public ModelAndView deleteContact(HttpServletRequest request) throws IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        userService.delUser(userId);
        return new ModelAndView("redirect:/userList");
    }

    @RequestMapping(value = "/fillUpBalance", method = RequestMethod.GET)
    public ModelAndView fillUpBalance(HttpServletRequest request) throws IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        System.out.println(userId + " Test fill up balance");
        return new ModelAndView("redirect:/personalAccount");
    }
}
