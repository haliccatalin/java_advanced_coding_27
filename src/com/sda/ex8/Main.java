package com.sda.ex8;

/*8. We’re going on vacation
a. Load created in the previous exercise plan (JSON). Display it.
b. Create a simple interaction with a user. Every time, when user will press Enter (or
write “next”) next city (or country) should be displayed.
c. Add a possibility to remove a city/country from the list (user was not able to visit it)
d. de inlocuit secventele cu if, else if cu un switch
e. dupa operatiunile de next, remove p, remove n, la comanda exit, sa salvati lista de orase/tari inapoi intr-un JSON
*/

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            //planLocationList reprezinta o lista cu toate orasele/ tarile din JSON
            List<String> planLocationList = importFromJSON("{\"Romania\":[\"Timisoara\",\"Brasov\",\"Bucuresti\"]," +
                    "\"Spania\":[\"Madrid\",\"Barcelona\",\"Cordoba\"]," +
                    "\"Italia\":[\"Roma\",\"Milano\",\"Venetia\",\"Roma back and forth\"]," +
                    "\"StateleUnitealeAmericii\":[\"Washington\",\"SanFrancisco\",\"NewYork\"]}");

            int contor = 0;

            while (true) {
                System.out.print("\nInsert command (next, remove n, remove p, show list): ");
                String data = sc.nextLine();

                if (data.equals("next")) {
                    //planLocationList.get(contor) ne returneaza elementul din lista de pe pozitia contor (0, 1, 2, ..., etc)
                    String location = planLocationList.get(contor);
                    System.out.println(location);
                    contor++;
                } else if (data.equals("remove n")) {
                    System.out.println("Element to be deleted: " + planLocationList.get(contor));
                    planLocationList.remove(contor);
                } else if (data.equals("remove p")) {
                    if (contor > 0) {
                        System.out.println("Element to be deleted: " + planLocationList.get(contor-1));
                        //--contor => inainte de folosire se scade 1 => contor = contor-1
                        //contor-- => sout(contor), iar dupa folosire se intampla contor = contor-1
                        planLocationList.remove(--contor);
                    } else {
                        System.out.println("Cannot remove previous element");
                        //continue ne permite sa introducem din nou o comanda
                        continue;
                    }
                } else if (data.equals("show list")) {
                    //   planLocationList.stream().forEach((String location) -> System.out.println(location));
                    planLocationList.stream().forEach(System.out::println);
                }


                if (contor == planLocationList.size()) {
                    contor = 0;
                }
            }

        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

    }

    public static List<String> importFromJSON(String jsonString) throws ParseException {
        System.out.println("importFromString");
        JSONParser jsonParser = new JSONParser();

        // JSONParser ne ajuta sa transformam un String in JSON folosind metoda parse()

        JSONObject json = (JSONObject) jsonParser.parse(jsonString);

        List<String> locations = new ArrayList<>();

        //cu Iterator parcurgem toate cheile din json
        //metoda keySet() ne returneaza un Set de key-uri
        Iterator<String> iterator = json.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            locations.add(key);
            System.out.println(key);

            //json.get(key) acceseaza valorile fiecarei chei
            //key = Romania => lista: Timisoara, Brasov, Bucuresti
            List<String> townslist = (List<String>) json.get(key);
            for (String town : townslist) {
                locations.add(town);
                System.out.println(town);
            }
        }
        return locations;
    }
}
