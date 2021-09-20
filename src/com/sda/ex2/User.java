package com.sda.ex2;

public class User implements ItemManager, ItemSummary {
    private WarehouseManager warehouse;

    public User () {
        warehouse = new WarehouseManager();
    }


    @Override
    public void addItem(Item item) {
        this.warehouse.addItem(item);
    }

    @Override
    public void editItem(Item item) throws Exception {
        this.warehouse.editItem(item);
    }

    @Override
    public void deleteItem(Item item) throws Exception {
        this.warehouse.deleteItem(item);
    }


    @Override
    public void displayItem(String key) throws Exception {
        this.warehouse.displayItem(key);

    }

    @Override
    public void displayAllItems() {

        this.warehouse.displayAllItems();

    }

    @Override
    public int sumOfAllProducts() {
        return this.warehouse.sumOfAllProducts();
    }

    @Override
    public double sumOfAllPrices() {
        return this.warehouse.sumOfAllPrices();
    }
}
