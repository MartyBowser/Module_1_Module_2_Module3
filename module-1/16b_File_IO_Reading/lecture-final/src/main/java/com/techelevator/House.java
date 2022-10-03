package com.techelevator;

public class House extends Building{

    public House(String address, int numberOfFloors){
        super(address, numberOfFloors);
    }

    public House(String address, int numberOfFloors, String color){
        super(address, numberOfFloors, color);

    }

    @Override
    public String getAddress() {
        return "gibberish";
    }

    @Override
    public void openGarageDoor(){
        System.out.println("Open");
    }
}
