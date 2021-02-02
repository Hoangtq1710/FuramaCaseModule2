package models;

public class Room extends Services implements Comparable<Room>{
    private String freeService;

    public Room() {
    }

    public Room(String idService, String nameService, double usableArea,
                double rentalCost, int amountPeople, String rentType,
                String freeService) {
        super(idService, nameService, usableArea, rentalCost, amountPeople, rentType);
        this.freeService = freeService;
    }

    public Room(String[] roomInfo) {
        super(roomInfo[0],roomInfo[1],Double.parseDouble(roomInfo[2]),Double.parseDouble(roomInfo[3]),Integer.parseInt(roomInfo[4]),roomInfo[5]);
        this.freeService = roomInfo[6];
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String showInfor() {
        return "Room " +
                super.showInfor() +
                ", freeService = " + freeService +"\n";
    }

    @Override
    public String toString() {
        return super.toString()+","+this.freeService;
    }

    @Override
    public int compareTo(Room o) {
        return this.getNameService().compareTo(o.getNameService());
    }
}
