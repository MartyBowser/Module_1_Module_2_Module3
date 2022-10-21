package com.techelevator.dao;

import com.techelevator.model.Location;

import java.util.List;

public interface LocationDao {

    List<Location> list();

    Location get(int id);

    Location create(Location location);

    Location update(Location location, int id);

    void delete(int id);

}
