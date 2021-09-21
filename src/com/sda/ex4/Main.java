package com.sda.ex4;

import com.sda.ex4.enums.Brand;
import com.sda.ex4.enums.Models;

import java.util.Locale;
import java.util.Scanner;

/**4. Let’s buy a vehicle
 * a. Create class Person
 *         b. Create class Parser
 *         c. Create interface or an abstract class Vehicle
 *         d. Create classes Car and Bike, that will implement/inherit Vehicle.
 *         e. User will provide all of the details about the Person (buyer) using command-line
 *         (e.g. “John Smith born 3/24/1984”. Provided information will be parsed using Regex within Parser class.
 *         Parser class should receive char sequence and return an object of type Person or Null if provided details will not have required information.
 *         f. Created person will then buy a bike and car. Information about what and when was bought should be displayed.
 *         g. Brand and model of car/bike should be stored using variable of type Enum.
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce-ti date despre user : ");
        String line = sc.nextLine();
        Person p = Parser.createPersonFromInput(line);
        if(p != null){
            System.out.println(p);
        }else {
            System.out.println("Datele sunt invalide !");
        }
//        System.out.println("Buy bike !");
//        System.out.println("Bike model :");
//        String model = sc.nextLine();
//        System.out.println("Bike brand :");
//        String brand = sc.nextLine();
//        Bike bike = new Bike(brand , model);
//        System.out.println(bike);
//
//        System.out.println("Car brand :");
//         brand = sc.nextLine();
//        Car car = new Car(model ,brand);
//        System.out.println(car);
//        buyCar(sc);
//        buyBike(sc);

        System.out.println("--------------");
    }
    public static void buyCar(Scanner scanner){

        System.out.println("Buy car !");
        System.out.println("Car model :");
       String model = scanner.nextLine();
        Models.valueOf(model.toUpperCase(Locale.ROOT));
        System.out.println("Car brand !");
        String brand = scanner.nextLine();
        Car car = new Car(Brand.valueOf(brand.toUpperCase(Locale.ROOT)),Models.valueOf(model.toUpperCase(Locale.ROOT)));
        System.out.println(car);

    }
    public static  void buyBike(Scanner scanner){
        System.out.println("Buy bike !");
        System.out.println("Bike model :");
        String model = scanner.nextLine();
        Models.valueOf(model.toUpperCase(Locale.ROOT));
        System.out.println("Bike brand !");
        String brand = scanner.nextLine();
      Bike bike= new Bike(Brand.valueOf(brand.toUpperCase(Locale.ROOT)),Models.valueOf(model.toUpperCase(Locale.ROOT)));
        System.out.println(bike);
    }
}
