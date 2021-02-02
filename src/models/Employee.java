package models;

public class Employee {
    private String idEmp;
    private String fullName;
    private String age;
    private String address;

    public Employee() {
    }

    public Employee(String idEmp, String fullName, String age, String address) {
        this.idEmp = idEmp;
        this.fullName = fullName;
        this.age = age;
        this.address = address;
    }

    public Employee(String[] empInfo) {
        this.idEmp = empInfo[0];
        this.fullName = empInfo[1];
        this.age = empInfo[2];
        this.address = empInfo[3];
    }

    public String getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(String idEmp) {
        this.idEmp = idEmp;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return  "Employee id : "+this.idEmp+
                ", name : "+this.fullName+
                ", age : "+this.age+
                ", address : "+this.address + "\n";
    }
}
