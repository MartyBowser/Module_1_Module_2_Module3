package com.techelevator.controller;

import com.techelevator.dao.ReporterDao;
import com.techelevator.model.Reporter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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

