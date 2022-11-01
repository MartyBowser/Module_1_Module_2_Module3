package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Reporter;

import java.util.List;

public interface ReporterDao {

    List<Reporter> getReporters();
    Reporter getReporter(int id);
    Reporter createReporter(Reporter reporter);
}
