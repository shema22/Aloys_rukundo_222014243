package ENTITIES;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
public class employee {
	private  String EmployeeID;
	private String FirstName;
	private String Lastname;
	private String Position;
	private String contactNumber;
	private String Email;
	public employee() {}
	public employee( String EmployeeID, String FirstName, String Lastname, String Position, String contactNumber,String Email) {
		super();
		this.EmployeeID =EmployeeID;
		this.FirstName =FirstName;
		this.Lastname = Lastname;
		this.Position = Position;
		this.contactNumber = contactNumber;
		this.Email=Email;
	}
	public void setEmail(String email_txf) {
		this.Email = email_txf;
	}
	public String getEmail() {
		return Email;
	}
	
	public employee( String FirstName, String Lastname, String Position, String contactNumber) {
		this.FirstName =FirstName;
		this.Lastname = Lastname;
		this.Position = Position;
		this.contactNumber = contactNumber;
	}
	public String getEmployeeID() {
		return EmployeeID;
	}
	public void setEmployeeID( String EmployeeID) {
		this.EmployeeID = EmployeeID;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String FirstName) {
		this.FirstName =FirstName;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String Lastname) {
		this.Lastname = Lastname;
	}
	public String getPosition() {
		return Position;
	}
	public void setPosition(String Position) {
		this.Position = Position;
	}
	public String getcontactNumber() {
		return contactNumber;
	}
	public void setcontactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public void makeconnection() {
	}
	
	public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/employee_orientation_tracker";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO employee (FirstName, Lastname, Position,contactNumber,Email) VALUES (?, ?, ?, ?, ?)";

	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	        PreparedStatement stm= con.prepareStatement(sql);
	    ) {
	        // Set the values for the prepared statement
	       stm.setString(1, this.FirstName);
	        stm.setString(2, this.Lastname);
	        stm.setString(3, this.Position);
	        stm.setString(4, this.contactNumber);
	        stm.setString(5, this.Email);

	        // Execute the query
	        int rowsAffected = stm.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	        	
	            JOptionPane.showMessageDialog(null, "Data inserted successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to insert data.");
	            JOptionPane.showMessageDialog(null, "Failed to insert data.!","After insert",JOptionPane.ERROR_MESSAGE);

	        }
	        con.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }	
	}

	public void readwithEmployeeID(int inputEmployeeID) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/employee_orientation_tracker";
	    String user = "root";
	    String password = "";

	    // SQL query to select all columns from employee whereEmployeeEmployeeID = ?
	    String sql = "SELECT * FROM employee WHERE EmployeeID = ?";

	    try (
	        // Establish the connection
	        Connection connection = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	    ) {
	        // Set the value for the parameterized query
	        //intEmployeeID= 1; // Replace with the desired employeeEmployeeEmployeeID
	        //if()
	    	preparedStatement.setInt(1, inputEmployeeID);

	        // Execute the query and get the result set
	        ResultSet resultSet = preparedStatement.executeQuery();

	        // Process the result set
	        while (resultSet.next()) {
	        	this.readwithEmployeeID(resultSet.getInt("EmployeeID"));
	           this.setFirstName(resultSet.getString("FirstName"));
	           this.setLastname(resultSet.getString("Lastname"));
	           this.setPosition(resultSet.getString("Position"));
	            this.setcontactNumber(resultSet.getString("contactNumber"));
	            this.setEmail(resultSet.getString("Email"));
	           

	        }
	        connection.close();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public void update(int inputEmployeeID) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/employee_orientation_tracker";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE employee SET FirstName = ?, Lastname = ?,Position = ?, contactNumber = ?, Email=? WHERE EmployeeID= ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	        stm.setString(1, this.getFirstName());
	        stm.setString(2, this.getLastname());
	        stm.setString(3, this.getPosition()); // Assuming there is a column named 'EmployeeID' for the WHERE clause
	        stm.setString(4, this.getcontactNumber());
	        stm.setString(5, this.getEmail());
	        stm.setInt(6, inputEmployeeID);
	        // Execute the update
	        int rowsAffected = stm.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	        	
	            JOptionPane.showMessageDialog(null, "Data updated  successfully!","After updated",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to update data. No matching record found.");
	        }
	        con.close();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }   
	}
	public void delete(int inputEmployeeID) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/employee_orientation_tracker";
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM employee WHERE EmployeeID = ?";

	    try (
	        // Establish the con
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement stm = con.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        stm.setInt(1, inputEmployeeID); // Assuming there is a column named 'EmployeeID' for the WHERE clause

	        // Execute the delete
	        int rowsAffected = stm.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	        	
	            JOptionPane.showMessageDialog(null, "Data deleted successfully!","After delete",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to delete data. No matching record found.");
	        }
	        con.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	


	
        }
	