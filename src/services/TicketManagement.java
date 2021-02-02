package services;

import commons.read_write.ReadAndWriteFile;
import models.Ticket;

import java.util.ArrayList;
import java.util.List;


public class TicketManagement {
    static ReadAndWriteFile<Ticket> readAndWriteFile = new ReadAndWriteFile<>();

    public void addTicket(Ticket ticket) {
        List<Ticket> addTicketList = new ArrayList<>();
        addTicketList.add(ticket);
        readAndWriteFile.writeServiceToFile("ticket.csv",addTicketList,true);
    }
    public List<Ticket> findAll() {
        List<String[]> list = readAndWriteFile.readServiceFromFile("ticket.csv");
        List<Ticket> ticketList = new ArrayList<>();
        for(String[] line : list) {
            Ticket ticket = new Ticket(line);
            ticketList.add(ticket);
        }
        return ticketList;
    }
}
