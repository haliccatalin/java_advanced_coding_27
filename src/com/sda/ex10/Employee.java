package com.sda.ex10;

import java.io.Serializable;

public abstract class Employee implements Serializable {
    private String name;
    private String telephoneNumber;
    private String tool;

    public Employee(){
        System.out.println("Constructor clasa Employee");
    }

    public Employee(String name, String telephoneNumber,String tool) {
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.tool = tool;
        System.out.println("Constructor clasa Employee");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }
}
