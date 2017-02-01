
import DAO.RoomDAO;
import model.Fields;
import model.Room;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.*;


public class RoomDAOTests {

    private RoomDAO roomDAO;
    private Room testRoom;
    private Map<String, String> trueParams;
    private Map<String, String> fakeParams;

    @Before
    public void init() {
        trueParams = new HashMap<>();
        fakeParams = new HashMap<>();
        trueParams.put(Fields.ID, "0");
        roomDAO = new RoomDAO();
        testRoom = roomDAO.select(trueParams).stream().findFirst().get();
        trueParams.clear();
    }

    @After
    public void tearDown() {
        roomDAO = null;
        testRoom = null;
        trueParams = null;
        fakeParams = null;
    }

    @Test
    public void testRoomUpdate() {
        trueParams.put(Fields.ID, testRoom.getId() + "");
        Room room = new Room(testRoom.getId(), testRoom.getName(), testRoom.getPrice(), testRoom.getPersons());
        roomDAO.update(testRoom.getId(), room);
        assertEquals(room, roomDAO.select(trueParams).stream().findFirst().get());
        room.setName(testRoom.getName());
        roomDAO.update(testRoom.getId(), room);
        room.setPersons(testRoom.getPersons());
        roomDAO.update(testRoom.getId(), room);
        room.setPrice(testRoom.getPrice());
        roomDAO.update(testRoom.getId(), room);
        room.setUserReserved(testRoom.getUserReserved());
        roomDAO.update(testRoom.getId(), room);
    }

    @Test
    public void testRoomInsert() {
        Room room = new Room(1000, "lux", 2000, 2);
        assertFalse(roomDAO.getAll().contains(room));
        roomDAO.insert(room);
        assertTrue(roomDAO.getAll().contains(room));
        roomDAO.delete(room);
    }

    @Test
    public void testRoomDelete() {
        assertTrue(roomDAO.getAll().contains(testRoom));
        roomDAO.delete(testRoom);
        assertFalse(roomDAO.getAll().contains(testRoom));
        roomDAO.insert(testRoom);
    }

    @Test
    public void testRoomSelect() {
        trueParams.put(Fields.ID, "" + testRoom.getId());
        fakeParams.put(Fields.ID, "1");
        roomDAO.select(trueParams);
        roomDAO.select(fakeParams);
        assertEquals(roomDAO.select(trueParams), roomDAO.getAll().stream().
                filter(room -> room.getId() == testRoom.getId())
                .collect(Collectors.toSet()));
        assertNotEquals(roomDAO.select(fakeParams), roomDAO.getAll().stream().
                filter(room -> room.getId() == testRoom.getId())
                .collect(Collectors.toSet()));
        trueParams.clear();
        fakeParams.clear();


        trueParams.put(Fields.ROOM_NAME, "" + testRoom.getName());
        fakeParams.put(Fields.ROOM_NAME, "testRoomName");
        roomDAO.select(trueParams);
        roomDAO.select(fakeParams);
        assertEquals(roomDAO.select(trueParams), roomDAO.getAll().stream().
                filter(room -> room.getName().equals(testRoom.getName()))
                .collect(Collectors.toSet()));
        assertNotEquals(roomDAO.select(fakeParams), roomDAO.getAll().stream().
                filter(room -> room.getName().equals(testRoom.getName()))
                .collect(Collectors.toSet()));
        trueParams.clear();
        fakeParams.clear();


        trueParams.put(Fields.ROOM_PERSONS, "" + testRoom.getPersons());
        fakeParams.put(Fields.ROOM_PERSONS, "2");
        roomDAO.select(trueParams);
        roomDAO.select(fakeParams);
        assertEquals(roomDAO.select(trueParams), roomDAO.getAll().stream().
                filter(room -> room.getPersons() == testRoom.getPersons())
                .collect(Collectors.toSet()));
        assertNotEquals(roomDAO.select(fakeParams), roomDAO.getAll().stream().
                filter(room -> room.getPersons() == testRoom.getPersons())
                .collect(Collectors.toSet()));
        trueParams.clear();
        fakeParams.clear();


        trueParams.put(Fields.ROOM_PRICE, "" + testRoom.getPrice());
        fakeParams.put(Fields.ROOM_PRICE, "350");
        roomDAO.select(trueParams);
        roomDAO.select(fakeParams);
        assertEquals(roomDAO.select(trueParams), roomDAO.getAll().stream().
                filter(room -> room.getPrice() == testRoom.getPrice())
                .collect(Collectors.toSet()));
        assertNotEquals(roomDAO.select(fakeParams), roomDAO.getAll().stream().
                filter(room -> room.getPrice() == testRoom.getPrice())
                .collect(Collectors.toSet()));
        trueParams.clear();
        fakeParams.clear();
    }
}
