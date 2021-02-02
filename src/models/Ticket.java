package models;

public class Ticket {
    private String nameCustomer;
    private String idCustomer;
    private String buyTime;

    public Ticket() {
    }

    public Ticket(String nameCustomer, String idCustomer, String buyTime) {
        this.nameCustomer = nameCustomer;
        this.idCustomer = idCustomer;
        this.buyTime = buyTime;
    }

    public Ticket(String[] ticketInfo) {
        this.idCustomer = ticketInfo[0];
        this.nameCustomer = ticketInfo[1];
        this.buyTime = ticketInfo[2];
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime;
    }

    public String toString() {
        return this.idCustomer+","+this.nameCustomer+","+this.buyTime;
    }
    public String showInfor(){
        return  "Ticket : ID Customer "+this.idCustomer+
                        ", Name Customer "+this.nameCustomer+
                        ", Buy At Time "+this.buyTime;
    }
}
