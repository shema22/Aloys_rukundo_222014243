package ENTITIES;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class project {
	private  int projectID;
	private String ProjectName;
	private String department;
	private String EmployeeID;
	private String place;

	public project() {}
	public project( int projectID, String ProjectName, String department, String EmployeeID, String place,String Email) {
		super();
		this.projectID =projectID;
		this.ProjectName =ProjectName;
		this.department = department;
		this.EmployeeID =EmployeeID;
		this.place = place;
		
	}
	
	
	public project( String ProjectName, String department, String projectID, String place) {
		this.ProjectName =ProjectName;
		this.department = department;
		this.EmployeeID =projectID;
		this.place = place;
	}
	public int getprojectID() {
		return projectID;
	}
	public void setprojectID( int projectID) {
		this.projectID = projectID;
	}
	public String getProjectName() {
		return ProjectName;
	}
	public void setProjectName(String ProjectName) {
		this.ProjectName =ProjectName;
	}
	public String getdepartment() {
		return department;
	}
	public void setdepartment(String department) {
		this.department = department;
	}
	public String getEmployeeID() {
		return EmployeeID;
	}
	public void setEmployeeID(String EmployeeID) {
		this.EmployeeID =EmployeeID;
	}
	public String getplace() {
		return place;
	}
	public void setplace(String place) {
		this.place = place;
	}
	public void makeconnection() {
	}
	public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/employee_orientation_tracker";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO projects(ProjectName, department,EmployeeID ,place) VALUES (?, ?, ?, ?)";

	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	        PreparedStatement stm= con.prepareStatement(sql);
	    ) {
	        // Set the values for the prepared statement
	       stm.setString(1, this.ProjectName);
	        stm.setString(2, this.department);
	        stm.setString(3, this.EmployeeID);
	        stm.setString(4, this.place);

	        // Execute the query
	        int rowsAffected = stm.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	        	System.out.println("Data inserted successfully!");
	            JOptionPane.showMessageDialog(null, "Data inserted successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to insert data.");
	            JOptionPane.showMessageDialog(null, "Failed to insert data.!","After insert",JOptionPane.ERROR_MESSAGE);

	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }	
	}

	public void readwithprojectID(int inputprojectID) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/employee_orientation_tracker";
	    String user = "root";
	    String password = "";

	    // SQL query to select all columns from project whereprojectprojectID = ?
	    String sql = "SELECT * FROM projects WHERE projectID = ?";

	    try (
	        // Establish the connection
	        Connection connection = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	    ) {
	        // Set the value for the parameterized query
	        //intprojectID= 1; // Replace with the desired projectprojectprojectID
	        //if()
	    	preparedStatement.setInt(1, inputprojectID);

	        // Execute the query and get the result set
	        ResultSet resultSet = preparedStatement.executeQuery();

	        // Process the result set
	        while (resultSet.next()) {
	        	this.setprojectID(resultSet.getInt("projectID"));
	           this.setProjectName(resultSet.getString("ProjectName"));
	           this.setdepartment(resultSet.getString("department"));
	           this.setEmployeeID(resultSet.getString("EmployeeID"));
	            this.setplace(resultSet.getString("place"));
	          

	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public void update(int inputprojectID) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/employee_orientation_tracker";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE projects SET ProjectName = ?, department = ?,EmployeeID = ?, place = ? WHERE projectID= ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	        stm.setString(1, this.getProjectName());
	        stm.setString(2, this.getdepartment());
	        stm.setString(3, this.getEmployeeID());
	        stm.setString(4, this.getplace());
	       
	        stm.setInt(5, inputprojectID);
	        // Execute the update
	        int rowsAffected = stm.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	        	
	            JOptionPane.showMessageDialog(null, "Data updated successfully!","After update",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to update data. No matching record found.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }   
	}
	public void delete(int inputprojectID) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/employee_orientation_tracker";
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM projects WHERE projectID = ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        stm.setInt(1, inputprojectID); // Assuming there is a column named 'projectID' for the WHERE clause

	        // Execute the delete
	        int rowsAffected = stm.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	        	
	            JOptionPane.showMessageDialog(null, "Data deleted successfully!","After delete",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to delete data. No matching record found.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
