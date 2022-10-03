package com.techelevator.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scratch {

    public static void exampleMethod(String[] stringArray) {
        //this is just a dummy method for a demo below
        return;
    }


    public static void main(String[] args) {

        // Arrays
        // These are just collections of values of any
        // datatype we choose

        // Two ways to initialize
        // First way: directly give values, and it infers the size
        String[] myStringArray = {"a", "b", "c"};

        // Second way: we explicitly declare the size
        // and give it values later
        String[] myStringArray2 = new String[3];
        myStringArray2[0] = "a";
        myStringArray2[1] = "b";
        myStringArray2[2] = "c";

        //if I want to pass an array to a method, I can
        // pass a variable that's already declared by either of the
        // two styles above
        exampleMethod(myStringArray);
        exampleMethod(myStringArray2);

        //but if I want to pass in an array directly, I need
        // to be explicit about its type
        exampleMethod(new String[]{"a","b","c"});

        // the big thing with arrays is that they are
        // always the size they are initialized as. The individual
        // values inside may change, but it will always have the
        // same number of items


        //if we want update any specific location
        // (remember that we start at 0 for the first index)
        myStringArray2[0] = "Cat";

        // regardless of size, we can calculate the last index
        // by subtract 1 from the length
        myStringArray2[myStringArray2.length - 1] = "Dog";


        // arrays are limited in that we can't just add or remove
        // as we want to, and so Java has lists
        List<String> myStringList = new ArrayList<>();

        // List is an interface
        // ArrayList is a class that implements that interface
        // To go to any of the class or interface definitions
        // just right click on the data type and select "Go To"
        // and then select "Declaration or Usages"

        //Lists have methods that make collections easy

        // To add
        myStringList.add("a");
        myStringList.add("b");
        myStringList.add("c");

        //to get the size
        myStringList.size();

        //to check if something already is in the list
        boolean containsA = myStringList.contains("a");

        //we can also remove items
        myStringList.remove("a");

        //we can also remove by index
        myStringList.remove(0);

        //if we want to iterate through a list or array, we can
        // use for each loops, or regular for loops

        //for each loop
        for(String myString : myStringArray) {
            System.out.println(myString);
        }

        for(String myString : myStringList) {
            System.out.println(myString);
        }

        // regular for loops
        for(int i = 0; i < myStringArray.length; i++){
            System.out.println(myStringArray[i]);
        }

        for(int i = 0; i < myStringList.size(); i++){
            System.out.println(myStringList.get(i));
        }


        //Maps - with lists we keep track of only a single value but
        // a map will keep track of a key-value pair. Similar to a dictionary
        // you would give a word, and receive a definiton back
        Map<String, String> myMap = new HashMap<>();

        //For maps, the key and the value can be any data type. They don't
        // have to each be the same data type. So we can have keys
        // that are integers and values that are strings which would look like
        // this:
        Map<Integer, String> myMap2 = new HashMap<>();

        //or any datatype we want
        Map<String, Boolean> myMap3 = new HashMap<>();
        Map<Integer, Boolean> myMap4 = new HashMap<>();
        Map<Integer, Object> myMap5 = new HashMap<>();

        // if we want to add a key value pair:
        myMap.put("word", "definition");
        myMap2.put(1, "value");
        myMap3.put("key", true);

        // if I want to retrieve a value
        String myValue = myMap2.get(1);
        System.out.println(myValue);

        // a few other things with maps:

        //check if it already has as key
        boolean alreadyHasWord = myMap.containsKey("word");

        //check if it already has a value
        boolean alreadyHasDefinition = myMap.containsValue("definition");

        //we can see the size
        int size = myMap.size();

        //we can iterate through a map several different ways
        //1.  By keys
        for(String key : myMap.keySet()){
            System.out.println(key);
        }

        //2. By values
        for(String value : myMap.values()){
            System.out.println(value);
        }

        //3. Or by the entire key-value pair
        for(Map.Entry<String,String> entry : myMap.entrySet()){
            // our key
            System.out.println(entry.getKey());
            // our value
            System.out.println(entry.getValue());
        }
    }
}
