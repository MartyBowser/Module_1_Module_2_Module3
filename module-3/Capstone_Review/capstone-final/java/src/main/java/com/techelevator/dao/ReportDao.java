package com.techelevator.dao;

import com.techelevator.model.Report;

import java.util.List;

public interface ReportDao {

    List<Report> getReports();
    void createReport(Report report);
}

