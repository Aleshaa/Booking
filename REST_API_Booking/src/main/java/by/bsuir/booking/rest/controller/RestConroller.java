package by.bsuir.booking.rest.controller;

import by.bsuir.booking.rest.model.*;
import by.bsuir.booking.rest.services.*;
import by.bsuir.booking.rest.util.Status;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class RestConroller {

    @Autowired
    UserServices userServices;

    @Autowired
    CheckServices checkServices;

    @Autowired
    PictureServices pictureServices;

    @Autowired
    ReservationServices reservationServices;

    @Autowired
    RoleServices roleServices;

    @Autowired
    RoomServices roomServices;

    @Autowired
    TypeRoomServices typeRoomServices;

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
                user = new User();
        } catch (Exception e) {
            e.printStackTrace();
            user = new User();
            return user;
        }
        return user;
    }

    @RequestMapping(value = "/user/search/{name}", method = RequestMethod.GET)
    public @ResponseBody
    User getUserByName(@PathVariable("name") String userName) {
        User user = null;
        try {
            user = userServices.getUserByName(userName);
            if (user==null)
                user = new User();
            else
                System.out.println(user.getFirstName());
        } catch (Exception e) {
            e.printStackTrace();
            user = new User();
            return user;
        }
        return user;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public @ResponseBody
    List<User> getUsers() {
        List<User> employeeList = null;
        try {
            employeeList = userServices.getUserList();
            for (User user:employeeList){
                System.out.println(user.getSecondName());
                System.out.println(user.getRoleByIdRole().getNameRole());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return employeeList;
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
    ////
    @RequestMapping(value = "/check", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status addCheck(@RequestBody Check_r check) {
        try {
            checkServices.addCheck(check);
            return new Status(200, "Check added Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/checks", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status addChecks(@RequestBody List<Check_r> check_rList) {
        try {
            checkServices.addChecks(check_rList);
            return new Status(200, "Checks added Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/check/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status updCheck(@RequestBody Check_r check_r) {
        try {
            checkServices.updateCheck(check_r);
            return new Status(200, "Check update Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/checks", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status updChecks(@RequestBody List<Check_r> check_rList) {
        try {
            checkServices.updateChecks(check_rList);
            return new Status(200, "Checks update Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/check/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Check_r getCheck(@PathVariable("id") int id) {
        Check_r check_r = null;
        try {
            check_r = checkServices.getCheckById(id);
            if (check_r==null)
                check_r = new Check_r();
        } catch (Exception e) {
            e.printStackTrace();
            check_r = new Check_r();
            return check_r;
        }
        return check_r;
    }

    @RequestMapping(value = "/checks", method = RequestMethod.GET)
    public @ResponseBody
    List<Check_r> getChecks() {
        List<Check_r> checkRList = null;
        try {
            checkRList = checkServices.getCheckList();
            /*for (Check_r check_r:checkRList){
                System.out.println(user.getSecondName());
                System.out.println(user.getRoleByIdRole().getNameRole());
            }*/
        } catch (Exception e) {
            e.printStackTrace();
            return checkRList;
        }
        return checkRList;
    }

    @RequestMapping(value = "/checks", method = RequestMethod.DELETE)
    public @ResponseBody
    Status delChecks() {
        try {
            checkServices.deleteAllChecks();
            return new Status(200, "Checks deleted Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }
    }

    @RequestMapping(value = "check/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    Status delCheck(@PathVariable("id") int id) {
        try {
            checkServices.deleteCheck(id);
            return new Status(200, "Check deleted Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }
    }

    ////

    @RequestMapping(value = "/picture", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status addPic(@RequestBody Picture picture) {
        try {
            pictureServices.addPicture(picture);
            return new Status(200, "Picture added Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/pictures", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status addPics(@RequestBody List<Picture> pictures) {
        try {
            pictureServices.addPictures(pictures);
            return new Status(200, "Pictures added Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/picture/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status updPic(@RequestBody Picture picture) {
        try {
            pictureServices.updatePicture(picture);
            return new Status(200, "Picture update Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/pictures", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status updPics(@RequestBody List<Picture> pictures) {
        try {
            pictureServices.updatePictures(pictures);
            return new Status(200, "Pictures update Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/picture/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Picture getPic(@PathVariable("id") int id) {
        Picture picture = null;
        try {
            picture = pictureServices.getPictureById(id);
            if (picture==null)
                picture = new Picture();
        } catch (Exception e) {
            e.printStackTrace();
            picture = new Picture();
            return picture;
        }
        return picture;
    }

    @RequestMapping(value = "/picture/search/{name}", method = RequestMethod.GET)
    public @ResponseBody
    Picture getPictureByPath(@PathVariable("name") String name) {
        Picture picture = null;
        try {
            picture = pictureServices.getPictureByPath(name);
            if (picture==null)
                picture = new Picture();
            else
                System.out.println(picture.getUploadedNname());
        } catch (Exception e) {
            e.printStackTrace();
            picture = new Picture();
            return picture;
        }
        return picture;
    }

    @RequestMapping(value = "/pictures", method = RequestMethod.GET)
    public @ResponseBody
    List<Picture> getPics() {
        List<Picture> pictureList = null;
        try {
            pictureList = pictureServices.getPictureList();
            /*for (User user:employeeList){
                System.out.println(user.getSecondName());
                System.out.println(user.getRoleByIdRole().getNameRole());
            }*/
        } catch (Exception e) {
            e.printStackTrace();
            return pictureList;
        }
        return pictureList;
    }

    @RequestMapping(value = "/pictures", method = RequestMethod.DELETE)
    public @ResponseBody
    Status delPics() {
        try {
            pictureServices.deleteAllPictures();
            return new Status(200, "Pictures deleted Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }
    }

    @RequestMapping(value = "picture/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    Status delPic(@PathVariable("id") int id) {

        try {
            pictureServices.deletePicture(id);
            return new Status(200, "Picture deleted Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }
    ////
    @RequestMapping(value = "/reservation", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status addReserv(@RequestBody Reservation reservation) {
        try {
            reservationServices.addReservation(reservation);
            return new Status(200, "Reservation added Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/reservations", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status addReservs(@RequestBody List<Reservation> reservationList) {
        try {
            reservationServices.addReservations(reservationList);
            return new Status(200, "Reservations added Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/reservation/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status updReserv(@RequestBody Reservation reservation) {
        try {
            reservationServices.updateReservation(reservation);
            return new Status(200, "Reservation update Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/reservations", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status updReservs(@RequestBody List<Reservation> reservationList) {
        try {
            reservationServices.updateReservations(reservationList);
            return new Status(200, "Reservations update Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/reservation/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Reservation getReserv(@PathVariable("id") int id) {
        Reservation reservation = null;
        try {
            reservation = reservationServices.getReservationById(id);
            if (reservation==null)
                reservation = new Reservation();
        } catch (Exception e) {
            e.printStackTrace();
            reservation = new Reservation();
            return reservation;
        }
        return reservation;
    }

    @RequestMapping(value = "/reservations", method = RequestMethod.GET)
    public @ResponseBody
    List<Reservation> getReservs() {
        List<Reservation> reservationList = null;
        try {
            reservationList = reservationServices.getReservationList();
            /*for (Check_r check_r:checkRList){
                System.out.println(user.getSecondName());
                System.out.println(user.getRoleByIdRole().getNameRole());
            }*/
        } catch (Exception e) {
            e.printStackTrace();
            return reservationList;
        }
        return reservationList;
    }

    @RequestMapping(value = "/reservations", method = RequestMethod.DELETE)
    public @ResponseBody
    Status delReservs() {
        try {
            reservationServices.deleteAllReservations();
            return new Status(200, "Reservations deleted Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }
    }

    @RequestMapping(value = "reservation/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    Status delReserv(@PathVariable("id") int id) {
        try {
            reservationServices.deleteReservation(id);
            return new Status(200, "Reservation deleted Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }
    }

    ////
    @RequestMapping(value = "/role", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status addRole(@RequestBody Role role) {
        try {
            roleServices.addRole(role);
            return new Status(200, "Role added Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/roles", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status addRoles(@RequestBody List<Role> roleList) {
        try {
            roleServices.addRoles(roleList);
            return new Status(200, "Roles added Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/role/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status updRole(@RequestBody Role role) {
        try {
            roleServices.updateRole(role);
            return new Status(200, "Role update Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }
    }

    @RequestMapping(value = "/roles", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status updRoles(@RequestBody List<Role> roleList) {
        try {
            roleServices.updateRoles(roleList);
            return new Status(200, "Roles update Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/role/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Role getRole(@PathVariable("id") int id) {
        Role role = null;
        try {
            role = roleServices.getRoleById(id);
            if (role==null)
                role = new Role();
        } catch (Exception e) {
            e.printStackTrace();
            role = new Role();
            return role;
        }
        return role;
    }

    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public @ResponseBody
    List<Role> getRoles() {
        List<Role> roleList = null;
        try {
            roleList = roleServices.getRoleList();
            /*for (Check_r check_r:checkRList){
                System.out.println(user.getSecondName());
                System.out.println(user.getRoleByIdRole().getNameRole());
            }*/
        } catch (Exception e) {
            e.printStackTrace();
            return roleList;
        }
        return roleList;
    }

    @RequestMapping(value = "/roles", method = RequestMethod.DELETE)
    public @ResponseBody
    Status delRoles() {
        try {
            roleServices.deleteAllRoles();
            return new Status(200, "Roles deleted Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }
    }

    @RequestMapping(value = "role/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    Status delRole(@PathVariable("id") int id) {
        try {
            roleServices.deleteRole(id);
            return new Status(200, "Role deleted Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }
    }

    ////

    @RequestMapping(value = "/room", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status addRoom(@RequestBody Room room) {
        try {
            roomServices.addRoom(room);
            return new Status(200, "Room added Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/rooms", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status addRooms(@RequestBody List<Room> rooms) {
        try {
            roomServices.addRooms(rooms);
            return new Status(200, "Rooms added Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/room/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status updRoom(@RequestBody Room room) {
        try {
            roomServices.updateRoom(room);
            return new Status(200, "Room update Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/rooms", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status updRooms(@RequestBody List<Room> rooms) {
        try {
            roomServices.updateRooms(rooms);
            return new Status(200, "Rooms update Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/room/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Room getRoom(@PathVariable("id") int id) {
        Room room = null;
        try {
            room = roomServices.getRoomById(id);
            if (room==null)
                room = new Room();
        } catch (Exception e) {
            e.printStackTrace();
            room = new Room();
            return room;
        }
        return room;
    }

    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    public @ResponseBody
    List<Room> getRooms() {
        List<Room> roomList = null;
        try {
            roomList = roomServices.getRoomList();
            /*for (User user:employeeList){
                System.out.println(user.getSecondName());
                System.out.println(user.getRoleByIdRole().getNameRole());
            }*/
        } catch (Exception e) {
            e.printStackTrace();
            return roomList;
        }
        return roomList;
    }

    @RequestMapping(value = "/typeroom/search/{name}", method = RequestMethod.GET)
    public @ResponseBody
    Typeroom getTRByName(@PathVariable("name") String name) {
        Typeroom tr = null;
        try {
            System.out.println("REST:TEST GET TR BY NAME: " + name);
            tr = typeRoomServices.getTypeRoomByName(name);
            if (tr==null)
                tr = new Typeroom();
            else
                System.out.println(tr.getNameTRoom());
        } catch (Exception e) {
            e.printStackTrace();
            tr = new Typeroom();
            return tr;
        }
        return tr;
    }

    @RequestMapping(value = "/rooms", method = RequestMethod.DELETE)
    public @ResponseBody
    Status delRooms() {
        try {
            roomServices.deleteAllRooms();
            return new Status(200, "Rooms deleted Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }
    }

    @RequestMapping(value = "room/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    Status delRoom(@PathVariable("id") int id) {

        try {
            roomServices.deleteRoom(id);
            return new Status(200, "Room deleted Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }
    ////
    @RequestMapping(value = "/typeroom", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status addTRoom(@RequestBody Typeroom typeroom) {
        try {
            typeRoomServices.addTypeRoom(typeroom);
            return new Status(200, "TypeRoom added Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/typesroom", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status addTRooms(@RequestBody List<Typeroom> typeroomList) {
        try {
            typeRoomServices.addTypesRoom(typeroomList);
            return new Status(200, "TypesRoom added Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/typeroom/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status updTRoom(@RequestBody Typeroom typeroom) {
        try {
            System.out.println("TEST UPDATE CONTROL " + typeroom.getIdTRoom());
            typeRoomServices.updateTypeRoom(typeroom);
            return new Status(200, "TypeRoom update Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/typesroom", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Status updTRooms(@RequestBody List<Typeroom> typeroomList) {
        try {
            typeRoomServices.updateTypesRoom(typeroomList);
            return new Status(200, "TypesRoom update Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }

    }

    @RequestMapping(value = "/typeroom/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Typeroom getTRoom(@PathVariable("id") int id) {
        Typeroom typeroom = null;
        try {
            typeroom = typeRoomServices.getTypeRoomById(id);
            if (typeroom==null)
                typeroom = new Typeroom();
        } catch (Exception e) {
            e.printStackTrace();
            typeroom = new Typeroom();
            return typeroom;
        }
        return typeroom;
    }

    @RequestMapping(value = "/typesroom", method = RequestMethod.GET)
    public @ResponseBody
    List<Typeroom> getTRooms() {
        List<Typeroom> typeroomList = null;
        try {
            typeroomList = typeRoomServices.getTypeRoomList();
            /*for (Check_r check_r:checkRList){
                System.out.println(user.getSecondName());
                System.out.println(user.getRoleByIdRole().getNameRole());
            }*/
        } catch (Exception e) {
            e.printStackTrace();
            return typeroomList;
        }
        return typeroomList;
    }

    @RequestMapping(value = "/typesroom", method = RequestMethod.DELETE)
    public @ResponseBody
    Status delTRooms() {
        try {
            typeRoomServices.deleteAllTypesRoom();
            return new Status(200, "TypesRoom deleted Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }
    }

    @RequestMapping(value = "typeroom/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    Status delTRoom(@PathVariable("id") int id) {
        try {
            typeRoomServices.deleteTypeRoom(id);
            return new Status(200, "TypeRoom deleted Successfully !");
        } catch (Exception e) {
            return new Status(400, e.toString());
        }
    }

    ////
}
