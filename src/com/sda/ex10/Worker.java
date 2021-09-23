package com.sda.ex10;

import java.io.Serializable;

public class Worker extends Employee {

    public Worker(String name,String phone,String tool){
        super(name,phone,tool);
        System.out.println("Constructor clasa Worker");
    }
}
