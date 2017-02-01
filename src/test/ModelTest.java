import model.Hotel;
import model.Room;
import model.User;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ModelTest {
	@Test
	public void testingUser() {
		User user=new User("login");
		assertEquals("user.getId(): "+user.toString(),1, user.getId());
		assertEquals("user.getLogin(): "+user.toString(), "login", user.getLogin());
	}

	@Test
	public void testingHotel() {
		Hotel hotel=new Hotel("Ukraine","Kiev");
		assertEquals("hotel.getId(): "+hotel.toString(), hotel.getId(), 0);
		hotel.setId(2);
		assertEquals("hotel.getId(): "+hotel.toString(), hotel.getId(), 2);
		assertEquals("hotel.getCity(): "+hotel.toString(), hotel.getCity(), "Kiev");
		hotel.setCity("Lviv");
		assertEquals("hotel.getCity(): "+hotel.toString(), hotel.getCity(), "Lviv");
		assertEquals("hotel.getName(): "+hotel.toString(), hotel.getName(), "Ukraine");
		hotel.setName("XXX");
		assertEquals("hotel.getName(): "+hotel.toString(), hotel.getName(), "XXX");
		Set<Room> rooms = new HashSet<>();
		Room room1 = new Room("1", 1,2);
		Room room2 = new Room("2", 2,3);
		rooms.add(room1);
		rooms.add(room2);
		hotel.setRoomSet(rooms);
		Set<Room> rooms1 = new HashSet<>(rooms);
		Room room3 = new Room("2", 2,3);
		rooms1.add(room3);
		assertEquals(hotel.getRoomSet(),rooms);
		assertNotEquals(hotel.getRoomSet(),rooms1);
		hotel.getRoomSet().add(room3);
		assertEquals(hotel.getRoomSet(),rooms1);
	}

	@Test
	public void testingRoom() {
		User user=new User("login");
		Room room = new Room("01", 20, 4);
		assertEquals("01", room.getName());
		room.setName("02");
		assertEquals("02", room.getName());
		assertEquals(20, room.getPrice());
		room.setPrice(30);
		assertEquals(30, room.getPrice());
		assertEquals(4,room.getPersons());
		room.setPersons(2);
		assertEquals(2,room.getPersons());
		assertEquals(null,room.getUserReserved());
		assertEquals(false, room.isReserved());
		room.setUserReserved(user);
		assertEquals(user, room.getUserReserved());
		assertEquals(true, room.isReserved());
	}
}
