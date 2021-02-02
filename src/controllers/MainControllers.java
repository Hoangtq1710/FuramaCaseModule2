package controllers;

import commons.comparator.DobSortingAscending;
import commons.exception.*;
import commons.validation.customer_validation.DayOfBirthValidation;
import commons.validation.customer_validation.EmailCusValidation;
import commons.validation.customer_validation.GenderCusValidation;
import commons.validation.customer_validation.IdCardCusValidation;
import commons.validation.service_validation.*;
import models.*;
import services.*;

import java.text.SimpleDateFormat;
import java.util.*;

public class MainControllers {
    static Scanner scanner = new Scanner(System.in);

    private static final int SERVICE_VILLA = 1;
    private static final int SERVICE_HOUSE = 2;
    private static final int SERVICE_ROOM = 3;

    static VillaManagement villaList = new VillaManagement();
    static HouseManagement houseList = new HouseManagement();
    static RoomManagement roomList = new RoomManagement();
    static CustomerManagement customerList = new CustomerManagement();
    static BookingManagement bookingList = new BookingManagement();
    static EmployeeManagement empList = new EmployeeManagement();

    static LinkedList<Customer> customerQueue = new LinkedList<>();
    static List<String> timeBuyList = new ArrayList<>();

    private static void displayMainMenu(){
        do {
            System.out.println( "MAIN MENU\n" +
                                "1. Add New Services\n"+
                                "2. Show Services\n"+
                                "3. Add New Customer\n"+
                                "4. Show Information of Customer\n"+
                                "5. Add New Booking\n"+
                                "6. Show Information of Employee\n"+
                                "7. Cinema 4D\n"+
                                "0. Exit\n");
            int choiceMenu;
            System.out.print("Your choice is : ");
            choiceMenu = Integer.parseInt(scanner.nextLine());
            switch (choiceMenu) {
                case 1:
                    addNewServices();
                    break;
                case 2:
                    showService();
                    break;
                case 3:
                    //method in task 5
                    addNewCustomer();
                    break;
                case 4:
                    //method in task 5
                    showInformationCustomers();
                    break;
                case 5:
                    //method in task 7
                    addNewBooking();
                    break;
                case 6:
                    //method in task 9
                    showInformationEmployee();
                    break;
                case 7:
                    //method in task 10
                    cinema4D();
                    break;
                case 0:
                    System.exit(choiceMenu);
                    break;
                default:
                    System.out.println("Failed");
                    break;
            }
        } while (true);
    }

    private static void addNewServices() {
        boolean flagAddSer = true;
        do {
            System.out.println( "\n"+
                                "1. Add New Villa\n"+
                                "2. Add New House\n"+
                                "3. Add New Room\n"+
                                "4. Back to Menu\n"+
                                "0. Exit\n");
            System.out.print("Your choice is : ");
            int choiceAddSer;
            choiceAddSer = Integer.parseInt(scanner.nextLine());

            switch (choiceAddSer) {
                case 1:
                    addNewSer(SERVICE_VILLA);
                    break;
                case 2:
                    addNewSer(SERVICE_HOUSE);
                    break;
                case 3:
                    addNewSer(SERVICE_ROOM);
                    break;
                case 4:
                    flagAddSer = false;
                    break;
                case 0:
                    System.exit(choiceAddSer);
                    break;
                default:
                    System.out.println("Failed");
                    break;
            }
        } while (flagAddSer);
    }

