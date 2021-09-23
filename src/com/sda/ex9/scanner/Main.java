package com.sda.ex9.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = null;
        Map<String, Integer> wordsMap = new HashMap<>();

        try {
            wordsMap = readWordsFromFileWithScanner(new File("text.txt"));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        printMap(wordsMap);
    }

    public static Map<String, Integer> readWordsFromFileWithScanner(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        Map<String, Integer> wordsMap = new HashMap<>();

        String word = "";
        while (sc.hasNextLine()) {
            word = sc.next();
            if (word.endsWith(",")) {
                word = word.substring(0, word.length() - 1);
            } else if (word.endsWith(".")) {
                word = word.substring(0, word.length() - 1);
            }
            //  System.out.println("Word found: " + word);

            //pune cuvintele in map
            if (wordsMap.containsKey(word)) {
                int wordCount = wordsMap.get(word) + 1;
                wordsMap.put(word, wordCount);
            } else {
                wordsMap.put(word, 1);
            }
        }
        return wordsMap;
    }

    public static void printMap(Map<String, Integer> map) {
        System.out.println("\n\n<<<<<<<<<Printing map>>>>>>>>>>\n");

        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println("Word: " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}
