package com.techelevator.mariokart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Scratch {

    public static void main(String[] args) {




        List<Raceable> racers = new ArrayList<>();
        racers.add(new Mario());
        racers.add(new Luigi("green"));
     //   racers.add(new Luigi("yellow"));
     //   racers.add(new Luigi("red"));
        racers.add(new Wario());
        racers.add(new PrincessPeach());
        racers.add(new RedShell());

        for(int i = 0; i < 3; i++) {

            System.out.println("Lap " + (i+1) + ":");
            Collections.shuffle(racers);

            for(Raceable r : racers) {
                System.out.println(r.getName() + " - " + r.getPhrase());
            }

            System.out.println("");
            System.out.println("");

        }

        Raceable winner = racers.get(0);
        System.out.println(winner.getName() + " Wins!");
        System.out.println(winner.getPhrase());

    }
}