    private static void addNewSer(int serviceType){
        String id;
        String name;
        double usableArea;
        double rentalCost;
        int amountPeople;
        String rentType;
        String roomStandard;
        int floor;
        String description;
        double poolArea;
        String freeService;

        do {
            System.out.print("Enter id of Service (SVXX-YYYY) : ");
            id = scanner.nextLine();
            if (!IdServiceValidation.idSerValidate(serviceType,id)) {
                System.out.println("Invalid ID");
            }
        } while (!IdServiceValidation.idSerValidate(serviceType,id));

        do {
            System.out.print("Enter name of Service (Abcd) : ");
            name = scanner.nextLine();
            if (!NameValidation.nameSerValidate(name)) {
                System.out.println("Invalid Name");
            }
        } while (!NameValidation.nameSerValidate(name));

        do {
            System.out.print("Enter Usable Area of Service (> 30.0) : ");
            usableArea = Double.parseDouble(scanner.nextLine());
            if (!AreaValidation.areaValidate(usableArea)) {
                System.out.println("Invalid Area");
            }
        } while (!AreaValidation.areaValidate(usableArea));

        do {
            System.out.print("Enter Rental Cost of Service (> 0) : ");
            rentalCost = Double.parseDouble(scanner.nextLine());
            if (!RentalCostValidation.rentalCostValidate(rentalCost)) {
                System.out.println("Invalid Rental Cost");
            }
        } while (!RentalCostValidation.rentalCostValidate(rentalCost));

        do {
            System.out.print("Enter Amount People of Service (0<N<20) : ");
            amountPeople = Integer.parseInt(scanner.nextLine());
            if (!AmountPeopleValidation.amountPeopleValidate(amountPeople)) {
                System.out.println("Invalid Amount People");
            }
        } while (!AmountPeopleValidation.amountPeopleValidate(amountPeople));

        do {
            System.out.print("Enter Rent Type of Service (Abcd) : ");
            rentType = scanner.nextLine();
            if (!NameValidation.nameSerValidate(rentType)) {
                System.out.println("Invalid Rent Type");
            }
        } while (!NameValidation.nameSerValidate(rentType));

        switch (serviceType) {
            case SERVICE_VILLA :
            case SERVICE_HOUSE :
                do {
                    System.out.print("Enter Room Standard of Service (Abcd) : ");
                    roomStandard = scanner.nextLine();
                    if (!NameValidation.nameSerValidate(roomStandard)) {
                        System.out.println("Invalid Room Standard");
                    }
                } while (!NameValidation.nameSerValidate(roomStandard));

                do {
                    System.out.print("Enter Floor of Service (> 0) : ");
                    floor = Integer.parseInt(scanner.nextLine());
                    if (!FloorValidation.floorValidate(floor)) {
                        System.out.println("Invalid Floor");
                    }
                } while (!FloorValidation.floorValidate(floor));

                System.out.print("Other Description : ");
                description = scanner.nextLine();
                if (serviceType == SERVICE_VILLA) {
                    do {
                        System.out.print("Enter Pool Area of Service (> 30.0) : ");
                        poolArea = Double.parseDouble(scanner.nextLine());
                        if (!AreaValidation.areaValidate(poolArea)) {
                            System.out.println("Invalid Pool Area");
                        }
                    } while (!AreaValidation.areaValidate(poolArea));

                    Villa villa = new Villa(id,name,usableArea,rentalCost,amountPeople,rentType,roomStandard,poolArea,floor,description);
                    villaList.add(villa);
                }
                House house = new House(id,name,usableArea,rentalCost,amountPeople,rentType,roomStandard,floor,description);
                houseList.add(house);
                break;
            case SERVICE_ROOM :
                System.out.print("Enter Free Service : ");
                freeService = scanner.nextLine();
                Room room = new Room(id,name,usableArea,rentalCost,amountPeople,rentType,freeService);
                roomList.add(room);
                break;
        }
    }

