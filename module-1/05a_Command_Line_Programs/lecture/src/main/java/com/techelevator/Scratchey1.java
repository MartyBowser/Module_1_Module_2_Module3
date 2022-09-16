package com.techelevator;

import java.util.Scanner;

public class Scratchey1 {

    public static void main(String[] args) {

        int[] myInts = {1, 2, 3, 4};

        boolean[] myBools = new boolean[3];

        //To reference the first element in the array
        myBools[0] = true;

        //To reference the last element in the array
        myBools[myBools.length - 1] = false;


        // init index;      specify the condition;  determine the iterator
        for (int index = 0; index < myBools.length; index++) {
            System.out.println(myBools[index]);

        }
        for (int index = myBools.length - 1; index >= 0; index--) {
            System.out.println(myBools[index]);
        }

        String[] pets = {"dog", "dog", "ferret", "cat", "dog"};

        int catCounter = 0;
        for (int index = 0; index < pets.length; index++) {
            catCounter++;
            continue; // stops executing the current iteration of the for loop and goes back to start
            // the new iteration of the loop

        }
        //if(pets[index].equals("ferret")){
        //break stop the for loop and you will drop out of it to the code below
        // break;

        String myName = "Christopher";

        int x = 10;
        int y = 10;
        System.out.println(x == y);


        //How to split a string into an array
        String groceryList = "Bread-Milk,Eggs, Butter";
        String[] groceryListArray = groceryList.split(",|-");


        //How to convert from string to another data type
        String myIntString = "10";
        int intVal = Integer.parseInt(myIntString);

        String myDoubleString = "3.14";
        double dblVal = Double.parseDouble(myDoubleString);

        String myLongString = "3000000000";
        long longVal = Long.parseLong(myLongString);



        String myBoolString = "true";
        boolean boolVal = Boolean.parseBoolean(myBoolString);


        // How to get user input
        System.out.println("How many cats do you have");

        Scanner scan = new Scanner(System.in);
        String numCatsString = scan.nextLine();
        System.out.println("You have " + numCatsString + "cats");
        System.out.println("How many dogsdo you have?");
        String numDogsString = scan.next


        System.out.println("Finished");


    }
}
