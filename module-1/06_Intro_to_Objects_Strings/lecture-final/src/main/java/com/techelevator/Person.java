package com.techelevator;

public class Person {

    // properties
    private String firstName;
    private String lastName;
    private String worstMovie;

    public Person(String firstName, String lastName, String worstMovie) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.worstMovie = worstMovie;
    }

    //methods
    public void introduceSelf() {
        System.out.println("Hi my name is" + firstName + " " + lastName);
        System.out.println("And the worst movie I saw was " + worstMovie);
    }



}
