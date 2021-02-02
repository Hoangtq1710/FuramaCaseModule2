package services;

import commons.read_write.ReadAndWriteFile;
import models.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerManagement implements CRUDInterfaces<Customer>{
    static ReadAndWriteFile<Customer> readAndWriteFile = new ReadAndWriteFile<>();

    @Override
    public List<Customer> findAll() {
        List<String[]> list = readAndWriteFile.readServiceFromFile("customer.csv");
        List<Customer> customerList = new ArrayList<>();
        for(String[] line : list) {
            Customer customer = new Customer(line);
            customerList.add(customer);
        }
        return customerList;
    }

    @Override
    public void add(Customer customer) {
        List<Customer> list = new ArrayList<>();
        list.add(customer);
        readAndWriteFile.writeServiceToFile("customer.csv",list,true);
    }

    public boolean nameCusChecking(String name) {
        if (Character.isLowerCase(name.charAt(0))) {
            return false;
        }
        for (int i = 0; i < name.length() -1; i++) {
            if (name.charAt(i) == ' ' && (name.charAt(i +1) == ' ' || Character.isLowerCase(i +1))){
                return false;
            }
        }
        if (name.charAt(name.length() - 1) == ' ') {
            return false;
        }
        return true;
    }
}
