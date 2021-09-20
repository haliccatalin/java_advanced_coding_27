package com.sda;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // write your code here

        //how to go through a Map
        Map<String, String> products = new HashMap<>();
        products.put("TV", "Samsung");
        products.put("PC", "Asus");

        //foreach method
        for (Map.Entry<String, String> inregistrare : products.entrySet()) {
            System.out.println(inregistrare.getKey() + " - " + inregistrare.getValue() );
        }

        //Iterator method
        Iterator<Map.Entry<String, String>> mapIterator = products.entrySet().iterator();
        while (mapIterator.hasNext()) {
            Map.Entry<String, String> entry = mapIterator.next();
            System.out.println(entry.getKey() + " - " + entry.getValue() );
        }

    }
}
