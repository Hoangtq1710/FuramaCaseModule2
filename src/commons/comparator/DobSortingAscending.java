package commons.comparator;

import models.Customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class DobSortingAscending implements Comparator<Customer> {
    @Override
    public int compare(Customer customer1, Customer customer2) {
        int result = customer1.getName().compareTo(customer2.getName());
        if (result > 0) {
            return 1;
        } else if (result < 0) {
            return  -1;
        } else {
            Date customer1Dob = null;
            Date customer2Dob = null;
            try {
                customer1Dob = new SimpleDateFormat("dd/MM/yyyy").parse(customer1.getDob());
                customer2Dob = new SimpleDateFormat("dd/MM/yyyy").parse(customer2.getDob());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            result =  customer1Dob.compareTo(customer2Dob);
        }
        return result;
    }
}