    private static void showService() {
        boolean flagShow = true;
        do {
            System.out.println( "1. Show all Villa\n"+
                                "2. Show all House\n"+
                                "3. Show all Room\n"+
                                "4. Show ALL Name Villa NOT Duplicate\n"+
                                "5. Show ALL Name House NOT Duplicate\n"+
                                "6. Show ALL Name Room NOT Duplicate\n"+
                                "7. Back to Menu\n"+
                                "0. Exit\n");
            System.out.print("Your choice is : ");
            int choiceShowSer = Integer.parseInt(scanner.nextLine());
            switch (choiceShowSer) {
                case 1:
                    showSer(SERVICE_VILLA);
                    //show all villa
                    break;
                case 2:
                    showSer(SERVICE_HOUSE);
                    //show all house
                    break;
                case 3:
                    showSer(SERVICE_ROOM);
                    //show all room
                    break;
                case 4:
                    showSerNotDup(SERVICE_VILLA);
                    //show all NAME villa not duplicate TASK 8
                    break;
                case 5:
                    showSerNotDup(SERVICE_HOUSE);
                    //show all NAME house not duplicate TASK 8
                    break;
                case 6:
                    showSerNotDup(SERVICE_ROOM);
                    //show all NAME room not duplicate TASK 8
                    break;
                case 7:
                    flagShow = false;
                    //back to menu
                    break;
                case 0:
                    System.exit(choiceShowSer);
                    //exit
                    break;
                default:
                    break;
            }
        } while (flagShow);
    }

    private static void showSer(int serviceType) {
        switch (serviceType) {
            case SERVICE_VILLA :
                List<Villa> listShowVilla = villaList.findAll();
                for (int i = 0; i < listShowVilla.size(); i++) {
                    System.out.println((i +1)+". "+listShowVilla.get(i).showInfor());
                }
                break;
            case SERVICE_HOUSE :
                List<House> listShowHouse = houseList.findAll();
                for (int i = 0; i < listShowHouse.size(); i++) {
                    System.out.println((i +1)+". "+listShowHouse.get(i).showInfor());
                }
                break;
            case SERVICE_ROOM :
                List<Room> listShowRoom = roomList.findAll();
                for (int i = 0; i < listShowRoom.size(); i++) {
                    System.out.println((i +1)+". "+listShowRoom.get(i).showInfor());
                }
                break;
            default:
                break;
        }
    }

    private static void addNewCustomer() {
        String name;
        String identifyCard;
        String gender;
        String dob;
        String phoneNumber;
        String email;
        String customerType;
        String address;

        while (true) {
            try {
                System.out.print("Enter Name Customer (Xxx Xxx) : ");
                name = scanner.nextLine();
                if (!customerList.nameCusChecking(name)) {
                    throw new NameException("Customer Name must capitalize first letter of each word !");
                }
                break;
            } catch (NameException e) {
                System.out.println(e.getMessage());
            }
        } // name
        while (true) {
            try {
                System.out.print("Enter ID Card Customer (XXXXXXXXX) : ");
                identifyCard = scanner.nextLine();
                if (!IdCardCusValidation.idCusValidate(identifyCard)) {
                    throw new IdCardException("ID Card must be have 9 digits and in this format XXXXXXXXX !");
                }
                break;
            } catch (IdCardException e) {
                System.out.println(e.getMessage());
            }
        } // id
        while (true) {
            try {
                System.out.print("Enter Gender (Male/ Female/ Unknown) : ");
                gender = scanner.nextLine();
                if (!GenderCusValidation.genderValidate(gender)) {
                    throw new GenderException("Gender must be one (Male/ Female/ Unknown) !");
                }
                break;
            } catch (GenderException e) {
                System.out.println(e.getMessage());
            }
        } // gender
        gender = GenderCusValidation.genderStandardized(gender);

        while (true) {
            try {
                System.out.print("Enter Day Of Birth (dd/MM/yyyy) : ");
                dob = scanner.nextLine();
                if (!DayOfBirthValidation.dobValidate(dob)) {
                    throw new BirthDayException("Birthday must be greater than 1900 and 18 years smaller than current year and in this correct format dd/MM/yyyy !");
                }
                break;
            } catch (BirthDayException e) {
                System.out.println(e.getMessage());
            }
        } // Dob

        System.out.print("Enter Phone Number : ");
        phoneNumber = scanner.nextLine();
        while (true) {
            try {
                System.out.print("Enter Email (abc@abc.abc) : ");
                email = scanner.nextLine();
                if (!EmailCusValidation.emailCusValidate(email)) {
                    throw new EmailException("Email must be in the correct format abc@abc.abc !");
                }
                break;
            } catch (EmailException e) {
                System.out.println(e.getMessage());
            }
        } // email

        System.out.print("Enter Type of Customer : ");
        customerType = scanner.nextLine();
        System.out.print("Enter Address : ");
        address = scanner.nextLine();
        Customer customer = new Customer(name,identifyCard,gender,dob,phoneNumber,email,customerType,address);
        customerList.add(customer);
    }

