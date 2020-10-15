package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Project;
import it.contrader.model.User;

public class ProjectDAO {

	private final String QUERY_ALL = "SELECT * FROM project";
	private final String QUERY_CREATE = "INSERT INTO project (userid, projectname) VALUES (?,?)";
	private final String QUERY_READ = "SELECT * FROM project WHERE projectid=?";
	private final String QUERY_DELETE = "DELETE FROM project WHERE projectid=?";
	
	public ProjectDAO() {
	
	}
	
	
	public List<Project> getAll() {
		List<Project> projectList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Project progetto;
			while (resultSet.next()) {
				int projectid = resultSet.getInt("projectid");
				int userid = resultSet.getInt("userid");
				String projectname = resultSet.getString("projectname");
				progetto = new Project(userid, projectname);
				progetto.setProjectid(projectid);
				projectList.add(progetto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return projectList;
	}
	
	
	public boolean insert(Project projectToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, projectToInsert.getUserid());
			preparedStatement.setString(2, projectToInsert.getProjectname());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}
	
	public Project read(int projectId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, projectId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String projectname;
			int userid;

			userid = resultSet.getInt("userid");
			projectname = resultSet.getString("projectname");
			Project progetto = new Project(userid, projectname);
			progetto.setProjectid(resultSet.getInt("projectid"));

			return progetto;
		} catch (SQLException e) {
			return null;
		}

	}
	
	public boolean delete(int projectId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, projectId);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}
	
	
}
