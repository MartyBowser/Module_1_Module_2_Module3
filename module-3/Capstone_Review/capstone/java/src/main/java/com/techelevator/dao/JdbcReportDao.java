package com.techelevator.dao;

import com.techelevator.model.Report;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcReportDao implements ReportDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcReportDao(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Report> getReports() {
        //Step 1 - declare object we want to return
        List<Report> reports = new ArrayList<>();

        //Step 2 - make our sql
        String sql = "SELECT report_id, location, language, number_of_eyewitnesses, report_date, report_time,  " +
                "moon_phase_id, weather, description, involved_alcohol, recurring, encounter_type_id " +
                "FROM report;";

        //Step 3 - send to the database
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        //Step 4 - mapping results to objects
        while(results.next()) {

            Report r = mapReport(results);
            reports.add(r);
        }

        return reports;
    }

    public void createReport(Report report) {

        String sql = "INSERT INTO report(location, language, number_of_eyewitnesses, report_date, report_time, " +
                " weather, description, involved_alcohol, recurring) " +
                " VALUES(?, ?, ?, ?, ?, ?,?, ?, ?) RETURNING report_id";

        int reportId = jdbcTemplate.queryForObject(sql, Integer.class, report.getLocation(), report.getLanguage(),
                report.getNumberOfEyewitnesses(), report.getReportDate(), report.getReportTime(), report.getWeather(),
                report.getDescription(), report.isInvolvedAlcohol(), report.isRecurring());

    }

    private Report mapReport(SqlRowSet results) {
        Report r = new Report();

        r.setReportId(results.getInt("report_id"));
        r.setLocation(results.getString("location"));
        r.setLanguage(results.getString("language"));
        r.setNumberOfEyewitnesses(results.getInt("number_of_eyewitnesses"));

        if(results.getDate("report_date") != null) {
            r.setReportDate(results.getDate("report_date").toLocalDate());
        }

        if(results.getTime("report_time") != null) {
            r.setReportTime(results.getTime("report_time").toLocalTime());
        }

        r.setMoonPhaseId(results.getInt("moon_phase_id"));
        r.setWeather(results.getString("weather"));
        r.setDescription(results.getString("description"));
        r.setInvolvedAlcohol(results.getBoolean("involved_alcohol"));
        r.setRecurring(results.getBoolean("recurring"));
        r.setEncounterTypeId(results.getInt("encounter_type_id"));

        return r;
    }
}

