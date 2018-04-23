package sample;

import enums.*;

public class Customer implements Comparable<Customer> {
    String name;
    PersonType adultOrChild;
    ClassType classType;
    SeatType preferredSeat;
    int rowNumber;
    int columnNumber;
    
    public Customer(String _name){
        name = _name;
    }


    public Customer(String _name, PersonType _adultOrChild, ClassType _classType, SeatType _preferredSeat){
        name = _name;
        adultOrChild = _adultOrChild;
        classType = _classType;
        preferredSeat = _preferredSeat;
    }


	@Override
	public int compareTo(Customer arg0) {
		return this.name.toString().toLowerCase().compareTo(arg0.name.toString().toLowerCase());
	}
}
