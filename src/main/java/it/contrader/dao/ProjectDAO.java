package it.contrader.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Project;

public class ProjectDAO implements DAO<Project> {

	private final String QUERY_ALL = "SELECT * FROM project";
	private final String QUERY_CREATE = "INSERT INTO project (userid, projectname) VALUES (?,?)";
	private final String QUERY_READ = "SELECT * FROM project WHERE projectid=?";
	private final String QUERY_UPDATE = "UPDATE project SET userid=?, projectname=? WHERE projectid=?";
	private final String QUERY_DELETE = "DELETE FROM project WHERE projectid=?";

	public ProjectDAO() {

	}

	public List<Project> getAll() {
		List<Project> projectList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Project project;
			while (resultSet.next()) {
				int projectid = resultSet.getInt("projectid");
				int userid = resultSet.getInt("userid");
				String projectname = resultSet.getString("projectname");

				project = new Project(userid, projectname);
				project.setProjectid(projectid);
				projectList.add(project);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return projectList;
	}

	public boolean insert(Project userToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, userToInsert.getUserid());
			preparedStatement.setString(2, userToInsert.getProjectname());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Project read(int projectid) {
		Connection connection = ConnectionSingleton.getInstance();
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, projectid);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int userid;
			String projectname;

			userid = resultSet.getInt("projectid");
			projectname = resultSet.getString("projectname");
			Project project = new Project(userid, projectname);
			project.setProjectid(resultSet.getInt("projectid"));

			return project;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Project projectToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (projectToUpdate.getProjectid() == 0)
			return false;

		Project projectRead = read(projectToUpdate.getProjectid());
		if (!projectRead.equals(projectToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (projectToUpdate.getUserid() == 0) {
					projectToUpdate.setUserid(projectRead.getUserid());
				}

				if (projectToUpdate.getProjectname() == null || projectToUpdate.getProjectname().equals("")) {
					projectToUpdate.setProjectname(projectRead.getProjectname());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, projectToUpdate.getUserid());
				preparedStatement.setString(2, projectToUpdate.getProjectname());
				preparedStatement.setInt(3, projectToUpdate.getProjectid());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;

	}

	public boolean delete(int projectid) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, projectid);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}

}
