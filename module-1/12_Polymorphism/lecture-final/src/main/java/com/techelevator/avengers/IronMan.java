package com.techelevator.avengers;

public class IronMan extends Avenger implements Flyable{

    public IronMan(){
        super("Iron Man");
    }

    public void fly() {
        System.out.println("Iron Man is flying - rockets go!");
    }
}
