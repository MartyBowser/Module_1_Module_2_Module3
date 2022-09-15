package com.techelevator;

public class Scratch {

    // psvm shortcut
    public static void main(String[] args) {

        int money = 50;
        boolean isConcertPlayingTonight = false;
        boolean isRaining = true;

        // if there is a concert tonight
        if (isConcertPlayingTonight && money > 30) {

            // and if I have the money to go (more than 30)

            // then I'm going to the concert
            System.out.println("I'm going to the concert!");

        }
        else if(!isRaining) {
            System.out.println("I'm taking a walk in the park");
        }
        else {
            System.out.println("Rest at home");
        }

        System.out.println("Finished");

        int sum = doMathQuick(2, 3);

        String person1 = "Christopher";
        String person2 = "Craig";
        String person3 = "Heather";

        // There are two ways to create an array:

        // Option 1: Declare it with values right away. The length is implied.
       // String[] people = {"Christopher", "Craig", "Heather"};

        // Option 2: Declare only the size of the array, and populate the individual indexes later
        String[] people = new String[3];
        people[0] = "Christopher";
        people[1] = "Craig";
        people[2] = "Heather";

        // We can use any data type for an array using either of those declarations above
        int[] numbers = new int[3];
        int[] oddNumbers = {1,3,5};

        // Every array has a property we can reference as .length
        System.out.println(people.length);

        // If we want the last element, it's always length - 1
        int lastIndex = people.length - 1;
        System.out.println(people[lastIndex]);

        // If we want the first element, it's always 0
        System.out.println(people[0]);

        System.out.println("****************************************************");

        //   init index         condition          how we increment
        for(int index = 0; index < people.length ; index++) {
            System.out.println(people[index]);
        }

        System.out.println("****************************************************");

        //if I want to go backwards through the array:
        for(int index = people.length - 1; index >= 0; index--) {
            System.out.println(people[index]);
        }

        // if I want to find the sum of an array of numbers
        int[] arrayOfNumbers = {1,2,34,5,6};
        int sumOfArray = 0;
        for(int index =0; index < arrayOfNumbers.length; index++){
            int currentValue = arrayOfNumbers[index];
            sumOfArray = sumOfArray + currentValue;
            // sumOfArray += arrayOfNumbers[index]
        }

        // if we wanted the average
        int average = sumOfArray / arrayOfNumbers.length;


        /////////
        // shortcuts
        //////////

        int i = 0;
        // all four of these do the same thing
        i = i + 1;
        i++; // nuance to when the increment occurs
        ++i;
        i+=1;

        // all four of these do the same thing
        i = i - 1;
        i--; //nuance to when the decrement occurs
        --i;
        i-=1;

    }

    public static int doMathQuick(int num1, int num2) {
        int sum = num1 + num2;
        return sum;
    }

}
