package com.techelevator.dao;

import com.techelevator.model.Reporter;

import java.util.List;

public interface ReporterDao {

    List<Reporter> getReporters();
    Reporter getReporter(int id);
    Reporter createReporter(Reporter reporter);
}