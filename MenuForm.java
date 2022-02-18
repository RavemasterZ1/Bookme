package MyFirstProject;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class MenuForm extends JFrame implements ActionListener
{
	JButton jb1,jb2,jb3,jb4;
	MenuForm()
	{
		   // Create and set up a frame window
        		JFrame.setDefaultLookAndFeelDecorated(true);
				ImageIcon img=new ImageIcon("MyLogo.jpg");
		    setIconImage(img.getImage());
		
        		this.setResizable(false);
        		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        		Font f = new Font("Tempus Sans ITC",Font.BOLD,35);
         
        		// Define new buttons with different width on help of the ---
        		 jb1 = new JButton("Book a Ticket");        
        		 jb2 = new JButton("Edit/Update a Ticket");
        		 jb3 = new JButton("Search All");
        		 jb4= new JButton("Log Out");
				 
				 jb1.setFont(f);
        		jb2.setFont(f);
        		jb3.setFont(f);

				jb1.addActionListener(this);
				jb2.addActionListener(this);
				jb3.addActionListener(this);
				jb4.addActionListener(this);

				
				jb1.setActionCommand("B");
				jb2.setActionCommand("U");
				jb3.setActionCommand("S");
				jb4.setActionCommand("L");
             
         
        		// Define the panel to hold the buttons 
        		JPanel panel1 = new JPanel();
         
        		// Set up the title for different panels
        		panel1.setBorder(BorderFactory.createTitledBorder("MENU"));
         
        		// Set up the BoxLayout
        		BoxLayout layout1 = new BoxLayout(panel1, BoxLayout.Y_AXIS);
        		panel1.setLayout(layout1);
        
         
        		// Add the buttons into the panel with three different alignment options
        		jb1.setAlignmentX(Component.CENTER_ALIGNMENT);
        		jb2.setAlignmentX(Component.CENTER_ALIGNMENT);
        		jb3.setAlignmentX(Component.CENTER_ALIGNMENT);
        		jb4.setAlignmentX(Component.CENTER_ALIGNMENT);
       
    
        		panel1.add(jb1);
        		panel1.add(Box.createRigidArea(new Dimension(10, 80))); 
        		panel1.add(jb2);
        		panel1.add(Box.createRigidArea(new Dimension(0, 90))); 
        		panel1.add(jb3);
        		panel1.add(Box.createRigidArea(new Dimension(0, 100)));
        		panel1.add(jb4); 
        		panel1.add(Box.createRigidArea(new Dimension(0, 100))); 

         
        		// Add the three panels into the frame
        		setLayout(new FlowLayout());
        		add(panel1);
         		setBounds(450,50,100,100);
        		// Set the window to be visible as the default to be false
       	 	this.pack();
        		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand().equals("U"))
		{
			
			Search s = new Search();
			this.setVisible(false);
			s.setVisible(true);
		}
		if(ae.getActionCommand().equals("L"))
		{
			Login If= new Login();
			this.setVisible(false);
			If.setVisible(true);
		}
		if(ae.getActionCommand().equals("B"))
		{
			BookTicket bf= new BookTicket();
			this.setVisible(false);
			bf.setVisible(true);
		}
		if(ae.getActionCommand().equals("S"))
		{
			SearchAll sa= new SearchAll();
			this.setVisible(false);
			sa.setVisible(true);
			
		}
	}

 
    	public static void main(String[] args) 
		
	{
     		new MenuForm();
    	}
}