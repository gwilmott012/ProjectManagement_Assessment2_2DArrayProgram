package sample;

import enums.*;

public class Customer {
    String name;
    PersonType adultOrChild;
    ClassType classType;
    SeatType preferredSeat;
    int rowNumber;
    int columnNumber;


    public Customer(String _name, PersonType _adultOrChild, ClassType _classType, SeatType _preferredSeat){
        name = _name;
        adultOrChild = _adultOrChild;
        classType = _classType;
        preferredSeat = _preferredSeat;
    }
}
