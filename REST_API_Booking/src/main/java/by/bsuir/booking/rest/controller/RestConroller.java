package by.bsuir.booking.rest.controller;

import by.bsuir.booking.rest.model.User;
import by.bsuir.booking.rest.services.UserServices;
import by.bsuir.booking.rest.util.Status;
import by.bsuir.booking.rest.util.UserNotFoundException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by User on 11.04.2016.
 */
@Controller
@RequestMapping("/rest")
public class RestConroller {

    @Autowired
    UserServices userServices;

    static final Logger logger = Logger.getLogger(RestController.class);

    @RequestMapping(value = "/user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status addUser(@RequestBody User user) {
        try {
            userServices.addUser(user);
            return new Status(200, "User added Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/users", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status addUsers(@RequestBody List<User> users) {
        try {
            userServices.addUsers(users);
            return new Status(200, "Users added Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status updUser(@RequestBody User user) {
        try {
            userServices.updateUser(user);
            return new Status(200, "User update Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/users", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status updUsers(@RequestBody List<User> users) {
        try {
            userServices.updateUsers(users);
            return new Status(200, "Users update Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public @ResponseBody
    User getUser(@PathVariable("id") int id) {
        User user = null;
        try {
            user = userServices.getUserById(id);
            if (user==null)
                throw new UserNotFoundException(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public @ResponseBody
    List<User> getUsers() {
        List<User> employeeList = null;
        try {
            System.out.println("GOVNO");
            employeeList = userServices.getUserList();
            for (User user:employeeList){
                System.out.println(user.getSecondName());
                System.out.println(user.getRoleByIdRole().getNameRole());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @RequestMapping(value = "/users", method = RequestMethod.DELETE)
    public @ResponseBody
    Status delUsers() {
        try {
            userServices.deleteAllUsers();
            return new Status(200, "Users deleted Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    Status delUser(@PathVariable("id") int id) {

        try {
            userServices.deleteUser(id);
            return new Status(200, "User deleted Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }
}
