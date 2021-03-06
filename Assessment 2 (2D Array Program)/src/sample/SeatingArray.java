package sample;

import enums.*;

public class SeatingArray {

    private final int TOTAL_ROWS = 12;
    private final int TOTAL_COLUMNS = 6;
    private final String HEADER = "       A B C   D E F";
    private final String ROW_LABEL = "Row ";

    //Constants to define Class boundaries (zero based values)
    private final int FIRST_CLASS_ROW_START = 0;
    private final int FIRST_CLASS_ROW_END = 1;
    private final int BUSINESS_CLASS_ROW_START = 2;
    private final int BUSINESS_CLASS_ROW_END = 5;
    private final int ECONOMY_CLASS_ROW_START = 6;
    private final int ECONOMY_CLASS_ROW_END = 11;

    private final int[] WINDOW_SEATS = new int[]{0,5};
    private final int[] MIDDLE_SEATS = new int[]{1,4};
    private final int[] AISLE_SEATS = new int[]{2,3};


    private Customer seatingAllocation[][] = new Customer[TOTAL_ROWS][TOTAL_COLUMNS];

    public Customer getCustomerAllocatedToSeat(int row, int column) {
        return seatingAllocation[row][column];
    }
    
    public boolean CancelSeatAllocation(int row, int column) {
    	try {
    		seatingAllocation[row][column] = null;
    		return true;
    	}catch(Exception ex) {
    		return false;
    	}
    }

    //Allocates a new customer to a particular seat on the flight
    public String AllocateSeat(String name, PersonType personType, ClassType classType, SeatType seatType) {
        Customer customer = new Customer(name, personType, classType, seatType);

        int requestedRowStart = 0;
        int requestedRowEnd = 0;
        int[] requestedColumns = new int[2];

        // Checks for which class type the customer wants to be in
        switch (customer.classType){
            case First:
                requestedRowStart = FIRST_CLASS_ROW_START;
                requestedRowEnd = FIRST_CLASS_ROW_END;
                break;
            case Business:
                requestedRowStart = BUSINESS_CLASS_ROW_START;
                requestedRowEnd = BUSINESS_CLASS_ROW_END;
                break;
            case Economy:
                requestedRowStart = ECONOMY_CLASS_ROW_START;
                requestedRowEnd = ECONOMY_CLASS_ROW_END;
                break;
        }

        // Checks for customers seat preference
        switch (customer.preferredSeat){
            case Window:
                requestedColumns = WINDOW_SEATS;
                break;
            case Middle:
                requestedColumns = MIDDLE_SEATS;
                break;
            case Aisle:
                requestedColumns = AISLE_SEATS;
                break;
        }

        // variable for if the customer was successfully allocated to a seat
        boolean customerAllocatedToSeat = false;

        // loops through every possible row and column the customer might want to sit in
        for (int row = requestedRowStart; row <= requestedRowEnd; row++){

            for(int index = 0; index < requestedColumns.length; index++){
                int column = requestedColumns[index];

                // checks if the seat is empty and if it is assigns the customer to that seat.
                if(seatEmpty(row, column)){
                    customer.rowNumber = row;
                    customer.columnNumber = column;
                    seatingAllocation[row][column] = customer;
                    customerAllocatedToSeat = true;
                }

                // if the customer was allocated to a seat breaks out of loops
                if (customerAllocatedToSeat)
                    break;
            }
            if (customerAllocatedToSeat)
                break;

        }

        if(customerAllocatedToSeat) {
            CustomerArray.getInstance().AddCustomers(seatingAllocation);
        }


        return customerAllocatedToSeat ? "Seat allocation successful" : "There are no " + classType.toString().toLowerCase() + " class " + seatType.toString().toLowerCase() + " seats on this flight available.";
    }


    private boolean seatEmpty(int row, int column){
        return seatingAllocation[row][column] == null ? true : false;
    }

    @Override
    public String toString() {
        int row;
        int column;
        StringBuilder sb = new StringBuilder();
        sb.append(HEADER+"\r\n");

        for (row = 0; row <  TOTAL_ROWS; row++) {
            for (column = 0; column < TOTAL_COLUMNS; column++) {

                if(column==0) {
                    if (row < 9)
                        sb.append(ROW_LABEL + (row+1) + "  ");
                    else
                        sb.append(ROW_LABEL + (row+1) + " ");
                }

                Customer tmpCustomer = seatingAllocation[row][column];

                if(tmpCustomer == null)
                    sb.append("* ");
                else
                    sb.append(tmpCustomer.adultOrChild == PersonType.Adult ? "A " : tmpCustomer.adultOrChild == PersonType.Child ? "C " : "");

                sb.append(column == 5 ? "\r\n" : column == 2 ? "  " : "");
            }
        }
        return sb.toString();
    }
}
