package com.techelevator;

import java.util.Scanner;

public class Scratch {

    //psvm
    public static void main(String[] args) {

        int[] myInts = {1,2,3,4};

        boolean[] myBools = new boolean[3];

        //To reference the first element in the array
        myBools[0] = true;
        myBools[0] = false;

        //To reference the last element in the array
        myBools[myBools.length - 1] = false;

        //  init index;   specify the condition;  determine the iterator
        for(int index = 0; index < myBools.length; index++) {
            System.out.println(myBools[index]);
        }

        for(int index = myBools.length-1; index >= 0; index--){
            System.out.println(myBools[index]);
        }

        String[] pets = {"dog","cat","dog", "dog", "ferret", "cat", "dog"};

        int catCounter = 0;
        for(int index = 0; index < pets.length; index++){

            if(pets[index].equals("cat")) {
                catCounter++;

                // stops executing the current iteration of the for loop and goes back to start
                // the next iteration of the loop
                continue;
            }

            if(pets[index].equals("ferret")) {
                // break stops the for loop and you will drop out of it to the code below
                break;
            }

        }

        System.out.println("*******************************");
        // Example of how to test String equality

        int x = 10;
        int y = 10;
        System.out.println(x == y);


        String myName = "Christopher";
        String secondName = new String("Christopher");
        System.out.println(myName == secondName);
        System.out.println(myName.equals(secondName));


        // How to split a string into an array
        String groceryList = "Bread,Milk,Eggs,Butter";
        //groceryList = groceryList.replaceAll("-",",");
        String[] groceryListArray = groceryList.split(",");

        // How to convert from String to another data type
        String myIntString = "10";
        int intVal = Integer.parseInt(myIntString);

        String myDoubleString = "3.14";
        double myDoubleValue = Double.parseDouble(myDoubleString);

        String myLongString = "30000000000";
        long longVal = Long.parseLong(myLongString);

        String myBoolString = "true";
        boolean boolVal = Boolean.parseBoolean(myBoolString);

        // How to get user input
       System.out.println("How many cats do you have?");

       Scanner scan = new Scanner(System.in);
       String numCatsString = scan.nextLine();
       System.out.println("You have " + numCatsString + " cats");
       System.out.println("How many dogs do you have?");
        String numDogsString = scan.nextLine();
        System.out.println("You have " + numDogsString + " dogs");

        System.out.println("Finished");
    }
}
