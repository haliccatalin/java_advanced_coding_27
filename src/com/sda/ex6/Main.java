package com.sda.ex6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    /**Create a Map where the key will be the employee and the value - his manager.
     a. The key and value are of the String type
     b. The key and value are classes of type "Employee" and "Manager"
     c. * The key is of type "Manager", the value is a list storing the type "Employee"
     d. * Let the employee be dismissed, display the result
     e. * Allow to employ a new employee, display the result
     */

    public static void main(String[] args) {

        Map<String,String> mapStrings = new HashMap<>();

        mapStrings.put("Ion","Mihai");

        Map<Employee,Manager> projectMap = new HashMap<>();

        Employee employee1 = new Employee("Ion");
        Manager manager1 = new Manager("Mihai");

        projectMap.put(employee1,manager1);

        Map<Manager, List<Employee>> managerMap = new HashMap<>();

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);

        managerMap.put(manager1,employeeList);

        printMap(managerMap);

    }

    public static void printMap(Map<Manager,List<Employee>> managerMap){


        for(Map.Entry<Manager,List<Employee>> entry : managerMap.entrySet()){

            System.out.println("Manager: " + entry.getKey().getName());
            List<Employee> employees = entry.getValue();

            for(Employee employee : employees){

                System.out.println(" - " + employee.getName());
            }
        }
    }




}
