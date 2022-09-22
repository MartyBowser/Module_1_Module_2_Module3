package com.techelevator.example;

import java.util.HashMap;
import java.util.Map;

public class Scratch {

    public static void main(String[] args) {

        Map<String, Integer> peterPaul = new HashMap<>();
        peterPaul.put("Peter", 1100);
        peterPaul.put("Paul", 9900);

        // if paul has more than 5000 and peter has less than 2000
        // then take half of paul and give it to peter

        int peterAmount = peterPaul.get("Peter");
        int paulAmount = peterPaul.get("Paul");

        boolean paulMoreThan5000 = paulAmount > 5000;

        if(paulAmount > 5000 && peterAmount < 2000) {

            int halfOfPaul = paulAmount / 2;
            int newPeterAmount = peterAmount + halfOfPaul;
            int newPaulAmount = paulAmount - halfOfPaul;

            peterPaul.put("Peter", newPeterAmount);
            peterPaul.put("Paul", newPaulAmount);

        }

        //return peterPaul;

        // If you are unsure of the contents of your map
        // and want to search through all of them

        // if you're just searching for specific key
        boolean hasKey = peterPaul.containsKey("Peter");

        // we can search by keys
        for(String key : peterPaul.keySet()) {
            System.out.println(key.toLowerCase());
        }

        for(Map.Entry<String, Integer> entry : peterPaul.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }
}
