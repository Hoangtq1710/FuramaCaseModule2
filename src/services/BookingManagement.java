package services;

import commons.read_write.ReadAndWriteFile;
import models.Customer;

import java.util.ArrayList;
import java.util.List;

public class BookingManagement<T> {
    static ReadAndWriteFile<Customer> readAndWriteFile = new ReadAndWriteFile<>();

    public void addBook(Customer customer) {
        List<Customer> addBookingList = new ArrayList<>();
        addBookingList.add(customer);
        readAndWriteFile.writeServiceToFile("booking.csv",addBookingList,true);
    }
}
