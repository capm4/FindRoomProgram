package model;

public class Room implements Comparable<Room>{
    private long id;
    private String name;
    private User userReserved;
    private int price = 0;
    private int persons = 0;
    public static long idCounter = 0;

    public Room(String name, int price, int persons) {
        this.id = idCounter++;
        this.name = name;
        this.price = price;
        this.persons = persons;
    }

    @Deprecated
    public Room(long id, String name, int price, int persons) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.persons = persons;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + persons;
        result = prime * result + price;
        result = prime * result + ((userReserved == null) ? 0 : userReserved.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (id != room.id) return false;
        if (price != room.price) return false;
        if (persons != room.persons) return false;
        if (name != null ? !name.equals(room.name) : room.name != null) return false;
        return userReserved != null ? userReserved.equals(room.userReserved) : room.userReserved == null;

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

    public User getUserReserved() {
        return userReserved;
    }

    public void setUserReserved(User userReserved) {
        this.userReserved = userReserved;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPersons() {
        return persons;
    }

    public void setPersons(int persons) {
        this.persons = persons;
    }

    public boolean isReserved() {
        return userReserved == null ? false : true;
    }

    @Override
    public String toString() {
        return "Room [id=" + id + ", name=" + name + ", price="
                + price + ", persons=" + persons + ", reserved=" + isReserved() + "]";
    }

    @Override
    public int compareTo(Room o) {
        Long one = o.getId();
        Long two = this.getId();
        return  two.compareTo(one);
    }
}