package com.techelevator.avengers;

import com.techelevator.avengers.Avenger;

public class Hulk extends Avenger {

    public Hulk(String name) {
        super(name);
    }

    public void smash() {
        System.out.println(getName() + " smash!");
    }


}
