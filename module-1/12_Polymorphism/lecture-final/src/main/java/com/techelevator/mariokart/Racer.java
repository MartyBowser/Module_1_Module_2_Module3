package com.techelevator.mariokart;

public class Racer implements Raceable {

    private String phrase;
    private String name;

    public Racer(String name, String phrase) {
        this.name = name;
        this.phrase = phrase;;
    }

    public String getName() {
        return name;
    }

    public String getPhrase(){
        return phrase;
    }
}
