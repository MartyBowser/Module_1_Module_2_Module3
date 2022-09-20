package com.techelevator;

public class Scratch {

    // psvm
    public static void main(String[] args) {

        String city = "Columbus";

        char[] myArray = new char[city.length()];

        for(int i = 0; i < city.length(); i++) {
            myArray[i] = city.charAt(i);
        }

        //return myArray;


        char myChar = 'C';
        String myString = "C";

        String firstTwoAndLastTwo = city.substring(0,2) + city.substring(city.length() - 2);

        String firstTwo = city.substring(0,2);
        int secondToLastIndex = city.length() - 2;
        String lastTwo = city.substring(secondToLastIndex);

        System.out.println(firstTwoAndLastTwo);
    }
}
