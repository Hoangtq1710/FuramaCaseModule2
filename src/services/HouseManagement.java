package services;

import commons.read_write.ReadAndWriteFile;
import models.House;

import java.util.ArrayList;
import java.util.List;

public class HouseManagement implements AdditionService<House> {
    static ReadAndWriteFile<House> readAndWriteFile = new ReadAndWriteFile<>();
    @Override
    public List<House> findAll() {
        List<String[]> list = readAndWriteFile.readServiceFromFile("house.csv");
        List<House> houseList = new ArrayList<>();
        for(String[] line : list) {
            House house = new House(line);
            houseList.add(house);
        }
        return houseList;
    }

    @Override
    public House findById(int id) {
        return null;
    }

    @Override
    public void add(House house) {
        List<House> list = new ArrayList<>();
        list.add(house);
        readAndWriteFile.writeServiceToFile("house.csv", list, true);
    }

    @Override
    public void edit(House house, int id) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public boolean idExist(int id) {
        return false;
    }

    @Override
    public List<House> sortById() {
        return null;
    }
}
