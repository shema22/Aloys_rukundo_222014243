package FORMS;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import ENTITIES.sites;
import java.sql.Connection;
@SuppressWarnings("unused")
public class siteForm implements ActionListener{
	JFrame frame;//SiteID;SiteName;Location;
	JLabel SiteID_lb=new JLabel("Site ID");
	JLabel SiteName_lb=new JLabel("Site Name");
	JLabel Location_lb=new JLabel("Location");
	
	JTextField SiteID_txf=new JTextField();
	JTextField SiteName_txf=new JTextField();
	JTextField Location_txf=new JTextField();
	
	//Buttons CRUD
		JButton insert_btn=new JButton("Insert");
		JButton Read_btn=new JButton("View");
		JButton update_tbtn=new JButton("Update");
		JButton delete_btn=new JButton("Delete");
		
		Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
		int w=(int) screensize.getWidth();
		int h=(int) screensize.getHeight();
		public siteForm() {
			createForm();

		}
		private void ActionEvent() {
			insert_btn.addActionListener((ActionListener) this);
			Read_btn.addActionListener((ActionListener) this);
			update_tbtn.addActionListener((ActionListener) this);
			delete_btn.addActionListener((ActionListener) this);
		}
		private void createForm() {
			frame=new JFrame();
			frame.setTitle(" welcome to site Form");
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
			SiteID_lb.setBounds(10, 10, 300, 30);
			SiteName_lb.setBounds(10, 50, 300, 30);
			Location_lb.setBounds(10, 90, 300, 30);
			
			SiteID_txf.setBounds(160, 10, 300, 30);
			SiteName_txf.setBounds(160, 50, 300, 30);
			Location_txf.setBounds(160, 90, 300, 30);
			
			//Buttons CRUD
			insert_btn.setBounds(100,150, 85, 30);
			Read_btn.setBounds(200,150, 85, 30);
			update_tbtn.setBounds(300,150, 85, 30);
			delete_btn.setBounds(400,150, 85, 30);
			setFontforall();
			addcomponentforFrame();

		}
		private void setFontforall() {
			Font font = new Font("Georgia", Font.BOLD, 18);

			SiteID_lb.setFont(font);
			SiteName_lb.setFont(font);
			Location_lb.setFont(font);
			
			
			SiteID_txf.setFont(font);
			SiteName_txf.setFont(font);
			Location_txf.setFont(font);
			
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
			frame.add(SiteID_lb);
			frame.add(SiteName_lb);
			frame.add(Location_lb);
			frame.add(SiteID_txf);
			frame.add(SiteName_txf);
			frame.add(Location_txf);
			
			
			frame.add(insert_btn);
			frame.add(Read_btn);
			frame.add(update_tbtn);
			frame.add(delete_btn);
			ActionEvent();
		}
		public void actionPerformed(ActionEvent e) {
			sites st= new sites();
			if(e.getSource()==insert_btn) {
				
				st.setSiteName(SiteName_txf.getText());
				st.setLocation(Location_txf.getText());
				
				//st.insertData(st.getSiteName(), st.getLocation()
				st.insertData();
			}else if (e.getSource()==Read_btn) {
				int SiteID=Integer.parseInt(SiteID_txf.getText());
				st.readwithSiteID (SiteID);
				
				SiteName_txf.setText(st.getSiteName());
				Location_txf.setText( st.getLocation());
				
			}else if (e.getSource()==update_tbtn) {
				int SiteID=Integer.parseInt(SiteID_txf.getText());
				
				st.setSiteName(SiteName_txf.getText());
				st.setLocation(Location_txf.getText());
				st.update(SiteID);
			}else {
				int SiteID=Integer.parseInt(SiteID_txf.getText());
				st.delete(SiteID);
			}

		}
		public static void main(String[] args) {
		
			siteForm stf=new siteForm();

		}
		}


