package com.techelevator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scratch {

    public static void createArray(int size) {

        // arrays don't have to be initialized with a known number
        // we can make it a variable. It's just important to remember
        // the arrays have a limit - once their size is declared
        // they cannot grow or shrink. They are fixed.
        String[] myStringArray = new String[size];
    }

    public static void acceptArrayAsParam(String[] myArray) {
        // just an example
    }

    public static void main(String[] args) {

        //Arrays

        //There are two ways to initialize arrays

        //the first way the size is explicitly declared

        //I first indicate the datatype (String) follow it with [] (to indicate array)
        // and then say that the new String array length is going to be 5
        String[] myStringArray = new String[5];
        myStringArray[0] = "a";
        myStringArray[1] = "b";
        myStringArray[2] = "c";

        //The data type can be anything
        BankAccount[] myBankAccountArray = new BankAccount[10];

        //The second way to declare an array is to give it values immediately
        // in which case the size is inferred by the compiler
        String[] myStringArray2 = {"a","b","c"};
        String[] myStringArray3 = new String[]{"a","b","c"};

        //if we are passing an array to a method and want to initialize it inline
        acceptArrayAsParam(new String[]{"a", "b", "c"});

        //to loop through an array using a for
        // Reminder: for loops are good when you want to make updates to the collection itself
        // while you iterate, or if you want to iterate from the end of the array to the beginning,
        // or do anything else that's not a 1 at a time increment with the index (for instance
        // if you wanted to do every other item like i+=2 instead of i++)
        for(int i = 0; i < myStringArray.length; i++) {
            String myCurrentValue = myStringArray[i];
            System.out.println(myCurrentValue);
        }

        //if we want to loop through an array using a for from end to beginning
        for(int i = myStringArray.length - 1; i >= 0; i--) {
            String myCurrentValue = myStringArray[i];
            System.out.println(myCurrentValue);
        }

        //to loop through an array using a for each
        // Reminder: for each loops are great when you only have to read each value
        // one at a time from a collection start to finish
        for(String currentValue : myStringArray) {
            System.out.println(currentValue);
        }


        // Lists
        // We can grow and shrink as necessary
        // lists allow duplicates
        List<String> myStringList = new ArrayList<>();
        List<BankAccount> myBankAccountList = new ArrayList<>();

        // to get the size of list
        int size = myStringList.size();

        // to add to the list
        myStringList.add("cat");
        myStringList.add("dog");
        myStringList.add("dog");
        myStringList.add("fish");

        // to remove from the list we can do it two ways
        // by index:
        myStringList.remove(0);
        // by value (remember it is case sensitive):
        myStringList.remove("dog"); // this removes the first instance it finds, not all

        //if we wanted to remove all
        while(myStringList.contains("dog")){
            myStringList.remove("dog");
        }

        //we can check if something is already in the list
        boolean alreadyContainsFish = myStringList.contains("fish");

        // loop with a for
        for(int i = 0; i < myStringList.size(); i++) {
            String myCurrentValue = myStringList.get(i);
            System.out.println(myCurrentValue);
        }

        // loop with a for each
        for(String myCurrentValue : myStringList) {
            System.out.println(myCurrentValue);
        }


        // Maps
        // This keeps track of two values: a key and a value
        // keys must be distinct, they cannot be duplicated
        // values can be duplicated, so long as their keys are unique

        //REMINDER: maps do not keep any sort of order to them. If you enter something first
        // that does not mean it will stay in the first position. They have their own sorting
        // mechanisms.

        // think about a dictionary, keys would be the words you are looking up and values
        // would correspond to the definition associated with each word

        // keys and values can be defined as any object type
        Map<String, String> dictionary = new HashMap<>();

        Map<Integer, String> employeeIdLookup = new HashMap();

        Map<String, BankAccount> myMap = new HashMap();

        //if I want to add to a map
        employeeIdLookup.put(12345, "Christopher");
        employeeIdLookup.put(78990, "Craig");

        myMap.put("555-55-5555", new BankAccount("Primary", "1234567890"));

        //if I want to remove from a map
        myMap.remove("555-55-5555");

        //if we want to iterate through our maps, we can do it three ways

        //first way, by key
        for(Integer employeeId : employeeIdLookup.keySet()){
            System.out.println(employeeId);
        }

        //second way by value
        for(String employeeName : employeeIdLookup.values()){
            System.out.println(employeeName);
        }

        //third way by both key and value
        for(Map.Entry<Integer, String> entry : employeeIdLookup.entrySet()){
            System.out.println(entry.getKey()); //key
            System.out.println(entry.getValue()); //value
        }

        // to retrieve a value
        String name = employeeIdLookup.get(12345);

        // to check if a key already exists
        boolean alreadyHasEmployee12345 = employeeIdLookup.containsKey(12345);

        //update a value in our map
        employeeIdLookup.put(12345, "Frank");

        //Two merge two maps
        Map<Integer, String> ids = new HashMap<>();
        ids.put(1,"cat");
        ids.put(2, "dog");
        ids.put(3, "fish");
        Map<Integer, String> ids2 = new HashMap<>();
        ids2.put(4, "ferret");
        ids2.put(5, "parrot");
        ids2.put(1, "hamster");

        //if we want to merge everything into ids
        for(Map.Entry<Integer,String> entry : ids2.entrySet()) {
            ids.put(entry.getKey(), entry.getValue()); // keep in mind that key 1 will now have a value of hamster not cat
        }

    }
}
