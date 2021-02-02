package models;

public class Customer{
    private String name;
    private String identifyCard;
    private String gender;
    private String dob;
    private String phoneNumber;
    private String email;
    private String customerType;
    private String address;
    private Services useService;

    public Customer() {
    }

    public Customer(String name, String id, String gender, String dob,
                    String phoneNumber, String email, String customerType,
                    String address) {
        this.name = name;
        this.identifyCard = id;
        this.gender = gender;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.customerType = customerType;
        this.address = address;
//        this.useService = null;
    }

    public Customer(String[] customerInfo) {
        this.name = customerInfo[0];
        this.identifyCard = customerInfo[1];
        this.gender = customerInfo[2];
        this.dob = customerInfo[3];
        this.phoneNumber = customerInfo[4];
        this.email = customerInfo[5];
        this.customerType = customerInfo[6];
        this.address = customerInfo[7];
//        this.useService = customerInfo[8];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return identifyCard;
    }

    public void setId(String id) {
        this.identifyCard = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Services getUseService() {
        return useService;
    }

    public void setUseService(Services useService) {
        this.useService = useService;
    }

    public String showInfor() {
        String result = "";
        result += "Customer " +
                "name = " + name +
                ", id = " + identifyCard +
                ", gender = " + gender +
                ", dob = " + dob +
                ", phoneNumber = " + phoneNumber + "\n\t" +
                "email = " + email +
                ", customerType = " + customerType +
                ", address = " + address;
        if (this.useService != null) {
            result +=", useService = " + useService +"\n";
        }
        return result;
    }

    @Override
    public String toString() {
        String result = "";
        result += this.name+","+this.identifyCard+","+this.gender+","+this.dob+","+this.phoneNumber+","+this.email+","+this.customerType+","+this.address;
        if (this.useService != null) {
            result += ","+this.useService;
        }
        return result;
    }
}
