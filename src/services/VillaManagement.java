package services;

import commons.read_write.ReadAndWriteFile;
import models.Villa;

import java.util.ArrayList;
import java.util.List;

public class VillaManagement implements CRUDInterfaces<Villa> {
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
    public void add(Villa villa) {
        List<Villa> list = new ArrayList<>();
        list.add(villa);
        readAndWriteFile.writeServiceToFile("villa.csv",list,true);
    }
}
