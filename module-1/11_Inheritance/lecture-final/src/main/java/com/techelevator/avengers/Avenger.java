package com.techelevator.avengers;

public class Avenger {

    // state
    private String name;
    protected String coolNewUniform;

    // constructors
    public Avenger(String name) {

        this.name = name;
        this.coolNewUniform = "Space age material";
    }

    //behavior - methods
    //getters
    public String getName() {

        return name;
    }

    public String getUniform() {
        return coolNewUniform;
    }

    //setters
    public void setName(String name) {

        this.name = name;
    }

    public void setUniform(String uniform) {
        this.coolNewUniform = uniform;
    }
}
