package pl.edu.wszib.roomReservation.database;

import pl.edu.wszib.roomReservation.model.Room;

import java.util.List;
import java.util.Optional;

public interface IRoomDAO {
    List<Room> getRooms();
    Optional<Room> getRoomById(int id);
    void updateRoom(Room room);
}