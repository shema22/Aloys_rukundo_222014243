package FORMS;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import ENTITIES.employee;


import java.sql.Connection;

@SuppressWarnings("unused")
public class employeeForm implements ActionListener{
	
	
	
	JFrame frame;
	JLabel EmployeeID_lb=new JLabel("EmployeeID");
	JLabel FirstName_lb=new JLabel("FirstName");
	JLabel Lastname_lb=new JLabel("Lastname");
	JLabel Position_lb=new JLabel("Position");
	JLabel contactNumber_lb=new JLabel("contactNumber");
	JLabel Email_lb=new JLabel("Email");

	JTextField EmployeeID_txf=new JTextField();
	JTextField FirstName_txf=new JTextField();
	JTextField Lastname_txf=new JTextField();
	JTextField Position_txf=new JTextField();
	JTextField contactNumber_txf=new JTextField();

	JTextField Email_txf = new JTextField();

	//Buttons CRUD
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_tbtn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");

	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();
	public employeeForm() {
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
		frame.setTitle(" welcome to employee Form");
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
		EmployeeID_lb.setBounds(10, 10, 300, 30);
		FirstName_lb.setBounds(10, 50, 300, 30);
		Lastname_lb.setBounds(10, 90, 300, 30);
		Position_lb.setBounds(10, 130, 300, 30);
		contactNumber_lb.setBounds(10, 170, 300, 30);
		Email_lb.setBounds(10, 210, 300, 30);
		EmployeeID_txf.setBounds(160, 10, 300, 30);
		FirstName_txf.setBounds(160, 50, 300, 30);
		Lastname_txf.setBounds(160, 90, 300, 30);
		Position_txf.setBounds(160, 130, 300, 30);
		contactNumber_txf.setBounds(160, 170, 300, 30);
		Email_txf.setBounds(160, 210, 300, 30);
		//Buttons CRUD
		insert_btn.setBounds(100,270, 85, 30);
		Read_btn.setBounds(200,270, 85, 30);
		update_tbtn.setBounds(300,270, 85, 30);
		delete_btn.setBounds(400,270, 85, 30);
		setFontforall();
		addcomponentforFrame();

	}
	private void setFontforall() {
		Font font = new Font("Georgia", Font.BOLD, 18);
		EmployeeID_lb.setForeground(Color.WHITE);
		EmployeeID_lb.setFont(font);
		FirstName_lb.setFont(font);
		FirstName_lb.setForeground(Color.WHITE);
		Lastname_lb.setFont(font);
		Lastname_lb.setForeground(Color.WHITE);
		Position_lb.setFont(font);
		Position_lb.setForeground(Color.WHITE);
		contactNumber_lb.setFont(font);
		contactNumber_lb.setForeground(Color.WHITE);
		Email_lb.setFont(font);
		Email_lb.setForeground(Color.WHITE);

		EmployeeID_txf.setFont(font);
		FirstName_txf.setFont(font);
		Lastname_txf.setFont(font);
		Position_txf.setFont(font);
		contactNumber_txf.setFont(font);
		Email_txf.setFont(font);
		//Buttons CRUD
		Font fonti = new Font("Courier New",Font.BOLD, 12);
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
		frame.add(EmployeeID_lb);
		frame.add(FirstName_lb);
		frame.add(Lastname_lb);
		frame.add(Position_lb);
		frame.add(contactNumber_lb);
		frame.add(Email_lb);
		frame.add(EmployeeID_txf);
		frame.add(FirstName_txf);
		frame.add(Lastname_txf);
		frame.add(Position_txf);
		frame.add(contactNumber_txf);
		frame.add(Email_txf);
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		ActionEvent();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		employee st=new employee();
		if(e.getSource()==insert_btn) {
			st.setFirstName(FirstName_txf.getText());
			st.setLastname(Lastname_txf.getText());
			st.setPosition(Position_txf.getText());
			st.setcontactNumber(contactNumber_txf.getText());
			st.setEmail(Email_txf.getText());
			
			//st.insertData(st.getFirstName(), st.getLastname(), st.getPosition(), st.getcontactNumber(), st.getEmail());
			st.insertData();
		}else if (e.getSource()==Read_btn) {
			int EmployeeID=Integer.parseInt(EmployeeID_txf.getText());
			st.readwithEmployeeID(EmployeeID);
			EmployeeID_txf.setText(String.valueOf(st.getEmployeeID()));
			FirstName_txf.setText(st.getFirstName());
 			Lastname_txf.setText(st.getLastname());
			Position_txf.setText(st.getPosition());
			contactNumber_txf.setText(st.getcontactNumber());
			Email_txf.setText(st.getEmail());
			
		}else if (e.getSource()==update_tbtn) {
			int EmployeeID=Integer.parseInt(EmployeeID_txf.getText());
			
			st.setFirstName(FirstName_txf.getText());
			st.setLastname(Lastname_txf.getText());
			st.setPosition(Position_txf.getText());
			st.setcontactNumber(contactNumber_txf.getText());
			st.setEmail(Email_txf.getText());
			st.update(EmployeeID);
		}else {
			int EmployeeID=Integer.parseInt(EmployeeID_txf.getText());
			st.delete(EmployeeID);
		}

	}
	public static void main(String[] args) {
		employeeForm stf=new employeeForm();

	}
}

