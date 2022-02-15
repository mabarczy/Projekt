package pl.edu.wszib.roomReservation.database;

import pl.edu.wszib.roomReservation.model.Reservation;

import java.util.List;

public interface IReservationDAO {
    void addReservation(Reservation reservation);
    List<Reservation> getReservations();
    public List<Reservation> getReservationsByUserId(int userId);

}
