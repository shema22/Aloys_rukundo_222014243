package FORMS;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

@SuppressWarnings("serial")
public class report extends JFrame {
    private DefaultTableModel tableModel;
    private JTable table;

    public report() {
        super("Employee Report");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 500);
        setBackground(new Color(116,163,202));
        setForeground(Color.white);

        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        table.setBackground(Color.lightGray);
        table.setForeground(Color.white);
        
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        fetchAndDisplayData();

        setVisible(true);
    }

    private void fetchAndDisplayData() {
        String url = "jdbc:mysql://localhost/employee_orientation_tracker";
        String username = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT employee.FirstName, employee.Lastname, employee.Position, projects.ProjectName, " +
                         "projects.department, sites.Location, orientationsession.SessionTime " +
                         "FROM employee " +
                         "INNER JOIN orientationsession ON orientationsession.conductedBy = employee.EmployeeID " +
                         "INNER JOIN projects ON orientationsession.projectID = projects.projectID " +
                         "INNER JOIN sites ON orientationsession.siteID = sites.siteID";

            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                // Create columns for the table
                tableModel.addColumn("First Name");
                tableModel.addColumn("Last Name");
                tableModel.addColumn("Position");
                tableModel.addColumn("Project Name");
                tableModel.addColumn("Department");
                tableModel.addColumn("Location");
                tableModel.addColumn("Session Time");
               

                // Add data to the table
                while (resultSet.next()) {
                    String firstName = resultSet.getString("FirstName");
                    String lastName = resultSet.getString("Lastname");
                    String position = resultSet.getString("Position");
                    String projectName = resultSet.getString("ProjectName");
                    String department = resultSet.getString("department");
                    String location = resultSet.getString("Location");
                    String sessionDate = resultSet.getString("SessionTime");

                    Object[] rowData = {firstName, lastName, position, projectName, department, location, sessionDate};
                    tableModel.addRow(rowData);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(report::new);
    }
}
