package view.IOmethod;

import controller.Controller;
import model.Fields;
import model.Hotel;
import model.Room;
import model.User;

import java.util.*;
import java.util.stream.Collectors;

public class IOMenu {
    Controller ctr = new Controller();
    IOMethod IOmet = new IOMethod();
    private static int returnToIndex;
    private static long currentUserID;
    private static String choice;
    private static int seargMetodHotel;
    private static String paramFindRoom;
    private Scanner scanner = new Scanner(System.in);

    private void mainMenu() {
        IOmet.mainMenuT();
        choice = scanner.nextLine();
        exit(choice);
        Integer choiceInt = null;
        returnToIndex = 1;
        try{
            choiceInt = Integer.parseInt(choice);
        }catch (NumberFormatException e){
            System.out.println("-------Ви Ввели не вірне значення повторіть спробу-------");
            retunrnTo("ret", 1);
        }
        if (choiceInt.equals(1)) {
            findHotelMenu();
        } else if (choiceInt.equals(2)) {
            findRoomMenu();
        } else {
            System.out.println("-------Ви Ввели не вірне значення повторіть спробу-------");
            mainMenu();
        }
    }

    private void findRoomMenu() {
        IOmet.findRoomMenuT();
        choice = scanner.nextLine();
        exit(choice);
        retunrnTo(choice, 1);
        returnToIndex = 3;
        Integer choiceInt = null;
        try{
            choiceInt = Integer.parseInt(choice);
        }catch (NumberFormatException e){
            System.out.println("-------Ви Ввели не вірне значення повторіть спробу-------");
            retunrnTo("ret", 3);
        }
        invalidInput(1,5,choiceInt,3);
        if (1<= choiceInt && choiceInt <=3){
            findRooms(choiceInt);
        }
        else{
            findRoomFourParam(choiceInt);
        }
    }

    private void findRoomFourParam (int choiceInt){
        if(choiceInt == 4){
            System.out.println("**********************************************");
            System.out.println("*              Критерії пошуку               *");
            System.out.println("**********************************************");
            System.out.println("| Введіть назву готелю                       |");
            String parmaHotel = scanner.nextLine();
            System.out.println("| Введіть назву міста                        |");
            String paramCity = scanner.nextLine();
            System.out.println("| Введіть вартість номеру                    |");
            String paramPrice = scanner.nextLine();
            System.out.println("| Введіть к-сть осіб                         |");
            String paramPerson = scanner.nextLine();
            Set<Room> setRoom = IOmet.findRoomParamsFour(parmaHotel, paramCity,paramPrice,paramPerson);
            roomfindParams(setRoom);
        }
    }

    private void findRooms (int seargMetodRoom){
        String seargParam = "";
            if (seargMetodRoom == 1) {
                seargParam = "вартість";
            }
            else if (seargMetodRoom == 2) {
                seargParam = "назву готелю";
            }
            else if (seargMetodRoom == 3) {
                seargParam = "К-сть осіб";
            }

        System.out.println("**********************************************");
        System.out.println("*              Критерії пошуку               *");
        System.out.println("**********************************************");
        System.out.println("| Введіть " + seargParam +"            |");
        System.out.println("| Повернутись в попереднє меню введіть 'ret' |");
        System.out.println("| Щоб вийти введіть 'q'                      |");
        choice = scanner.nextLine();
        exit(choice);
        retunrnTo(choice, 3);
        try{
            int choiceInt = Integer.parseInt(choice);
        }catch (NumberFormatException e){
            System.out.println("-------Ви Ввели не вірне значення повторіть спробу-------");
            retunrnTo("ret", 3);
        }
        Set<Room> setRoom = IOmet.findRoomParams(seargMetodRoom, choice);
        roomfindParams(setRoom);
    }

    protected void roomfindParams(Set<Room> name){ //TODO should we change access to private?
        int rowCount = 0;
        System.out.println("***********************************");
        System.out.println("*     Скисок найдених номерів     *");
        System.out.println("***********************************");
        for (Room room : name) {
            Hotel hotelName = ctr.getHotelByRoom(room);
            System.out.println("-----------------------------------");
            System.out.println("| id номеру             : " + room.getId());
            System.out.println("| Назва готелю          : " + hotelName.getName());
            System.out.println("| Місто                 : " + hotelName.getCity());
            System.out.println("| к-сть осіб            : " + room.getPersons());
            System.out.println("| вартість              : " + room.getPrice());
            System.out.println("| Кімната зарезервована : " + (room.isReserved() ? "YES" : "NO")) ;
            System.out.println("-----------------------------------");
            rowCount++;
        }
        System.out.println("| За вашими кретеріями пошуку найдено " + rowCount + " кімнат");
        System.out.println("| Щоб ЗАРЕЗЕРВУВАТИ кімнату введіть її id       |");
        System.out.println("| Повернутись в попереднє меню введіть 'ret'    |");
        System.out.println("| Щоб вийти введіть 'q'                         |");
        paramFindRoom = scanner.nextLine();
        exit(paramFindRoom);
        retunrnTo(paramFindRoom, returnToIndex);
        reservRoom(paramFindRoom, name);
    }

