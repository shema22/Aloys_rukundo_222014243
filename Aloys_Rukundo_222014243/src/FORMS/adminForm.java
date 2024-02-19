package FORMS;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import ENTITIES.admins;

public class adminForm implements ActionListener{
	JFrame frame;

	JLabel adminsIDlb=new JLabel("User ID");
	JLabel usernamelb=new JLabel("Username");
	JLabel  passwordlb=new JLabel("Password");
	JLabel fnamelb=new JLabel("First name");
	JLabel  lnamelb=new JLabel("Last Name");
	JLabel role=new JLabel("role");
	//Text field
	JTextField adminsIDtxf=new JTextField ();
	JTextField  usernametxf=new JTextField ();
	JPasswordField  passwordpsf=new JPasswordField();
	JTextField  fnametxf=new JTextField ();
	JTextField  lnametxf=new JTextField ();
	JTextField  roletxf=new JTextField ();
	//buttons
	
	JButton insert_btn=new JButton("Register");
	JButton Read_btn=new JButton("Display");
	JButton update_tbtn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");
	
	public adminForm () {
		createwindow();
		SetlocationandSize();
		addcomponetToFrame();
		addActionEvent();


	}

	private void addActionEvent() {
		
		insert_btn.addActionListener(this);
		Read_btn.addActionListener(this);
		update_tbtn.addActionListener(this);
		delete_btn.addActionListener(this);

	}


	private void addcomponetToFrame() {
		frame.add(adminsIDlb);
		frame.add(usernamelb);
		frame.add(passwordlb);
		frame.add(fnamelb);
		frame.add(lnamelb);
		frame.add(role);
		//Text field
		frame.add(adminsIDtxf);
		frame.add(usernametxf);
		frame.add(passwordpsf);
		frame.add(fnametxf);
		frame.add(lnametxf);
		frame.add(roletxf);
		//buttons
		
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
	

	}


	private void SetlocationandSize() {
		adminsIDlb.setBounds(10, 10, 300, 30);
		usernamelb.setBounds(5, 50, 300, 30);
		passwordlb.setBounds(5, 90, 300, 30);
		fnamelb.setBounds(5, 130, 300, 30);
		lnamelb.setBounds(5, 170, 300, 30);
		role.setBounds(5, 210, 300, 30);
		//Text field
		adminsIDtxf.setBounds(160, 10, 300, 30);
		usernametxf.setBounds(160, 50, 300, 30);
		passwordpsf.setBounds(160, 90, 300, 30);
		fnametxf.setBounds(160, 130, 300, 30);
		lnametxf.setBounds(160, 170, 300, 30);
		roletxf.setBounds(160, 210, 300, 30);
		//buttons
		
		insert_btn.setBounds(100,300, 100, 30);
		Read_btn.setBounds(220,300, 85, 30);
		update_tbtn.setBounds(320, 300, 85, 30);
		delete_btn.setBounds(420, 300, 85, 30);
		

	}


	private void createwindow() {
		frame=new JFrame();
		frame.setTitle("welcome to user form");
		frame.setForeground(Color.WHITE);
        frame.setFont(new Font("Arial", Font.BOLD, 24));
		frame.setBounds(0,0,700,400);
		frame.getContentPane().setBackground( new Color(116,163,202));
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
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


	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		admins user=new admins();
		if(e.getSource()==insert_btn) {
			user.setadminsID(Integer.parseInt(adminsIDtxf.getText()));
			user.setusername(usernametxf.getText());
			user.setPassword(passwordpsf.getText());
			user.setFname(fnametxf.getText());
			user.setLname(lnametxf.getText());
			user.setrole(roletxf.getText());
			user.registertwo();
			
		}else if(e.getSource()==Read_btn) {
			int adminsID=Integer.parseInt(adminsIDtxf.getText());
			user.readwithadminsID(adminsID);
			adminsIDtxf.setText(String.valueOf(user.getadminsID()));
			usernametxf.setText(user.getusername());
			passwordpsf.setText(user.getPassword());
			fnametxf.setText(user.getFname());
			lnametxf.setText(user.getLname());
			roletxf.setText(user.getrole());
			
		}else if(e.getSource()==update_tbtn) {
            int adminsID=Integer.parseInt(adminsIDtxf.getText());
			user.setusername(usernametxf.getText());
			user.setPassword(passwordpsf.getText());
			user.setFname(fnametxf.getText());
			user.setLname(lnametxf.getText());
			user.setrole(roletxf.getText());
			user.update(adminsID);
		}else {
			int adminsID=Integer.parseInt(adminsIDtxf.getText());
			user.delete(adminsID);
		}

	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		adminForm adfm =new adminForm();
	}

}

