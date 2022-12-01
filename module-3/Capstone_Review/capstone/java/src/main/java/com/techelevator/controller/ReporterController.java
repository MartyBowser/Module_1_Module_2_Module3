package com.techelevator.controller;

import com.techelevator.dao.ReporterDao;
import com.techelevator.model.Reporter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReporterController {

    ReporterDao dao = null;

    public ReporterController(ReporterDao dao) {

        this.dao = dao;
    }

    @RequestMapping(path="/reporters", method = RequestMethod.GET)
    public List<Reporter> getReporters() {

        return dao.getReporters();

    }

    @RequestMapping(path="/reporters", method = RequestMethod.POST)
    public Reporter createReporter(@RequestBody Reporter reporter){
        return dao.createReporter(reporter);
    }
}

