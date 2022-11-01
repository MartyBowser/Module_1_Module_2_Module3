package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Report;

import java.util.List;

public interface ReportDao {

    List<Report> getReports();
    void createReport(Report report);
}
