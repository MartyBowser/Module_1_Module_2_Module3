package com.techelevator.farm;

import java.math.BigDecimal;

public class Tractor implements Singable {

    private String name;
    private String sound;
    private BigDecimal price;

    public Tractor() {
        name = "Tractor";
        sound = "vroom!";
    }

    public Tractor(BigDecimal price){
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getSound() {
        return sound;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
