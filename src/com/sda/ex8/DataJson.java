package com.sda.ex8;

import java.util.List;

/**
 * DataJson este clasa care ne ajuta sa tinem la un loc doua obiecte de tipul List.
 * In metoda din clasa Main care returneaza un DataJson avem doua liste : una pentru locatii si una pentru tari.
 */
public class DataJson {

    //Exemplu de compozitie (randurile 12 si 13)
    private List<String> locations;
    private List<String> countries;

    public DataJson(List<String> locations, List<String> countries) {

        this.locations = locations;
        this.countries = countries;
    }

     public List<String> getLocations(){

        return this.locations;
     }

    public List<String> getCountries() {
        return countries;
    }
}
