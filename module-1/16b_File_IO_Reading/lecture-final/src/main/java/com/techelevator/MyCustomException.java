package com.techelevator;

public class MyCustomException extends Exception{

    // state
    private String customData = "";

    // constructors
    public MyCustomException(String customData, String message) {
        super(message);
        this.customData = customData;
    }

    //methods

    // - getters
    public String getCustomData() {
        return customData;
    }

}
