package model;

import java.util.Set;
import java.util.TreeSet;

public class Hotel implements Comparable<Hotel>{

    private Set<Room> roomSet;
    private long id;
    private String name;
    private String city;
    public static long idCounter = 0;

    public Hotel(String name, String city) {
        this.roomSet = new TreeSet<>(); //When creating Hotel we just create empty new RoomSet
        this.id = idCounter++;
        this.name = name;
        this.city = city;
    }

    @Deprecated
    public Hotel(long id, String name, String city) {
        this.roomSet = new TreeSet<>(); //When creating Hotel we just create empty new RoomSet
        this.id = id;
        this.name = name;
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hotel hotel = (Hotel) o;

        if (id != hotel.id) return false;
        if (roomSet != null ? !roomSet.equals(hotel.roomSet) : hotel.roomSet != null) return false;
        if (name != null ? !name.equals(hotel.name) : hotel.name != null) return false;
        return city != null ? city.equals(hotel.city) : hotel.city == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "roomSet=" + roomSet +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public Set<Room> getRoomSet() {
        return roomSet;
    }

    public void setRoomSet(Set<Room> roomSet) {
        this.roomSet = roomSet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void addRoom(Room room) {
        roomSet.add(room);
    }

    public boolean isRoom(Room room) {
        return roomSet.stream().filter(r -> r.equals(room)).findFirst().orElse(null) != null ? true : false;
    }

    @Override
    public int compareTo(Hotel o) {
        Long one = o.getId();
        Long two = this.getId();
        return  two.compareTo(one);
    }
}
