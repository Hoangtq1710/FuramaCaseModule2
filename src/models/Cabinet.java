package models;

import commons.read_write.ReadAndWriteFile;
import services.EmployeeManagement;

import java.util.List;
import java.util.Stack;

public class Cabinet {
    static EmployeeManagement empList = new EmployeeManagement();
    static Stack<Employee> stack = new Stack<>();
    static List<Employee> listEmp = empList.findAll();

    public static void addAllToStack() {
        for (Employee emp : listEmp) {
            stack.push(emp);
        }
    }

    public static void findEmpById(String id) {
        boolean flagFind = true;
        if (!stack.isEmpty()) {
            for (Employee employee : stack) {
                if (employee.getIdEmp().equals(id)) {
                    System.out.println(employee);
                    flagFind = false;
                    break;
                } else {
                    stack.pop();
                }
            }
            if (flagFind) {
                System.out.println("Oops ID "+id+" didn't match any Employee ID!");
            }
        } else {
            System.out.println("Stack is Empty!");
        }
    }
}
