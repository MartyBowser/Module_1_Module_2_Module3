package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Scratchey {

    //psvm
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(2);
        numbers.add(3);
        numbers.add(12);
        numbers.add(7);
        numbers.add(15);

        Collections.sort(numbers);

        //for loop
        for (int i = 0; i < numbers.size(); i++) {

            int currentNumber = numbers.get(i);
            System.out.println(currentNumber);
        }

        //for each loop
        for (int currentNumber : numbers) {
            System.out.println(currentNumber);
        }
    }
}

