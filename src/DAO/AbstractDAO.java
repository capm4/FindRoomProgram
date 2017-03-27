package DAO;

import com.google.gson.Gson;
import model.Hotel;
import model.Room;
import model.User;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public abstract class AbstractDAO<T> {

    private String filePath;

    Gson gson = new Gson();

    public void insert(T itemToInsert) {

        filePath = getFilePath(itemToInsert);
        Set<T> itemSet = new TreeSet<T>(getAll());

        if (!itemSet.contains(itemToInsert)) {
            String line = gson.toJson(itemToInsert);
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true))) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String getFilePath(T itemToInsert) {
        if (itemToInsert instanceof User) {
            return "src/db/userDB.txt";
        }
        if (itemToInsert instanceof Room) {
            return "src/db/roomDB.txt";
        }
        if (itemToInsert instanceof Hotel) {
            return "src/db/hotelDB.txt";
        }
        return "";
    }

    public abstract void update(long id, T item);

    public void delete(T itemToDelete) {
        filePath = getFilePath(itemToDelete);
        Set<T> itemSet = new TreeSet<T>(getAll());
        File DBFile = new File(filePath);
        File tmpFile = new File(filePath + "_tmp");
        if (itemSet.contains(itemToDelete)) {
            itemSet.remove(itemToDelete);
            for (T user : itemSet) {
                String line = gson.toJson(user);
                try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tmpFile, true))) {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        DBFile.delete();
        tmpFile.renameTo(DBFile);
    }

    public abstract Set<T> select(Map<String, String> params);

    public Set<T> getAll() { return null; }


}
