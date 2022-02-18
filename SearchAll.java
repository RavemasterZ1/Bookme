package MyFirstProject;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SearchAll extends JFrame
{
	static JTable tb;
	JButton btnSearch;
	JTextField txID;
	JLabel lbID;
	JPanel pl1;
	 
	
	String [] colName = {"Passenger ID","Passenger Name","Booking Reference","Ticket Number","Date Issued","Flight","Depart/Arrive","Airport/Terminal","Class","Coupon/Validity"};
	
	
	SearchAll()
	{
		
		setTitle(" Database Search Result ");
		setSize(1200,500);
		setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		ImageIcon img=new ImageIcon("MyLogo.jpg");
		    setIconImage(img.getImage());
		
		//TableModel tm = new TableModel();
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(colName);
		//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames()); 
		//tab = new JTable(model);
		tb = new JTable();
		tb.setModel(model); 
		tb.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tb.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane(tb);
		scroll.setHorizontalScrollBarPolicy(
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		//String value = txID.getText();
		
		String id ="";
		String name ="";
		String booking ="";
		String ticket ="";
		String dateIssue ="";
		String flight  ="";
		String departArrive ="";
		String airportTerminal ="";
		String clas ="";
		String couponValidity ="";
		
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost; DatabaseName = StarTrust; user = sa;password = Babatounde1998");
			PreparedStatement ps = con.prepareStatement("select PID, [Passenger Name],[Booking Reference], [Ticket Number], [Date Issued], Flight, [Depart/Arrive], [Airport/Terminal], Class, [Coupon/Validity] from [Passenger Information]");
		
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				id = rs.getString(1);
				name = rs.getString(2);
				booking = rs.getString(3);
				ticket = rs.getString(4);
				dateIssue = rs.getString(5);
				flight = rs.getString(6);
				departArrive = rs.getString(7);
				airportTerminal = rs.getString(8);
				clas = rs.getString(9);
				couponValidity = rs.getString(10);
				
				model.addRow(new Object[]{id,name,booking,ticket,dateIssue,flight,departArrive,airportTerminal,clas,couponValidity});
			}
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
		
		add(scroll);
		
		setVisible(true);
		
	
	}
	public static void main(String[] args)
	
	{
		new SearchAll();
	}
}