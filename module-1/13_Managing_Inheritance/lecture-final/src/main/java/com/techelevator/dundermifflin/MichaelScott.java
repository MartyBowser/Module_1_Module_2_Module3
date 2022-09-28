package com.techelevator.dundermifflin;

// When final is on a class, this class cannot
// be extended. There will be no children
public final class MichaelScott extends DunderMifflinEmployee{

    public MichaelScott() {
        super("Michael Scott", "Regional Manager");
    }

    @Override
    public void doJob() {
        System.out.println("Best Boss Ever");
    }
}
