package com.sda.ex9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * 9. * Statistics
 * a. Create a file that will contain any text. It can be generated using lorem ipsum library.
 * b. Create statistics of words contained in the text.
 * c. Display the number of occurrences of individual words in the form
 * <word>: <number of occurrences>
 * d. * as above sorted
 */
public class Main {
    public static void main(String[] args) {
        createFile();

        String result = readFromFile();
        System.out.println(result);

        result = result.replaceAll(",", "");
        result = result.replaceAll("\\.", "");

        String[] wordsArray = result.split(" ");

        Map<String, Integer> wordsMap = new HashMap<>();
        for (String element : wordsArray) {
            if (element.equalsIgnoreCase(" ")) {
                continue;
            }
            if (wordsMap.containsKey(element)) {
                int value = wordsMap.get(element);
                wordsMap.put(element, value + 1);
            } else {
                wordsMap.put(element, 1);
            }
        }

        //unsorted
        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            System.out.println("Word: " + entry.getKey() + " -> Value: " + entry.getValue());
        }

        System.out.println("-------------------------------------------");

        sortMap(wordsMap);
    }

    public static void createFile() {
        List<String> textList = new ArrayList<>();
        try {
            Files.writeString(Path.of("text.txt"), "Lorem Ipsum is" +
                    " simply dummy text of the printing and typesetting i" +
                    "ndustry. Lorem Ipsum has been the industry's " +
                    "standard dummy text ever since the 1500s, when an unknown " +
                    "printer took a galley of type and scrambled it to make a t" +
                    "ype specimen book. It has survived not only five centuries, but" +
                    " also the leap into electronic typesetting, remaining essentially unc" +
                    "hanged. It was popularised in the 1960s with the release of Letraset she" +
                    "ets containing Lorem Ipsum passages, and more recently with desktop publis" +
                    "hing software like Aldus PageMaker including versions of Lorem Ipsum.");
        } catch (IOException e) {
            System.out.println("error");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static String readFromFile() {
        try {
            List<String> text = Files.readAllLines(Path.of("text.txt"));
            return text.stream()
                    .reduce("", (oldString, newString) -> oldString + newString);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
            return "";
        }
    }

    public static void sortMap(Map<String, Integer> map) {
        //TreeMap este sortat automat dupa chei
        TreeMap<String, Integer> sortedMap = new TreeMap<>(map);//ii dam constructorului din clasa TreeMap un Map ca si parametru
//        sortedMap.putAll(map);

        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println("Word: " + entry.getKey() + " -> Value: " + entry.getValue());
        }
    }
}
