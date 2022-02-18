package MyFirstProject;
import java.sql.*;
import java.util.*;
import java.awt.*;
import java.util.Arrays;
import javax.swing.*;
import java.awt.event.*;



class Login extends JFrame implements ActionListener
{
        JTextField jtxtUN;
        JPasswordField jpwd;
        JButton btnS, btnC;

        Login()
        {
            setSize(500,500);
            setLocationRelativeTo(null);
            setTitle("GridBag Constraint");
            setLayout(new GridLayout(3,1));
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            ImageIcon img=new ImageIcon("MyLogo.jpg");
		    setIconImage(img.getImage());

            Font f = new Font("Tempus Sans ITC",Font.BOLD,40);
            Font f1 = new Font("Comic Sans MS",Font.BOLD,20);
            Font f2 = new Font("Comic Sans MS",Font.BOLD,20);

            JPanel pnlOne = new JPanel();
            JPanel pnlTwo = new JPanel();
            JPanel pnlThree = new JPanel();

            GridBagConstraints gbc = new GridBagConstraints();

            pnlOne.setLayout(new FlowLayout());
            pnlTwo.setLayout(new GridBagLayout());
            pnlThree.setLayout(new FlowLayout());

            /*pnlOne.setBackground(Color.PINK);
            pnlTwo.setBackground(Color.YELLOW);
            pnlThree.setBackground(Color.GRAY);*/

            JLabel jlblTitle = new JLabel("Log In");
            JLabel jlblUN = new JLabel("Username");
            JLabel jlblpwd = new JLabel("Password");

            jlblUN.setFont(f1);
            jlblpwd.setFont(f1);

            jlblTitle.setFont(f);

            jtxtUN = new JTextField(10);
            jpwd = new JPasswordField(10);

            jtxtUN.setFont(f1);
            jpwd.setFont(f1);


            btnS = new JButton("Log In");
            btnC = new JButton("Clear");

            btnS.addActionListener(this);
            btnC.addActionListener(this);

            btnS.setActionCommand("S");
            btnC.setActionCommand("C");


            btnS.setFont(f2);
            btnC.setFont(f2);

            pnlOne.add(jlblTitle);
            //This method is for the spacing of components in the Login
            gbc.insets = new Insets(5,5,5,5);
            gbc.gridx = 0;
            gbc.gridy = 0;
            pnlTwo.add(jlblUN,gbc);

            gbc.gridx = 1;
            gbc.gridy = 0;
            pnlTwo.add(jtxtUN,gbc);

            gbc.gridx = 0;
            gbc.gridy = 1;
            pnlTwo.add(jlblpwd,gbc);

            gbc.gridx = 1;
            gbc.gridy = 1;
            pnlTwo.add(jpwd,gbc);

            pnlThree.add(btnS);
            pnlThree.add(btnC);

            add(pnlOne);
            add(pnlTwo);
            add(pnlThree);

            setVisible(true);
        }

        public void actionPerformed(ActionEvent ae)
        {
                if(ae.getActionCommand().equals("C"))
                {
                            jtxtUN.setText("");
                            jpwd.setText("");
                }

                if(ae.getActionCommand().equals("S"))
                {
                        char a[] = new char[] {};

                        if(jtxtUN.getText().equals(""))
                        {
                                JOptionPane.showMessageDialog(this,"Username cannot be left empty","ERROR",
                                JOptionPane.ERROR_MESSAGE);
                        }
                        else if(Arrays.equals(jpwd.getPassword(),a))
                        {
                                JOptionPane.showMessageDialog(this,"Password cannot be left empty",
                                "ERROR",JOptionPane.ERROR_MESSAGE);
                        }
                        else
                       {
                    try
                    {
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

                        Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-2I7EIN8;DatabaseName=StarTrust;user = sa;password=Babatounde1998");

                        PreparedStatement ps = con.prepareStatement("select UserName, Password from Login where UserName = ? and Password=?");

                        String PWD = String.valueOf(jpwd.getPassword());

                        ps.setString(1,jtxtUN.getText());
                        ps.setString(2,PWD);

                        ResultSet rs = ps.executeQuery();

                        do
                        {
                                if(!(rs.next()))
                                {
                                    JOptionPane.showMessageDialog(this,"Credentials not found","ERROR",
                                    JOptionPane.ERROR_MESSAGE);
                                }
                                else if(jtxtUN.getText().equals(rs.getString(1)) && PWD.equals(rs.getString(2)))
                                {
                                    JOptionPane.showMessageDialog(this,"Welcome "+jtxtUN.getText(),
                                    "Authenticated",JOptionPane.INFORMATION_MESSAGE);

                                    MenuForm mf = new MenuForm();
                                    this.setVisible(false);
                                    mf.setVisible(true);
                                }
                        }while(rs.next());
                    }
                    catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(this,"Database Error, please try again later"+e,
                        "ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                    finally
                    {
                            jtxtUN.setText("");
                            jpwd.setText("");
                            
                        
                    }}
                }
        }

        public static void main(String[]args)
        {
            new Login();
        }
}