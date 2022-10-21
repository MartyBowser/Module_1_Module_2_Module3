package com.techelevator.dao;

import com.techelevator.model.User;

import java.util.Optional;

public interface UserDao {

    Optional<User> findByUsername(String username);

}
