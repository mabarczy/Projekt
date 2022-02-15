package pl.edu.wszib.roomReservation.services;

import pl.edu.wszib.roomReservation.model.Room;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IRoomService {
    List<Room> getAllRooms();
    List<Room> getEmptyRooms(LocalDate startDate, LocalDate endDate);
}
