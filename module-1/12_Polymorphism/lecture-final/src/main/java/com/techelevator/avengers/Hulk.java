package com.techelevator.avengers;

public class Hulk extends Avenger implements Flyable{

    public Hulk(String name) {
        super(name);
    }

    public void fly() {
        System.out.println("I'm a flying Hulk!");
    }
}
