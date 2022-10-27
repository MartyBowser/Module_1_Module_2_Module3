package com.techelevator.auctions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private AuctionDao dao;

    public AuctionController() {
        this.dao = dao;
    }

    @RequestMapping( method = RequestMethod.GET)
    public List<Auction> list(@RequestParam(required = false, defaultValue = "") String title_like,
                              @RequestParam(required = false, defaultValue = "0") double currentBid_lte) {

        if(!title_like.isEmpty() && currentBid_lte > 0) {
            return dao.searchByTitleAndPrice(title_like, currentBid_lte);
        }
        if(!title_like.isEmpty()) {
            return dao.searchByTitle(title_like);
        }

        if(currentBid_lte > 0){
            return dao.searchByPrice(currentBid_lte);
        }
        else {
            return dao.list();
        }

    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) {

            return dao.get(id);
        }


    @RequestMapping( path = "", method = RequestMethod.POST)
    public Auction create(@RequestBody Auction auction) {
        return dao.create(auction);
    }


}
