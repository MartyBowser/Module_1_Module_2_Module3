package com.techelevator.projects.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;

public class JdbcProjectDao implements ProjectDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcProjectDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Project getProject(int projectId) {

		Project project = null;
		String sql = "SELECT project_id, name, from_date, to_date " +
				"FROM project " +
				"WHERE project_id = ?;";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);
		while (results.next()) {
			project = mapRowToProject(results);

		}
		return project;
	}

	private Project mapRowToProject(SqlRowSet results) {
		Project project = new Project();

		int projectId = results.getInt("project_id");
		project.setId(projectId);
		String Name = results.getString("name");
		project.setName(Name);

		if (results.getDate("from_date") != null) {
			LocalDate fromDate = results.getDate("from_date").toLocalDate();
			project.setFromDate(fromDate);
		}
		if (results.getDate("to_date") != null) {
			LocalDate toDate = results.getDate("to_date").toLocalDate();
			project.setToDate(toDate);
		}

		return project;
		}

	@Override
	public List<Project> getAllProjects() {

	List<Project> projects = new ArrayList<>();
	String sql = "select project_id, name, from_date, to_date " +
	"from project;";

	SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

	while (results.next()) {
	Project project = mapRowToProject(results);
	projects.add(project);
	}
	return projects;


	}

	@Override
	public Project createProject(Project newProject) {
	String sql = "INSERT INTO project (project_id, name, from_date, to_date) " +
	"VALUES (?, ?, ?, ?) RETURNING project_id;";

		Integer newId = jdbcTemplate.queryForObject(sql, Integer.class,
		newProject.getId(), newProject.getName(), newProject.getFromDate(), newProject.getToDate());

		return getProject(newId);
	}

	@Override
	public void deleteProject(int projectId) {

	String sql = "DELETE FROM project_employee Where project_id = ?;";
	jdbcTemplate.update(sql, projectId);

	sql = "DELETE FROM PROJECT WHERE project_id = ?;";
		jdbcTemplate.update(sql, projectId);


	}
	

}
