package com.sda.ex10;

import java.io.Serializable;

public class Manager extends Employee {

    public Manager(String name ,String phone,String tool){
       super(name,phone,tool);
        System.out.println("Constructor clasa Manager");

    }
}
