package com.sda.ex4;

import com.sda.exercises.ex4.enums.Brand;
import com.sda.exercises.ex4.enums.Models;

public abstract class Vehicle {
    private Brand brand;
    private Models model;

    public Vehicle(Brand brand, Models model) {
        this.brand = brand;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
