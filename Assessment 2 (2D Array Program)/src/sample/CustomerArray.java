package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*

This class is a singleton, which means that only one object can be created from it.
I have done this so I can access it from
methods in different classes without passing it as a parameter and I know that it contains the data set by other methods.

*/
public class CustomerArray {
    //This class variable is where the singleton object is stored when it is created
    private static CustomerArray instance = null;
    //private Customer[] customers;
    
    private ArrayList<Customer> customers = new ArrayList<Customer>();

    //The constructor has been made private so it can't be instantiated from outside the class.
    private CustomerArray(){
    }

    //This static method allows the singleton object to be accessed.
    public static CustomerArray getInstance(){
        if (instance == null)
            instance = new CustomerArray();

        return instance;
    }

    public void AddCustomers(Customer[][] seatingAllocation){
        //How many Customers are in the 2D seatingAllocation array?
        int numberCustomers = GetNoOfCustomers(seatingAllocation);


        //Copy the Customers from the seatingAllocation 2D array to the customers array
        CopyCustomers(seatingAllocation);
    }

    private void CopyCustomers(Customer[][] seatingAllocation) {
        int index = 0;

        for (int row = 0; row < seatingAllocation.length; row++) {
            for (int column = 0; column < seatingAllocation[row].length; column++) {
                Customer customer = seatingAllocation[row][column];

                if (customer != null) {

                    //Add the customer to the customer array
                    customers.add(customer);

                    //Increment the index
                    index += 1;
                }
            }
        }

        SortCustomersByName();
    }

    private void SortCustomersByName(){
        // Sort through customers array sorting by customer name
    	
    	Collections.sort(customers);
    	
        //Arrays.sort(customers, Comparator.comparing(d -> d.name));
    }

    //Get the number of Customers in the seatingAllocation
    private int GetNoOfCustomers(Customer[][] seatingAllocation){
        int count = 0;

        for (int row = 0; row < seatingAllocation.length; row++) {
            for (int column = 0; column < seatingAllocation[row].length; column++) {
                Customer customer = seatingAllocation[row][column];

                if (customer != null)
                    count+=1;
            }
        }
        return count;
    }

    public Customer SearchCustomer(String name){
        SortCustomersByName();
        int index = Collections.binarySearch(customers, new Customer(name));
        try {
	        Customer foundCustomer = customers.get(index);
	        return foundCustomer;
        } catch(Exception ex)
        {
        	return null;
        }
        
    }
}