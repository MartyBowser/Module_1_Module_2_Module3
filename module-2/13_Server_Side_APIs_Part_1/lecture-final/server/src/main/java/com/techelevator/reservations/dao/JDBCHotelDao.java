package com.techelevator.reservations.dao;

import com.techelevator.reservations.model.Hotel;

import java.util.List;

public class JDBCHotelDao implements HotelDao{
    @Override
    public List<Hotel> list() {
        return null;
    }

    @Override
    public void create(Hotel hotel) {

    }

    @Override
    public Hotel get(int id) {
        return null;
    }

    // I'll create a JDBCTemplate in here and actually
    //start writing SQL


}
