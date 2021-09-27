package com.sda.ex10;

import java.io.Serializable;

public class Manager extends Employee {

    public Manager(String name,String phone,String tool, Double earningsPerHour){
        super(name,phone,tool,earningsPerHour);
        System.out.println("Constructor clasa Manager");

    }
}