    public void reservRoom(String choice, Set<Room> name){ //TODO should we change access to private?
        Long choiceInt = null;
        try{
            choiceInt = Long.parseLong(choice);
        }catch (NumberFormatException e){
            System.out.println("-------Ви Ввели не вірне значення повторіть спробу-------");
            retunrnTo("ret", returnToIndex);
        }
        Room RoomForFindHotelID = null;
        for (Room room : name) {
            if (room.getId() == choiceInt) {
                RoomForFindHotelID = room;
            }
        }
        if (RoomForFindHotelID == null) {
            System.out.println("==============================================");
            System.out.println("| Із таким ID " + choiceInt + " номеру немає |");
            System.out.println("==============================================");
            reservRoom(paramFindRoom, name);
        }

        else if(!(RoomForFindHotelID.isReserved())) {
            long HotelID = ctr.getHotelIdByRoom(RoomForFindHotelID);
            ctr.bookRoom(choiceInt, currentUserID, HotelID);
            System.out.println("| Вітаємо ви успішно зарезервували кімнату      |");
            System.out.println("| Щоб відмінити резерв введіть 'cancel'         |");
            System.out.println("| Повернутись в попереднє меню введіть 'ret'    |");
            System.out.println("| Щоб вийти введіть 'q'                         |");
            String bookRoomMenu = scanner.nextLine();
            if(bookRoomMenu.toLowerCase().equals("cancel")){
                ctr.cancelReservation(choiceInt, currentUserID, HotelID);
                System.out.println("| Ви успішно сняли резерв ");;
                String ret = "ret";
                retunrnTo(ret, returnToIndex);
            }
            exit(bookRoomMenu);
            retunrnTo(bookRoomMenu, returnToIndex);
        }
        else {
            System.out.println("| Вибачте даний номер зарезервовано |");
            retunrnTo("ret", returnToIndex);
        }
    }

    private void findHotelMenu() {
        System.out.println("**********************************************");
        System.out.println("*           Меню пошуку готелів              *");
        System.out.println("**********************************************");
        System.out.println("| Для переходу по меню вибирайте (1,2..)     |");
        System.out.println("| 1. Пошук готелю за назвою                  |");
        System.out.println("| 2. Пошук готелю за містом розташування     |");
        System.out.println("| 3. Список всіх готелів                     |");
        System.out.println("| Повернутись в попереднє меню введіть 'ret' |");
        System.out.println("| Щоб вийти введіть 'q'                      |");
        choice = scanner.nextLine();
        exit(choice);
        retunrnTo(choice, 1);
        returnToIndex = 2;
        Integer choiceInt = null;
        try{
            choiceInt = Integer.parseInt(choice);
        }catch (NumberFormatException e){
            System.out.println("-------Ви Ввели не вірне значення повторіть спробу-------");
            retunrnTo("ret", 2);
        }

        invalidInput(1,3,choiceInt,2);
        findHotel(choiceInt);
    }

