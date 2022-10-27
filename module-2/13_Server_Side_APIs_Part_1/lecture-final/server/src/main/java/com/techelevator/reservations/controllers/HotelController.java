package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.*;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HotelController {

    private HotelDao hotelDao;
    private ReservationDao reservationDao;

    public HotelController() {
        this.hotelDao = new MemoryHotelDao();
        this.reservationDao = new MemoryReservationDao(hotelDao);
    }

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
    public List<Hotel> list() {

        return hotelDao.list();
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
    public Hotel get(@PathVariable int id) {

        return hotelDao.get(id);
    }

    @RequestMapping(path="/reservations", method = RequestMethod.GET)
    public List<Reservation> getReservations(){
        return reservationDao.findAll();
    }

    @RequestMapping(path="/reservations/{id}", method=RequestMethod.GET)
    public Reservation getReservationById(@PathVariable int id) {
        return reservationDao.get(id);
    }

    @RequestMapping(path="/hotels/{hotelId}/reservations", method=RequestMethod.GET)
    public List<Reservation> getReservationsByHotel(@PathVariable int hotelId){
        return reservationDao.findByHotel(hotelId);
    }

    @RequestMapping(path="/reservations", method = RequestMethod.POST)
    public Reservation addReservation(@RequestBody Reservation newReservation){
        return reservationDao.create(newReservation, newReservation.getHotelID());
    }

    @RequestMapping(path="/hotels/search", method = RequestMethod.GET)
    public List<Hotel> filter(@RequestParam(defaultValue="Ohio") String state,
                              @RequestParam(required = false) String city,
                              @RequestParam int rating) {

        // If instead of saying required= false for city, I could give it a default value
        //@RequestParam(defaultValue="") String city
        // If the param in the url is named differently than the param in the method - I can specify that with the value
        //@RequestParam(value="city_to_search") String city
        // And you can combine these if you want
        //@RequestParam(value="city_to_search", defaultValue="") String city

        List<Hotel> hotels = new ArrayList<>();

        for(Hotel hotel : hotelDao.list()){

            if(hotel.getAddress().getState().equals(state) &&
               hotel.getAddress().getCity().equals(city)) {

                hotels.add(hotel);

            } else if(hotel.getAddress().getState().equals(state) &&
                    city == null) {

                hotels.add(hotel);

            }

        }

        return hotels;
    }



}
