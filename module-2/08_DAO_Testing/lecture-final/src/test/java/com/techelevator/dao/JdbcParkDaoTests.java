package com.techelevator.dao;

import com.techelevator.model.Park;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class JdbcParkDaoTests extends BaseDaoTests {

    private static final Park PARK_1 =
            new Park(1, "Park 1", LocalDate.parse("1800-01-02"), 100, true);
    private static final Park PARK_2 =
            new Park(2, "Park 2", LocalDate.parse("1900-12-31"), 200, false);
    private static final Park PARK_3 =
            new Park(3, "Park 3", LocalDate.parse("2000-06-15"), 300, false);

    private JdbcParkDao dao;



    @Test
    public void getPark_returns_correct_park_for_id() {

        //Arrange
        // we'll use the constants at the top

        //Act - calling the method we want to test and storing it in a result
        Park result = dao.getPark(1);

        //Assert - make sure that the result from Act is what we expect
        assertParksMatch(PARK_1, result);

    }

    @Test
    public void getPark_returns_null_when_id_not_found() {

        //Act
        Park result = dao.getPark(999);

        //Assert
        //Assert.assertNull(result);
        Assert.assertEquals(null, result);


    }

    @Test
    public void getParksByState_returns_all_parks_for_state() {

        //Act
        List<Park> results = dao.getParksByState("AA");

        //Assert
        Assert.assertEquals(2, results.size());
        assertParksMatch(PARK_1, results.get(0));
        assertParksMatch(PARK_3, results.get(1));
    }

    @Test
    public void getParksByState_returns_empty_list_for_abbreviation_not_in_db() {

        //Act
        List<Park> results = dao.getParksByState("ZZ");

        //Assert
        Assert.assertEquals(0, results.size());
    }

    @Test
    public void createPark_returns_park_with_id_and_expected_values() {
        // Arrange
        Park testPark = new Park(0, "Test Park", LocalDate.parse("2022-10-20"), 1, true);

        //Act
        Park result = dao.createPark(testPark);

        //Assert
        Assert.assertTrue(result.getParkId() > 0);
        testPark.setParkId(result.getParkId());
        assertParksMatch(testPark, result);


    }

    @Test
    public void created_park_has_expected_values_when_retrieved() {

        // Arrange
        Park testPark = new Park(0, "Test Park", LocalDate.parse("2022-10-20"), 1, true);

        //Act
        Park createdPark = dao.createPark(testPark);
        Park retrievedPark = dao.getPark(createdPark.getParkId());

        //Assert
        assertParksMatch(createdPark, retrievedPark);
    }

    @Test
    public void updated_park_has_expected_values_when_retrieved() {

        //Arrange
        Park parkToUpdate = dao.getPark(1);

        parkToUpdate.setHasCamping(false);
        parkToUpdate.setDateEstablished(LocalDate.parse("2020-10-20"));
        parkToUpdate.setParkName("Park Infinity");
        parkToUpdate.setArea(999);

        //Act
        dao.updatePark(parkToUpdate);
        Park retrievedPark = dao.getPark(1);

        //Assert
        assertParksMatch(parkToUpdate, retrievedPark);
    }

    @Test
    public void deleted_park_cant_be_retrieved() {

        //Act
        dao.deletePark(1);

        //Assert
        Park park = dao.getPark(1);
        Assert.assertEquals(null, park);

        List<Park> parksByState = dao.getParksByState("AA");
        Assert.assertEquals(1, parksByState.size());
        assertParksMatch(PARK_3, parksByState.get(0));

    }

    @Test
    public void park_added_to_state_is_in_list_of_parks_by_state() {

        //Act
        dao.addParkToState(2, "AA");

        //Assert
        List<Park> parks = dao.getParksByState("AA");
        Assert.assertEquals(3, parks.size());
        assertParksMatch(PARK_1, parks.get(0));
        assertParksMatch(PARK_2, parks.get(1));
        assertParksMatch(PARK_3, parks.get(2));



    }

    @Test
    public void park_removed_from_state_is_not_in_list_of_parks_by_state() {

        //Act
        dao.removeParkFromState(2, "BB");

        //Assert
        List<Park> parks = dao.getParksByState("BB");
        Assert.assertEquals(0, parks.size());
    }

    private void assertParksMatch(Park expected, Park actual) {
        Assert.assertEquals(expected.getParkId(), actual.getParkId());
        Assert.assertEquals(expected.getParkName(), actual.getParkName());
        Assert.assertEquals(expected.getDateEstablished(), actual.getDateEstablished());
        Assert.assertEquals(expected.getArea(), actual.getArea(), 0.1);
        Assert.assertEquals(expected.getHasCamping(), actual.getHasCamping());
    }

    @Before
    public void setup() {

        dao = new JdbcParkDao(dataSource);
    }

}
