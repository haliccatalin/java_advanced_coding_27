package com.sda.ex4;

public class Parser {
    public static Person createPersonFromInput(String line){
        String[] data = line.split(",");
        if(data.length == 3) {
            String name = data[0];
            String surname = data[1];
            String dateOfBirth = data[2];
            Person p = new Person(name ,surname ,dateOfBirth);
            return p ;
        }else{
            return null;
        }
    }
}
