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
            DataJson planData = importFromJSON("{\"Romania\":[\"Timisoara\",\"Brasov\",\"Bucuresti\"]," +
                    "\"Spania\":[\"Madrid\",\"Barcelona\",\"Cordoba\"]," +
                    "\"Italia\":[\"Roma\",\"Milano\",\"Venetia\",\"Roma back and forth\"]," +
                    "\"StateleUnitealeAmericii\":[\"Washington\",\"SanFrancisco\",\"NewYork\"]}");

            //planLocationList reprezinta o lista cu toate orasele/ tarile din JSON
            List<String> planLocationList = planData.getLocations();
            List<String> countriesList = planData.getCountries();
            int contor = 0;
            boolean isRunning = true;

            while (isRunning) {
                System.out.print("\nInsert command (next, remove n, remove p, show list): ");
                String data = sc.nextLine();

                switch (data) {
                    //planLocationList.get(contor) ne returneaza elementul din lista de pe pozitia contor (0, 1, 2, ..., etc)

                    case "next":
                        String location = planLocationList.get(contor);
                        System.out.println(location);
                        contor++;
                        break;

                    case "remove n":
                        System.out.println("Element to be deleted: " + planLocationList.get(contor));
                        planLocationList.remove(contor);
                        break;

                    case "remove p":

                        if (contor > 0) {
                            System.out.println("Element to be deleted: " + planLocationList.get(contor - 1));
                            //--contor => inainte de folosire se scade 1 => contor = contor-1
                            //contor-- => sout(contor), iar dupa folosire se intampla contor = contor-1
                            planLocationList.remove(--contor);

                        } else {
                            System.out.println("Cannot remove previous element");
                            //continue ne permite sa introducem din nou o comanda
                            continue;
                        }
                        break;

                    case "show list":
                        //   planLocationList.stream().forEach((String location) -> System.out.println(location));
                        planLocationList.stream().forEach(System.out::println);
                        break;
                    case "exit":
                        isRunning = false;
                        break;

                    default:
                        System.out.println("Invalid command");
                }


                if (contor == planLocationList.size()) {
                    contor = 0;
                }
            }
            savePlanAsJson(planLocationList, countriesList);


        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void savePlanAsJson(List<String> locations, List<String> countries) {

        JSONObject noulJSON = new JSONObject();

        for (String country : countries) {

            noulJSON.put(country, new ArrayList<>());
        }


        //currentCountry il folosim pentru a salva fiecare tara gasita in lista numita locations
        String currentCountry = "";
        //parcurgem lista de locatii
        for (String location : locations) {
            //verificam daca locatia este o tara,adica daca noul JSON contine ca si cheie valoarea din location
            if (noulJSON.containsKey(location)) {
                //Salvam tara gasita intr-o variabila.
                //currentCountry = Romania => pana la gasirea unei noi tari, toate variabilele vor fi considerate orase
                currentCountry = location;

            } else {
                //daca am ajuns aici inseamna ca location este un oras

                //pentru a evita aceasta situatie restrictionam utilizatorul sa stearga tarile
                //sTODO:in metodele de remove sa nu lasam utilizatorul sa stearga o tara
                //sFIXME:

                if (currentCountry.equals("")) {

                    currentCountry = "others";
                    noulJSON.put(currentCountry, new ArrayList<>());
                }
                //folosim currentCountry care reprezinta ultima tara gasita, pentru a lua din noul JSON lista de orase atribuita respectivei tari
                List<String> cities = (List<String>) noulJSON.get(currentCountry);
                //adaugam orasul gasit la lista de orase preluata din noul JSON
                cities.add(location);
                //in noul JSON actualizam lista de orase pentru ultima tara gasita
                noulJSON.put(currentCountry, cities);
            }
        }
        //salvam JSON-ul ca string
        System.out.println(noulJSON.toJSONString());


    }

    public static DataJson importFromJSON(String jsonString) throws ParseException {
        System.out.println("importFromString");
        JSONParser jsonParser = new JSONParser();

        // JSONParser ne ajuta sa transformam un String in JSON folosind metoda parse()

        JSONObject json = (JSONObject) jsonParser.parse(jsonString);

        List<String> locations = new ArrayList<>();
        List<String> keyList = new ArrayList<>();


        //cu Iterator parcurgem toate cheile din json
        //metoda keySet() ne returneaza un Set de key-uri
        Iterator<String> iterator = json.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            keyList.add(key);
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
        DataJson exportToDataJson = new DataJson(locations, keyList);

        return exportToDataJson;
    }


}
