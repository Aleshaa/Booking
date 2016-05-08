package by.bsuir.booking.client.web;

import by.bsuir.booking.client.model.Typeroom;
import by.bsuir.booking.client.service.SecurityService;
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

    @RequestMapping(value = "/trEdit", method = RequestMethod.GET)
    public String editTypeRoom(HttpServletRequest request, Model model) throws IOException, ParseException {
        int id = Integer.parseInt(request.getParameter("id"));
        Typeroom tr = typeroomService.getTypeRoomByID(id);
        model.addAttribute("trForm", tr);
        return "trAdd";
    }

    @RequestMapping(value = "/trAdd", method = RequestMethod.GET)
    public String addTypeRoom(Model model) {
        model.addAttribute("trForm", new Typeroom());

        return "trAdd";
    }

    @RequestMapping(value = "/trEdit", method = RequestMethod.POST)
    public String editTypeRoom(@ModelAttribute("trForm") Typeroom trForm, BindingResult bindingResult, Model model, HttpServletRequest req) throws IOException, ParseException {

        if(trForm.getPictureByIdPic()!=null) {
            if(trForm.getPictureByIdPic().getUploadedNname()!=null&&!trForm.getPictureByIdPic().getUploadedNname().trim().equals(""))
                typeroomService.update(trForm);
            else{
                trForm.setPictureByIdPicture(req.getParameter("pic"));
                typeroomService.update(trForm);
            }
        }

        return "redirect:/trList";
    }

    @RequestMapping(value = "/trAdd", method = RequestMethod.POST)
    public String addTypeRoom(@ModelAttribute("trForm") Typeroom trForm, BindingResult bindingResult, Model model) throws IOException, ParseException {

        typeroomService.save(trForm);

        return "redirect:/trList";
    }

    @RequestMapping(value = "/deleteTR", method = RequestMethod.GET)
    public ModelAndView deleteContact(HttpServletRequest request) throws IOException {
        int TrID = Integer.parseInt(request.getParameter("id"));
        typeroomService.delTTypeRoom(TrID);
        return new ModelAndView("redirect:/trList");
    }

}
