package models;

import java.util.Comparator;

public class Villa extends Services implements Comparable<Villa> {
    private String roomStandard;
    private double poolArea;
    private int villaFloor;
    private String description;

    public Villa() {
    }

    public Villa(   String idService, String nameService, double usableArea, double rentalCost,
                    int amountPeople, String rentType, String roomStandard, double poolArea,
                    int villaFloor, String description) {

        super(idService, nameService, usableArea, rentalCost, amountPeople, rentType);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.villaFloor = villaFloor;
        this.description = description;
    }

    public Villa(String[] villaInfo) {
        super(villaInfo[0],villaInfo[1],Double.parseDouble(villaInfo[2]),Double.parseDouble(villaInfo[3]),Integer.parseInt(villaInfo[4]),villaInfo[5]);
        this.roomStandard = villaInfo[6];
        this.poolArea = Double.parseDouble(villaInfo[7]);
        this.villaFloor = Integer.parseInt(villaInfo[8]);
        this.description = villaInfo[9];
    }

    @Override
    public String showInfor() {
        return "Villa " +
                super.showInfor() +
                ", roomStandard = " + roomStandard +
                ", poolArea = " + poolArea +
                ", villaFloor = " + villaFloor +
                ", description = " + description + "\n";
    }

    @Override
    public String toString() {
        return super.toString()+","+this.roomStandard+","+this.poolArea+","+this.villaFloor+","+this.description;
    }

    @Override
    public int compareTo(Villa o) {
        return this.getNameService().compareTo(o.getNameService());
    }
}
