package com.sda.ex10;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 10. *Create a factory that includes Manager, employees (Worker) and *Director.
 * a. loops, conditions - adding employees, displaying currently working (what they do), getting orders from the user.
 * b. OOP - all employees (including the director), inherit from the common class (Employee).
 * Each employee may have a work tool (e.g. Hammer, Laptop, PointingFinger).
 * c. collections - appropriate grouping of data
 * d. * threads -  use the while loop only to receive orders from the user, use the threads to display status / modify each object.
 * e. ** additional functionalities – e.g. displaying information about who and how much has earned since the beginning of work (counting every few seconds), "deduct in succession" - sorted list of employees (by name), employee data can be loaded from the file at the beginning.
 * f. ** support for the Director class - displaying information "everybody works - great!", "where is <name> ?!" (e.g. if the employee has left earlier).
 */
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;

        final List<Employee> employeeList = new ArrayList<>();

        while (isRunning) {
            System.out.println("1. Create director");
            System.out.println("2. Create manager");
            System.out.println("3. Create Worker");
            System.out.println("4. Show employees");
            System.out.println("5. Export");
            System.out.println("6. Import");
            System.out.println("exit");

            String option = sc.nextLine();

            switch (option) {
                case "1":
                    System.out.println("Director");
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Tool: ");
                    String tool = sc.nextLine();

                    Director director = new Director(name, phone, tool);
                    employeeList.add(director);
                    break;
                case "2":
                    System.out.println("Manager");
                    System.out.print("Name: ");
                    String name1 = sc.nextLine();
                    System.out.print("Phone: ");
                    String phone1 = sc.nextLine();
                    System.out.print("Tool: ");
                    String tool1 = sc.nextLine();

                    Manager manager1 = new Manager(name1, phone1, tool1);
                    employeeList.add(manager1);
                    break;
                case "3":
                    System.out.println("Worker");
                    System.out.print("Name: ");
                    String name2 = sc.nextLine();
                    System.out.print("Phone: ");
                    String phone2 = sc.nextLine();
                    System.out.print("Tool: ");
                    String tool2 = sc.nextLine();

                    Worker worker = new Worker(name2, phone2, tool2);
                    employeeList.add(worker);
                    break;
                case "4":
                    for (Employee employee : employeeList) {
                        //instanceof =>ne ajuta sa identificam clasa cu care a fost creat obiectul
                        if (employee instanceof Director) {
                            System.out.println("Director: " + employee.getName() + " - " + employee.getTelephoneNumber() + " - " + employee.getTool());
                        } else if (employee instanceof Manager) {
                            System.out.println("Manager: " + employee.getName() + " - " + employee.getTelephoneNumber() + " - " + employee.getTool());
                        } else if (employee instanceof Worker) {
                            System.out.println("Worker: " + employee.getName() + " - " + employee.getTelephoneNumber() + " - " + employee.getTool());
                        }

                    }
                    break;
                case "5":
                    //Interfata anonima
                    Runnable functionThread = new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(1000 * 3);
                                exportData(employeeList);

                            } catch (Exception e) {
                                System.err.println(e.getMessage());

                            }
                        }
                    };
                    Thread exportThread = new Thread(functionThread);
                    exportThread.start();
                    break;
                case "6":
                    List<Employee> temp = importData("employees.txt");
                    for (Employee emp : temp) {
                        employeeList.add(emp);

                    }

                    break;
                case "exit":
                    isRunning = false;
                    break;

            }
        }
    }

    public static void exportData(List<Employee> employesList) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("employees.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(employesList);

            objectOutputStream.close();
            System.out.println("Export with success!");
        } catch (Exception e) {
            //err =>afiseaza textul cu rosu in consola
            System.err.println(e.getMessage());
            e.printStackTrace();
        }


    }

    public static List<Employee> importData(String fileName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            List<Employee> employees = (List<Employee>) objectInputStream.readObject();
            return employees;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return new ArrayList<>();

    }
}