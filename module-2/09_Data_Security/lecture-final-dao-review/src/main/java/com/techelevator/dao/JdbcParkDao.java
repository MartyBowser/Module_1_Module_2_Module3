package com.techelevator.dao;

import com.techelevator.model.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcParkDao implements ParkDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcParkDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // Step 1 - Declare a variable for what you want to return
    // Step 2 - Write out the SQL and store it to a string variable
    // Step 3 - Send the sql to the database and store results
    //        a) If you want a result set (spreadsheet) to come back,
    /*           ie you're expecting multiple columns, use
                  jdbcTemplate.queryForRowSet
              b) If you want only a single value back from the query
                 then you can use jdbcTemplate.queryForObject
              c) If you are running an update or delete, use the
                    jdbcTemplate.update
        Step 4 - if we have results from the database map them to
                the results we want to return that we declared in
                Step 1
        Step 5 - Return the results if there are any
     */

    @Override
    public Park getPark(int parkId) {

        //Step 1 - declare the variable we want to return
        Park park = null;

        //Step 2 - write out our sql and store it in a string
        String sql = "SELECT park_id, park_name, date_established, area, has_camping " +
                "FROM park " +
                "WHERE park_id = ?;";

        //Step 3 - send the sql to the database and store results if necessary
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parkId);

        //Step 4 - map the results to the variable we declared in step 1
        while(results.next()){
            park = mapRowToPark(results);

        }

        //Step 5 - return the result
        return park;

    }

    public Park getPark(String parkName) {

        //Step 1 - declare the variable we want to return
        Park park = null;

        //Step 2 - write out our sql and store it in a string
        String sql = "SELECT park_id, park_name, date_established, area, has_camping " +
                "FROM park " +
                "WHERE park_name ILIKE ? ;";

        //Step 3 - send the sql to the database and store results if necessary
        //String searchTerm = parkName + "%"; // only searches where park name BEGINS with parkName
        //String searchTerm = "%" + parkName ; // only searches where park name ENDS with parkName
        String searchTerm = "%" + parkName + "%"; // only searches where park name CONTAINS parkName

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, searchTerm);

        //Step 4 - map the results to the variable we declared in step 1
        while(results.next()){
            park = mapRowToPark(results);

        }

        //Step 5 - return the result
        return park;

    }

    @Override
    public List<Park> getParksByState(String stateAbbreviation) {
        //Step 1 - declare the return type
        List<Park> parksList = new ArrayList<>();

        // Step 2 - write out the sql and store it in a string
        String sql = "SELECT park.park_id, park_name, date_established, area, has_camping " +
                "FROM park " +
                "JOIN park_state ON park.park_id = park_state.park_id " +
                "WHERE park_state.state_abbreviation = ?;";

        // Step 3 - send sql to the database and store the result
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, stateAbbreviation);

        // Step 4 - convert the results to the variable in step 1
        while(results.next()){
            Park park = mapRowToPark(results);
            parksList.add(park);
        }

        // Step 5 - return the result
        return parksList;
    }

    @Override
    public Park createPark(Park park) {
        // Step 1 create the variable we return
        // Already provided as a parameter

        // Step 2 - create the sql
        String sql = "INSERT INTO park(park_name, date_established, area, has_camping) " +
                "VALUES(?,?,?,?) RETURNING park_id;";

        // Step 3 - send it to the database
        int newId = jdbcTemplate.queryForObject(sql, Integer.class,
                park.getParkName(), park.getDateEstablished(), park.getArea(),
                park.getHasCamping());

        // Step 4 - convert to the variable we declared in step 1

        // Step 5 - return our park
        return getPark(newId);

    }

    @Override
    public void updatePark(Park park) {

        // Step 1 - declare the variable you want to return
        // skipping, not returning anything

        // Step2 - write out the sql
        String sql = "UPDATE park " +
                "SET park_name = ?, date_established = ?, area = ?, has_camping=? " +
                "WHERE park_id = ?;";

        // Step 3 - send to the database
        jdbcTemplate.update(sql, park.getParkName(),
                park.getDateEstablished(), park.getArea(),
                park.getHasCamping(), park.getParkId());

        // Step 4 - we have nothing to convert

        // Step 5 - we have nothing to return
    }

    @Override
    public void deletePark(int parkId) {

        // Step 1 - declare a variable for us to return
        // we can skip this, we have no return for this method (void)

        // Step 2 - write out our SQL
        String sqlDeleteFromParkState = "DELETE " +
                                        "FROM park_state " +
                                        "WHERE park_id = ?;";
        String sqlDeleteFromPark = "DELETE " +
                                    "FROM park " +
                                    "WHERE park_id = ?;";

        // Step 3 - send the sql to the database
        jdbcTemplate.update(sqlDeleteFromParkState, parkId);
        jdbcTemplate.update(sqlDeleteFromPark, parkId);

        //OR we can write it like this:
        //jdbcTemplate.update(sqlDeleteFromParkState + sqlDeleteFromPark, parkId, parkId );

        // Step 4 convert to variable in step 1
        // we can skip this

        // Step 5 - return the result
        // we can skip this too
    }

    @Override
    public void addParkToState(int parkId, String stateAbbreviation) {

        // Step 1 - I can skip, there's no return type

        // Step 2 - write out the sql
        String sql = "INSERT INTO park_state(park_id, state_abbreviation) " +
                        "VALUES(?, ?) ;";

        // Step 3 - send the sql to the database
        jdbcTemplate.update(sql, parkId, stateAbbreviation);
    }

    @Override
    public void removeParkFromState(int parkId, String stateAbbreviation) {
         // Step 1 - declare a variable for us to return
        // we can skip this, we have no return for this method (void)

        // Step 2 - write out our SQL
        String sqlDeleteFromParkState = "DELETE " +
                "FROM park_state " +
                "WHERE park_id = ? AND state_abbreviation = ?;";

        //Step 3 - send the sql to our database
        jdbcTemplate.update(sqlDeleteFromParkState, parkId, stateAbbreviation);
    }

    private Park mapRowToPark(SqlRowSet results) {
        Park park = new Park();

        int parkIdFromDb = results.getInt("park_id");
        park.setParkId(parkIdFromDb);

        String parkName = results.getString("park_name");
        park.setParkName(parkName);

        // If the date established column allows for null values, we should check that
        // it's not null before calling .toLocalDate() on it
        if(results.getDate("date_established") != null) {
            LocalDate establishedDate = results.getDate("date_established").toLocalDate();
            park.setDateEstablished(establishedDate);
        }

        double area = results.getDouble("area");
        park.setArea(area);

        boolean hasCamping = results.getBoolean("has_camping");
        park.setHasCamping(hasCamping);

        return park;
    }
}
