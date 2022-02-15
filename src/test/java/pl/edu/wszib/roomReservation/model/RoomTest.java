package pl.edu.wszib.roomReservation.model;

import org.junit.Assert;
import org.junit.Test;
import pl.edu.wszib.roomReservation.model.Room;

public class RoomTest{
    @Test
    public void cloneTest(){
        Room room = new Room();
        room.setId(1);
        room.setNumber(1);
        room.setRoomtype(Room.RoomType.ONEPERSON);
        room.setPrice(30);
        
        Room clone = room.clone();

        Assert.assertEquals(room.getId(), clone.getId());
        Assert.assertEquals(room.getNumber(), clone.getNumber());
        Assert.assertEquals(room.getRoomtype(), clone.getRoomtype());
        Assert.assertEquals(room.getPrice(), clone.getPrice(), 0.0001);

        Assert.assertNotSame(room, clone);
    }
}