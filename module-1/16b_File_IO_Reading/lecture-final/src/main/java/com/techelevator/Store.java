package com.techelevator;

public class Store extends Building{

    private String storeName;

    public Store(String storeName, String address, int numberOfFloors){

        super(address, numberOfFloors);
        this.storeName = storeName;
    }

    public Store(String address, int numberOfFloors, String color){
        super(address, numberOfFloors, color);

    }

    @Override
    public void openGarageDoor(){
        System.out.println("Open");
    }

    @Override
    public String toString(){
        return storeName + " - " + getAddress();
    }

}
