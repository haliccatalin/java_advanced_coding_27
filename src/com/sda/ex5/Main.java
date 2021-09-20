package com.sda.ex5;
import java.util.ArrayList;
import java.util.List;

/**
 * 5. Create a List that stores the character, e.g. "*".
 * <p>
 * a. Use the list to draw a horizontal line.
 * b. Draw a vertical line
 * c. Draw a square full of asterisks.
 * d. * Inside the loop, allow the user to select "add" / "delete" "row" / "column" - display
 * the effect after each selection.
 */
public class Main {
    public static void main(String[] args) {
        List<Character> characterList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            characterList.add('*');
        }
        System.out.println("\n a) Use the list to draw a horizontal line.");
        drawHorizontalLine(characterList);
        System.out.println("\n b)Draw a vertical line");
        drawVerticalLine(characterList);
        System.out.println("\n c) Draw a square full of asterisks.");
        drawSquare(characterList);
        System.out.println("\n c) Draw a square of asterisks.");
        drawEmptySquare(characterList);
    }
    public static void drawHorizontalLine(List<Character> list) {
        list.stream().forEach((character) -> System.out.print(character + " "));
    }
    public static void drawVerticalLine(List<Character> list) {
        list.stream().forEach((character) -> System.out.println(character));
    }
    public static void drawSquare(List<Character> list) {
        for (int i = 0; i < list.size(); i++) {
            drawHorizontalLine(list);
            //   drawVerticalLine(list);
            System.out.println();
        }
    }
    public static void drawEmptySquare(List<Character> list) {
        //print line 1
        drawHorizontalLine(list);
        System.out.println();
        for (int i = 0; i < list.size() - 2; i++) {
            System.out.print("*");
            for (int j = 0; j < list.size() - 3; j++) {
                System.out.print("   ");
            }
            System.out.println("*");
        }
        //print line 5
        drawHorizontalLine(list);
    }
}