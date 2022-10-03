package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordSearch {

    public static void main(String[] args) {

        int counter = 0;
        Scanner userScan = new Scanner(System.in);
        System.out.println("Please enter a file path");
        String myPath = userScan.nextLine();
        File myFile = new File(myPath);

        System.out.println("Please enter a search word to check for");

        String word = userScan.nextLine();
        try (Scanner scan = new Scanner(myFile)) {

            while (scan.hasNextLine()) {

                String line = scan.nextLine();
                counter++;

                if (line.contains(word)) {
                    System.out.println(counter + " " + line);
                }
            }
        } catch (FileNotFoundException exception) {
            System.out.println("We couldn't find the file you were looking for sorry");
        }
    }
}
