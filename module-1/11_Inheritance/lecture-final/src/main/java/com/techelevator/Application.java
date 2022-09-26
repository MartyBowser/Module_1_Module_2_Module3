package com.techelevator;

import com.techelevator.avengers.Hulk;
import com.techelevator.avengers.SheHulk;
import com.techelevator.avengers.Thor;

public class Application {

    public static void main(String[] args) {

        /*
        Thor t = new Thor();
        Hulk hulk = new Hulk("Hulk");
        SheHulk sheHulk = new SheHulk();
        Hulk redHulk = new Hulk("Red Hulk");

        sheHulk.practiceLaw();
        sheHulk.smash();

        String originalName = t.getName();
        t.setName("Larry");
        String newName = t.getName();


        t.fly();
        hulk.smash();
*/
        /*
        House starkHouse = new House("Dire Wolf");
        House lannisterHouse = new House("Lion");
        House targaryenHouse = new House("Dragon");

        String banner = lannisterHouse.getBanner();
        System.out.println(banner);
        */


        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");

        generalAuction.placeBid(new Bid("Josh", 1));
        generalAuction.placeBid(new Bid("Fonz", 23));
        generalAuction.placeBid(new Bid("Rick Astley", 13));
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids

        System.out.println("Starting a reserve auction");
        System.out.println("-----------------");

        ReserveAuction ra = new ReserveAuction("Signed Tech Elevator t-shirt", 20);
        ra.placeBid(new Bid("Craig", 10));
        ra.placeBid(new Bid("Evie", 21));
        ra.placeBid(new Bid("Jason", 50));
        ra.placeBid(new Bid("Craig", 25));


    }
}
