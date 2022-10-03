package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Scratch {

    public static int getUserInput(){

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        int myInt = Integer.parseInt(input);
        return myInt;
    }

    public static void main(String[] args) {

        System.out.println("Please enter a number to double");

        // in the try block we put all the code that we want to provide a safety net for
        try {


            String name = "Christopher";
            if(name.equals("Christopher")) {
                throw new MyCustomException(name, "Our name is null");
            }
            String lowerCaseName = name.toLowerCase();

            int myInt = getUserInput();
            System.out.println(myInt * 2);
        }
        // the catch block is the safety net
        catch(Exception ex) {
            System.out.println("Something went wrong.");
        }


        /*
        Building myBuilding = new House("123 Main St", 2);
        String myBuildingString = myBuilding.toString();
      // System.out.println(myBuildingString);

        Store myStore = new Store("Kroger","123 Wall St.", 7);
        Store myStore2 = new Store("Meijer", "124 Wall St", 8);


        List<Object> stuff = new ArrayList<>();
        stuff.add("Christopher"); // String
        stuff.add(2.0); // Double
        stuff.add(1);  // Integer
        stuff.add(true); //Boolean
        stuff.add(myBuilding);
        stuff.add(myStore);
        stuff.add(myStore2);

        for(Object o : stuff) {
            System.out.println(o.toString());
        }
            */

    }
}
