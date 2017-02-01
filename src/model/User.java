package model;

/**
 * Created by user on 31.01.2017.
 */
public class User implements Comparable<User>{
    private long id;
    private String login;
    public static long idCounter = 0;

    public User(String login) {
        this.id = idCounter++;
        this.login = login;
    }

    @Deprecated
    public User(long id, String login) {
        this.id = id;
        this.login = login;
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return login != null ? login.equals(user.login) : user.login == null;

    }

    @Override
    public int hashCode() {
        return login != null ? login.hashCode() : 0;
    }

    @Override
    public String toString() {
        return id + "," + login;
    }

    @Override
    public int compareTo(User o) {
        Long one = o.getId();
        Long two = this.getId();
        return  two.compareTo(one);
    }
}
