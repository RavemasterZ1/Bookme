package MyFirstProject;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Search extends JFrame implements ActionListener
{
	JPanel firstTitle, passengerInfo1, passengerInfo2, secondTitle, travelInfo1, travelInfo2, thirdTitle, searchPanel, btnPanel;
	JLabel lbTitle1, lbTitle2, lbName, lbBookRef, lbTicketNumber, lbIssueByDate, lbFlight, lbDepartArrive, lbAirporTerminal, lbClass, lbCouponValid,
	lbIdRef;
	JTextField txName, txBookRef, txTicketNumber, txIssueByDate, txFlight, txDepartArrive, txAirporTerminal, txClass, txCouponValid, txIdref;
	JButton btnSearch, btnUpdate, btnClear;
	
	Search()
	{
		
		setTitle(" AIRPORT MANAGEMENT SEARCH PANE ");
		setSize(600,600);
		setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(3,1));
		
		Font f = new Font("Serif", Font.BOLD, 24);
		Font f1= new Font("Serif",Font.BOLD,18);
		
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
		searchPanel = new JPanel();
		btnPanel = new JPanel();
		
		btnSearch = new JButton("SEARCH");
		btnUpdate = new JButton("UPDATE"); 
		btnClear = new JButton("CLEAR");
		
		lbTitle1 = new JLabel("-- PASSENGER AND TICKET INFORMATION --");
		lbTitle1.setForeground(Color.red);
		lbTitle1.setFont(f);
		passengerInfo1.add(lbTitle1);
				
		lbName = new JLabel("PASSENGER NAME: ");
		passengerInfo2.add(lbName);	
		txName = new JTextField(12);
		txName.setEnabled(false);
		txName.setBackground(Color.BLACK);
		txName.setFont(f1);
		passengerInfo2.add(txName);	
		

		lbTicketNumber = new JLabel("TICKET NUMBER: ");
		passengerInfo2.add(lbTicketNumber);		
		txTicketNumber = new JTextField(10);
		txTicketNumber.setEnabled(false);
		txTicketNumber.setBackground(Color.BLACK);
		txTicketNumber.setFont(f1);
		passengerInfo2.add(txTicketNumber);
		
		lbIssueByDate = new JLabel("ISSUE_BY_DATE: ");
		passengerInfo2.add(lbIssueByDate);
		txIssueByDate = new JTextField(10);
		txIssueByDate.setEnabled(false);
		txIssueByDate.setBackground(Color.BLACK);
		txIssueByDate.setFont(f1);
		passengerInfo2.add(txIssueByDate);
		
		lbTitle2 = new JLabel("-- TRAVEL INFORMATION --");
		lbTitle2.setForeground(Color.red);
		lbTitle2.setFont(f);
		travelInfo1.add(lbTitle2);
		
		lbFlight = new JLabel("FLIGHT: ");
		travelInfo2.add(lbFlight);
		txFlight = new JTextField(10);
		txFlight.setEnabled(false);
		txFlight.setBackground(Color.BLACK);
		txFlight.setFont(f1);
		travelInfo2.add(txFlight);
		
		lbDepartArrive = new JLabel("DEPART/ARRIVE: ");
		travelInfo2.add(lbDepartArrive);
		txDepartArrive = new JTextField(10);
		txDepartArrive.setEnabled(false);
	    txDepartArrive.setBackground(Color.BLACK);
	    txDepartArrive.setFont(f1);
		travelInfo2.add(txDepartArrive);
		
		lbAirporTerminal = new JLabel("AIRPORT/TERMINAL: ");
		travelInfo2.add(lbAirporTerminal);
		txAirporTerminal = new JTextField(10);
		txAirporTerminal.setEnabled(false);
		txAirporTerminal.setBackground(Color.BLACK);
		txAirporTerminal.setFont(f1);
		travelInfo2.add(txAirporTerminal);
		
		lbClass = new JLabel("CLASS : ");
		travelInfo2.add(lbClass);
		txClass = new JTextField(10);
		txClass.setEnabled(false);
		txClass.setBackground(Color.BLACK);
		txClass.setFont(f1);
		travelInfo2.add(txClass);
		
		lbCouponValid = new JLabel("COUPON VALIDITY: ");
		travelInfo2.add(lbCouponValid);
		txCouponValid = new JTextField(10);
		txCouponValid.setEnabled(false);
		txCouponValid.setBackground(Color.BLACK);
		txCouponValid.setFont(f1);
		travelInfo2.add(txCouponValid);
		
		lbIdRef = new JLabel("BOOKING REFERENCE: ");
		searchPanel.add(lbIdRef);
		txIdref = new JTextField(14);
		
		searchPanel.add(txIdref);
		
		btnPanel.add(btnSearch);
		btnPanel.add(btnUpdate);
		btnPanel.add(btnClear);
		
		add(firstTitle);
		firstTitle.add(passengerInfo1);
		firstTitle.add(passengerInfo2);
		
		add(secondTitle);
		secondTitle.add(travelInfo1);
		secondTitle.add(travelInfo2);
		
		add(thirdTitle);
		thirdTitle.add(searchPanel);
		thirdTitle.add(btnPanel);
		
		
		
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand().equals("B"))
		{
			MenuForm mf = new MenuForm();
			this.setVisible(false);
			mf.setVisible(true);
		}

		if(ae.getActionCommand().equals("C"))
		{
				txBookRef.setText("");
				txTicketNumber.setText("");
				txIssueByDate.setText("");
				txFlight.setText("");
				txDepartArrive.setText("");
				txAirporTerminal.setText("");
				txClass.setText("");
				txCouponValid.setText("");
				txIdref.setText("");
		}
		
		if(ae.getActionCommand().equals("U"))
		{
			if(txIdref.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Booking Reference cannot be left empty","ERROR",
				JOptionPane.ERROR_MESSAGE);
		    }
		}    else
		{
			if(btnUpdate.getText().equals("UPDATE"))
			{
				btnUpdate.setText("CHANGE");
				txName.setEnabled(true);
				txTicketNumber.setEnabled(true);
				txIssueByDate.setEnabled(true);
				txFlight.setEnabled(true);
				txDepartArrive.setEnabled(true);
				txAirporTerminal.setEnabled(true);
				txClass.setEnabled(true);
				txCouponValid.setEnabled(true);
			}
			else if(btnUpdate.getText().equals("CHANGE"))
			{
					if(txIdref.getText().equals(""))
					{
						JOptionPane.showMessageDialog(this,"Booking Reference cannot be left empty","ERROR",
						JOptionPane.ERROR_MESSAGE);
					}
					else
					{
							try 
							{
								Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

								Connection con = DriverManager.getConnection("jdbc:sqlserver://KEVIN;DatabaseName=StarTrust;user = sa;password=patrickdorian");

								PreparedStatement ps = con.prepareStatement("update [Passenger Information] set [Passenger Name]=?,[Ticket Number]=?,[Date Issued]=?,[Flight]=?,[Depart/Arrive]=?,[Airport/Terminal]=?,[Class]=?,[Coupon/Validity]=? where [Booking Reference]=?");
								
								ps.setString(1,txName.getText());
								ps.setString(2,txTicketNumber.getText());
								ps.setString(3,txIssueByDate.getText());
								ps.setString(4,txFlight.getText());
								ps.setString(5,txDepartArrive.getText());
								ps.setString(6,txAirporTerminal.getText());
								ps.setString(7,txClass.getText());
								ps.setString(8,txCouponValid.getText());
								ps.setString(9,txIdref.getText());

								ps.executeUpdate();

								JOptionPane.showMessageDialog(this,"Record Updated","SUCCESS",
								JOptionPane.INFORMATION_MESSAGE);

								btnUpdate.setText("UPDATE");

								txName.setText("");
								txTicketNumber.setText("");
								txIssueByDate.setText("");
								txFlight.setText("");
								txDepartArrive.setText("");
								txAirporTerminal.setText("");
								txClass.setText("");
								txCouponValid.setText("");

								txName.setEnabled(false);
								txTicketNumber.setEnabled(false);
								txIssueByDate.setEnabled(false);
								txFlight.setEnabled(false);
								txDepartArrive.setEnabled(false);
								txAirporTerminal.setEnabled(false);
								txClass.setEnabled(false);
								txCouponValid.setEnabled(false);
							} 
							catch (Exception E) 
							{
								JOptionPane.showMessageDialog(this,"Error with database, please try again later"+E,
								"ERROR",JOptionPane.ERROR_MESSAGE);
							}
					}
			}	}
		
		if(ae.getActionCommand().equals("S"))
		{
          try
		  {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-2I7EIN8;DatabaseName=StarTrust;user = sa;password=Babatounde1998");

			PreparedStatement ps = con.prepareStatement("select[Passenger Name],[Booking Reference],[Ticket Number],[Date Issued],[Depart/Arrive],[Airport/Terminal],[Coupon/Validity] from [Passenger Information] where [Booking Reference]=?");
			PreparedStatement ps1 = con.prepareStatement("select [Booking Reference] from [Passenger Name] where [Booking Reference]=? ");
			ps.setString(1,txIdref.getText());
			ps1.setString(1,txIdref.getText());
			
			ResultSet rs=ps.executeQuery();
			ResultSet rs1=ps1.executeQuery();
			do
			{
				if(!(rs1.next()))
				{
					JOptionPane.showMessageDialog(this,"Booking Reference does not exist.","INFORMATION",
			JOptionPane.INFORMATION_MESSAGE);
				}
			
			else  
			{
			  JOptionPane.showMessageDialog(this,"Record Found.","SUCCESS",
			  JOptionPane.INFORMATION_MESSAGE);
			  while(rs.next())
			  {
				  txName.setText(rs.getString(1));
				  txTicketNumber.setText(rs.getString(2));
				  txIssueByDate.setText(rs.getDate(3).toString());
				  txFlight.setText(rs.getString(4));
				  txDepartArrive.setText(rs.getString(5));
				  txAirporTerminal.setText(rs.getString(6));
				  txClass.setText(rs.getString(7));
				  txCouponValid.setText(rs.getString(8));
			  }
			}
		}while(rs1.next());
		}
		  catch (Exception e)
		  {
			JOptionPane.showMessageDialog(this,"error retrieving Data."+e,"ERROR",
			JOptionPane.ERROR_MESSAGE);
			txIdref.setText("");
		  
		}}

	}
	
	public static void main(String[] args)
	{
		new Search();
	}
}