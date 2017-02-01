package DAO;

import model.Hotel;
import model.Room;
import model.User;


public class InitialisationDB {
    public static void main(String[] args) {

        UserDAO userDAO = new UserDAO();
        RoomDAO roomDAO = new RoomDAO();
        HotelDAO hotelDAO = new HotelDAO();

        User user1 = new User("Mozart");
        User user2 = new User("Bach");
        User user3 = new User("Queen");
        User user4 = new User("Vasya");
        User user5 = new User("User");
        User user6 = new User("George");
        User user7 = new User("Alex");
        User user8 = new User("Maestro");
        User user9 = new User("Nastya");
        User user10 = new User("TheKid");



        userDAO.insert(user1);
        userDAO.insert(user2);
        userDAO.insert(user3);
        userDAO.insert(user4);
        userDAO.insert(user5);
        userDAO.insert(user6);
        userDAO.insert(user7);
        userDAO.insert(user8);
        userDAO.insert(user9);
        userDAO.insert(user10);

        Hotel RadissonKiev = new Hotel("Radisson", "Kiev");

        Room RK1 = new Room("1", 200, 1);
        Room RK2 = new Room("2", 200, 1);
        Room RK3 = new Room("3", 200, 1);
        Room RK4 = new Room("4", 200, 1);
        Room RK5 = new Room("5", 350, 2);
        Room RK6 = new Room("6", 350, 2);
        Room RK7 = new Room("7", 350, 2);
        Room RK8 = new Room("8", 350, 2);
        Room RK9 = new Room("9", 350, 2);
        Room RK10 = new Room("10", 400, 3);
        Room RK11 = new Room("11", 400, 3);
        Room RK12 = new Room("12", 400, 3);
        Room RK13 = new Room("13", 400, 3);
        Room RK14 = new Room("14", 450, 4);
        Room RK15 = new Room("15", 450, 4);
        Room RK16 = new Room("16", 650, 5);
        Room RK17 = new Room("17", 650, 5);
        Room RK18 = new Room("18", 650, 5);
        Room RK19 = new Room("19", 450, 3);
        Room RK20 = new Room("20", 450, 3);
        Room RK21 = new Room("21", 450, 3);
        Room RK22 = new Room("22", 450, 3);
        Room RK23 = new Room("23", 450, 3);

        RadissonKiev.getRoomSet().add(RK1);
        RadissonKiev.getRoomSet().add(RK2);
        RadissonKiev.getRoomSet().add(RK3);
        RadissonKiev.getRoomSet().add(RK4);
        RadissonKiev.getRoomSet().add(RK5);
        RadissonKiev.getRoomSet().add(RK6);
        RadissonKiev.getRoomSet().add(RK7);
        RadissonKiev.getRoomSet().add(RK8);
        RadissonKiev.getRoomSet().add(RK9);
        RadissonKiev.getRoomSet().add(RK10);
        RadissonKiev.getRoomSet().add(RK11);
        RadissonKiev.getRoomSet().add(RK12);
        RadissonKiev.getRoomSet().add(RK13);
        RadissonKiev.getRoomSet().add(RK14);
        RadissonKiev.getRoomSet().add(RK15);
        RadissonKiev.getRoomSet().add(RK16);
        RadissonKiev.getRoomSet().add(RK17);
        RadissonKiev.getRoomSet().add(RK18);
        RadissonKiev.getRoomSet().add(RK19);
        RadissonKiev.getRoomSet().add(RK20);
        RadissonKiev.getRoomSet().add(RK21);
        RadissonKiev.getRoomSet().add(RK22);
        RadissonKiev.getRoomSet().add(RK23);

        roomDAO.insert(RK1);
        roomDAO.insert(RK2);
        roomDAO.insert(RK3);
        roomDAO.insert(RK4);
        roomDAO.insert(RK5);
        roomDAO.insert(RK6);
        roomDAO.insert(RK7);
        roomDAO.insert(RK8);
        roomDAO.insert(RK9);
        roomDAO.insert(RK10);
        roomDAO.insert(RK11);
        roomDAO.insert(RK12);
        roomDAO.insert(RK13);
        roomDAO.insert(RK14);
        roomDAO.insert(RK15);
        roomDAO.insert(RK16);
        roomDAO.insert(RK17);
        roomDAO.insert(RK18);
        roomDAO.insert(RK19);
        roomDAO.insert(RK20);
        roomDAO.insert(RK21);
        roomDAO.insert(RK22);
        roomDAO.insert(RK23);

        hotelDAO.insert(RadissonKiev);


        Hotel HyattKiev = new Hotel("Hyatt", "Kiev");

        Room HK1 = new Room("1", 200, 1);
        Room HK2 = new Room("2", 200, 1);
        Room HK3 = new Room("3", 200, 1);
        Room HK4 = new Room("4", 200, 1);
        Room HK5 = new Room("5", 350, 2);
        Room HK6 = new Room("6", 350, 2);
        Room HK7 = new Room("7", 350, 2);
        Room HK8 = new Room("8", 350, 2);
        Room HK9 = new Room("9", 350, 2);
        Room HK10 = new Room("10", 400, 3);
        Room HK11 = new Room("11", 400, 3);
        Room HK12 = new Room("12", 400, 3);
        Room HK13 = new Room("13", 400, 3);
        Room HK14 = new Room("14", 450, 4);
        Room HK15 = new Room("15", 450, 4);
        Room HK16 = new Room("16", 650, 5);
        Room HK17 = new Room("17", 650, 5);
        Room HK18 = new Room("18", 650, 5);
        Room HK19 = new Room("19", 450, 3);
        Room HK20 = new Room("20", 450, 3);

        HyattKiev.getRoomSet().add(HK1);
        HyattKiev.getRoomSet().add(HK2);
        HyattKiev.getRoomSet().add(HK3);
        HyattKiev.getRoomSet().add(HK4);
        HyattKiev.getRoomSet().add(HK5);
        HyattKiev.getRoomSet().add(HK6);
        HyattKiev.getRoomSet().add(HK7);
        HyattKiev.getRoomSet().add(HK8);
        HyattKiev.getRoomSet().add(HK9);
        HyattKiev.getRoomSet().add(HK10);
        HyattKiev.getRoomSet().add(HK11);
        HyattKiev.getRoomSet().add(HK12);
        HyattKiev.getRoomSet().add(HK13);
        HyattKiev.getRoomSet().add(HK14);
        HyattKiev.getRoomSet().add(HK15);
        HyattKiev.getRoomSet().add(HK16);
        HyattKiev.getRoomSet().add(HK17);
        HyattKiev.getRoomSet().add(HK18);
        HyattKiev.getRoomSet().add(HK19);
        HyattKiev.getRoomSet().add(HK20);

        roomDAO.insert(HK1);
        roomDAO.insert(HK2);
        roomDAO.insert(HK3);
        roomDAO.insert(HK4);
        roomDAO.insert(HK5);
        roomDAO.insert(HK6);
        roomDAO.insert(HK7);
        roomDAO.insert(HK8);
        roomDAO.insert(HK9);
        roomDAO.insert(HK10);
        roomDAO.insert(HK11);
        roomDAO.insert(HK12);
        roomDAO.insert(HK13);
        roomDAO.insert(HK14);
        roomDAO.insert(HK15);
        roomDAO.insert(HK16);
        roomDAO.insert(HK17);
        roomDAO.insert(HK18);
        roomDAO.insert(HK19);
        roomDAO.insert(HK20);

        hotelDAO.insert(HyattKiev);

        Hotel InterContinentalKiev = new Hotel("Intercontinental", "Kiev");

        Room IK1 = new Room("1", 200, 1);
        Room IK2 = new Room("2", 200, 1);
        Room IK3 = new Room("3", 200, 1);
        Room IK4 = new Room("4", 200, 1);
        Room IK5 = new Room("5", 350, 2);
        Room IK6 = new Room("6", 350, 2);
        Room IK7 = new Room("7", 350, 2);
        Room IK8 = new Room("8", 350, 2);
        Room IK9 = new Room("9", 350, 2);
        Room IK10 = new Room("10", 400, 3);
        Room IK11 = new Room("11", 400, 3);
        Room IK12 = new Room("12", 400, 3);
        Room IK13 = new Room("13", 400, 3);
        Room IK14 = new Room("14", 450, 4);
        Room IK15 = new Room("15", 450, 4);
        Room IK16 = new Room("16", 650, 5);
        Room IK17 = new Room("17", 650, 5);
        Room IK18 = new Room("18", 650, 5);
        Room IK19 = new Room("19", 450, 3);
        Room IK20 = new Room("20", 450, 3);

        InterContinentalKiev.getRoomSet().add(IK1);
        InterContinentalKiev.getRoomSet().add(IK2);
        InterContinentalKiev.getRoomSet().add(IK3);
        InterContinentalKiev.getRoomSet().add(IK4);
        InterContinentalKiev.getRoomSet().add(IK5);
        InterContinentalKiev.getRoomSet().add(IK6);
        InterContinentalKiev.getRoomSet().add(IK7);
        InterContinentalKiev.getRoomSet().add(IK8);
        InterContinentalKiev.getRoomSet().add(IK9);
        InterContinentalKiev.getRoomSet().add(IK10);
        InterContinentalKiev.getRoomSet().add(IK11);
        InterContinentalKiev.getRoomSet().add(IK12);
        InterContinentalKiev.getRoomSet().add(IK13);
        InterContinentalKiev.getRoomSet().add(IK14);
        InterContinentalKiev.getRoomSet().add(IK15);
        InterContinentalKiev.getRoomSet().add(IK16);
        InterContinentalKiev.getRoomSet().add(IK17);
        InterContinentalKiev.getRoomSet().add(IK18);
        InterContinentalKiev.getRoomSet().add(IK19);
        InterContinentalKiev.getRoomSet().add(IK20);

        roomDAO.insert(IK1);
        roomDAO.insert(IK2);
        roomDAO.insert(IK3);
        roomDAO.insert(IK4);
        roomDAO.insert(IK5);
        roomDAO.insert(IK6);
        roomDAO.insert(IK7);
        roomDAO.insert(IK8);
        roomDAO.insert(IK9);
        roomDAO.insert(IK10);
        roomDAO.insert(IK11);
        roomDAO.insert(IK12);
        roomDAO.insert(IK13);
        roomDAO.insert(IK14);
        roomDAO.insert(IK15);
        roomDAO.insert(IK16);
        roomDAO.insert(IK17);
        roomDAO.insert(IK18);
        roomDAO.insert(IK19);
        roomDAO.insert(IK20);

        hotelDAO.insert(InterContinentalKiev);


        Hotel GrandHotelKiev = new Hotel("Grand Hotel", "Kiev");

        Room GK1 = new Room("1", 200, 1);
        Room GK2 = new Room("2", 200, 1);
        Room GK3 = new Room("3", 200, 1);
        Room GK4 = new Room("4", 200, 1);
        Room GK5 = new Room("5", 350, 2);
        Room GK6 = new Room("6", 350, 2);
        Room GK7 = new Room("7", 350, 2);
        Room GK8 = new Room("8", 350, 2);
        Room GK9 = new Room("9", 350, 2);
        Room GK10 = new Room("10", 400, 3);
        Room GK11 = new Room("11", 400, 3);
        Room GK12 = new Room("12", 400, 3);
        Room GK13 = new Room("13", 400, 3);
        Room GK14 = new Room("14", 450, 4);
        Room GK15 = new Room("15", 450, 4);
        Room GK16 = new Room("16", 650, 5);
        Room GK17 = new Room("17", 650, 5);
        Room GK18 = new Room("18", 650, 5);
        Room GK19 = new Room("19", 450, 3);
        Room GK20 = new Room("20", 450, 3);

        GrandHotelKiev.getRoomSet().add(GK1);
        GrandHotelKiev.getRoomSet().add(GK2);
        GrandHotelKiev.getRoomSet().add(GK3);
        GrandHotelKiev.getRoomSet().add(GK4);
        GrandHotelKiev.getRoomSet().add(GK5);
        GrandHotelKiev.getRoomSet().add(GK6);
        GrandHotelKiev.getRoomSet().add(GK7);
        GrandHotelKiev.getRoomSet().add(GK8);
        GrandHotelKiev.getRoomSet().add(GK9);
        GrandHotelKiev.getRoomSet().add(GK10);
        GrandHotelKiev.getRoomSet().add(GK11);
        GrandHotelKiev.getRoomSet().add(GK12);
        GrandHotelKiev.getRoomSet().add(GK13);
        GrandHotelKiev.getRoomSet().add(GK14);
        GrandHotelKiev.getRoomSet().add(GK15);
        GrandHotelKiev.getRoomSet().add(GK16);
        GrandHotelKiev.getRoomSet().add(GK17);
        GrandHotelKiev.getRoomSet().add(GK18);
        GrandHotelKiev.getRoomSet().add(GK19);
        GrandHotelKiev.getRoomSet().add(GK20);

        roomDAO.insert(GK1);
        roomDAO.insert(GK2);
        roomDAO.insert(GK3);
        roomDAO.insert(GK4);
        roomDAO.insert(GK5);
        roomDAO.insert(GK6);
        roomDAO.insert(GK7);
        roomDAO.insert(GK8);
        roomDAO.insert(GK9);
        roomDAO.insert(GK10);
        roomDAO.insert(GK11);
        roomDAO.insert(GK12);
        roomDAO.insert(GK13);
        roomDAO.insert(GK14);
        roomDAO.insert(GK15);
        roomDAO.insert(GK16);
        roomDAO.insert(GK17);
        roomDAO.insert(GK18);
        roomDAO.insert(GK19);
        roomDAO.insert(GK20);

        hotelDAO.insert(GrandHotelKiev);


        Hotel LvivLviv = new Hotel("Lviv", "Lviv");

        Room LL1 = new Room("1", 200, 1);
        Room LL2 = new Room("2", 200, 1);
        Room LL3 = new Room("3", 200, 1);
        Room LL4 = new Room("4", 200, 1);
        Room LL5 = new Room("5", 350, 2);
        Room LL6 = new Room("6", 350, 2);
        Room LL7 = new Room("7", 350, 2);
        Room LL8 = new Room("8", 350, 2);
        Room LL9 = new Room("9", 350, 2);
        Room LL10 = new Room("10", 400, 3);
        Room LL11 = new Room("11", 400, 3);
        Room LL12 = new Room("12", 400, 3);
        Room LL13 = new Room("13", 400, 3);
        Room LL14 = new Room("14", 450, 4);
        Room LL15 = new Room("15", 450, 4);
        Room LL16 = new Room("16", 650, 5);
        Room LL17 = new Room("17", 650, 5);
        Room LL18 = new Room("18", 650, 5);
        Room LL19 = new Room("19", 450, 3);
        Room LL20 = new Room("20", 450, 3);

        LvivLviv.getRoomSet().add(LL1);
        LvivLviv.getRoomSet().add(LL2);
        LvivLviv.getRoomSet().add(LL3);
        LvivLviv.getRoomSet().add(LL4);
        LvivLviv.getRoomSet().add(LL5);
        LvivLviv.getRoomSet().add(LL6);
        LvivLviv.getRoomSet().add(LL7);
        LvivLviv.getRoomSet().add(LL8);
        LvivLviv.getRoomSet().add(LL9);
        LvivLviv.getRoomSet().add(LL10);
        LvivLviv.getRoomSet().add(LL11);
        LvivLviv.getRoomSet().add(LL12);
        LvivLviv.getRoomSet().add(LL13);
        LvivLviv.getRoomSet().add(LL14);
        LvivLviv.getRoomSet().add(LL15);
        LvivLviv.getRoomSet().add(LL16);
        LvivLviv.getRoomSet().add(LL17);
        LvivLviv.getRoomSet().add(LL18);
        LvivLviv.getRoomSet().add(LL19);
        LvivLviv.getRoomSet().add(LL20);

        roomDAO.insert(LL1);
        roomDAO.insert(LL2);
        roomDAO.insert(LL3);
        roomDAO.insert(LL4);
        roomDAO.insert(LL5);
        roomDAO.insert(LL6);
        roomDAO.insert(LL7);
        roomDAO.insert(LL8);
        roomDAO.insert(LL9);
        roomDAO.insert(LL10);
        roomDAO.insert(LL11);
        roomDAO.insert(LL12);
        roomDAO.insert(LL13);
        roomDAO.insert(LL14);
        roomDAO.insert(LL15);
        roomDAO.insert(LL16);
        roomDAO.insert(LL17);
        roomDAO.insert(LL18);
        roomDAO.insert(LL19);
        roomDAO.insert(LL20);

        hotelDAO.insert(LvivLviv);


        Hotel AstoriaLviv = new Hotel("Astoria", "Lviv");

        Room AL1 = new Room("1", 200, 1);
        Room AL2 = new Room("2", 200, 1);
        Room AL3 = new Room("3", 200, 1);
        Room AL4 = new Room("4", 200, 1);
        Room AL5 = new Room("5", 350, 2);
        Room AL6 = new Room("6", 350, 2);
        Room AL7 = new Room("7", 350, 2);
        Room AL8 = new Room("8", 350, 2);
        Room AL9 = new Room("9", 350, 2);
        Room AL10 = new Room("10", 400, 3);
        Room AL11 = new Room("11", 400, 3);
        Room AL12 = new Room("12", 400, 3);
        Room AL13 = new Room("13", 400, 3);
        Room AL14 = new Room("14", 450, 4);
        Room AL15 = new Room("15", 450, 4);
        Room AL16 = new Room("16", 650, 5);
        Room AL17 = new Room("17", 650, 5);
        Room AL18 = new Room("18", 650, 5);
        Room AL19 = new Room("19", 450, 3);
        Room AL20 = new Room("20", 450, 3);

        AstoriaLviv.getRoomSet().add(AL1);
        AstoriaLviv.getRoomSet().add(AL2);
        AstoriaLviv.getRoomSet().add(AL3);
        AstoriaLviv.getRoomSet().add(AL4);
        AstoriaLviv.getRoomSet().add(AL5);
        AstoriaLviv.getRoomSet().add(AL6);
        AstoriaLviv.getRoomSet().add(AL7);
        AstoriaLviv.getRoomSet().add(AL8);
        AstoriaLviv.getRoomSet().add(AL9);
        AstoriaLviv.getRoomSet().add(AL10);
        AstoriaLviv.getRoomSet().add(AL11);
        AstoriaLviv.getRoomSet().add(AL12);
        AstoriaLviv.getRoomSet().add(AL13);
        AstoriaLviv.getRoomSet().add(AL14);
        AstoriaLviv.getRoomSet().add(AL15);
        AstoriaLviv.getRoomSet().add(AL16);
        AstoriaLviv.getRoomSet().add(AL17);
        AstoriaLviv.getRoomSet().add(AL18);
        AstoriaLviv.getRoomSet().add(AL19);
        AstoriaLviv.getRoomSet().add(AL20);

        roomDAO.insert(AL1);
        roomDAO.insert(AL2);
        roomDAO.insert(AL3);
        roomDAO.insert(AL4);
        roomDAO.insert(AL5);
        roomDAO.insert(AL6);
        roomDAO.insert(AL7);
        roomDAO.insert(AL8);
        roomDAO.insert(AL9);
        roomDAO.insert(AL10);
        roomDAO.insert(AL11);
        roomDAO.insert(AL12);
        roomDAO.insert(AL13);
        roomDAO.insert(AL14);
        roomDAO.insert(AL15);
        roomDAO.insert(AL16);
        roomDAO.insert(AL17);
        roomDAO.insert(AL18);
        roomDAO.insert(AL19);
        roomDAO.insert(AL20);

        hotelDAO.insert(AstoriaLviv);


        Hotel LeopolisLviv = new Hotel("Leopolis", "Lviv");

        Room LeoL1 = new Room("1", 200, 1);
        Room LeoL2 = new Room("2", 200, 1);
        Room LeoL3 = new Room("3", 200, 1);
        Room LeoL4 = new Room("4", 200, 1);
        Room LeoL5 = new Room("5", 350, 2);
        Room LeoL6 = new Room("6", 350, 2);
        Room LeoL7 = new Room("7", 350, 2);
        Room LeoL8 = new Room("8", 350, 2);
        Room LeoL9 = new Room("9", 350, 2);
        Room LeoL10 = new Room("10", 400, 3);
        Room LeoL11 = new Room("11", 400, 3);
        Room LeoL12 = new Room("12", 400, 3);
        Room LeoL13 = new Room("13", 400, 3);
        Room LeoL14 = new Room("14", 450, 4);
        Room LeoL15 = new Room("15", 450, 4);
        Room LeoL16 = new Room("16", 650, 5);
        Room LeoL17 = new Room("17", 650, 5);
        Room LeoL18 = new Room("18", 650, 5);
        Room LeoL19 = new Room("19", 450, 3);
        Room LeoL20 = new Room("20", 450, 3);

        LeopolisLviv.getRoomSet().add(LeoL1);
        LeopolisLviv.getRoomSet().add(LeoL2);
        LeopolisLviv.getRoomSet().add(LeoL3);
        LeopolisLviv.getRoomSet().add(LeoL4);
        LeopolisLviv.getRoomSet().add(LeoL5);
        LeopolisLviv.getRoomSet().add(LeoL6);
        LeopolisLviv.getRoomSet().add(LeoL7);
        LeopolisLviv.getRoomSet().add(LeoL8);
        LeopolisLviv.getRoomSet().add(LeoL9);
        LeopolisLviv.getRoomSet().add(LeoL10);
        LeopolisLviv.getRoomSet().add(LeoL11);
        LeopolisLviv.getRoomSet().add(LeoL12);
        LeopolisLviv.getRoomSet().add(LeoL13);
        LeopolisLviv.getRoomSet().add(LeoL14);
        LeopolisLviv.getRoomSet().add(LeoL15);
        LeopolisLviv.getRoomSet().add(LeoL16);
        LeopolisLviv.getRoomSet().add(LeoL17);
        LeopolisLviv.getRoomSet().add(LeoL18);
        LeopolisLviv.getRoomSet().add(LeoL19);
        LeopolisLviv.getRoomSet().add(LeoL20);

        roomDAO.insert(LeoL1);
        roomDAO.insert(LeoL2);
        roomDAO.insert(LeoL3);
        roomDAO.insert(LeoL4);
        roomDAO.insert(LeoL5);
        roomDAO.insert(LeoL6);
        roomDAO.insert(LeoL7);
        roomDAO.insert(LeoL8);
        roomDAO.insert(LeoL9);
        roomDAO.insert(LeoL10);
        roomDAO.insert(LeoL11);
        roomDAO.insert(LeoL12);
        roomDAO.insert(LeoL13);
        roomDAO.insert(LeoL14);
        roomDAO.insert(LeoL15);
        roomDAO.insert(LeoL16);
        roomDAO.insert(LeoL17);
        roomDAO.insert(LeoL18);
        roomDAO.insert(LeoL19);
        roomDAO.insert(LeoL20);

        hotelDAO.insert(LeopolisLviv);


        Hotel AtlantisDubai = new Hotel("Atlantis The Palm", "Dubai");

        Room AD1 = new Room("1", 200, 1);
        Room AD2 = new Room("2", 200, 1);
        Room AD3 = new Room("3", 200, 1);
        Room AD4 = new Room("4", 200, 1);
        Room AD5 = new Room("5", 350, 2);
        Room AD6 = new Room("6", 350, 2);
        Room AD7 = new Room("7", 350, 2);
        Room AD8 = new Room("8", 350, 2);
        Room AD9 = new Room("9", 350, 2);
        Room AD10 = new Room("10", 400, 3);
        Room AD11 = new Room("11", 400, 3);
        Room AD12 = new Room("12", 400, 3);
        Room AD13 = new Room("13", 400, 3);
        Room AD14 = new Room("14", 450, 4);
        Room AD15 = new Room("15", 450, 4);
        Room AD16 = new Room("16", 650, 5);
        Room AD17 = new Room("17", 650, 5);
        Room AD18 = new Room("18", 650, 5);
        Room AD19 = new Room("19", 450, 3);
        Room AD20 = new Room("20", 450, 3);

        AtlantisDubai.getRoomSet().add(AD1);
        AtlantisDubai.getRoomSet().add(AD2);
        AtlantisDubai.getRoomSet().add(AD3);
        AtlantisDubai.getRoomSet().add(AD4);
        AtlantisDubai.getRoomSet().add(AD5);
        AtlantisDubai.getRoomSet().add(AD6);
        AtlantisDubai.getRoomSet().add(AD7);
        AtlantisDubai.getRoomSet().add(AD8);
        AtlantisDubai.getRoomSet().add(AD9);
        AtlantisDubai.getRoomSet().add(AD10);
        AtlantisDubai.getRoomSet().add(AD11);
        AtlantisDubai.getRoomSet().add(AD12);
        AtlantisDubai.getRoomSet().add(AD13);
        AtlantisDubai.getRoomSet().add(AD14);
        AtlantisDubai.getRoomSet().add(AD15);
        AtlantisDubai.getRoomSet().add(AD16);
        AtlantisDubai.getRoomSet().add(AD17);
        AtlantisDubai.getRoomSet().add(AD18);
        AtlantisDubai.getRoomSet().add(AD19);
        AtlantisDubai.getRoomSet().add(AD20);

        roomDAO.insert(AD1);
        roomDAO.insert(AD2);
        roomDAO.insert(AD3);
        roomDAO.insert(AD4);
        roomDAO.insert(AD5);
        roomDAO.insert(AD6);
        roomDAO.insert(AD7);
        roomDAO.insert(AD8);
        roomDAO.insert(AD9);
        roomDAO.insert(AD10);
        roomDAO.insert(AD11);
        roomDAO.insert(AD12);
        roomDAO.insert(AD13);
        roomDAO.insert(AD14);
        roomDAO.insert(AD15);
        roomDAO.insert(AD16);
        roomDAO.insert(AD17);
        roomDAO.insert(AD18);
        roomDAO.insert(AD19);
        roomDAO.insert(AD20);

        hotelDAO.insert(AtlantisDubai);

        Hotel BurjDubai = new Hotel("Burj Al Arab", "Dubai");

        Room BD1 = new Room("1", 200, 1);
        Room BD2 = new Room("2", 200, 1);
        Room BD3 = new Room("3", 200, 1);
        Room BD4 = new Room("4", 200, 1);
        Room BD5 = new Room("5", 350, 2);
        Room BD6 = new Room("6", 350, 2);
        Room BD7 = new Room("7", 350, 2);
        Room BD8 = new Room("8", 350, 2);
        Room BD9 = new Room("9", 350, 2);
        Room BD10 = new Room("10", 400, 3);
        Room BD11 = new Room("11", 400, 3);
        Room BD12 = new Room("12", 400, 3);
        Room BD13 = new Room("13", 400, 3);
        Room BD14 = new Room("14", 450, 4);
        Room BD15 = new Room("15", 450, 4);
        Room BD16 = new Room("16", 650, 5);
        Room BD17 = new Room("17", 650, 5);
        Room BD18 = new Room("18", 650, 5);
        Room BD19 = new Room("19", 450, 3);
        Room BD20 = new Room("20", 450, 3);

        BurjDubai.getRoomSet().add(BD1);
        BurjDubai.getRoomSet().add(BD2);
        BurjDubai.getRoomSet().add(BD3);
        BurjDubai.getRoomSet().add(BD4);
        BurjDubai.getRoomSet().add(BD5);
        BurjDubai.getRoomSet().add(BD6);
        BurjDubai.getRoomSet().add(BD7);
        BurjDubai.getRoomSet().add(BD8);
        BurjDubai.getRoomSet().add(BD9);
        BurjDubai.getRoomSet().add(BD10);
        BurjDubai.getRoomSet().add(BD11);
        BurjDubai.getRoomSet().add(BD12);
        BurjDubai.getRoomSet().add(BD13);
        BurjDubai.getRoomSet().add(BD14);
        BurjDubai.getRoomSet().add(BD15);
        BurjDubai.getRoomSet().add(BD16);
        BurjDubai.getRoomSet().add(BD17);
        BurjDubai.getRoomSet().add(BD18);
        BurjDubai.getRoomSet().add(BD19);
        BurjDubai.getRoomSet().add(BD20);

        roomDAO.insert(BD1);
        roomDAO.insert(BD2);
        roomDAO.insert(BD3);
        roomDAO.insert(BD4);
        roomDAO.insert(BD5);
        roomDAO.insert(BD6);
        roomDAO.insert(BD7);
        roomDAO.insert(BD8);
        roomDAO.insert(BD9);
        roomDAO.insert(BD10);
        roomDAO.insert(BD11);
        roomDAO.insert(BD12);
        roomDAO.insert(BD13);
        roomDAO.insert(BD14);
        roomDAO.insert(BD15);
        roomDAO.insert(BD16);
        roomDAO.insert(BD17);
        roomDAO.insert(BD18);
        roomDAO.insert(BD19);
        roomDAO.insert(BD20);

        hotelDAO.insert(BurjDubai);
    }
}
