package com.techelevator;

import java.util.*;

public class Scratch {



    //psvm
    public static void main(String[] args) {


        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(2);
        numbers.add(3);
        numbers.add(12);
        numbers.add(7);
        numbers.add(15);

       // Collections.sort(numbers);
       // Collections.reverse(numbers);

        //for loop
        for(int i = 0; i < numbers.size(); i++) {
            Integer currentNumber = numbers.get(i);
            System.out.println(currentNumber);

        }

        // for each loop
        List<String> answerList = new ArrayList<>();
        for(Integer currentNumber : numbers) {

            // print fizz buzz if divisible by both
            if((currentNumber % 3 == 0) && (currentNumber % 5 == 0)) {
                answerList.add("Fizz Buzz");
                System.out.println("Fizz Buzz");
            }

            // print fizz if divisible by 3

            // print buzz if divisible by 5

            // print number if not divisible by either
            else {
                answerList.add(currentNumber.toString());
            }
        }

       // return answerList;

        // LIFO - last in first out, stack of books
        Stack<String> todoList = new Stack<>();
        todoList.push("Go to grocery");
        todoList.push("Do Laundry");
        todoList.push("Do dishes");

        System.out.println(todoList.pop());
        System.out.println(todoList.pop());
        System.out.println(todoList.pop());

        // FIFO - first in first out, line at DMV take a number
        Queue<String> waitingInLine = new LinkedList<>();
        waitingInLine.offer("Christopher");
        waitingInLine.offer("Craig");
        waitingInLine.offer("Meredith");

        System.out.println(waitingInLine.poll());
        System.out.println(waitingInLine.poll());
        System.out.println(waitingInLine.poll());



    }
}
