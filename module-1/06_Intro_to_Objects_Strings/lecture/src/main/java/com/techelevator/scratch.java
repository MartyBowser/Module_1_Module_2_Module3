package com.techelevator;

import java.util.Scanner;

public class scratch {

    //psvm
    public static void main(String[] args){

        System.out.println("Please enter a comma separated list of numbers");

        Scanner scan = new Scanner(System.in);
        String listOfNumbers = scan.nextLine();

        String[] numbers = listOfNumbers.split(",");
        for(int i =0; i < numbers.length; i++) {

            String numStr = numbers[i];
            int num = Integer.parseInt(numStr);

            String binaryString = Integer.toBinaryString(num);
            System.out.println(binaryString);
        }
    }
}
