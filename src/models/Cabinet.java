package models;

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

    public static boolean findEmpById(String id) {
        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                Employee employee = stack.pop();
                if (employee.getIdEmp().equals(id)) {
                    System.out.println(employee);
                    return true;
                }
            }
            System.out.println("Oops ID "+id+" didn't match any Employee ID!");
        } else {
            System.out.println("Stack is Empty!");
        }
        return false;
    }
}
