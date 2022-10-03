package com.techelevator;

public abstract class Building implements Addressable {

    // state - the data we are storing in private variables
    private int numberOfFloors;
    private String address;
    protected String color = "Grey";

    //Constructors

    public Building(String address, int numberOfFloors){
        this.address = address;
        this.numberOfFloors = numberOfFloors;
    }

    //When we have multiple constructors or methods named the same thing but with
    // different numbers or types of parameters, that's called Overloading
    public Building(String address, int numberOfFloors, String color){
        this.address = address;
        this.numberOfFloors = numberOfFloors;
        this.color = color;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address){
        this.address = address;

    }

    public abstract void openGarageDoor();

}
