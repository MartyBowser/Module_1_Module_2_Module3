package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileExample {

    public static void main(String[] args) {


        // Example of a try
     /*   Scanner scan;
        try {
            scan = new Scanner(myFile);
        }
        catch(FileNotFoundException ex) {
            System.out.println("Could not find file");
        } finally {

           // scan.close();
        } */

        // Example of a try-with-resources
        // Scanner will be declared at the start of our try, and then
        // whether it succeeds or fails, the try knows to close it as well
        // so we don't have to make a finally
        String myPath = "C:\\Users\\Student\\instructor_repos\\instructor-code\\module-1\\16b_File_IO_Reading\\lecture-final\\names.txt";
        File myFile = new File(myPath);
        int counter = 0;
        int countIfHasR = 0;
        List<String> namesWithR = new ArrayList<>();

        try(Scanner scan = new Scanner(myFile)) {

            // if we want to run through each line in the file
            while(scan.hasNextLine()) {
                String line = scan.nextLine();

                //All the other code here is pretty much cookie cutter, you'll use the same
                // template most of the time.  Now that we have a line that we read from the
                // file - this is where we can do custom logic:
                counter++;

                if(line.toLowerCase().contains("r")){
                    countIfHasR++;
                    namesWithR.add(line);
                }
                //end custom logic
            }

            System.out.println("The file has " + counter + " lines in it");
            System.out.println(countIfHasR + " of those lines contain an r");
            for(String name : namesWithR) {
                System.out.println(name);
            }
        }
        catch(FileNotFoundException ex) {
            System.out.println("Could not find file");
        }



        // Clean example of file reading template:
        /*String myPath = "C:\\Users\\Student\\instructor_repos\\instructor-code\\module-1\\16b_File_IO_Reading\\lecture-final\\names.txt";
        File myFile = new File(myPath);

        try(Scanner scan = new Scanner(myFile)) {

            // if we want to run through each line in the file
            while(scan.hasNextLine()) {
                String line = scan.nextLine();

                //All the other code here is pretty much cookie cutter, you'll use the same
                // template most of the time.  Now that we have a line that we read from the
                // file - this is where we can do custom logic:

                // custom logic

                //end custom logic
            }
        }
        catch(FileNotFoundException ex) {
            System.out.println("Could not find file");
        }
*/

    }
}
