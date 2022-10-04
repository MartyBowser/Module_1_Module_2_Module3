package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {


    public static void main(String[] args) {

        int counter = 0;
        Scanner userScan = new Scanner(System.in);
        System.out.println("Please enter a search word to check for");
        String word = userScan.nextLine();
        System.out.println("Please enter the replacement word");
        String replacement = userScan.nextLine();
        System.out.println("Please enter a file path");
        String mySourceFile = userScan.nextLine();
        String myDestinationFile = userScan.nextLine();
        File theDestination = new File(myDestinationFile);
        File theSource = new File(mySourceFile);




        try (Scanner scan = new Scanner(theSource);
             PrintWriter writer = new PrintWriter(theDestination)) {
            while (scan.hasNextLine()) {


                String line = scan.nextLine();
                counter++;
//  we would want to replace the line of text
             String piglett = line.replaceAll(word, replacement );
                //we would replace the word bacon with ham
                // we would only want to replace lower case bacon uppercase not requested
            writer.println(piglett);
                //write to the destination file



            }
        } catch (FileNotFoundException exception) {
            System.out.println("We couldn't find the file you were looking for sorry");
        }
    }
}

