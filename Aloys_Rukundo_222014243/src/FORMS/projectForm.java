package FORMS;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ENTITIES.employee;
import ENTITIES.project;


import java.sql.Connection;
@SuppressWarnings("unused")
public class projectForm implements ActionListener{
	
	
	
	JFrame frame;//projectID;ProjectName;department;EmployeeID;place;
	JLabel projectID_lb=new JLabel("Project ID");
	JLabel ProjectName_lb=new JLabel("Project Name");
	JLabel department_lb=new JLabel("Department");
	JLabel EmployeeID_lb=new JLabel("Employee ID");
	JLabel place_lb=new JLabel("Place");
	

	JTextField projectID_txf=new JTextField();
	JTextField ProjectName_txf=new JTextField();
	JTextField department_txf=new JTextField();
	JTextField EmployeeID_txf=new JTextField();
	JTextField place_txf=new JTextField();
	//Buttons CRUD
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_tbtn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");

	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();
	public projectForm() {
		createForm();

	}
	private void ActionEvent() {
		insert_btn.addActionListener(this);
		Read_btn.addActionListener(this);
		update_tbtn.addActionListener(this);
		delete_btn.addActionListener(this);
		
		//EmailBox.addActionListener(this);
	}
	private void createForm() {
		frame=new JFrame();
		frame.setTitle(" welcome to project Form");
	    frame.setForeground(Color.WHITE);
        frame.setFont(new Font("Arial", Font.BOLD, 24));
		frame.setBounds(2, 4, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground( new Color(116,163,202));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		setLocationandSize();
		
	}


	private void setLocationandSize() {
		projectID_lb.setBounds(10, 10, 300, 30);
		ProjectName_lb.setBounds(10, 50, 300, 30);
		department_lb.setBounds(10, 90, 300, 30);
		EmployeeID_lb.setBounds(10, 130, 300, 30);
		place_lb.setBounds(10, 170, 300, 30);
		
		projectID_txf.setBounds(160, 10, 300, 30);
		ProjectName_txf.setBounds(160, 50, 300, 30);
		department_txf.setBounds(160, 90, 300, 30);
		EmployeeID_txf.setBounds(160, 130, 300, 30);
		place_txf.setBounds(160, 170, 300, 30);
		
		//Buttons CRUD
		insert_btn.setBounds(100,250, 85, 30);
		Read_btn.setBounds(200,250, 85, 30);
		update_tbtn.setBounds(300,250, 85, 30);
		delete_btn.setBounds(400,250, 85, 30);
		setFontforall();
		addcomponentforFrame();

	}
	private void setFontforall() {
		Font font = new Font("Georgia", Font.BOLD, 18);
		projectID_lb.setForeground(Color.white);
		projectID_lb.setFont(font);
		ProjectName_lb.setFont(font);
		ProjectName_lb.setForeground(Color.white);
		department_lb.setFont(font);
		department_lb.setForeground(Color.white);
		EmployeeID_lb.setFont(font);
		EmployeeID_lb.setForeground(Color.white);
		place_lb.setFont(font);
		place_lb.setForeground(Color.white);

		projectID_txf.setFont(font);
		ProjectName_txf.setFont(font);
		department_txf.setFont(font);
		EmployeeID_txf.setFont(font);
		place_txf.setFont(font);
		
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.BOLD, 12);

		insert_btn.setFont(fonti);
		
		insert_btn.setFont(fonti);
		insert_btn.setForeground(Color.orange);
		insert_btn.setBackground(Color.white);
		Read_btn.setFont(fonti);
		Read_btn.setForeground(Color.black);
		Read_btn.setBackground(Color.WHITE);
		update_tbtn.setFont(fonti);
		update_tbtn.setForeground(Color.cyan);
		update_tbtn.setBackground(Color.white);
		delete_btn.setFont(fonti);
		delete_btn.setForeground(Color.red);
		delete_btn.setBackground(Color.white);
	}
	private void addcomponentforFrame() {
		frame.add(projectID_lb);
		frame.add(ProjectName_lb);
		frame.add(department_lb);
		frame.add(EmployeeID_lb);
		frame.add(place_lb);
		
		frame.add(projectID_txf);
		frame.add(ProjectName_txf);
		frame.add(department_txf);
		frame.add(EmployeeID_txf);
		frame.add(place_txf);
		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		ActionEvent();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
project st=new project();
		if(e.getSource()==insert_btn) {
			st.setProjectName(ProjectName_txf.getText());
			st.setdepartment(department_txf.getText());
			st.setEmployeeID(EmployeeID_txf.getText());
			st.setplace(place_txf.getText());
			
			
			//st.insertData(st.getProjectName(), st.getdepartment(), st.getEmployeeID(), st.getplace());
			st.insertData();
		}else if (e.getSource()==Read_btn) {
			int projectID=Integer.parseInt(projectID_txf.getText());
			st.readwithprojectID(projectID);
			projectID_txf.setText(String.valueOf(st.getprojectID()));
			ProjectName_txf.setText(st.getProjectName());
			department_txf.setText(st.getdepartment());
			EmployeeID_txf.setText(st.getEmployeeID());
			place_txf.setText(st.getplace());
		
			
		}else if (e.getSource()==update_tbtn) {
			int projectID=Integer.parseInt(projectID_txf.getText());
			
			st.setProjectName(ProjectName_txf.getText());
			st.setdepartment(department_txf.getText());
			st.setEmployeeID(EmployeeID_txf.getText());
			st.setplace(place_txf.getText());
			st.update(projectID);
		}else {
			int projectID=Integer.parseInt(projectID_txf.getText());
			st.delete(projectID);
		}

	}
	public static void main(String[] args) {
		
		projectForm stf=new projectForm();

	}
}
