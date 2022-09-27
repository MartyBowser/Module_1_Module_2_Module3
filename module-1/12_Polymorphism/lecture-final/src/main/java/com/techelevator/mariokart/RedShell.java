package com.techelevator.mariokart;

import com.techelevator.avengers.Flyable;

public class RedShell implements Raceable, Flyable {

    public void fly() {System.out.println("I'm flying");}

    public String getName() {
        return "This is a red shell";
    }

    public String getPhrase() {
        return " *** explosion sound ***";
    }
}
