package pl.edu.wszib.roomReservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.wszib.roomReservation.database.IRoomDAO;
import pl.edu.wszib.roomReservation.model.Reservation;
import pl.edu.wszib.roomReservation.services.IReservationService;
import pl.edu.wszib.roomReservation.session.SessionObject;

import javax.annotation.Resource;

@Controller
public class ReservationController {

    @Autowired
    IReservationService reservationService;

    @Autowired
    IRoomDAO roomDAO;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/reservations/add/{roomId}")
    public String addReservation(@PathVariable Integer roomId){
        Reservation reservation = new Reservation(sessionObject.getUser(), roomDAO.getRoomById(roomId).get(), sessionObject.getStartDate(), sessionObject.getEndDate());
        reservationService.addReservation(reservation);
        return "redirect:/main";
    }

    @RequestMapping(value = "/reservations")
    public String reservation(Model model){
        model.addAttribute("logged", this.sessionObject.isLogged());
        model.addAttribute("reservations", this.reservationService.getReservationsForCurrentUser());
        return "reservations";
    }

}
