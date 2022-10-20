package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcEmployeeDao implements EmployeeDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcEmployeeDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Employee> getAllEmployees() {
		//Step1 - declare return type
		List<Employee> yawllHiring = new ArrayList<>();

		//Step2 write out the sql and store it in a string
		String sql = "SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date " +
				"FROM employee ";

		//Step3 send sql to the database and store the result
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

		//Step4 convert the results to the variable in step1
		while (results.next()) {
			Employee employee = mapRowToEmployees(results);
			yawllHiring.add(employee);
		}
		//Step5
		return yawllHiring;


	}

	private Employee mapRowToEmployees(SqlRowSet results) {


		Employee employee = new Employee();
		employee.setId(results.getInt("employee_id"));
		employee.setLastName(results.getString("last_name"));
		employee.setFirstName(results.getString("first_name"));
		employee.setBirthDate(results.getDate("birth_date").toLocalDate());
		employee.setHireDate(results.getDate("hire_date").toLocalDate());
		employee.setDepartmentId(results.getInt("department_id"));

		return employee;
	}




	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT employee.employee_id, department_id, first_name, last_name, birth_date, hire_date " +
				"from employee " +
				"where first_name ILIKE ? and last_name ILIKE ?;";

		String searchIt = "%" + firstNameSearch + "%";
		String searchIts = "%" + lastNameSearch + "%";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, searchIt, searchIts);
		while(results.next()) {
			Employee employee = mapRowToEmployees(results);
			employees.add(employee);

		}
		return employees;

		}


	@Override
	public List<Employee> getEmployeesByProjectId(int projectId) {

		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT employee.employee_id, department_id, first_name, last_name, birth_date, hire_date " +
				"from employee " +
				"JOIN project_employee ON employee.employee_id = project_employee.employee_id " +
				"WHERE project_employee.project_id = ?;";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);

		while (results.next()) {
			Employee employee = mapRowToEmployees(results);
			employees.add(employee);
		}

			return employees;
	}

	@Override
	public void addEmployeeToProject(int projectId, int employeeId) {

		String sql = "INSERT INTO project_employee(project_id, employee_id) " +
		"VALUES(?, ?) ;";

		jdbcTemplate.update(sql, projectId, employeeId);

	}

	@Override
	public void removeEmployeeFromProject(int projectId, int employeeId) {

		String sql = "DELETE FROM project_employee WHERE project_id = ? and employee_id = ?;";

		jdbcTemplate.update(sql, projectId, employeeId);

	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {


		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT employee.employee_id, department_id, first_name, last_name, birth_date, hire_date " +
				"FROM employee " +
				"LEFT JOIN project_employee ON employee.employee_id = project_employee.employee_id " +
				"WHERE project_employee.project_id IS NULL;";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

		while (results.next()) {
			Employee employee = mapRowToEmployees(results);
			employees.add(employee);
		}

		return employees;
	}

}
