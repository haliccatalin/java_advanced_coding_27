package com.sda.ex10;

import java.io.Serializable;

public abstract class Employee implements Serializable {
    private String name;
    private String telephoneNumber;
    private String tool;
    private double earnings;
    private double earningPerHour;

    public Employee() {
        System.out.println("Constructor clasa Employee");
    }

    public Employee(String name, String telephoneNumber, String tool, Double earningsPerHour) {
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.tool = tool;
        this.earningPerHour = earningsPerHour;
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

    public double getEarnings() {
        return this.earnings;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", tool='" + tool + '\'' +
                ", earnings=" + earnings +
                '}';
    }

    public void increaseEarnings() {
        earnings += earningPerHour;
    }
}