    private static void showInformationCustomers() {
        List<Customer> listShowCustomer = customerList.findAll();
        DobSortingAscending compa = new DobSortingAscending();
        listShowCustomer.sort(compa);
        for (int i = 0; i < listShowCustomer.size(); i++) {
            System.out.println((i +1)+". "+listShowCustomer.get(i).showInfor());
        }
    }

    private static void addNewBooking() {
        List<Customer> listShowCustomer = customerList.findAll();
        List<Villa> listVilla = villaList.findAll();
        List<House> listHouse = houseList.findAll();
        List<Room> listRoom = roomList.findAll();

        showInformationCustomers();
        int choiceCustomer;
        int choiceBookingMenu;
        do {
            System.out.print("Which one? : ");
            choiceCustomer = Integer.parseInt(scanner.nextLine());
            // người dùng chọn số từ 1 đến list.size()
            if (choiceCustomer < 1 || choiceCustomer > listShowCustomer.size()) {
                System.out.println("Invalid Customer");
            }
        } while (choiceCustomer < 1 || choiceCustomer > listShowCustomer.size());
        System.out.println( "BOOKING MENU\n"+
                            "1. Booking Villa\n"+
                            "2. Booking House\n"+
                            "3. Booking Room\n"+
                            "4. Back\n"+
                            "0. Exit\n");
        System.out.print("Which Service do you wanna book? : ");
        choiceBookingMenu = Integer.parseInt(scanner.nextLine());
        switch (choiceBookingMenu) {
            case 1:
                showSer(SERVICE_VILLA);
                int choiceVillaBook;
                do {
                    System.out.print("Which Villa do you wanna book? : ");
                    choiceVillaBook = Integer.parseInt(scanner.nextLine());
                    // người dùng chọn số từ 1 đến list.size()
                    if (choiceVillaBook < 1 || choiceVillaBook > listVilla.size()) {
                        System.out.println("Invalid Villa");
                    }
                } while (choiceVillaBook < 1 || choiceVillaBook > listVilla.size());
                listShowCustomer.get(choiceCustomer -1).setUseService(listVilla.get(choiceVillaBook -1));

                bookingList.addBook(listShowCustomer.get(choiceCustomer -1));
                break;
            case 2:
                showSer(SERVICE_HOUSE);
                int choiceHouseBook;
                do {
                    System.out.print("Which House do you wanna book? : ");
                    choiceHouseBook = Integer.parseInt(scanner.nextLine());
                    if (choiceHouseBook < 1 || choiceHouseBook > listHouse.size()) {
                        System.out.println("Invalid House");
                    }
                } while (choiceHouseBook < 1 || choiceHouseBook > listHouse.size());
                listShowCustomer.get(choiceCustomer -1).setUseService(listHouse.get(choiceHouseBook -1));

                bookingList.addBook(listShowCustomer.get(choiceCustomer -1));
                break;
            case 3:
                showSer(SERVICE_ROOM);
                int choiceRoomBook;
                do {
                    System.out.print("Which Room do you wanna book? : ");
                    choiceRoomBook = Integer.parseInt(scanner.nextLine());
                    if (choiceRoomBook < 1 || choiceBookingMenu > listRoom.size()) {
                        System.out.println("Invalid Room");
                    }
                } while (choiceRoomBook < 1 || choiceBookingMenu > listRoom.size());
                listShowCustomer.get(choiceCustomer -1).setUseService(listRoom.get(choiceRoomBook -1));

                bookingList.addBook(listShowCustomer.get(choiceCustomer -1));
                break;
            default:
                System.out.println("Failed");
                break;
        }
    }