    private void findHotel (int seargMetodHotel){
        String seargParam = "";
        if (seargMetodHotel == 1) {
            seargParam = "готелю";
        }
        else if (seargMetodHotel == 2) {
            seargParam = "міста";
        }
        if(seargMetodHotel == 1 ||seargMetodHotel == 2) {
            IOmet.findParams(seargParam);
            choice = scanner.nextLine();
            exit(choice);
            retunrnTo(choice, 2);
            switch (seargMetodHotel) {
                case 1:
                    TreeSet<Hotel> hotelName = new TreeSet<>(ctr.findHotelByName(choice));
                    if (hotelName.isEmpty()) {
                        IOmet.errorMessege("За такою назвою готелів немає");
                        try {
                            retunrnTo("ret", 2);
                        } catch (NullPointerException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        IOmet.findHotelList(hotelName);
                        choice = scanner.nextLine();
                        exit(choice);
                        retunrnTo(choice, 2);
                        findRoomInHotel(checkChoice(choice,2,hotelName), hotelName);
                    }
                    break;
                case 2:
                    TreeSet<Hotel> hotelCity = new TreeSet<>(ctr.findHotelByCity(choice));
                    if (hotelCity.isEmpty()) {
                        IOmet.errorMessege(" В даному місті готелів нема");
                        try {
                            retunrnTo("ret", 2);
                        } catch (NullPointerException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        IOmet.findHotelList(hotelCity);
                        choice = scanner.nextLine();
                        exit(choice);
                        retunrnTo(choice, 2);
                        findRoomInHotel(checkChoice(choice,2,hotelCity),hotelCity);
                    }
                    break;
                default:
                    break;
            }
        }
        else if (seargMetodHotel == 3){
            TreeSet<Hotel> hotelList = new TreeSet<>(ctr.findAllHotels());
            IOmet.findHotelList(hotelList);
            choice = scanner.nextLine();
            findRoomInHotel(checkChoice(choice, 2, hotelList), ctr.findAllHotels());
        }

    }

    private void findRoomInHotel (long HotelId, Set<Hotel> hotel){
        Set<Room> roomSet = null;
        for (Hotel findhotel : hotel){
            if(findhotel.getId() == HotelId){
                roomSet = findhotel.getRoomSet();
            }
        }
        roomfindParams(roomSet);
    }

    private void invalidInput(int first, int last,int value, int numOfMenu){
        if (first > value || value > last){
            try{
                retunrnTo("ret", numOfMenu);
            }catch (NullPointerException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void retunrnTo(String value, int numOfMenu) {
        try {
            if (value.toLowerCase().equals("ret")) {
                switch (numOfMenu) {
                    case 1:
                        mainMenu();
                        break;
                    case 2:
                        findHotelMenu();
                        break;
                    case 3:
                        findRoomMenu();
                        break;
                    case 4:
                        findHotel(seargMetodHotel);
                        break;
                    case 5:
                        authorization();
                        break;
                    default:
                        break;
                }
            }
        }catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }
    }

    private void exit(String value) {
        if (value.toLowerCase().equals("q")) {
            System.out.println("exit");
            scanner.close();
            System.exit(0);
        }
    }

    public void authorization() {
        System.out.println("*************************");
        System.out.println("*    Вхід в систему.    *");
        System.out.println("*************************");
        System.out.println("| Введіть логін         |");
        System.out.println("| Щоб вийти введіть 'q' |");
        String login;
        login = scanner.nextLine();
        if (login == null || login.length() == 0) {
            System.out.println("| Ви нічого не ввели  |");
            authorization();
        }
        exit(login);
        boolean ret = userCheckOrReg(login);
        if (ret){
            try{
                mainMenu();
            }catch (NullPointerException e){
                System.out.println(e.getMessage());
            }
        }
        else{
            validLog();
        }
    }

    private boolean userCheckOrReg(String login){
        boolean ret = false;
        if(login == null || login.length() == 0 ) {
            ret= false;
        }
        Map<String, String> params = new HashMap<>();
        params.put(Fields.USER_LOGIN, login);
        Set<User> seargUser= ctr.searchUser(params);
        if (seargUser.isEmpty()){
            User newUser = new User(login);
            ctr.registerUser(newUser);
            ctr.setCurrentUser(newUser);
            System.out.println("=============================================");
            System.out.println("| Вітаєм Ви створили нового кристовча " + login);
            System.out.println("=============================================");
            currentUserID = newUser.getId();
            ret = true;
        }
        else{
            System.out.println("===============================");
            System.out.println("| Вітаєм Вас у системі " + login );
            System.out.println("===============================");
            for (User user : seargUser) {
                currentUserID = user.getId();
                ctr.setCurrentUser(user);
            }
            ret = true;
        }
        return ret;
    }

    private void validLog() {
        System.out.println("***************************************");
        System.out.println("*               Помилка               *");
        System.out.println("*      Ви вевели не вірний логін      *");
        System.out.println("***************************************");
        System.out.println("| Для повторення введення введіть '1' |");
        System.out.println("| Щоб вийти введіть 'q'               |");
        String choice = scanner.nextLine();
        exit(choice);
        Integer choiceInt = 0;
        try{
            choiceInt = Integer.parseInt(choice);
        }catch (NumberFormatException e){
            System.out.println("***********************************************");
            System.out.println("*                Помилка вводу                *");
            System.out.println("***********************************************");
            System.out.println("| Ви Ввели не вірне значення повторіть спробу |");
            validLog();
        }
        if (choiceInt.equals(1)) {
            authorization();
        }
    }

    private long checkChoice(String choice, int returnTo, Set<Hotel> rooms){
        exit(choice);
        retunrnTo(choice, returnTo);
        Set<Long> idSet = rooms.stream().map(Hotel::getId).collect(Collectors.toSet());
        try {
            while (!idSet.contains(Long.valueOf(choice))) {
                IOmet.errorMessege("ви ввели навірне значення");
                System.out.println("| Повернутись в попереднє меню введіть 'ret' |");
                System.out.println("| Щоб вийти введіть 'q'                      |");
                choice = scanner.nextLine();
            }
            return Long.valueOf(choice);
        } catch (NumberFormatException e){
            IOmet.errorMessege("ви ввели навірне значення");
            retunrnTo("ret", 2);
        }
        return 0;
    }
}
