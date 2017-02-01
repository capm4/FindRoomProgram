
import DAO.HotelDAO;
import model.Fields;
import model.Hotel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.*;


public class HotelDAOTests {
    private HotelDAO hotelDAO;
    private Hotel testHotel;
    private Map<String, String> trueParams;
    private Map<String, String> fakeParams;

    @Before
    public void init() {
        trueParams = new HashMap<>();
        fakeParams = new HashMap<>();
        trueParams.put(Fields.ID, "0");
        hotelDAO = new HotelDAO();
        testHotel = hotelDAO.select(trueParams).stream().findFirst().get();
        trueParams.clear();
    }

    @After
    public void tearDown() {
        hotelDAO = null;
        trueParams = null;
        fakeParams = null;
        testHotel = null;
    }

    @Test
    public void testHotelInsert() {
        Hotel hotel = new Hotel(400, "testHotel", "testCity");
        assertFalse(hotelDAO.getAll().contains(hotel));
        hotelDAO.insert(hotel);
        assertTrue(hotelDAO.getAll().contains(hotel));
        hotelDAO.delete(hotel);
    }

    @Test
    public void testHotelUpdate() {
        trueParams.put(Fields.ID, testHotel.getId() + "");
        Hotel hotel = new Hotel(testHotel.getId(), testHotel.getName(), testHotel.getCity());
        hotelDAO.update(testHotel.getId(), hotel);
        assertEquals(hotel, hotelDAO.select(trueParams).stream().findFirst().get());
        hotel.setRoomSet(testHotel.getRoomSet());
        hotelDAO.update(testHotel.getId(), hotel);
    }

    @Test
    public void testHotelDelete() {
        assertTrue(hotelDAO.getAll().contains(testHotel));
        hotelDAO.delete(testHotel);
        assertFalse(hotelDAO.getAll().contains(testHotel));
        hotelDAO.insert(testHotel);

    }

    @Test
    public void testHotelSelect() {
        trueParams.put(Fields.ID, "" + testHotel.getId());
        fakeParams.put(Fields.ID, "2");
        hotelDAO.select(trueParams);
        hotelDAO.select(fakeParams);
        assertEquals(hotelDAO.select(trueParams), hotelDAO.getAll().stream().filter(hotel -> hotel.getId() == testHotel.getId())
                .collect(Collectors.toSet()));
        assertNotEquals(hotelDAO.select(fakeParams), hotelDAO.getAll().stream().filter(hotel -> hotel.getId() == testHotel.getId())
                .collect(Collectors.toSet()));
        trueParams.clear();
        fakeParams.clear();


        trueParams.put(Fields.HOTEL_CITY, testHotel.getCity());
        fakeParams.put(Fields.HOTEL_CITY, "HOTELCITY");
        hotelDAO.select(trueParams);
        hotelDAO.select(fakeParams);
        assertEquals(hotelDAO.select(trueParams), hotelDAO.getAll().stream().filter(hotel -> testHotel.getCity().equals(hotel.getCity()))
                .collect(Collectors.toSet()));
        assertNotEquals(hotelDAO.select(fakeParams), hotelDAO.getAll().stream().filter(hotel -> testHotel.getCity().equals(hotel.getCity()))
                .collect(Collectors.toSet()));
        trueParams.clear();
        fakeParams.clear();

        trueParams.put(Fields.HOTEL_NAME, testHotel.getName());
        fakeParams.put(Fields.HOTEL_NAME, "HOTELNAME");
        hotelDAO.select(trueParams);
        hotelDAO.select(fakeParams);
        assertEquals(hotelDAO.select(trueParams), hotelDAO.getAll().stream().filter(hotel -> testHotel.getName().equals(hotel.getName()))
                .collect(Collectors.toSet()));
        assertNotEquals(hotelDAO.select(fakeParams), hotelDAO.getAll().stream().filter(hotel -> testHotel.getName().equals(hotel.getName()))
                .collect(Collectors.toSet()));
        trueParams.clear();
        fakeParams.clear();
    }
}
