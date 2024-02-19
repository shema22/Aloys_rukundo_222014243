package ENTITIES;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class admins{
	private int adminsID;
	private String username;
	private String password;
	private String fname;
	private String lname;
	private String role;
	public admins(int adminsID, String username, String password, String fname, String lname, String role) {
		this.adminsID = adminsID;
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.role =role;
	}
	public admins() {

	}
	public int getadminsID() {
		return adminsID;
	}
	public void setadminsID(int adminsID) {
		this.adminsID = adminsID;
	}
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getrole() {
		return role;
	}
	public void setrole(String role) {
		this.role =role;
	}
	//connect to the database
	public void registertwo() {
		String host = "jdbc:mysql://localhost/employee_orientation_tracker";
		String admins = "root";
		String password = "";
		String sql = "INSERT INTO admins (AdminID, username, Password, fname, lname,role) VALUES (?, ?, ?, ?, ?, ?)";

		String sqlQuery = "SELECT username FROM admins";

		try (Connection con = DriverManager.getConnection(host, admins, password);
				PreparedStatement pstmCheck = con.prepareStatement(sqlQuery);
				PreparedStatement pstm = con.prepareStatement(sql);
				ResultSet resultSet = pstmCheck.executeQuery()) {

			ArrayList<String> existingusernames = new ArrayList<>();

			// Collect existing usernames
			while (resultSet.next()) {
				String existingusername = resultSet.getString("username");
				existingusernames.add(existingusername);
			}

			// Check if the entered username already exists
			if (existingusernames.contains(this.username)) {
				JOptionPane.showMessageDialog(null, "username entered already exist!");
			} else {
				// Insert new admins
				pstm.setInt(1, this.adminsID);
				pstm.setString(2, this.username);
				pstm.setString(3, this.password);
				pstm.setString(4, this.fname);
				pstm.setString(5, this.lname);
				pstm.setString(6, this.role);

				int rowsAffected = pstm.executeUpdate();

				if (rowsAffected > 0) {
					JOptionPane.showMessageDialog(null, "Data inserted successfully!");
				} else {
					JOptionPane.showMessageDialog(null, "Failed to insert data.",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void readwithadminsID(int inputadminsID) {
		String url = "jdbc:mysql://localhost/employee_orientation_tracker";
		String admins = "root";
		String password = "";
		// SQL query to retrieve data
		String sql = "SELECT * from admins WHERE AdminID = ?";

		 try (
		        // Establish the connection
		        Connection connection = DriverManager.getConnection(url, admins, password);

		        // Create a prepared statement
		        PreparedStatement preparedStatement = connection.prepareStatement(sql);
		    ) {
		        
		    	preparedStatement.setInt(1,inputadminsID);

		        // Execute the query and get the result set
		        ResultSet resultSet = preparedStatement.executeQuery();

		        // Process the result set
		        while (resultSet.next()) {
		        	this.readwithadminsID(resultSet.getInt("AdminID"));
		           this.setusername(resultSet.getString("username"));
		           this.setPassword(resultSet.getString("password"));
		           this.setFname(resultSet.getString("fname"));
		            this.setLname(resultSet.getString("lname"));
		            this.setrole(resultSet.getString("role"));
		        }

		    } catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(int inputadminsID) {
		// JDBC URL, user, and password of MySQL server
	    String url = "jdbc:mysql://localhost/employee_orientation_tracker";
	    String admins = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE admins SET username = ?,password = ?,fname = ?,lname = ?,role=? WHERE AdminID= ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, admins, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	        stm.setString(1, this.getusername());
	        stm.setString(2, this.getPassword());
	        stm.setString(3, this.getFname()); 
	        stm.setString(4, this.getLname());
	        stm.setString(5, this.getrole());
	        stm.setInt(6, inputadminsID);
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
	public void delete(int inputadminsID) {
	    String url = "jdbc:mysql://localhost/employee_orientation_tracker";
	    String admins = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM admins WHERE AdminID = ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, admins, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        stm.setInt(1, inputadminsID); 

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