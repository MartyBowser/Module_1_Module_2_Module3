package com.techelevator.reservations.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(path="/hello", method=RequestMethod.GET)
    public String hello(){

        return "Hello World!";
    }

    @RequestMapping(path="/hammertime", method=RequestMethod.GET)
    public String hammerTime(){
        return "Can't touch this!";
    }
}
