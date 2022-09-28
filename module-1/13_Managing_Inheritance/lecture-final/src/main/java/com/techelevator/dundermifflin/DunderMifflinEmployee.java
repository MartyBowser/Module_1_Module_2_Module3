package com.techelevator.dundermifflin;

import com.techelevator.farm.Singable;

// if a class is abstract that means you cannot
// instantiate an individual instance of this class
// you must have a class that inherits from it, and then
// you can instantiate the child class.
public abstract class DunderMifflinEmployee implements Singable {

    private String name;
    private String role;
    private int salary;
    private String sound;

    public DunderMifflinEmployee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getSound() {return sound; }

    public String getRole() {
        return role;
    }

    public int getSalary() {
        return salary;
    }

    // final on a method means that this method
    // cannot be overwritten - all children must
    // use this implementation
    public final int giveRaise(int percent) {
        return (int)(salary + (salary * (percent / 100.00)));
    }


    // this is similar to an interface, where we are
    // making a laundry list of methods that we declare
    // but do not implement. Any class that inherits
    // from us will have to implement it
    public abstract void doJob() ;
}
