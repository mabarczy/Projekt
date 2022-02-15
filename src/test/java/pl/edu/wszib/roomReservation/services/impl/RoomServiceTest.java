package pl.edu.wszib.roomReservation.services.impl;

import pl.edu.wszib.roomReservation.configuration.TestConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.edu.wszib.roomReservation.database.IRoomDAO;
import pl.edu.wszib.roomReservation.model.Room;
import pl.edu.wszib.roomReservation.services.IRoomService;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
@WebAppConfiguration
public class RoomServiceTest {

    @Autowired
    IRoomService roomService;


    @MockBean
    IRoomDAO roomDAO;


    @Test
    public void getAllRoomsTest(){
        Mockito.when(this.roomDAO.getRooms()).thenReturn(generateList());
        List<Room> list = this.roomService.getAllRooms();
        Assert.assertNotNull(list);
        Room room1 = new Room(1,1, Room.RoomType.ONEPERSON, 30);
        Assert.assertEquals(list.get(0).getId(), room1.getId());
        Assert.assertEquals(list.get(0).getNumber(), room1.getNumber());
        Assert.assertEquals(list.get(0).getRoomtype(), room1.getRoomtype());
        Assert.assertEquals(list.get(0).getPrice(), room1.getPrice(), 0.01);
        Assert.assertEquals(list.size(), 2);
    }


    private List<Room> generateList(){
        List<Room> list = new ArrayList<>();
        Room room1 = new Room(1,1, Room.RoomType.ONEPERSON,30);
        Room room2 = new Room(2, 2, Room.RoomType.TWOPERSON, 40);
        list.add(room1);
        list.add(room2);
        return list;
    }

}