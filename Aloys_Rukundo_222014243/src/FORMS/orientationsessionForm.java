package FORMS;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ENTITIES.OrientationSessions;
@SuppressWarnings("unused")
public class orientationsessionForm implements ActionListener {
	
	JFrame frame;//SessionID;SessionDate;SessionTime;SiteID;conductedBy;
	JLabel SessionID_lb=new JLabel("SessionID");
	JLabel SessionDate_lb=new JLabel("SessionDate");
	JLabel SessionTime_lb=new JLabel("hour per day");
	JLabel SiteID_lb=new JLabel("SiteID");
	JLabel conductedBy_lb=new JLabel("conductedBy");
	JLabel projectID_lb=new JLabel("projectID");
	

	JTextField SessionID_txf=new JTextField();
	JTextField SessionDate_txf=new JTextField();
	JTextField SessionTime_txf=new JTextField();
	JTextField SiteID_txf=new JTextField();
	JTextField conductedBy_txf=new JTextField();

	JTextField projectID_txf = new JTextField();

	//Buttons CRUD
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_tbtn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");

	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();
	public orientationsessionForm() {
		createForm();

	}
	private void ActionEvent() {
		insert_btn.addActionListener((ActionListener) this);
		Read_btn.addActionListener((ActionListener) this);
		update_tbtn.addActionListener((ActionListener) this);
		delete_btn.addActionListener((ActionListener) this);
		
		//projectIDBox.addActionListener(this);
	}
	private void createForm() {
		frame=new JFrame();
		frame.setTitle(" welcome to orrientation session Form");
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
		SessionID_lb.setBounds(10, 10, 300, 30);
		SessionDate_lb.setBounds(10, 50, 300, 30);
		SessionTime_lb.setBounds(10, 90, 300, 30);
		SiteID_lb.setBounds(10, 130, 300, 30);
		conductedBy_lb.setBounds(10, 170, 300, 30);
		projectID_lb.setBounds(10, 210, 300, 30);
		SessionID_txf.setBounds(160, 10, 300, 30);
		SessionDate_txf.setBounds(160, 50, 300, 30);
		SessionTime_txf.setBounds(160, 90, 300, 30);
		SiteID_txf.setBounds(160, 130, 300, 30);
		conductedBy_txf.setBounds(160, 170, 300, 30);
		projectID_txf.setBounds(160, 210, 300, 30);
		//Buttons CRUD
		insert_btn.setBounds(100,250, 85, 30);
		Read_btn.setBounds(200,250, 85, 30);
		update_tbtn.setBounds(300,250, 85, 30);
		delete_btn.setBounds(400,250, 85, 30);
		setFontforall();
		addcomponentforFrame();

	}
	private void setFontforall() {
		Font font = new Font("Century", Font.BOLD, 18);

		SessionID_lb.setFont(font);
		SessionID_lb.setForeground(Color.WHITE);
		SessionDate_lb.setFont(font);
		SessionDate_lb.setForeground(Color.WHITE);
		SessionTime_lb.setFont(font);
		SessionTime_lb.setForeground(Color.WHITE);
		SiteID_lb.setFont(font);
		SiteID_lb.setForeground(Color.WHITE);
		conductedBy_lb.setFont(font);
		conductedBy_lb.setForeground(Color.WHITE);
		 projectID_lb.setFont(font);
		 projectID_lb.setForeground(Color.WHITE);
		SessionID_txf.setFont(font);
		SessionDate_txf.setFont(font);
		SessionTime_txf.setFont(font);
		SiteID_txf.setFont(font);
		conductedBy_txf.setFont(font);
		projectID_txf.setFont(font);
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
		frame.add(SessionID_lb);
		frame.add(SessionDate_lb);
		frame.add(SessionTime_lb);
		frame.add(SiteID_lb);
		frame.add(conductedBy_lb);
		frame.add(projectID_lb);
		frame.add(SessionID_txf);
		frame.add(SessionDate_txf);
		frame.add(SessionTime_txf);
		frame.add(SiteID_txf);
		frame.add(conductedBy_txf);
		frame.add(projectID_txf);
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		ActionEvent();
	}
	public void actionPerformed(ActionEvent e) {
		OrientationSessions st=new OrientationSessions();
		if(e.getSource()==insert_btn) {
			
			st.setSessionDate(SessionDate_txf.getText());
			st.setSessionTime(SessionTime_txf.getText());
			st.setSiteID(SiteID_txf.getText());
			st.setconductedBy(conductedBy_txf.getText());
			st.setprojectID(projectID_txf.getText());
			
			//st.insertData(st.getSessionDate(), st.getSessionTime(), st.getSiteID(), st.getconductedBy(), st.getprojectID());
			st.insertData();
		}else if (e.getSource()==Read_btn) {
			int SessionID=Integer.parseInt(SessionID_txf.getText());
			st.readwithSessionID(SessionID);
			SessionID_txf.setText(String.valueOf(st.getSessionID()));
			SessionDate_txf.setText(st.getSessionDate());
			SessionTime_txf.setText(st.getSessionTime());
			SiteID_txf.setText(st.getSiteID());
			conductedBy_txf.setText(st.getconductedBy());
			
			
		}else if (e.getSource()==update_tbtn) {
			int SessionID=Integer.parseInt(SessionID_txf.getText());
			
			st.setSessionDate(SessionDate_txf.getText());
			st.setSessionTime(SessionTime_txf.getText());
			st.setSiteID(SiteID_txf.getText());
			st.setconductedBy(conductedBy_txf.getText());
			st.setprojectID(projectID_txf.getText());
			st.update(SessionID);
		}else {
			int SessionID=Integer.parseInt(SessionID_txf.getText());
			st.delete(SessionID);
		}

	}
	public static void main(String[] args) {
		orientationsessionForm stf =new orientationsessionForm();

	}

}
