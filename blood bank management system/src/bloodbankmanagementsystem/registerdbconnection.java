package bloodbankmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class registerdbconnection {

	private Connection con;
	private Statement st;
	ResultSet rs,donorSet;
	 

	public registerdbconnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blood bank management", "root", "");
			st = con.createStatement();

		} catch (Exception e) {
			// System.out.println(e);
		}
	}

	public void InsertRegister(String insertQuery) {

		try {
			st.executeUpdate(insertQuery);
			JOptionPane.showMessageDialog(null, "successfully registered");

		} catch (SQLException e) {
			// System.out.println(e);
			JOptionPane.showMessageDialog(null, "successfully not registered");

			newDoner f1 = new newDoner();

			f1.dispose();

			new Homepage();

			 

		}
	}


	// returns the donor list from the donor registration table
	public ResultSet donorList(String insertQuery) {
		
		try {
			donorSet = st.executeQuery(insertQuery);
			
		} catch (SQLException e) {}
		return donorSet;
	}
}
