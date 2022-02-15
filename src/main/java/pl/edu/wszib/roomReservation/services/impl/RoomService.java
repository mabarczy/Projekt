package pl.edu.wszib.roomReservation.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.roomReservation.database.IReservationDAO;
import pl.edu.wszib.roomReservation.database.IRoomDAO;
import pl.edu.wszib.roomReservation.model.Reservation;
import pl.edu.wszib.roomReservation.model.Room;
import pl.edu.wszib.roomReservation.model.User;
import pl.edu.wszib.roomReservation.services.IRoomService;

import java.io.Console;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService implements IRoomService {

    @Autowired
    IRoomDAO roomDAO;

    @Autowired
    IReservationDAO reservationDAO;

    @Override
    public List<Room> getAllRooms() {
        return roomDAO.getRooms();
    }

    @Override
    public List<Room> getEmptyRooms(LocalDate startDate, LocalDate endDate) {
        List<Room> roomList = roomDAO.getRooms();
        List<Reservation> reservations = reservationDAO.getReservations();
        List<Room> toRemove = new ArrayList<>();
        for(Reservation reservation : reservations){
            System.out.println(reservation.getRoom());
            if( !(endDate.isBefore(reservation.getStartDate())
                    || startDate.isAfter(reservation.getEndDate())) )
            {
                for (Room room: roomList) {
                    if(room.getId() == reservation.getRoom().getId()){
                        toRemove.add(room);
                    }
                }
            }
        }

        roomList.removeAll(toRemove);

        return roomList;
    }

}
