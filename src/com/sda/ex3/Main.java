package com.sda.ex3;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*3.
Personal information
a. Create a file containing any personal data (name, surname, phone number). Data of
individual persons should be in the following lines.
b. Download data from a file and create objects of people based on them (in any way -
Regex, String.split ...).
c. Enter the created objects into ArrayList or Map (<line number>: <Person>).
d. Present the obtained data.
*/
public class Main {
    public static void main(String[] args) {
        List<String> personList = readFile("personalData.txt");
        List<Person> personObjects = new ArrayList<>();
        Map<Integer, Person> personMap =  new HashMap<>();

        int contor = 1;

        for (String person : personList) {
            // impartim elementele din String dupa ", " pentru a obtine un array de string-uri
            String[] data = person.split(", ");
            // folosind constructorul Person trimitem datele obtinute mai sus
            Person personObject = new Person(data[0], data[1], data[2]); //data[0] = nume, datap[1] = prenume, data[2] = numar tel
            // adaugam obiectele in lista de obiecte
            personObjects.add(personObject);
            personMap.put(contor, personObject);
            contor++;
            // System.out.println("Data: " + data[0] + " " + data[1] + " "+ data[2]);
            System.out.println(person);
        }

        System.out.println("\n------------------------------");

        personObjects.stream().forEach((person) -> System.out.println(person));

        System.out.println("\n------------------------------");
        for(Map.Entry<Integer, Person> entry: personMap.entrySet()){
            System.out.println("ID: " + entry.getKey() + " -> " + entry.getValue());
        }

    }


    public static List<String> readFile(String fileName) {
        List<String> personList = new ArrayList<>();
        try {
            personList = Files.readAllLines(Path.of("personalData.txt"));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return personList;
    }
}
