package services;

import commons.read_write.ReadAndWriteFile;
import models.Villa;

import java.util.ArrayList;
import java.util.List;

public class VillaManagement implements AdditionService<Villa> {
    static ReadAndWriteFile<Villa> readAndWriteFile = new ReadAndWriteFile<>();

    @Override
    public List<Villa> findAll() {
        List<String[]> list = readAndWriteFile.readServiceFromFile("villa.csv");
        List<Villa> villaList = new ArrayList<>();
        for(String[] line : list) {
            Villa villa = new Villa(line);
            villaList.add(villa);
        }
        return villaList;
    }

    @Override
    public Villa findById(int id) {
        return null;
    }

    @Override
    public void add(Villa villa) {
        List<Villa> list = new ArrayList<>();
        list.add(villa);
        readAndWriteFile.writeServiceToFile("villa.csv",list,true);
    }

    @Override
    public void edit(Villa villa, int id) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public boolean idExist(int id) {
        return false;
    }

    @Override
    public List<Villa> sortById() {
        return null;
    }
}