    private static void showSerNotDup(int serviceType) {
        switch (serviceType) {
            case SERVICE_VILLA:
                List<Villa> listShowVilla = villaList.findAll();
                Set<Villa> treeVilla = new TreeSet<>(listShowVilla);
                int i = 1;
                for(Villa villa : treeVilla) {
                    System.out.println(i+". "+villa.showInfor());
                    i++;
                }
                break;
            case SERVICE_HOUSE:
                List<House> listShowHouse = houseList.findAll();
                Set<House> treeHouse = new TreeSet<>(listShowHouse);
                int j = 1;
                for(House house : treeHouse) {
                    System.out.println(j+". "+house.showInfor());
                    j++;
                }
                break;
            case SERVICE_ROOM:
                List<Room> listShowRoom = roomList.findAll();
                Set<Room> treeRoom = new TreeSet<>(listShowRoom);
                int k = 1;
                for(Room room : treeRoom) {
                    System.out.println(k+". "+room.showInfor());
                    k++;
                }
                break;
            default:
                break;
        }
    }

    private static void showInformationEmployee() {
        Map<String, Employee> showMap = addEmpToMap();
        int i = 1;
        for(Map.Entry<String, Employee> entry : showMap.entrySet()) {
            System.out.println(i+". "+entry.getKey()+" - "+entry.getValue());
            i++;
        }
    }

    private static Map<String, Employee> addEmpToMap() {
        List<Employee> listShowEmp = empList.findAll();
        List<String> listIdEmp = new ArrayList<>();
        for(Employee employee : listShowEmp) {
            listIdEmp.add(employee.getIdEmp());
        }
        Map<String,Employee> empMap = new TreeMap<>();
        for (int i = 0; i < listShowEmp.size(); i++) {
            empMap.put(listIdEmp.get(i),listShowEmp.get(i));
        }
        return empMap;
    }

    private static void cinema4D() {
        boolean flagCinema = true;
        int choiceCinema;
        do {
            System.out.println( "1. Buy a Ticket\n" +
                                "2. Show List\n"+
                                "3. Back\n" +
                                "0. Exit\n");
            System.out.print("Your choice is : ");
            choiceCinema = Integer.parseInt(scanner.nextLine());
            switch (choiceCinema) {
                case 1:
                    buyTicket(); // buy a ticket
                    break;
                case 2:
                    showSoldTicket(); // display list of customer bought ticket
                    break;
                case 3:
                    flagCinema = false;
                    break;
                case 0:
                    System.exit(choiceCinema);
                    break;
            }
        } while (flagCinema);
    }

    private static void buyTicket() {
        List<Customer> listCustomer = customerList.findAll();
        List<String> customerNameList = new ArrayList<>();
        for(Customer customer : listCustomer) {
            customerNameList.add(customer.getName());
        }
        for (int i = 0; i < customerNameList.size(); i++) {
            System.out.println((i +1)+". "+customerNameList.get(i));
        }
        int choiceCusTicket;
        do {
            System.out.print("Which customer? : ");
            choiceCusTicket = Integer.parseInt(scanner.nextLine());
            if (choiceCusTicket < 1 || choiceCusTicket > customerNameList.size()) {
                System.out.println("Invalid Customer");
            }
        } while (choiceCusTicket < 1 || choiceCusTicket > customerNameList.size());

        customerQueue.add(listCustomer.get(choiceCusTicket -1));
        timeBuyList.add(timeBuy());
        System.out.println("Thank you for buying ticket!");
    }

    private static void showSoldTicket() {
        System.out.println("LIST SOLD TICKET");
        if (!customerQueue.isEmpty()) {
            for (int i = 0; i < customerQueue.size(); i++) {
                System.out.println((i +1)+". Customer "+customerQueue.get(i).getName()+" bought a ticket at "+timeBuyList.get(i));
            }
        } else {
            System.out.println("Please buy some ticket first!");
        }
    }

    private static String timeBuy() {
        return new SimpleDateFormat("HH:mm").format(new Date());
    }

    public static void main(String[] args) {
        displayMainMenu();
    }
}
