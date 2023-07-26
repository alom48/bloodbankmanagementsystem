package bloodbankmanagementsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SearchDonor extends JFrame {
	
	registerdbconnection db = new registerdbconnection();;
	 	 ResultSet rs;

	 	public SearchDonor() {

			setSize(800, 600);
			setDefaultCloseOperation(3);
			setLocationRelativeTo(null);
			setResizable(false);
			setLayout(null);

			Font font = ((new Font("Arial", Font.BOLD, 20)));
			Font font1 = ((new Font("Arial", Font.BOLD, 30)));
			 

			JPanel p1 = new JPanel();
			p1.setBounds(0, 0, 800, 120);
			p1.setBackground(new Color(51, 153, 153));
			p1.setLayout(null);

			JLabel label1 = new JLabel("Donor list");
			label1.setBounds(300, 0, 200,50);
			label1.setForeground(Color.orange);
			label1.setFont(font1);
			label1.setLayout(null);
			p1.add(label1);
			add(p1);
			
			JButton back_btn = new JButton("Back");
	        back_btn.setBounds(20,30,100,50);
	        back_btn.setBackground(new Color(70,130,180));
	        back_btn.setFont(font);
	        p1.add(back_btn);
	        
	        back_btn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					new Homepage();
					dispose();
				}
			});
			
			
			
			JLabel searcl1 = new JLabel("Blood Group:");
			searcl1 .setBounds(400,50,200,50);
			searcl1 .setFont(font);
			p1.add(searcl1 );
			
			String course[] = {"A+","A-","B+","B-","AB+","AB-","O+","O-"};
			JComboBox cb= new JComboBox(course);
			cb.setBounds(550,65,50,20);
			p1.add(cb);
			
			
			
			
			Object data[][]= {{"","","","","",""}};
			String col[] = {"Name","Address","Mobile","Age","Sex","Bloodgroup"};
			DefaultTableModel model = new DefaultTableModel(data,col);
			model.removeRow(0);
			
			JTable table = new JTable(model);
			table.setEnabled(false);
			JScrollPane sp = new JScrollPane(table);
			sp.setBounds(0,120,800,480);
			add(sp);
			
			String str = "SELECT * FROM `search_donor`";
			rs = db.donorList(str);
			try {
				while(rs.next())
				{
					String name = rs.getString(1);
					String address = rs.getString(2);
					String mobile = rs.getString(3);
					String age = rs.getString(4);
					String sex = rs.getString(5);
					String blood= rs.getString(6);
					
					Object temp[] = {name,address,mobile,age,sex,blood};
					
					model.addRow(temp);
					
				}
			} catch (Exception e) {
			}
			
			JButton SearchDonor = new JButton("Search Donor ");
			SearchDonor.setBounds(610, 65, 150, 30);
			SearchDonor.setFont((new Font("Arial", Font.BOLD, 15)));
			p1.add(SearchDonor);
			
			SearchDonor.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e){
					
					String bloodSelected = cb.getSelectedItem().toString();
					System.out.println(bloodSelected);
					// removes all row
					int rowCount = table.getRowCount();
					for(int i=0;i<rowCount;i++)
					{
						model.removeRow(0); 					// remove the top row
					}
					rs = db.donorList(str);
					try {
						while(rs.next())
						{
							if(bloodSelected.equals(rs.getString(6)))
							{
								String name = rs.getString(1);
								String address = rs.getString(2);
								String mobile = rs.getString(3);
								String age = rs.getString(4);
								String sex = rs.getString(5);
								String blood= rs.getString(6);
								
								Object temp[] = {name,address,mobile,age,sex,blood};
								
								model.addRow(temp);
							}
						}
					} catch (SQLException e1) {
					}
				}
			});
			 
			
			
			setVisible(true);
	
	
}
}
	


