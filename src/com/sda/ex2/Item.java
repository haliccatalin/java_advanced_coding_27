package com.sda.ex2;

public class Item {
    private String name;
    private int cantitate;
    private double pret;

    public Item (String name, int cantitate, double pret) {
        this.name = name;
        this.cantitate = cantitate;
        this.pret = pret;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setCantitate (int cantitate) {
        this.cantitate = cantitate;
    }

    public void setPret (double pret) {
        this.pret = pret;
    }

    public String getName () {
        return this.name;
    }

    public int getCantitate () {
        return  this.cantitate;
    }

    public double getPret () {
        return this.pret;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", cantitate=" + cantitate +
                ", pret=" + pret +
                '}';
    }
}
