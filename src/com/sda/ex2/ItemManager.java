package com.sda.ex2;

public interface ItemManager {

    //urmatoarele sunt metode abstracte pentru interfete

    void addItem (Item item);

    void editItem (Item item) throws Exception;

    void deleteItem (Item item) throws Exception;

    void displayItem (String key) throws Exception;

    void displayAllItems ();

}
