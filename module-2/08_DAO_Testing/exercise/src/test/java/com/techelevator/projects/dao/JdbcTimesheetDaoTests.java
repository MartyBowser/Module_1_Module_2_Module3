package com.techelevator.projects.dao;

import com.techelevator.projects.model.Timesheet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.verification.Times;

import javax.sql.DataSource;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

public class JdbcTimesheetDaoTests extends BaseDaoTests {

    private static final Timesheet TIMESHEET_1 = new Timesheet(1, 1, 1,
            LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
    private static final Timesheet TIMESHEET_2 = new Timesheet(2, 1, 1,
            LocalDate.parse("2021-01-02"), 1.5, true, "Timesheet 2");
    private static final Timesheet TIMESHEET_3 = new Timesheet(3, 2, 1,
            LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
    private static final Timesheet TIMESHEET_4 = new Timesheet(4, 2, 2,
            LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");
    
    private JdbcTimesheetDao dao;
    private Timesheet testTimesheet;

    @Before
    public void setup() {
        dao = new JdbcTimesheetDao(dataSource);
    }


    @Test
    public void getTimesheet_returns_correct_timesheet_for_id() {
        Timesheet result = dao.getTimesheet(1);
        assertTimesheetsMatch(TIMESHEET_1, result);
    }

    @Test
    public void getTimesheet_returns_null_when_id_not_found() {
      Timesheet result = dao.getTimesheet(111422);
      Assert.assertEquals(null, result);

    }

    @Test
    public void getTimesheetsByEmployeeId_returns_list_of_all_timesheets_for_employee() {
        List<Timesheet> results = dao.getTimesheetsByEmployeeId(1);

        //Assert
        Assert.assertEquals(2, results.size());
    }

    @Test
    public void getTimesheetsByProjectId_returns_list_of_all_timesheets_for_project() {
        List<Timesheet> results = dao.getTimesheetsByProjectId(1);

        //Assert
        Assert.assertEquals(3, results.size());
    }

    @Test
    public void createTimesheet_returns_timesheet_with_id_and_expected_values() {
        Timesheet testTimesheet = new Timesheet(0,2,2,
                LocalDate.parse("2021-02-01"),2.0, false, "Timesheet 5");

        Timesheet result = dao.createTimesheet(testTimesheet);
        Assert.assertTrue(result.getTimesheetId() > 0);
        testTimesheet.setTimesheetId(result.getTimesheetId());
        assertTimesheetsMatch(testTimesheet, result);
    }

    @Test
    public void created_timesheet_has_expected_values_when_retrieved() {
        Timesheet testTimesheet = new Timesheet(4, 2, 2,
                LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");

        //Act
        Timesheet result = dao.createTimesheet(testTimesheet);
        Timesheet retrievedTimesheet = dao.getTimesheet(result.getTimesheetId());

        //Assert
        assertTimesheetsMatch(result, retrievedTimesheet);
    }

    @Test
    public void updated_timesheet_has_expected_values_when_retrieved() {
        Timesheet timesheetToUpdate = dao.getTimesheet(4);

        timesheetToUpdate.setEmployeeId(1);
        timesheetToUpdate.setProjectId(2);
        timesheetToUpdate.setDateWorked(LocalDate.parse("2022-02-01"));
        timesheetToUpdate.setHoursWorked(8);
        timesheetToUpdate.setBillable(true);
        timesheetToUpdate.setDescription("Timesheet 5");

        //Act
        dao.updateTimesheet(timesheetToUpdate);
        Timesheet retrievedTimeSheet = dao.getTimesheet(4);

        //Assert
        assertTimesheetsMatch(timesheetToUpdate, retrievedTimeSheet);
    }

    @Test
    public void deleted_timesheet_cant_be_retrieved() {

        dao.deleteTimesheet(1);

        //Assert
        Timesheet retrievedTimesheet = dao.getTimesheet(1);
        Assert.assertEquals(null, retrievedTimesheet);

        List<Timesheet> results = dao.getTimesheetsByEmployeeId(1);
        Assert.assertEquals(1, results.size());
        assertTimesheetsMatch(TIMESHEET_2, results.get(0));
    }

    @Test
    public void getBillableHours_returns_correct_total() {

       //Arrange
       double billableHours = dao.getBillableHours(2,2);

        //Act

        //Assert

       Assert.assertEquals(0, billableHours, 2);
    }

    private void assertTimesheetsMatch(Timesheet expected, Timesheet actual) {
        Assert.assertEquals(expected.getTimesheetId(), actual.getTimesheetId());
        Assert.assertEquals(expected.getEmployeeId(), actual.getEmployeeId());
        Assert.assertEquals(expected.getProjectId(), actual.getProjectId());
        Assert.assertEquals(expected.getDateWorked(), actual.getDateWorked());
        Assert.assertEquals(expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        Assert.assertEquals(expected.isBillable(), actual.isBillable());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
    }

}
