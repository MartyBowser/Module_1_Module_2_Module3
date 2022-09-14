package com.techelevator;

public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello World! My name is Christopher.");


        String name = "Christopher";

        // create a variable to hold my age and then print to console
        int age = 37;
        System.out.println(age);

        // We can assign an int to a double without an explicit cast
        // because we are not losing any precision
        double exactAge = age;

        // But if we are assigning a double to an int, we will lose any decimals
        // we have, and have to explicitly cast it to an int
        int onlyYears = (int)exactAge;


        /*
        This is a comment
        Multi line
        As many as I want
         */
        boolean isInstructor = true;
        System.out.println(isInstructor);

        double priceOfCoffee = 2.50;
        String coffeeLabel = priceOfCoffee + "Latte";
        System.out.println(priceOfCoffee + "Latte");

        String firstName = "Christopher";
        String lastName = "Guarnera";
        String fullName = firstName + " " + lastName;
        System.out.println(fullName);

        int num1 = 2;
        int num2 = 3;
        int sum = num1 + num2;
        System.out.println(sum);


        //double result = 5/2; - can't just be both ints if we want a double result
        double result = 5.0/2;
        System.out.println(result);

    }

}
