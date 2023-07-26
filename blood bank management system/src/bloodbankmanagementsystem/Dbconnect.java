package bloodbankmanagementsystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JOptionPane;

public class Dbconnect {

	private Connection con;
	private Statement st;
    ResultSet rs;
    int flag = 0;

	public Dbconnect() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ blood bank management", "root", "");
			st = con.createStatement();

		} catch (Exception e) {
			//System.out.println(e);
		}
	}

	public void InsertRegister(String insertQuery) {
		
		try {
			st.executeUpdate(insertQuery);
			JOptionPane.showMessageDialog(null, "successfully registered");
			
		} catch (SQLException e) {
			//System.out.println(e);
			//JOptionPane.showMessageDialog(null, "successfully not registered");
		}

	}

	
	public void login(String querylogin,String email, String password) {
		
		try {
			rs=st.executeQuery(querylogin);
			while(rs.next())
			{
			String tableemail = rs.getString(2);
			
			String tablepassword = rs.getString(3);	
			
			if(email.equals(tableemail)&& password.equals(tablepassword)) {
				
				JOptionPane.showMessageDialog(null, "successful login ");
				
				flag =1;
				
				
				
				 loginForm f1 = new  loginForm ();
				 
				 
				 f1.dispose();
				 
				 new Homepage();
				 
				  	
				break;
			}
			}
			if(flag==0) {
				
				JOptionPane.showMessageDialog(null, "You are not a valid user!!");
				
			}
				
			}
					
			catch (Exception e)	{
				e.printStackTrace();
					
		}
		
		
	}
}
 