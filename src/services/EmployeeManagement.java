package services;

import commons.read_write.ReadAndWriteFile;
import models.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManagement implements CRUDInterfaces<Employee> {
    static ReadAndWriteFile<Employee> readAndWriteFile = new ReadAndWriteFile<>();
    @Override
    public List<Employee> findAll() {
        List<String[]> list = readAndWriteFile.readServiceFromFile("employee.csv");
        List<Employee> employeeList = new ArrayList<>();
        for(String[] line : list) {
            Employee employee = new Employee(line);
            employeeList.add(employee);
        }
        return employeeList;
    }

    @Override
    public void add(Employee employee) {

    }
}
