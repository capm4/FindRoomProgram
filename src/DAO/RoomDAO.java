package DAO;

import model.Fields;
import model.Room;

import java.io.*;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RoomDAO extends AbstractDAO<Room> {
    private String filePath = "src/db/roomDB.txt";

    @Override
    public void update(long id, Room roomToUpdate) {
        Set<Room> rooms = new TreeSet<>(getAll());
        rooms.stream().filter(room -> room.getId() == id).forEach(room -> {
            room.setName(roomToUpdate.getName());
            room.setUserReserved(roomToUpdate.getUserReserved());
            room.setPersons(roomToUpdate.getPersons());
            room.setPrice(roomToUpdate.getPrice());
        });
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))){
            String line;
            for (Room room : rooms) {
                line = gson.toJson(room);
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    public Set<Room> select(Map<String, String> params) {
        String neededID = params.get(Fields.ID);
        String neededName = params.get(Fields.ROOM_NAME);
        String neededPrice = params.get(Fields.ROOM_PRICE);
        String neededPersons = params.get(Fields.ROOM_PERSONS);

        Stream<Room> roomStream = getAll().stream();

        if (!(neededID == null || neededID.isEmpty())) {
            long castedID = Long.valueOf(neededID);
            roomStream = roomStream.filter(room -> room.getId() == castedID);
        }

        if (!(neededName == null || neededName.isEmpty())) {
            roomStream = roomStream.filter(room -> room.getName().toLowerCase().equals(neededName));
        }

        if (!(neededPrice == null || neededPrice.isEmpty())) {
            int castedPrice = Integer.valueOf(neededPrice);
            roomStream = roomStream.filter(room -> room.getPrice() == castedPrice);
        }

        if (!(neededPersons == null || neededPersons.isEmpty())) {
            int castedPersons = Integer.valueOf(neededPersons);
            roomStream = roomStream.filter(room -> room.getPersons() == castedPersons);
        }

        return roomStream.collect(Collectors.toSet());
    }

    @Override
    public Set<Room> getAll() {
        Set<Room> roomSet = new TreeSet<>();
        File DBfile = new File(filePath);
        String line;
        if (DBfile.exists()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(DBfile))) {
                line = bufferedReader.readLine();
                while (line != null) {
                    roomSet.add(gson.fromJson(line, Room.class));
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
        return roomSet;
    }
}
