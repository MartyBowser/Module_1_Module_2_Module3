package com.techelevator.auctions.services;

import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.techelevator.auctions.model.Auction;

public class AuctionService {

    public static String API_BASE_URL = "http://localhost:3000/auctions/";
    private RestTemplate restTemplate = new RestTemplate();

    private HttpEntity<Auction> createEntity(Auction auction) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Auction> entity = new HttpEntity<>(auction, headers);
        return entity;
    }

    public Auction add(Auction newAuction) {
        // place code here
        HttpEntity<Auction> entity = createEntity(newAuction);
        Auction result = null;


        try {

            String url = API_BASE_URL ;
            result = restTemplate.postForObject(url, entity, Auction.class );


        } catch (RestClientResponseException e) { // this is when the server actually communicates an exception back to us
            // handles exceptions thrown by rest template and contains status codes
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) { // we weren't able to find the server at all
            // i/o error, ex: the server isn't running
            BasicLogger.log(e.getMessage());
        }

        return result;
    }

    public boolean update(Auction updatedAuction) {
        // place code here
        HttpEntity<Auction> entity = createEntity(updatedAuction);
        boolean result = false;

        try {

            String url = API_BASE_URL  + updatedAuction.getId();
            restTemplate.put(url, entity, Auction.class );
            result = true;

        } catch (RestClientResponseException e) { // this is when the server actually communicates an exception back to us
            // handles exceptions thrown by rest template and contains status codes
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) { // we weren't able to find the server at all
            // i/o error, ex: the server isn't running
            BasicLogger.log(e.getMessage());
        }

        return result;
    }

    public boolean delete(int auctionId) {
        // place code here
        boolean result = false;

        try {

            String url = API_BASE_URL + auctionId;
            restTemplate.delete(url);
            result = true;

        } catch (RestClientResponseException e) { // this is when the server actually communicates an exception back to us
            // handles exceptions thrown by rest template and contains status codes
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) { // we weren't able to find the server at all
            // i/o error, ex: the server isn't running
            BasicLogger.log(e.getMessage());
        }

        return result;
    }

    public Auction[] getAllAuctions() {
        Auction[] auctions = null;
        try {
            auctions = restTemplate.getForObject(API_BASE_URL, Auction[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auctions;
    }

    public Auction getAuction(int id) {
        Auction auction = null;
        try {
            auction = restTemplate.getForObject(API_BASE_URL + id, Auction.class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auction;
    }

    public Auction[] getAuctionsMatchingTitle(String title) {
        Auction[] auctions = null;
        try {
            auctions = restTemplate.getForObject(API_BASE_URL + "?title_like=" + title, Auction[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auctions;
    }

    public Auction[] getAuctionsAtOrBelowPrice(double price) {
        Auction[] auctions = null;
        try {
            auctions = restTemplate.getForObject(API_BASE_URL + "?currentBid_lte=" + price, Auction[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auctions;
    }

    private HttpEntity<Auction> makeEntity(Auction auction) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(auction, headers);
    }

}
