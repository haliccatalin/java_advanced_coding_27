package com.sda.ex7;

/* We’re planning vacations
a. User provides information about the country and cities that he is going to visit. You can use a nested while loop to gather information and a HashMap to store it.
b. Display the created plan.
i. *if city occurs on the list twice it should be displayed as “back and forth”
c. Store created plan using JSON.

JSON = javascript object notation
- mecanismul de functionare este asemanator cu un Map
- ca valoare, putem avea String, number, boolean, Array, Object, Null
- este folosit pentru a transmite date de la Client la Server (frontend la backend)
- important: "key-ul" sa fie de tipul String, sa fie unica
- intr-un JSON pot exista mai multe JSON
- un JSON incepe si se termina cu {}

JSON example:

{
  "firstName": "John",
  "lastName": "Smith",
  "isAlive": true,
  "age": 27,
  "address": {
    "streetAddress": "21 2nd Street",
    "city": "New York",
    "state": "NY",
    "postalCode": "10021-3100"
  },
  "phoneNumbers": [
    {
      "type": "home",
      "number": "212 555-1234"
    },
    {
      "type": "office",
      "number": "646 555-4567"
    }
  ],
  "children": [],
  "spouse": null
}
*/
//test


import netscape.javascript.JSObject;
import org.json.simple.JSONObject;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Romania,Timisoara,Brasov,Bucuresti
        // Italia, Roma, Milano, Venetia, Roma
        // Spania, Madrid, Barcelona, Cordoba
        // Statele Unite ale Americii, Washington, San Francisco, New York

        Map<String, List<String>> planMap = new LinkedHashMap<>();

        while (true) {
            System.out.println("Please insert: Country, Town, Town, etc");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break; // opreste bucla while
            }
            //System.out.println(input);

            //input = input.trim(); // .trim() elimina spatiile din lateralele String-ului (inainte si dupa el)
            input = input.replaceAll(" ", ""); //sterge toate spatiile
            String[] separatedInput = input.split(",");

            String key = "";
            List<String> values = new ArrayList<>();

            for (int i = 0; i < separatedInput.length; i++) {
                //System.out.println(separatedInput[i]);
                if (i == 0) {
                    key = separatedInput[i];
                } else {
                    if (values.contains(separatedInput[i])) {
                        values.add(separatedInput[i] + " back and forth");
                    } else {
                        values.add(separatedInput[i]);
                    }

                }
                //planMap.put(key,values);
                //System.out.println(planMap.get(key).size());
            }

            planMap.put(key, values);

        /*    for (String element : separatedInput) {
                System.out.println(element);
            }*/
        }

        for (Map.Entry<String, List<String>> entry : planMap.entrySet()) {
            System.out.println(entry.getKey());
            for (String town : entry.getValue()) {
                System.out.println(" - " + town);
            }
        }

        exportToJSON(planMap);


    }

    public static void exportToJSON(Map<String, List<String>> planMap) {
        JSONObject planJSON = new JSONObject();
        for (Map.Entry<String, List<String>> entry : planMap.entrySet()) {
            planJSON.put(entry.getKey(), entry.getValue());
        }
        System.out.println(planJSON.toJSONString());
    }
}
