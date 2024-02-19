package ENTITIES;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class sites {
	private  int SiteID;
	private String SiteName;
	private String Location;
	public sites() {}
	public sites( int SiteID, String SiteName, String Location) {
		super();
		this.SiteID =SiteID;
		this.SiteName =SiteName;
		this.Location = Location;

	}
	public sites( String SiteName, String Location) {
		this.SiteName =SiteName;
		this.Location = Location;
	}
	public int getSiteID() {
		return SiteID;
	}
	public void setSiteID( int SiteID) {
		this.SiteID = SiteID;
	}
	public String getSiteName() {
		return SiteName;
	}
	public void setSiteName(String SiteName) {
		this.SiteName =SiteName;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String Location) {
		this.Location=Location;
	}	
	
	public void makeconnection() {
	}
    public void insertData() {
	    String host = "jdbc:mysql://localhost/employee_orientation_tracker";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO sites (SiteName,Location) VALUES (?,?)";

	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	        PreparedStatement stm= con.prepareStatement(sql);
	    ) {
	        // Set the values for the prepared statement
	       stm.setString(1, this.SiteName);
	        stm.setString(2, this.Location);

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

	public void readwithSiteID(int inputSiteID) {
	    String url = "jdbc:mysql://localhost/employee_orientation_tracker";
	    String user = "root";
	    String password = "";

	    // SQL query to select all columns from sites wheresitesSiteID = ?
	    String sql = "SELECT * FROM sites WHERE SiteID = ?";

	    try (
	        // Establish the connection
	        Connection connection = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	    ) {
	        // Set the value for the parameterized query
	        //intSiteID= 1; // Replace with the desired sitessitesSiteID
	        //if()
	    	preparedStatement.setInt(1, inputSiteID);

	        // Execute the query and get the result set
	        ResultSet resultSet = preparedStatement.executeQuery();

	        // Process the result set
	        while (resultSet.next()) {
	        	this.setSiteID(resultSet.getInt("SiteID"));
	           this.setSiteName(resultSet.getString("SiteName"));
	           this.setLocation(resultSet.getString("Location"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void update(int inputSiteID) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/employee_orientation_tracker";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE sites SET SiteName = ?,Location = ? WHERE SiteID= ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	        stm.setString(1, this.getSiteName());
	        stm.setString(2, this.getLocation());
	        stm.setInt(3, inputSiteID);
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
	
public void delete(int inputSiteID) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/employee_orientation_tracker";
    String user = "root";
    String password = "";

    // SQL query to delete data
    String sql = "DELETE FROM sites WHERE SiteID = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement stm = con.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        stm.setInt(1, inputSiteID); // Assuming there is a column named 'SiteID' for the WHERE clause

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



