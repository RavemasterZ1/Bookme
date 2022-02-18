package MyFirstProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import java.util.Random;
import java.util.Locale;
import java.text.DateFormat;

public class BookTicket extends JFrame implements ActionListener
{
	JPanel firstTitle, passengerInfo1, passengerInfo2, secondTitle, travelInfo1, travelInfo2, thirdTitle, btnPanel;
	JLabel lbTitle1, lbTitle2, lbName, lbBookRef, lbTicketNumber, lbIssueByDate, lbFlight, lbDepartArrive, lbAirporTerminal, lbClass, lbCouponValid,
	lbIdRef;
	JTextField txName, txBookRef, txTicketNumber, txIssueByDate, txFlight, txDepartArrive, txAirporTerminal, txClass, txCouponValid, txIdref;
	JButton  btnSave, btnBack, btnPrint;
	
	BookTicket()
	{
		
		setTitle(" AIRPORT MANAGEMENT BOOKING TICKET ");
		setSize(600,600);
		setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(3,1));

		ImageIcon img=new ImageIcon("MyLogo.jpg");
		    setIconImage(img.getImage());
		
		Font f = new Font("Serif", Font.BOLD, 24);
		
		firstTitle = new JPanel();
		firstTitle.setLayout(new GridLayout(3,0));
		passengerInfo1 = new JPanel();
		passengerInfo2 = new JPanel();
		passengerInfo2.setBackground(Color.white);
		secondTitle = new JPanel();
		secondTitle.setLayout(new GridLayout(3,0));
		travelInfo1 = new JPanel();
		travelInfo2 = new JPanel();
		travelInfo2.setBackground(Color.white);
		thirdTitle = new JPanel();
		thirdTitle.setLayout(new GridLayout(4,0));	
		btnPanel = new JPanel();
		
		btnSave = new JButton("SAVE");
		btnBack = new JButton("BACK");
		btnPrint= new JButton("PRINT");
		
		btnSave.addActionListener(this);
		btnBack.addActionListener(this);
		btnPrint.addActionListener(this);
		
		btnSave.setActionCommand("S");
		btnBack.setActionCommand("B");
		btnPrint.setActionCommand("P");
		
		lbTitle1 = new JLabel("-- PASSENGER AND TICKET INFORMATION --");
		lbTitle1.setForeground(Color.red);
		lbTitle1.setFont(f);
		passengerInfo1.add(lbTitle1);
				
		lbName = new JLabel("PASSENGER NAME: ");
		passengerInfo2.add(lbName);	
		txName = new JTextField(12);
		
		passengerInfo2.add(txName);	
		
		lbBookRef = new JLabel("BOOKING REFERENCE: ");
		passengerInfo2.add(lbBookRef);	
		txBookRef = new JTextField(10);
		txBookRef.setEnabled(false);
		
		passengerInfo2.add(txBookRef);

		lbTicketNumber = new JLabel("TICKET NUMBER: ");
		passengerInfo2.add(lbTicketNumber);		
		txTicketNumber = new JTextField(10);
		txTicketNumber.setEnabled(false);
		
		passengerInfo2.add(txTicketNumber);
		
		lbIssueByDate = new JLabel("ISSUE_BY_DATE: ");
		passengerInfo2.add(lbIssueByDate);
		txIssueByDate = new JTextField(10);
		txIssueByDate.setEnabled(false);
		
		passengerInfo2.add(txIssueByDate);
		
		lbTitle2 = new JLabel("-- TRAVEL INFORMATION --");
		lbTitle2.setForeground(Color.red);
		lbTitle2.setFont(f);
		travelInfo1.add(lbTitle2);
		
		lbFlight = new JLabel("FLIGHT: ");
		travelInfo2.add(lbFlight);
		txFlight = new JTextField(10);
		
		travelInfo2.add(txFlight);
		
		lbDepartArrive = new JLabel("DEPART/ARRIVE: ");
		travelInfo2.add(lbDepartArrive);
		txDepartArrive = new JTextField(10);
		
		travelInfo2.add(txDepartArrive);
		
		lbAirporTerminal = new JLabel("AIRPORT/TERMINAL: ");
		travelInfo2.add(lbAirporTerminal);
		txAirporTerminal = new JTextField(10);
		
		travelInfo2.add(txAirporTerminal);
		
		lbClass = new JLabel("CLASS : ");
		travelInfo2.add(lbClass);
		txClass = new JTextField(10);
		
		travelInfo2.add(txClass);
		
		lbCouponValid = new JLabel("COUPON VALIDITY: ");
		travelInfo2.add(lbCouponValid);
		txCouponValid = new JTextField(10);
		
		travelInfo2.add(txCouponValid);
		
		btnPanel.add(btnSave);
		btnPanel.add(btnPrint);
		btnPanel.add(btnBack);
		
		
		add(firstTitle);
		firstTitle.add(passengerInfo1);
		firstTitle.add(passengerInfo2);
		
		add(secondTitle);
		secondTitle.add(travelInfo1);
		secondTitle.add(travelInfo2);
		
		add(thirdTitle);
		thirdTitle.add(btnPanel);
		
		
		
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand().equals("S"))
		{
			if(txName.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Passenger name cannot be left empty","ERROR",
				JOptionPane.ERROR_MESSAGE);
			}
			else if(txFlight.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Flight cannot be empty","ERROR",
				JOptionPane.ERROR_MESSAGE);
			}
			else if(txDepartArrive.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Depart/Arrive cannot be left empty","ERROR",
				JOptionPane.ERROR_MESSAGE);
			}
			else if(txAirporTerminal.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Airport Terminal cannot be left empty","ERROR",
				JOptionPane.ERROR_MESSAGE);
			}
			else if(txClass.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Class cannot be left empty","ERROR",
				JOptionPane.ERROR_MESSAGE);
			}
			else if(txCouponValid.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Coupon Validity cannot be left empty","ERROR",
				JOptionPane.ERROR_MESSAGE);
			}
			else
			{
              try{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

				Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-2I7EIN8;DatabaseName=StarTrust;user = sa;password=Babatounde1998");

				PreparedStatement ps = con.prepareStatement("insert into [Passenger Information] values(?,?,?,?,?,?,?,?,?)");
				Random r= new Random();
				String BK,TN;
				int x= r.nextInt(9999);
				BK="B"+String.valueOf(x);
				TN="T"+String.valueOf(x);
				DateFormat d= DateFormat.getDateInstance(DateFormat.LONG, new Locale("en","UK"));
				String DD= d.format(new Date());


				ps.setString(1,txName.getText());
				ps.setString(2,BK);
				ps.setString(3,TN);
				ps.setString(4,DD);
				ps.setString(5,txFlight.getText());
				ps.setString(6,txDepartArrive.getText());
				ps.setString(7,txAirporTerminal.getText());
				ps.setString(8,txClass.getText());
				ps.setString(9,txCouponValid.getText());

				ps.executeUpdate();
				JOptionPane.showMessageDialog(this,"Ticket has been booked","VALID",
				JOptionPane.INFORMATION_MESSAGE);
			  }
			  catch(Exception e)
			  {
				JOptionPane.showMessageDialog(this,"error generating ticket"+e,"ERROR",
				JOptionPane.ERROR_MESSAGE);
			  }
			}
		}
		if(ae.getActionCommand().equals("B"))
		{
			MenuForm mf = new MenuForm();
			this.setVisible(false);
			mf.setVisible(true);
			
			
		}
	}	
	
	public static void main(String[] args)
	
	{
		new BookTicket();
	}
}