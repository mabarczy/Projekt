package pl.edu.wszib.roomReservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.wszib.roomReservation.model.User;
import pl.edu.wszib.roomReservation.services.IRoomService;
import pl.edu.wszib.roomReservation.session.SessionObject;

import javax.annotation.Resource;
import java.time.LocalDate;

@Controller
public class CommonController {

    @Autowired
    IRoomService roomService;

    @Resource
    SessionObject sessionObject;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main() {
        return "redirect:/main";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model) {
        model.addAttribute("rooms", this.roomService.getEmptyRooms(sessionObject.getStartDate(), sessionObject.getEndDate()));
        model.addAttribute("logged", this.sessionObject.isLogged());
        model.addAttribute("startDate", this.sessionObject.getStartDate());
        model.addAttribute("endDate", this.sessionObject.getEndDate());
        return "main";
    }

    @RequestMapping(value = "/main", method = RequestMethod.POST)
    public String handleDate(@RequestParam("startDate")String startDate,
                             @RequestParam("endDate")String endDate){

        sessionObject.setStartDate(LocalDate.parse(startDate));
        sessionObject.setEndDate(LocalDate.parse(endDate));
        if(sessionObject.getStartDate().isAfter(sessionObject.getEndDate()) || sessionObject.getStartDate().equals(sessionObject.getEndDate())){
            sessionObject.setEndDate(sessionObject.getStartDate().plusDays(1));
        }

        return "redirect:/main";
    }
}