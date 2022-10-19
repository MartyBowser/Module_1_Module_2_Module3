package com.techelevator.projects.dao;

import java.sql.SQLWarning;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;

public class JdbcDepartmentDao implements DepartmentDao {
	
	private final JdbcTemplate jdbcTemplate;

	public JdbcDepartmentDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Department getDepartment(int id) {
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
		Department department = null;
		String sql = "SELECT department_id, name   " +
				"FROM department " +
				"WHERE department_id = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql,id);
		while(results.next()){
			department = mapRowToDepartment(results);
		}
		return department;
		}

	private Department mapRowToDepartment(SqlRowSet results) {
	Department department = new Department();
	int departmentID = results.getInt("department_id");
	department.setId(departmentID);
	String departmentName = results.getString("name");
	department.setName(departmentName);
	return department;
	}


	@Override
	public List<Department> getAllDepartments() {
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
		ArrayList<Department> deathNote = new ArrayList<>();
		String sql = "SELECT department_id, name FROM Department;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			Department department = mapRowToDepartment(results);
			deathNote.add(department);
		}
		return deathNote;
	}




	@Override
	public void updateDepartment(Department updatedDepartment) {

	}

}
