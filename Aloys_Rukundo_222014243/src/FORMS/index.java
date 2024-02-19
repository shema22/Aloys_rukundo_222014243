package FORMS;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class index extends JFrame  implements ActionListener{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2982199799068547857L;
	private JMenuBar menuBar;
    private JMenu home,employee ,project ,user,orientationsession,site;
    private JMenuItem exitMenuItem, aboutEmp, storyMenu ,aboutproject,aboutOS,aboutsite,aboutuser ,report;
    private JTextArea textArea;

    public index() {
    	
        setTitle("EMPLOYEE O TRACKER Application");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        
        // Create menu bar
        menuBar = new JMenuBar();
menuBar. setBackground(Color.black);

        // Create file menu
        home = new JMenu("Home");
        home.setForeground(Color.orange);
        exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setForeground(Color.red);
        exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        home.add(exitMenuItem);

        // Create employee menu
        employee = new JMenu("Employee");
        employee.setForeground(Color.WHITE);
        aboutEmp = new JMenuItem("Employee");
        employee.addActionListener(this);
        aboutEmp.addActionListener(this);
        aboutEmp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(e.getSource()==aboutEmp) {
        			new employeeForm();
        			dispose();
        		}
            }
        });
        //create project menu
        

        project = new JMenu("Project");
        project.setForeground(Color.WHITE);
        aboutproject = new JMenuItem(" Project");
        project.addActionListener(this);
        aboutproject.addActionListener(this);
        aboutproject.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(e.getSource()==aboutproject) {
        			new projectForm();
        			dispose();
        		}
            }
        });
        // create orientationsession menu
        
        
        orientationsession= new JMenu("Orientation Session");
        orientationsession.setForeground(Color.WHITE);
        aboutOS = new JMenuItem("Orientation Session Time");
        orientationsession.addActionListener(this);
        aboutOS.addActionListener(this);
        aboutOS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

        		if(e.getSource()==aboutOS) {
        		
        		new orientationsessionForm ();
        	dispose();
        			
        		}
            }
        });
        //create site menu
        
        
       site = new JMenu("Site");
       site.setForeground(Color.WHITE);
       aboutsite = new JMenuItem(" site");
       site.addActionListener(this);
       aboutsite.addActionListener(this);
       aboutsite.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(e.getSource()==aboutsite) {
        			new siteForm();
        			dispose();
        		}
            }
        });
       //create user menu
       user = new JMenu("User");
       user.setForeground(Color.cyan);
       aboutuser = new JMenuItem("user");
       aboutuser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(e.getSource()==aboutuser) {
        			new adminForm();
        			dispose();
        		}
            }
        });
        employee.add(aboutEmp);
        project.add(aboutproject);
        orientationsession.add(aboutOS);
        site.add(aboutsite);
        user.add(aboutuser);
      
        
        // create report menu
        report = new JMenuItem("REPORT");
        report.setBackground(Color.white);
        report.setForeground(Color.green);
        report.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	new report();
    			dispose();
            }
        });
       
       
        // Create story menu item
        storyMenu = new JMenuItem("About");
        storyMenu.setBackground(Color.black);
        storyMenu.setForeground(Color.YELLOW);
        storyMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showStory();
            }
        });
       

        menuBar.add(home);
        menuBar.add(employee);
        menuBar.add(project);
        menuBar.add(orientationsession);
        menuBar.add(site);
        menuBar.add(user);
        
        
        menuBar.add(storyMenu);
        setJMenuBar(menuBar);
        menuBar.add(report);
        setJMenuBar(menuBar);

        // Create home page with index paragraphs and short story details
        textArea = new JTextArea();
        textArea.setBackground( new Color(116,163,202));
        textArea.setForeground(Color.white);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setText(" WELCOME  to Employee Orientation Tracker Application!\n\n" +
                "This application allows you to perform various tasks using GUI.\n\n" +
                "OUR MAIN PURPOSE is to tracking Employee's workout in site.\n\n" +
                "BEFORE I STUDIED JAVA , I was not capable to build such small project like this.\n\n " +
                "But after took this course tought by  our lecturer DR BUGINGO ,\n\n along with this  hardest journey, HE shape and transform us in miracle ways . " +
                "so about picking up this project after finishing this course, \n\n "
                + "I sit and think how big company struggering with employee,"
                + "\n\n sometimes they not produce enough productivity,"
                + "\n\n and also sometime company loses their best due to over time working even not get reward " +
                "then I decide to develop this system . \n\n "
                + "it held in five parts.\n\n"
                + " where this part of employee,project,site,users,and also session shifted .\n\n "
                + "In all this system allow to apply CRUD to every part of this project " +
                " In the end, working in that project was victory .\n\neven though there is some issues i have been facing up, "
                + "and i wish we could have enough time to practise not for just doing it as project.\n\n"
                + " because programming language especial jave need more practice with an experts or\n\n"
                + " someone who have advanced knowledge incase you need help. " +
                " for me I celebrate what we have been though and what I studied.\n\n"
                + " this project developed and designed  by MR RUKUNDO SHEMA ALOYS, student in BIT Department GROUP 2 .\n\n"
                + " alright reserved. copyright \u00A9 2024 ");

        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    private void showStory() {
        JOptionPane.showMessageDialog(null, textArea.getText());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new index().setVisible(true);
            }
        });
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

