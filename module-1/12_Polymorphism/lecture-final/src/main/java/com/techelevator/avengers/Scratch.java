package com.techelevator.avengers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Scratch {

    public static void main(String[] args) {

        // Avengers assemble
        List<Avenger> avengers = new ArrayList<>();

        avengers.add(new BlackWidow());

        Avenger thor = new Thor();
        avengers.add(thor);

        avengers.add(new Hulk("Hulk"));
        avengers.add(new SheHulk());
        avengers.add(new IronMan());

        Collections.shuffle(avengers);

        for(Avenger avenger : avengers) {
            System.out.println(avenger.getName());



            if(avenger instanceof Thor) {
                Thor t = (Thor) avenger;
                t.setWorthy(true);
                System.out.println("Wait, now I'm worthy!");
                System.out.println(t.getName());
            }

            if(avenger instanceof Flyable) {
                Flyable flyer = (Flyable) avenger;
                flyer.fly();
            }

        }

        System.out.println("****************************");

        System.out.println("Thor is instanceof Thor: " + (thor instanceof Thor));
        System.out.println("Thor is instanceof Avenger: " + (thor instanceof Avenger));
        System.out.println("Thor is instanceof Object: " + (thor instanceof Object));
        System.out.println("Thor is instanceof IronMan: " + (thor instanceof IronMan));

    }
}
