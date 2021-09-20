package com.sda.ex2;

/*
Warehouse
a. User should be able to: add, display all of the details, update, delete an item
b. Use composition and collections (The warehouse has products/items)
c. Add possibility to display summaries, like sum of all of the products, their prices.
d. *Add possibility to update number of items in a specific way, e.g.: “pliers:30” “scissors:+4”
 */

public class Main {
    public static void main(String[] args) {

        User user = new User();

        Item item1 = new Item("Creioane", 20, 0.90);
        Item item2 = new Item("Pixuri", 50, 1.20);
        Item item3 = new Item("Stilouri", 10, 4.55);
        Item item4 = new Item("Carioci", 40, 2.55);

        user.addItem(item1);
        user.addItem(item2);
        user.addItem(item3);
        user.addItem(item4);

        user.displayAllItems();

        System.out.println("----------------------------------------");

        item3.setCantitate(100);

        try {
            user.editItem(item3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        user.displayAllItems();

        System.out.println("----------------------------------------");

        //item1.setName("Acuarele");
        try {
            user.deleteItem(item1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        user.displayAllItems();

        System.out.println("----------------------------------------");

        try {
            user.displayItem(item2.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("----------------------------------------");

        System.out.println("Pretul tuturor produselor este: " + user.sumOfAllPrices());
        System.out.println("Numarul total al produselor este: " + user.sumOfAllProducts());
    }

}
