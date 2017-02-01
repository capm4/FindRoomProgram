package DAO;

import model.*;

import java.io.*;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class HotelDAO extends AbstractDAO<Hotel> {
    private String filePath = "src/db/hotelDB.txt";

    @Override
    public void update(long id, Hotel hotelToUpdate) {
        Set<Hotel> hotels = new TreeSet<>(getAll());
        hotels.stream().filter(hotel -> hotel.getId()==id).forEach(hotel -> {
            hotel.setName(hotelToUpdate.getName());
            hotel.setCity(hotelToUpdate.getCity());
            hotel.setRoomSet(hotelToUpdate.getRoomSet());
        });
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))){
            String line;
            for (Hotel hotel : hotels) {
                line = gson.toJson(hotel);
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public Set<Hotel> select(Map<String, String> params) {
        String neededID = params.get(Fields.ID);
        String neededName = params.get(Fields.HOTEL_NAME);
        String neededCity = params.get(Fields.HOTEL_CITY);

        Stream<Hotel> hotelStream = getAll().stream();

        if (!(neededID == null || neededID.isEmpty())){
            long castedID = Long.valueOf(neededID);
            hotelStream = hotelStream.filter(hotel -> hotel.getId()==castedID);
        }
        if (!(neededName == null || neededName.isEmpty())){
            hotelStream = hotelStream.filter(hotel -> hotel.getName().toLowerCase().equals(neededName.toLowerCase()));
        }

        if (!(neededCity == null || neededCity.isEmpty())){
            hotelStream = hotelStream.filter(hotel -> hotel.getCity().toLowerCase().equals(neededCity.toLowerCase()));
        }

        return hotelStream.collect(Collectors.toSet());
    }

    @Override
    public Set<Hotel> getAll() {
        Set<Hotel> hotelSet = new TreeSet<>();
        File DBfile = new File(filePath);
        String line;
        if (DBfile.exists()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(DBfile))) {
                line = bufferedReader.readLine();
                while (line != null) {
                    hotelSet.add(gson.fromJson(line, Hotel.class));
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
        return hotelSet;
    }
}
