package ENTITIES;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import FORMS.orientationsessionForm;
@SuppressWarnings("unused")
public class OrientationSessions {

	private  int SessionID;
	private String SessionDate;
	private String SessionTime;
	private String SiteID;
	private String conductedBy;
	private String projectID;
	public OrientationSessions() {}
	public OrientationSessions( int SessionID, String SessionDate, String SessionTime, String SiteID, String conductedBy,String projectID) {
		super();
		this.SessionID =SessionID;
		this.SessionDate =SessionDate;
		this.SessionTime = SessionTime;
		this.SiteID = SiteID;
		this.conductedBy = conductedBy;
		this.projectID=projectID;
	}
	
	public OrientationSessions( String SessionDate, String SessionTime, String SiteID, String conductedBy) {
		this.SessionDate =SessionDate;
		this.SessionTime = SessionTime;
		this.SiteID = SiteID;
		this.conductedBy = conductedBy;
	}
	public int getSessionID() {
		return SessionID;
	}
	public void setSessionID( int SessionID) {
		this.SessionID = SessionID;
	}
	public String getSessionDate() {
		return SessionDate;
	}
	public void setSessionDate(String SessionDate) {
		this.SessionDate =SessionDate;
	}
	public String getSessionTime() {
		return SessionTime;
	}
	public void setSessionTime(String SessionTime) {
		this.SessionTime = SessionTime;
	}
	public String getSiteID() {
		return SiteID;
	}
	public void setSiteID(String SiteID) {
		this.SiteID = SiteID;
	}
	public String getconductedBy() {
		return conductedBy;
	}
	public void setconductedBy(String conductedBy) {
		this.conductedBy = conductedBy;
	}
	public String getprojectID () {
		return projectID;
	}
	public void setprojectID(String projectID) {
		this.projectID = projectID;
	}
	public void makeconnection() {
	}

	public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/employee_orientation_tracker";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO orientationsession (SessionDate,SessionTime,SiteID,conductedBy,projectID) VALUES ( ?, ?, ?, ? ,?)";

	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	        PreparedStatement stm= con.prepareStatement(sql);
	    ) {
	        // Set the values for the prepared statement
	       stm.setString(1, this.SessionDate);
	        stm.setString(2, this.SessionTime);
	        stm.setString(3, this.SiteID);
	        stm.setString(4, this.conductedBy);
	        stm.setString(5, this.projectID);

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

	public void readwithSessionID(int inputSessionID) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/employee_orientation_tracker";
	    String user = "root";
	    String password = "";

	    // SQL query to select all columns from orientationsession whereorientationsessionSessionID = ?
	    String sql = "SELECT * FROM orientationsession WHERE SessionID = ?";

	    try (
	        // Establish the connection
	        Connection connection = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	    ) {
	        // Set the value for the parameterized query
	        //intSessionID= 1; // Replace with the desired orientationsessionorientationsessionSessionID
	        //if()
	    	preparedStatement.setInt(1, inputSessionID);

	        // Execute the query and get the result set
	        ResultSet resultSet = preparedStatement.executeQuery();

	        // Process the result set
	        while (resultSet.next()) {
	        	this.readwithSessionID(resultSet.getInt("SessionID"));
	           this.setSessionDate(resultSet.getString("SessionDate"));
	           this.setSessionTime(resultSet.getString("SessionTime"));
	           this.setSiteID(resultSet.getString("SiteID"));
	            this.setconductedBy(resultSet.getString("conductedBy"));
	            this.setprojectID(resultSet.getString("projectID"));
	         

	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public void update(int inputSessionID) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/employee_orientation_tracker";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE orientationsession SET SessionDate = ?, SessionTime = ?,SiteID = ?, conductedBy = ?, projectID=? WHERE SessionID= ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	        stm.setString(1, this.getSessionDate());
	        stm.setString(2, this.getSessionTime());
	        stm.setString(3, this.getSiteID()); // Assuming there is a column named 'SessionID' for the WHERE clause
	        stm.setString(4, this.getconductedBy());
	        stm.setString(5, this.getprojectID());
	        stm.setInt(6, inputSessionID);
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
	public void delete(int inputSessionID) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/employee_orientation_tracker";
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM orientationsession WHERE SessionID = ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        stm.setInt(1, inputSessionID); // Assuming there is a column named 'SessionID' for the WHERE clause

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
