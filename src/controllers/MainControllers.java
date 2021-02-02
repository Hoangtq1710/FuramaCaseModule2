package controllers;

import commons.comparator.DobSortingAscending;
import commons.exception.*;
import commons.validation.customer_validation.*;
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
    //static TicketManagement ticketList = new TicketManagement();

    static Queue<Ticket> queue = new LinkedList<>();

    private static void displayMainMenu(){
        do {
            System.out.println( "\tMAIN MENU\n" +
                                "1. Add New Services\n"+
                                "2. Show Services\n"+
                                "3. Add New Customer\n"+
                                "4. Show Information of Customer\n"+
                                "5. Add New Booking\n"+
                                "6. Show Information of Employee\n"+
                                "7. Cinema 4D\n"+
                                "8. Cabinet Stack\n"+
                                "0. Exit\n");
            int choiceMenu;
            while (true) {
                try {
                    System.out.print("Your choice is : ");
                    choiceMenu = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Wrong format!");
                }
            }
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
                case 8:
                    //method in task 11
                    cabinetStack();
                    break;
                case 0:
                    System.exit(choiceMenu);
                    break;
                default:
                    System.out.println("Failed");
                    break;
            }
        } while (true);
    } // display main menu task 2.1

    private static void addNewServices() {
        boolean flagAddSer = true;
        do {
            System.out.println( "\n"+
                                "1. Add New Villa\n"+
                                "2. Add New House\n"+
                                "3. Add New Room\n"+
                                "4. Back to Menu\n"+
                                "0. Exit\n");
            int choiceAddSer;
            while (true) {
                try {
                    System.out.print("Your choice is : ");
                    choiceAddSer = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Wrong format!");
                }
            }

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
    } // task 2.2

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
    } // task 2.2 & 4 (regex)

    private static void showService() {
        boolean flagShow = true;
        do {
            System.out.println( "\n"+
                                "1. Show all Villa\n"+
                                "2. Show all House\n"+
                                "3. Show all Room\n"+
                                "4. Show ALL Name Villa NOT Duplicate\n"+
                                "5. Show ALL Name House NOT Duplicate\n"+
                                "6. Show ALL Name Room NOT Duplicate\n"+
                                "7. Back to Menu\n"+
                                "0. Exit\n");
            int choiceShowSer;
            while (true) {
                try {
                    System.out.print("Your choice is : ");
                    choiceShowSer = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Wrong format!");
                }
            }
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
                    System.out.println("Failed");
                    break;
            }
        } while (flagShow);
    } // task 3 & 8

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
    } // task 2

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
        while (true) {
            try {
                System.out.print("Enter Phone Number (0XXXXXXXXX) : ");
                phoneNumber = scanner.nextLine();
                if (!PhoneValidation.phoneValidate(phoneNumber)) {
                    throw new PhoneException("Phone number must be in the correct format 0XXXXXXXXX");
                }
                break;
            } catch (PhoneException e) {
                System.out.println(e.getMessage());
            }
        } // phone
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
    } // task 5

    private static void showInformationCustomers() {
        List<Customer> listShowCustomer = customerList.findAll();
        DobSortingAscending compa = new DobSortingAscending();
        listShowCustomer.sort(compa);
        for (int i = 0; i < listShowCustomer.size(); i++) {
            System.out.println((i +1)+". "+listShowCustomer.get(i).showInfor());
        }
    } // task 6

    private static void addNewBooking() {
        List<Customer> listShowCustomer = customerList.findAll();
        List<Villa> listVilla = villaList.findAll();
        List<House> listHouse = houseList.findAll();
        List<Room> listRoom = roomList.findAll();

        showInformationCustomers();

        int choiceCustomer;
        int choiceBookingMenu;
        boolean flagBooking = true;

        do {
            while (true) {
                try {
                    System.out.print("Which one? : ");
                    choiceCustomer = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Wrong format!");
                }
            }
            // người dùng chọn số từ 1 đến list.size()
            if (choiceCustomer < 1 || choiceCustomer > listShowCustomer.size()) {
                System.out.println("Invalid Customer");
            }
        } while (choiceCustomer < 1 || choiceCustomer > listShowCustomer.size());

        do {
            System.out.println( "\tBOOKING MENU\n"+
                                "1. Booking Villa\n"+
                                "2. Booking House\n"+
                                "3. Booking Room\n"+
                                "4. Back\n"+
                                "0. Exit\n");
            while (true) {
                try {
                    System.out.print("Which Service do you wanna book? : ");
                    choiceBookingMenu = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Wrong format!");
                }
            }
            switch (choiceBookingMenu) {
                case 1:
                    showSer(SERVICE_VILLA);
                    int choiceVillaBook;
                    do {
                        while (true) {
                            try {
                                System.out.print("Which Villa do you wanna book? : ");
                                choiceVillaBook = Integer.parseInt(scanner.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Wrong format!");
                            }
                        }
                        // người dùng chọn số từ 1 đến list.size()
                        if (choiceVillaBook < 1 || choiceVillaBook > listVilla.size()) {
                            System.out.println("Invalid Villa");
                        }
                    } while (choiceVillaBook < 1 || choiceVillaBook > listVilla.size());

                    listShowCustomer.get(choiceCustomer -1).setUseService(listVilla.get(choiceVillaBook -1));
                    bookingList.addBook(listShowCustomer.get(choiceCustomer -1));
                    flagBooking = false;
                    break;
                case 2:
                    showSer(SERVICE_HOUSE);
                    int choiceHouseBook;
                    do {
                        while (true) {
                            try {
                                System.out.print("Which House do you wanna book? : ");
                                choiceHouseBook = Integer.parseInt(scanner.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Wrong format!");
                            }
                        }
                        if (choiceHouseBook < 1 || choiceHouseBook > listHouse.size()) {
                            System.out.println("Invalid House");
                        }
                    } while (choiceHouseBook < 1 || choiceHouseBook > listHouse.size());

                    listShowCustomer.get(choiceCustomer -1).setUseService(listHouse.get(choiceHouseBook -1));
                    bookingList.addBook(listShowCustomer.get(choiceCustomer -1));
                    flagBooking = false;
                    break;
                case 3:
                    showSer(SERVICE_ROOM);
                    int choiceRoomBook;
                    do {
                        while (true) {
                            try {
                                System.out.print("Which Room do you wanna book? : ");
                                choiceRoomBook = Integer.parseInt(scanner.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Wrong format!");
                            }
                        }
                        if (choiceRoomBook < 1 || choiceBookingMenu > listRoom.size()) {
                            System.out.println("Invalid Room");
                        }
                    } while (choiceRoomBook < 1 || choiceBookingMenu > listRoom.size());

                    listShowCustomer.get(choiceCustomer -1).setUseService(listRoom.get(choiceRoomBook -1));
                    bookingList.addBook(listShowCustomer.get(choiceCustomer -1));
                    flagBooking = false;
                    break;
                case 4:
                    flagBooking = false;
                    break;
                default:
                    System.out.println("Failed");
                    break;
            }
        } while (flagBooking);

        System.out.println("Thank you for choosing our service!");
    } // task 7

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
    } // task 8

    private static void showInformationEmployee() {
        Map<String, Employee> showMap = addEmpToMap();
        int i = 1;
        for(Map.Entry<String, Employee> entry : showMap.entrySet()) {
            System.out.println(i+". "+entry.getKey()+" - "+entry.getValue());
            i++;
        }
    } // task 9 (Map)

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
    } // task 9

    private static void cinema4D() {
        boolean flagCinema = true;
        int choiceCinema;
        do {
            System.out.println( "\t CINEMA 4D\n"+
                                "1. Buy a Ticket\n" +
                                "2. Show List\n"+
                                "3. Back\n" +
                                "0. Exit\n");
            while (true) {
                try {
                    System.out.print("Your choice is : ");
                    choiceCinema = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Wrong format!");
                }
            }
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
    } // task 10 main (Queue)

    private static void buyTicket() {
        if (queue.size() == 5) {
            System.out.println("We are ran out of tickets");
        } else {
            System.out.println("\tBUY TICKET - JUST 5 TODAY");
            Ticket ticket = new Ticket();
            List<Customer> listCustomer = customerList.findAll();
            for (int i = 0; i < listCustomer.size(); i++) {
                System.out.println((i +1)+". "+listCustomer.get(i).getName());
            }
            int choiceCusTicket;
            do {
                while (true) {
                    try {
                        System.out.print("Which customer? : ");
                        choiceCusTicket = Integer.parseInt(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Wrong format!");
                    }
                }
                if (choiceCusTicket < 1 || choiceCusTicket > listCustomer.size()) {
                    System.out.println("Invalid Customer");
                }
            } while (choiceCusTicket < 1 || choiceCusTicket > listCustomer.size());
            ticket.setIdCustomer(listCustomer.get(choiceCusTicket -1).getId());
            ticket.setNameCustomer(listCustomer.get(choiceCusTicket -1).getName());
            ticket.setBuyTime(buyTime());

            queue.offer(ticket);
//        customerQueue.add(ticket);
//        ticketList.addTicket(ticket);
            System.out.println("Thank you for buying ticket!");
        }
    } // task 10
    private static void showSoldTicket() {
        if (queue.size() == 5) {
            while (!queue.isEmpty()) {
                System.out.println(queue.poll().showInfor());
            }
        } else {
            System.out.println("Tickets have not been sold out! ("+(5- queue.size())+" tickets left)");
        }
//        if (!customerQueue.isEmpty()) {
//            for (int i = 0; i < customerQueue.size(); i++) {
//                System.out.println((i +1)+". "+customerQueue.get(i).getIdCustomer()+" - "+customerQueue.get(i).getNameCustomer()+" - "+customerQueue.get(i).getBuyTime());
//            }
//            System.out.println();
//        } else {
//            System.out.println("Please buy some ticket first!");
//        }
//        List<Ticket> listTicket = ticketList.findAll();
//        for (int i = 0; i < listTicket.size(); i++) {
//            System.out.println((i +1)+". "+listTicket.get(i).showInfor());
//        }
    } // task 10
    private static String buyTime() {
        return new SimpleDateFormat("HH:mm").format(new Date());
    }

    private static void cabinetStack() {
        System.out.println( "\tCABINET STACK\n"+
                            "1. Add Employee to Stack\n"+
                            "2. Find Employee By Id\n"+
                            "3. Back\n"+
                            "4. Exit\n");
        int choiceCabinet;
        boolean flagCabinet = true;
        do {
            while (true) {
                try {
                    System.out.print("Your choice is : ");
                    choiceCabinet = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Wrong format!");
                }
            }
            switch (choiceCabinet) {
                case 1:
                    Cabinet.addAllToStack();
                    break;
                case 2:
                    String id;
                    System.out.print("Enter a ID to find : ");
                    id = scanner.nextLine();

                    Cabinet.findEmpById(id);
                    break;
                case 3:
                    flagCabinet = false;
                    break;
                case 4:
                    System.exit(choiceCabinet);
                    break;
                default:
                    System.out.println("Failed");
                    break;
            }
        } while (flagCabinet);

    } // task 11 (Stack)

    public static void main(String[] args) {
        displayMainMenu();
    }
}
