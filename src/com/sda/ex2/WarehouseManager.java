package com.sda.ex2;

import java.util.HashMap;
import java.util.Map;

public class WarehouseManager implements ItemManager, ItemSummary {

    private Map<String, Item> itemsMap;

    public WarehouseManager() {
        this.itemsMap = new HashMap<>();
    }

    @Override
    public void addItem(Item item) {
        String key = item.getName();
        if (itemsMap.containsKey(key)) {
            Item oldItem = itemsMap.get(key);

            int oldCantitate = oldItem.getCantitate();
            int newCantitate = oldCantitate + item.getCantitate();

            oldItem.setCantitate(newCantitate);

            itemsMap.put(key, oldItem);

        } else {
            itemsMap.put(key, item);
        }

    }

    @Override
    public void editItem(Item item) throws Exception {
        String key = item.getName();

        if (itemsMap.containsKey(key)) {
            itemsMap.put(key, item);
        } else {
            throw new Exception("Elementul nu a fost gasit!");
        }

    }

    @Override
    public void deleteItem(Item item) throws Exception {
        String key = item.getName();

        if (itemsMap.containsKey(key)) {
            itemsMap.remove(key); // itemsMap.clear - sterge tot map-ul
        } else {
            throw new Exception("Elementul nu a fost gasit!");
        }


    }

    @Override
    public void displayItem(String key) throws Exception{

        if (itemsMap.containsKey(key)) {
            Item item = itemsMap.get(key);

            System.out.println(item);

        } else {
            throw new Exception("Elementul nu a fost gasit!");
        }

    }

    @Override
    public void displayAllItems() {
        for(Map.Entry<String, Item > entry:this.itemsMap.entrySet()){
            Item item = entry.getValue();
            System.out.println(item.toString());
        }

    }

    @Override
    public int sumOfAllProducts() {
        Map.Entry<String, Item>[] data = (Map.Entry<String, Item>[]) this.itemsMap.entrySet().toArray();


//        test


        int totalProducts = 0;
        for(Map.Entry<String, Item > entry:this.itemsMap.entrySet()){
            totalProducts += entry.getValue().getCantitate();
        }

        return totalProducts;
    }

    @Override
    public double sumOfAllPrices() {
        int totalPrice = 0;
        for(Map.Entry<String, Item > entry:this.itemsMap.entrySet()){
            totalPrice += entry.getValue().getPret() * entry.getValue().getCantitate();
        }

        return totalPrice;

    }
}
