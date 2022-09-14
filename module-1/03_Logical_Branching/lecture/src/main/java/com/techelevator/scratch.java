package com.techelevator;

public class scratch {

    public static void main(String[] args) {

        int distance = 800;
        int alreadyTraveled = 537;
        double percentage = ((double) alreadyTraveled) / distance; // this will result in a decimal like .532
        int intPercent = (int) (percentage * 100);


        // Expressions, statements, and blocks
        // Expression is any segment of code that results in a single value
        int x = 1 + 2; // 1+2 is an expression
        int y = (1 + 2) + (3 + 4); // 1+2 is an expression, 3+4 is an expression, and adding their two results is an expression
        // all of line 21 until the semicolon is a statement, similar to a sentence, //think
        // of a semicolon like a period

        boolean myValue = true;
        System.out.println(myValue);
        System.out.println(!myValue);


        //String spiderman = "tom"
        {
            String spiderman = "tom";

        }
        {
            String spiderman = "andrew";
        }
        {
            String spiderman = "toby";
        }

        String spiderman = "peter";

        boolean isSpiderman = name.equals("toby") || name.equals("andrew") ||name.equaks("tom");
        System.out.println(name + " is Spiderman:n" + isSpiderman);

        //methods
        Scratch scratch = new Scratch(); scratch@851
          scratch.introduceSelf( name: "Christ");


        /*
        1. Specify the accessibility of the method. For now always use public
        2. Specify if the method returns a value, and if so, indicate its data type. If it doesnt return anything use void
        3. Give the method a name. Same name conventions as variables (camel case)
        4. Always include parentheses after the name, even if empty. If you are passing parameters into the method, put them inside these parentheses

         */
        public void introduceSelf(String name, String location, String movie){
            System.out.println("Hi my name is" + name);
            System.out.println("I Live in" + location);
            System.out.println("Worst movie I've seen lately is" = movie);


            /*
            Method name : add
            accepts two ints and returns the sum
             */
            public static int doMathQuick ( int first number,int secondNumber){
                int sum = firstNumber = secondNumber;
                return sum;

            }
        }