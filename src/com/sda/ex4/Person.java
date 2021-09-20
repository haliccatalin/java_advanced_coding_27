package com.sda.ex4;

public class Person {
    private String name;
    private String surname;
    private String dateOfBirth;

    public Person (String name, String surname ,String dateOfBirth){
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }

}
