package com.sda.ex10;

import java.io.Serializable;

public class Director extends Employee {

    public Director(String name,String phone,String tool){
        super(name,phone,tool);
        System.out.println("Constructor clasa Director");
    }
}
