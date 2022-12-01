package com.techelevator.dao;

import com.techelevator.model.Reporter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcReporterDao implements ReporterDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcReporterDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Reporter> getReporters(){
        // Step 1 - declare a return type
        List<Reporter> reporters = new ArrayList<>();

        // Step 2 - write our sql
        String sql = "SELECT reporter_id, reporter_name, location, age, email_address,  " +
                "receive_notifications, number_of_stories, gender " +
                "FROM reporter;";

        //Step 3 - send sql to the database
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        //Step 4 - map from results to java objects
        while(results.next()){

            Reporter r = mapReporter(results);
            reporters.add(r);

        }

        //Step 5
        return reporters;
    }

    public Reporter getReporter(int id) {
        //Step 1 - declare the return type
        Reporter reporter = null;

        //Step 2 - write my sql
        String sql = "SELECT reporter_id, reporter_name, location, age, email_address,  " +
                "receive_notifications, number_of_stories, gender " +
                "FROM reporter WHERE reporter_id = ?;";

        //Step 3 - send to database
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        //Step 4 - convert to return type
        if(results.next()){
            reporter = mapReporter(results);
        }

        //Step 5 - return
        return reporter;
    }

    public Reporter createReporter(Reporter reporter){

        //Step 1 - declare the return type


        //Step 2 - create the sql
        String sql = "INSERT INTO reporter(reporter_name, location, age ) " +
                "VALUES(?, ?, ?)  RETURNING reporter_id;";

        //Step 3 - send sql to database
        int reporterId = jdbcTemplate.queryForObject(sql, Integer.class, reporter.getReporterName(), reporter.getLocation(),
                reporter.getAge());

        // Step 4 - no convert

        // Step 5
        return getReporter(reporterId);

    }

    private Reporter mapReporter(SqlRowSet results) {
        Reporter r = new Reporter();

        int reporterId = results.getInt("reporter_id");
        r.setReporterId(reporterId);

        String reporterName = results.getString("reporter_name");
        r.setReporterName (reporterName);

        String location = results.getString("location");
        r.setLocation(location);

        int age = results.getInt("age");
        r.setAge(age);

        String email = results.getString("email_address");
        r.setEmailAddress(email);

        Boolean receiveNotifications = results.getBoolean("receive_notifications");
        r.setRecieveNotifications(receiveNotifications);

        int numStories = results.getInt("number_of_stories");
        r.setNumberOfStories(numStories);

        String gender = results.getString("gender");
        r.setGender(gender);

        return r;
    }
}

