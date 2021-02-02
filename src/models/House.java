package models;

public class House extends Services implements Comparable<House>{
    private String roomStandard;
    private int houseFloor;
    private String description;

    public House() {
    }

    public House(String idService, String nameService, double usableArea,
                 double rentalCost, int amountPeople, String rentType,
                 String roomStandard, int houseFloor, String description) {
        super(idService, nameService, usableArea, rentalCost, amountPeople, rentType);
        this.roomStandard = roomStandard;
        this.houseFloor = houseFloor;
        this.description = description;
    }

    public House(String[] houseInfo) {
        super(houseInfo[0],houseInfo[1],Double.parseDouble(houseInfo[2]),Double.parseDouble(houseInfo[3]),Integer.parseInt(houseInfo[4]),houseInfo[5]);
        this.roomStandard = houseInfo[6];
        this.houseFloor = Integer.parseInt(houseInfo[7]);
        this.description = houseInfo[8];
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getHouseFloor() {
        return houseFloor;
    }

    public void setHouseFloor(int houseFloor) {
        this.houseFloor = houseFloor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String showInfor() {
        return "House " +
                super.showInfor() +
                ", roomStandard = " + roomStandard +
                ", houseFloor = " + houseFloor +
                ", description = " + description + "\n";
    }

    @Override
    public String toString() {
        return super.toString()+","+this.roomStandard+","+this.houseFloor+","+this.description;
    }

    @Override
    public int compareTo(House o) {
        return this.getNameService().compareTo(o.getNameService());
    }
}
