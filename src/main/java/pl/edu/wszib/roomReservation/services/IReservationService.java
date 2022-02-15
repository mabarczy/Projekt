package pl.edu.wszib.roomReservation.services;

import pl.edu.wszib.roomReservation.model.Reservation;

import java.util.List;

public interface IReservationService {
    public void addReservation(Reservation reservation);
    public List<Reservation> getReservationsForCurrentUser();
}
