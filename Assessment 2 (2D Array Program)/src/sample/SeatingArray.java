package sample;

import enums.*;

public class SeatingArray {

    private final int TOTAL_ROWS = 12;
    private final int TOTAL_COLUMNS = 6;
    private final String HEADER = "       A B C   D E F";
    private final String ROW_LABEL = "Row ";

    //Constants to define First class boundaries
    private final int FIRST_CLASS_ROW_START = 1;
    private final int FIRST_CLASS_ROW_END = 2;
    private final int BUSINESS_CLASS_ROW_START = 3;
    private final int BUSINESS_CLASS_ROW_END = 6;
    private final int ECONOMY_CLASS_ROW_START = 7;
    private final int ECONOMY_CLASS_ROW_END = 12;

    private final int[] WINDOW_SEATS = new int[]{0,5};
    private final int[] MIDDLE_SEATS = new int[]{1,4};
    private final int[] AISLE_SEATS = new int[]{2,3};


    private Customer seatingAllocation[][] = new Customer[TOTAL_ROWS][TOTAL_COLUMNS];

    public Customer getCustomerAllocatedToSeat(int row, int column) {
        return seatingAllocation[row][column];
    }

    public void AllocateSeat(String name, PersonType personType, ClassType classType, SeatType seatType) {

        Customer customer = new Customer(name, personType, classType, seatType);

    }

    private boolean seatEmpty(int row, int column){
        return seatingAllocation[row][column] == null ? true : false;
    }

    public void CancelSeatAllocation(int row, int column){
        seatingAllocation[row][column] = null;
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

                //sb.append("(" + row + ", " + column + ")\r\n");



            }
        }
        return sb.toString();
    }
}
