package DAO;

import model.*;

import java.io.*;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class UserDAO extends AbstractDAO<User> {

    private String filePath = "src/db/userDB.txt";

    @Override
    public void update(long id, User userToUpdate) {
        Set<User> users = new TreeSet<>(getAll());
        users.stream().filter(user -> user.getId()==id).forEach(user1 ->
                user1.setLogin(userToUpdate.getLogin()));
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))){
            String line;
            for (User user : users) {
                line = gson.toJson(user);
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public Set<User> select(Map<String, String> params) {
        String neededID = params.get(Fields.ID);
        String neededLogin = params.get(Fields.USER_LOGIN);

        Stream<User> userStream = getAll().stream();

        if (!(neededID == null || neededID.isEmpty())){
            long castedID = Long.parseLong(neededID);
            userStream = userStream.filter( user -> user.getId() == castedID);
        }

        if (!(neededLogin == null || neededLogin.isEmpty())){
            userStream = userStream.filter(user -> user.getLogin().equals(neededLogin));
        }

        return userStream.collect(Collectors.toSet());

    }

    @Override
    public Set<User> getAll() {
        Set<User> userSet = new TreeSet<>();
        File DBfile = new File(filePath);
        String line;
        if (DBfile.exists()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(DBfile))) {
                line = bufferedReader.readLine();
                while (line != null) {
                    userSet.add(gson.fromJson(line, User.class));
                    line = bufferedReader.readLine();
                }
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return userSet;
    }
}
