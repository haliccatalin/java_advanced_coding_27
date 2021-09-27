package com.sda.ex10;

import java.io.Serializable;

public class Director extends Employee {

    public Director(String name,String phone,String tool, Double earningsPerHour){
        super(name,phone,tool,earningsPerHour);
        System.out.println("Constructor clasa Director");
    }
}
