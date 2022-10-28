package com.techelevator.auctions.dao;

import com.techelevator.auctions.model.User;

import java.util.Optional;

public interface UserDao {

    Optional<User> findByUsername(String username);

}
