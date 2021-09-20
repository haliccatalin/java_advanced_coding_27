package com.sda.ex1;

public class Developer extends Person {

    public Developer () {
        super(); // apelam constructorul din clasa parinte
        System.out.println("Constructor: Developer");
    }

    public void drinkCoffee () {
        System.out.println("Developer >> Wake Up!");
    }

}
