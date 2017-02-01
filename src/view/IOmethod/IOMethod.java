package view.IOmethod;

import controller.Controller;
import model.Fields;
import model.Hotel;
import model.Room;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class IOMethod {

    Controller ctr = new Controller();

    protected void mainMenuT(){
        System.out.println("******************************************");
        System.out.println("*              Головне меню              *");
        System.out.println("******************************************");
        System.out.println("| Для переходу по меню вибирайте (1,2..) |");
        System.out.println("| 1. Пошук готелів                       |");
        System.out.println("| 2. Пошук кімнат                        |");
        System.out.println("| Щоб вийти введіть 'q'                  |");
    }

    protected void findRoomMenuT(){
        System.out.println("**********************************************");
        System.out.println("*            Меню пошуку кімнат              *");
        System.out.println("**********************************************");
        System.out.println("| Для переходу по меню вибирайте (1,2..)     |");
        System.out.println("| 1. Пошук кімнат за вартістю                |");
        System.out.println("| 2. Пошук кімнат за містом розташування     |");
        System.out.println("| 3. Пошук кімнат за к-стю осіб              |");
        System.out.println("| 4. Пошук кімнат за вказаними параметрами   |");
        System.out.println("| Повернутись в попереднє меню введіть 'ret' |");
        System.out.println("| Щоб вийти введіть 'q'                      |");
    }

    protected void errorMessege(String value){
        System.out.println("*****************************************");
        System.out.println("|                Помилка                ");
        System.out.println("| "+ value+ " ");
        System.out.println("| повторіть спробу");
        System.out.println("*****************************************");
    }

    protected void findHotelList(TreeSet<Hotel> hotelList){
        System.out.println("***********************************");
        System.out.println("*     Список найдених готелів     *");
        System.out.println("***********************************");
        for (Hotel h : hotelList) {
            System.out.println("-----------------------------------");
            System.out.println("| id готелю          : " + h.getId());
            System.out.println("| Назва              : " + h.getName());
            System.out.println("| місто розташування : " + h.getCity());
            System.out.println("-----------------------------------");
        }
        System.out.println("| Щоб вибрати готель та передивитись номера введіть ID готелю |");
        System.out.println("| Повернутись в попереднє меню введіть 'ret'                  |");
        System.out.println("| Щоб вийти введіть 'q'                                       |");
    }

    protected void findParams(String seargParam){
        System.out.println("**********************************************");
        System.out.println("*              Критерії пошуку               *");
        System.out.println("**********************************************");
        System.out.println("| Введіть назву " + seargParam +"            |");
        System.out.println("| Повернутись в попереднє меню введіть 'ret' |");
        System.out.println("| Щоб вийти введіть 'q'                      |");
    }

    protected Set<Room> findRoomParamsFour (String hotel, String city, String price, String person){
        Set<Room> returnSet = null;
        Map<String, String> roomParams = new HashMap<>();
        roomParams.put(Fields.HOTEL_NAME, hotel);
        roomParams.put(Fields.HOTEL_CITY, city);
        roomParams.put(Fields.ROOM_PRICE, price);
        roomParams.put(Fields.ROOM_PERSONS, person);
        returnSet = ctr.findRoomExtended(roomParams);
        return  returnSet;
    }

    protected Set<Room> findRoomParams (int seargMetodRoom, String choice){
        Map<String, String> roomParams = new HashMap<>();
        Set <Room> returnSet = null;
        switch (seargMetodRoom) {
            case 1:
                roomParams.put(Fields.ROOM_PRICE, choice);
                Set<Room> foundroomByPrice = ctr.findRoom(roomParams);
                if (foundroomByPrice.isEmpty()){
                    System.out.println("*****************************************");
                    System.out.println("| За такою ціною номерів немає          |");
                    System.out.println("| повторіть спробу                      |");
                    System.out.println("*****************************************");
                    try{
                        findRoomParams (seargMetodRoom, choice);
                    }catch (NullPointerException e){
                        System.out.println(e.getMessage());
                    }
                }
                else {
                    returnSet = foundroomByPrice;
                }
                break;
            case 2:
                roomParams.put(Fields.ROOM_NAME, choice);
                Set<Room> foundroomByName = ctr.findRoom(roomParams);
                if (foundroomByName.isEmpty()){
                    System.out.println("*****************************************");
                    System.out.println("| в даному готелі номерів немає         |");
                    System.out.println("| повторіть спробу                      |");
                    System.out.println("*****************************************");
                    try{
                        findRoomParams (seargMetodRoom, choice);
                    }catch (NullPointerException e){
                        System.out.println(e.getMessage());
                    }
                }
                else{
                    returnSet = foundroomByName;
                }
                break;
            case 3:
                roomParams.put(Fields.ROOM_PERSONS, choice);
                Set<Room> foundroomByPerson = ctr.findRoom(roomParams);
                if (foundroomByPerson.isEmpty()){
                    System.out.println("**********************************************");
                    System.out.println("| номери для даної к-сті чоловік ми не знайшли |");
                    System.out.println("| повторіть спробу                           |");
                    System.out.println("**********************************************");
                    try{
                        findRoomParams (seargMetodRoom, choice);
                    }catch (NullPointerException e){
                        System.out.println(e.getMessage());
                    }
                }
                else{
                    returnSet = foundroomByPerson;
                }
                break;
            default:
                break;
        }
        return returnSet;
    }
}
