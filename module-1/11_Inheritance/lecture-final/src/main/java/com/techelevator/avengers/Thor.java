package com.techelevator.avengers;

import com.techelevator.avengers.Avenger;

public class Thor extends Avenger {

    private boolean worthy;

    public Thor() {

        super("Thor");
        worthy = true;
    }

    public void fly() {
        if(worthy) {
            System.out.println("I can fly");
        } else {
            System.out.println("I'm sorry - I can't lift my hammer");
        }
    }

    public boolean liftHammer() {
        if(worthy) {
            return true;
        } else {
            return false;
        }
    }
}
