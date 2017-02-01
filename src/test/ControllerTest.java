
import controller.Controller;
import model.Fields;
import model.Hotel;
import model.Room;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class ControllerTest {
	private Controller ctrl = new Controller();

	@Test
	public void findHotelByNameTest() {
		Set<Hotel> hotels1=ctrl.findHotelByName("Astoria");
		Set<Hotel> hotels2=ctrl.findHotelByName("Tourist");
		Set<Hotel> hotels3=ctrl.findHotelByName("intercontinental");

		assertNotEquals("findHotelByName [size="+hotels1.size()+"]: ", 0, hotels1.size());
		assertEquals("findHotelByName [size="+hotels2.size()+"]: ", 0, hotels2.size());
		assertNotEquals("findHotelByName [size="+hotels3.size()+"]: ", 0, hotels3.size());
	}

	@Test
	public void findHotelByCityTest() {
		Set<Hotel> hotels1=ctrl.findHotelByCity("Kiev");
		Set<Hotel> hotels2=ctrl.findHotelByCity("lviv");
		Set<Hotel> hotels3=ctrl.findHotelByCity("Duba");

		assertNotEquals("findHotelByCity [size="+hotels1.size()+"]: ", 0, hotels1.size());
		assertNotEquals("findHotelByCity [size="+hotels2.size()+"]: ", 0, hotels2.size());
		assertEquals("findHotelByCity [size="+hotels3.size()+"]: ", 0, hotels3.size());
	}

	@Test
	public void findRoomTest() {
		Map<String, String> params = new HashMap<>();
		params.put(Fields.ID, Long.toString(2));
		Set<Room> rooms=ctrl.findRoom(params);

		assertNotEquals("findRoom [size="+rooms.size()+"]: ", 0, rooms.size());
	}

	@Test
	public void bookRoomTest() {
		Map<String, String> params = new HashMap<>();

		ctrl.bookRoom(41, 2, 1);

		params.put(Fields.ID, Long.toString(41));
		Set<Room> rooms=ctrl.findRoom(params);
		Room room=rooms.stream().findFirst().orElse(null);

		assertTrue("bookRoom", room.isReserved());
		assertEquals("bookRoom",room.getUserReserved().getId(), 2);

	}

	@Test
	public void cancelReservationTest() {
		Map<String, String> params = new HashMap<>();

		ctrl.cancelReservation(41, 2, 1);

		params.put(Fields.ID, Long.toString(41));
		Set<Room> rooms=ctrl.findRoom(params);
		Room room=rooms.stream().findFirst().orElse(null);

		assertFalse("bookRoom",room.isReserved());
	}
}
