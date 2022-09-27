package com.techelevator.avengers;

public class Thor extends Avenger implements Flyable{

    private boolean worthy;

    public Thor(){
        super("Thor");
    }

    public Thor(String name){

        super(name);
    }

    public boolean isWorthy() {
        return worthy;
    }

    public void setWorthy(boolean worthy){
        this.worthy = worthy;
    }

    @Override
    public String getName(){

        if(worthy) {
            return super.getName();
        } else {
            return "I'm not worthy - don't look at me";
        }
    }

    public void fly() {
        System.out.println("When I swing my hammer fast, I fly! Weeee!");
    }
}
