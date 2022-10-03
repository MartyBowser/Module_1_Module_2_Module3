package com.techelevator;

public class BuildingException extends Exception{

    private Building myBuilding;

    public BuildingException(Building building) {
        this.myBuilding = building;
    }

    public Building getBuilding(){
        return myBuilding;
    }
}
