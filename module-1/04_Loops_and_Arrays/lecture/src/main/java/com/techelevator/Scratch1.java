package com.techelevator;

public class Scratch1<i> {

    //psvm shortcut
    public static void main(String[] args) {

        int money = 50;
        boolean isConcertPlayingTonight = true;
        boolean isRaining = true;

        // if there is a concert tonight
        if (isConcertPlayingTonight) {
            // and if I have the money to go (more than 30)

            if (money > 30) {
                // then I'm going to the concert
                System.out.println("I'm going to the concert!");

            }
        } else if (!isRaining) {
            System.out.println("I'm taking a walk in the park");
        } else {
            System.out.println("Rest at home");
        }
        System.out.println("Finished");

        int sum =doMathQuick(2,3);

        String person1 = "Christopher";
        String person2 = "Craig";
        String person3 = "Heather";

        // There are two ways to create an array
        //Option 1: Declare it with values right away. The length is implied
        // String [] people = { "Christopher", "Craig". "Heather"};

         // Option 2: Declare only the size of the array, and populate the individual indexes later
        String[] people = {"Christopher", "Craig", "Heather"};
        people[0] = "Christopher";
        people[1] = "Craig";
        people[2] = "heather";

        int[] numbers = new int[3];
        int[] oddNumbers = {1,3,5};

        // Every array has a property we can reference as .length - 1
        System.out.println(people[lastIndex]);

        // If we want the last element , its always

        // If ww want the first element
        }

    public static int doMathQuick(int num1, int num2) {
        int sum = num1 + num2;
        return sum;

    }
}



