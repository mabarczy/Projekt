package pl.edu.wszib.roomReservation.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.roomReservation.database.IReservationDAO;
import pl.edu.wszib.roomReservation.model.Reservation;
import pl.edu.wszib.roomReservation.services.IReservationService;
import pl.edu.wszib.roomReservation.session.SessionObject;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReservationService implements IReservationService {
    @Autowired
    IReservationDAO reservationDAO;

    @Resource
    SessionObject sessionObject;

    @Override
    public void addReservation(Reservation reservation) {
        reservationDAO.addReservation(reservation);
    }

    @Override
    public List<Reservation> getReservationsForCurrentUser() {
        return this.reservationDAO.getReservationsByUserId(this.sessionObject.getUser().getId());
    }
}
