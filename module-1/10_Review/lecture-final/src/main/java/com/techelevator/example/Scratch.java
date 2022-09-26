package com.techelevator.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scratch {

    public static void main(String[] args) {








        Map<Integer, String> employees = new HashMap<>();
        employees.put(103, "Christopher");
        employees.put(104, "Craig");

        String employeeName = employees.get(103);

        Map<Integer, BankAccount> bankAccounts = new HashMap<>();

        List<Book> booksByStephenKing = new ArrayList<>();

        booksByStephenKing.add(new Book("It", "Stephen King"));
        booksByStephenKing.add(new Book("Pet Semetary", "Stephen King"));
        booksByStephenKing.add(new Book("Christine", "Stephen King"));

        Map<String, List<Book>> authorBooks = new HashMap<>();
        authorBooks.put("King", booksByStephenKing);

        List<Book> books = authorBooks.get("King");








       List<String> pets = new ArrayList<>();
        pets.add("dog");
        pets.add("cat");
        pets.add("fish");
        pets.add("ferret");

        // The foreach loop is great for starting at the beginning of a list
        // or array and going one by one through it until the end

        for(String currentValue : pets) {

            //some code
        }

        // But the for loop can go backwards
        for(int i = pets.size() - 1; i >= 0; i--) {
            // some code
        }

        //The for loop can also go every other, or any pattern we want
        for(int i = 0; i < pets.size(); i+= 2) {
            // some code
        }

        //The for loop can also let you update the list/array itself as you go
        for(int i=0; i<pets.size(); i++) {
            String newValue = pets.get(i) + " says hello world";
            pets.remove(i);
            pets.add(i, newValue);
        }



        while(pets.size() > 0) {
            pets.remove(0);


        }
    }
}
