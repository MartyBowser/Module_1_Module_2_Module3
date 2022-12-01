package com.techelevator.controller;

import com.techelevator.dao.ReportDao;
import com.techelevator.model.Report;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ReportController {

    private ReportDao dao = null;

    public ReportController(ReportDao dao) {

        this.dao = dao;
    }

    @RequestMapping(path = "/reports", method= RequestMethod.GET)
    public List<Report> getReports(){
        return dao.getReports();
    }

    @RequestMapping(path="/reports", method=RequestMethod.POST)
    public void createReport(@RequestBody Report report) {
        dao.createReport(report);
    }
}
