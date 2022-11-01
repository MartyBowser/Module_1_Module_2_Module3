package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.ReportDao;
import com.techelevator.tenmo.dao.ReporterDao;
import com.techelevator.tenmo.model.Report;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
