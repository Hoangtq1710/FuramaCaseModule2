package models;

public abstract class Services {
    protected String idService;
    protected String nameService;
    protected double usableArea;
    protected double rentalCost;
    protected int amountPeople;
    protected String rentType;

    public Services() {
    }

    public Services(String idService, String nameService, double usableArea,
                    double rentalCost, int amountPeople, String rentType) {
        this.idService = idService;
        this.nameService = nameService;
        this.usableArea = usableArea;
        this.rentalCost = rentalCost;
        this.amountPeople = amountPeople;
        this.rentType = rentType;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(double usableArea) {
        this.usableArea = usableArea;
    }

    public double getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(double rentalCost) {
        this.rentalCost = rentalCost;
    }

    public int getAmountPeople() {
        return amountPeople;
    }

    public void setAmountPeople(int amountPeople) {
        this.amountPeople = amountPeople;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public String showInfor() {
        return "idService = " + idService +
                ", nameService = " + nameService +
                ", usableArea = " + usableArea +
                ", rentalCost = " + rentalCost +
                ", amountPeople = " + amountPeople + "\n" +
                "rentType = " + rentType
                ;
    }
    public String toString(){
        return this.idService+","+this.nameService+","+this.usableArea+","+this.rentalCost+","+this.amountPeople+","+this.rentType;
    }

}
