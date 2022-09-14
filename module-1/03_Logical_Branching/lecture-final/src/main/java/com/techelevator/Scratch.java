package com.techelevator;

public class Scratch {



    // type psvm and it will autogenerate
    public static void main(String[] args) {

        int distance = 800;
        int alreadyTraveled = 537;
        double percentage = ((double)alreadyTraveled) / distance; // this will result in a decimal like .532
        int intPercent = (int)(percentage * 100);


        int costPencil = 7;
        int amount = 50;
        int totalPencils = amount / costPencil;

        // Expressions, statements, and blocks
        // Expression is any segment of code that results in a single value
        int x = 1+2; // 1+2 is an expression
        int y = (1+2) + (3+4); // 1+2 is an expression, 3+4 is an expression, and adding their two results is an expression
                                // all of line 21 until the semicolon is a statement, similar to a sentence. Think
                                // of a semicolon like a period

        boolean myValue = true;
        System.out.println(myValue);
        System.out.println(!myValue);


        // individual blocks, each with their own scope
        // any code block embedded within a parent code block is in the parent code block's scope
        // so if I move one of these spidermen out of their code block's and put it into the code block
        // of this entire method (for instance, uncommenting line 35),
        // then there will be conflicts, and the makings of a good movie

        //String spiderman = "tom";
        {
            String spiderman = "tom";
        }
        {
            String spiderman = "andrew" ;
        }
        {
            String spiderman = "toby";
        }


        String name = "steve";
        boolean isSpiderman = name.equals("toby") ||  name.equals("andrew") ||name.equals("tom");
        System.out.println(name + " is Spiderman: " + isSpiderman);

        if(isSpiderman) {
            System.out.println("I'm Spiderman!");
        }

        //methods

       introduceSelf("Christopher", "Columbus", "Morbius");
       introduceSelf("Andrew", "Ferndale", "The Room");

       int sum1 = doMathQuick(2,4);
       System.out.println(sum1);
       int sum2 = doMathQuick(1,5);
        System.out.println(sum2);
       int sum3 = doMathQuick(3,4);
        System.out.println(sum3);

        int money = 0;
        boolean moreThan10 = money >= 10;
        boolean moreThan5 = money >= 5;
        boolean moreThan1AndSpiderman = money > 0 && isSpiderman;

        if (moreThan10) {
            System.out.println("Go to the movies");
        }
        else if (moreThan5) {
            System.out.println("Go to Wendy's and watch netflix");
        }
        else if( moreThan1AndSpiderman) {
            System.out.println("Buy a pepsi and crawl up high enough to see a drive in movie");
        }
        else {
            System.out.println(" Eat saltines, stare at blank wall");
        }

        System.out.println("Finished");
    }

    /*
    1. Specify the accessibility of the method. For now always use public
    2. Specify if the method returns a value, and if so, indicate its data type. If it doesn't
        return anything, use "void"
    3. Give the method a name. Same naming conventions as variables (camel case)
    4. Always include parentheses after the name, even if empty. If you are passing any parameters
        into the method, put them inside these parentheses as a comma separated list
    */
    public static void introduceSelf(String name, String location, String movie){
        System.out.println("Hi my name is " + name);
        System.out.println("I live in " + location);
        System.out.println("Worst movie I've seen lately is " + movie);
    }

    /*
    Method name : add
    accepts two ints and returns the sum
     */
    public static int doMathQuick(int firstNumber, int secondNumber) {
        int sum = firstNumber + secondNumber;
        return sum;
    }
}
