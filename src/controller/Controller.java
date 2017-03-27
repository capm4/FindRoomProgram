package controller;

import DAO.HotelDAO;
import DAO.RoomDAO;
import DAO.UserDAO;
import model.Fields;
import model.Hotel;
import model.Room;
import model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Controller {
    private static User currentUser = null;
    private HotelDAO hotelDao;
    private UserDAO userDao;
    private RoomDAO roomDao;


    private Map<String, String> params = new HashMap<>();

    public Controller() {
        this.hotelDao = new HotelDAO();
        this.userDao = new UserDAO();
        this.roomDao = new RoomDAO();

        if (!hotelDao.getAll().isEmpty()) {
            Hotel.idCounter = hotelDao.getAll().stream().max(Hotel::compareTo).get().getId() + 1;
        }
        if (!roomDao.getAll().isEmpty()) {
            Room.idCounter = roomDao.getAll().stream().max(Room::compareTo).get().getId() + 1;
        }
        if (!userDao.getAll().isEmpty()) {
            User.idCounter = userDao.getAll().stream().max(User::compareTo).get().getId() + 1;
        }

    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    public void registerUser(User user) {
        userDao.insert(user);
        Controller.currentUser = user;
    }

    public Set<Hotel> findHotelByName(String name) {
        params.clear();
        params.put(Fields.HOTEL_NAME, name.toLowerCase());

        return hotelDao.select(params);
    }

    public Set<Hotel> findHotelByCity(String city) {
        params.clear();
        params.put(Fields.HOTEL_CITY, city.toLowerCase());

        return hotelDao.select(params);
    }

    public void bookRoom(long roomId, long userId, long hotelId) {
        params.clear();
        params.put(Fields.ID, Long.toString(userId));
        User user = userDao.select(params).stream().findFirst().orElse(null);

        if (user == null) {
            System.out.println("There is no user with ID:" + userId);
            return;
        }
        params.clear();
        params.put(Fields.ID, Long.toString(hotelId));
        Hotel hotel = hotelDao.select(params).stream().findFirst().orElse(null);
        if (hotel == null) {
            System.out.println("There is no hotel with ID:" + hotelId);
            return;
        }

        params.clear();
        params.put(Fields.ID, Long.toString(roomId));
        params.put(Fields.HOTEL_NAME, hotel.getName());
        Room room = roomDao.select(params).stream().findFirst().orElse(null);
        if (room == null) {
            System.out.println("There is no room with ID:" + roomId);
            return;
        }

        if (!hotel.getRoomSet().contains(room)) {
            System.out.println("There is no room : " + room.toString()
                    + " in hotel " + hotel.getName() + " , " + hotel.getCity());
        } else if (room.isReserved()) {
            System.out.println("Room: " + room.toString() + " is already reserved.");
        } else {
            room.setUserReserved(user);
            roomDao.update(room.getId(), room);
            hotel.getRoomSet().stream().filter(roomInHotel -> roomInHotel.getId() == room.getId())
                    .forEach(selectedRoom -> selectedRoom.setUserReserved(room.getUserReserved()));
            hotelDao.update(hotel.getId(), hotel);
        }

    }


    public void cancelReservation(long roomId, long userId, long hotelId) {
        params.clear();
        params.put(Fields.ID, Long.toString(userId));
        User user = userDao.select(params).stream().findFirst().orElse(null);

        if (user == null) {
            System.out.println("There is no user with ID:" + userId);
            return;
        }
        params.clear();
        params.put(Fields.ID, Long.toString(hotelId));
        Hotel hotel = hotelDao.select(params).stream().findFirst().orElse(null);
        if (hotel == null) {
            System.out.println("There is no hotel with ID:" + hotelId);
            return;
        }

        params.clear();
        params.put(Fields.ID, Long.toString(roomId));
        params.put(Fields.HOTEL_NAME, hotel.getName());
        Room room = roomDao.select(params).stream().findFirst().orElse(null);
        if (room == null) {
            System.out.println("There is no room with ID:" + roomId);
            return;
        }

        if (!hotel.getRoomSet().contains(room)) {
            System.out.println("There is no room : " + room.toString()
                    + " in hotel " + hotel.getName() + " , " + hotel.getCity());
        } else if (!room.isReserved()) {
            System.out.println("Room: " + room.toString() + " is not reserved.");
        } else if (!room.getUserReserved().equals(user)) {
            System.out.println("You can't cancel room reservation of another user!");
        } else {
            room.setUserReserved(null);
            roomDao.update(room.getId(), room);
            hotel.getRoomSet().stream().filter(roomInHotel -> roomInHotel.getId() == room.getId())
                    .forEach(selectedRoom -> selectedRoom.setUserReserved(room.getUserReserved()));
            hotelDao.update(hotel.getId(), hotel);

        }
    }

    public Set<Room> findRoomByFloatingPrice(int price, int gap) {
        Set<Room> selectedRooms = new TreeSet<>();
        for (Room room : roomDao.getAll()) {
            int roomPrice = room.getPrice();
            if ((roomPrice >= price - gap) && (roomPrice <= price + gap)) {
                selectedRooms.add(room);
            }
        }
        return selectedRooms;
    }

    public Set<Room> findRoom(Map<String, String> params) {
        this.params.clear();
        this.params = params;
        return roomDao.select(params);
    }

    public Set<Room> findRoomExtended(Map<String, String> params) {
        this.params.clear();
        this.params = params;
        Set<Room> selectedRooms = new TreeSet<>();
        if (!params.containsKey(Fields.HOTEL_NAME) && !params.containsKey(Fields.HOTEL_CITY)) {
            return roomDao.select(params);
        } else {
            Stream<Hotel> hotelStream = hotelDao.getAll().stream();


            if(!(params.get(Fields.HOTEL_CITY) == null || params.get(Fields.HOTEL_CITY).isEmpty())){
                hotelStream = hotelStream.filter(hotel ->
                        hotel.getCity().toLowerCase().equals(params.get(Fields.HOTEL_CITY).toLowerCase()));
            }

            if(!(params.get(Fields.HOTEL_NAME) == null || params.get(Fields.HOTEL_NAME).isEmpty())){
                hotelStream = hotelStream.filter(hotel ->
                        hotel.getName().toLowerCase().equals(params.get(Fields.HOTEL_NAME).toLowerCase()));
            }

            Set<Hotel> selectedHotels = new TreeSet<>(hotelStream.collect(Collectors.toSet()));

            for (Hotel selectedHotel : selectedHotels) {
                selectedRooms.addAll(selectedHotel.getRoomSet());
            }
            Stream<Room> roomStream = selectedRooms.stream();

            if (!(params.get(Fields.ROOM_PRICE) == null || params.get(Fields.ROOM_PRICE).isEmpty())){
                int castedPrice = Integer.valueOf(params.get(Fields.ROOM_PRICE));
                roomStream = roomStream.filter( room -> room.getPrice() == castedPrice);
            }

            if (!(params.get(Fields.ROOM_PERSONS) == null || params.get(Fields.ROOM_PERSONS).isEmpty())){
                int castedPersons = Integer.valueOf(params.get(Fields.ROOM_PERSONS));
                roomStream = roomStream.filter(room -> room.getPersons() == castedPersons);
            }
            return roomStream.collect(Collectors.toSet());
        }


    }


    public Set<User> findAllUsers() {
        return userDao.getAll();
    }

    public Set<Hotel> findAllHotels() {
        return hotelDao.getAll();
    }

    public long getHotelIdByRoom(Room room) {
        Hotel hotel = hotelDao.getAll().stream().filter(p -> p.isRoom(room) == true).findFirst().orElse(null);
        return hotel != null ? hotel.getId() : 0;
    }

    public Hotel getHotelByRoom(Room room) {
        Hotel hotel = hotelDao.getAll().stream().filter(p -> p.isRoom(room) == true).findFirst().orElse(null);
        return hotel;
    }

    public Set<User> searchUser(Map<String, String> params){
        return userDao.select(params);
    }
}