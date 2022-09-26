package com.techelevator.example;

import java.util.ArrayList;
import java.util.List;

public class Book {

    // State - what data it keeps track of
    private String title;
    private List<String> authors = new ArrayList<>();
    private boolean paperback = true;
    private int yearPublished;
    private boolean used = false;

    // Constructor - how we initialize a class
    // they only have a access modifier(ex. public)
    // then the class name, then parentheses inside
    // of which we accept any parameters we want

    // When we have multiple constructors (or methods)
    // that are named the same thing but the only difference
    // between them are the number of parameters it accepts
    // this is called overloading
    public Book() {
        paperback = true;
    }

    public Book(String title, String author) {

        this.title = title;
        this.authors.add(author);

    }

    public Book(String title, List<String> authors) {
        this.title = title;
        this.authors = authors;
    }

    public Book(int yearPublished, String title, String author) {
        this.yearPublished =  yearPublished;
        this.title= title;
        this.authors.add(author);
    }

    // Behavior - what methods it has
    // firt, getters / setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
