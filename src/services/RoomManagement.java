package services;

import commons.read_write.ReadAndWriteFile;
import models.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomManagement implements CRUDInterfaces<Room>{
    static ReadAndWriteFile<Room> readAndWriteFile = new ReadAndWriteFile<>();
    @Override
    public List<Room> findAll() {
        List<String[]> list = readAndWriteFile.readServiceFromFile("room.csv");
        List<Room> roomList = new ArrayList<>();
        for(String[] line : list) {
            Room room = new Room(line);
            roomList.add(room);
        }
        return roomList;
    }

    @Override
    public void add(Room room) {
        List<Room> list = new ArrayList<>();
        list.add(room);
        readAndWriteFile.writeServiceToFile("room.csv", list, true);
    }
}
