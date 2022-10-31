package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Reporter;
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

            Reporter r = new Reporter();

            int reporterId = results.getInt("reporter_id");
            r.setReporterId(reporterId);

            String reporterName = results.getString("reporter_name");
            r.setReporterName (reporterName);

            String location = results.getString("location");
            r.setLocation(location);

            //TODO map the rest of the fields

            reporters.add(r);

        }

        //Step 5
        return reporters;
    }
}
