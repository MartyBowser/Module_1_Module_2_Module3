package com.techelevator;

public class House {

    //state
    private String banner;

    //constructors
    public House (String banner) {
        this.banner = banner;
    }

    //behavior - methods
    // getters
    public String getBanner() {
        return banner;
    }

    // setters
    public void setBanner(String banner) {
        this.banner = banner;
    }
}
