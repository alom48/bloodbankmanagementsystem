package bloodbankmanagementsystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Stock extends JFrame{
	
	registerdbconnection db = new registerdbconnection();;
	ResultSet rs;
	public Stock() {
		setSize(500, 300);
		setDefaultCloseOperation(3);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		
		JLabel top = new JLabel("Stock");
		top.setBounds(0,0,500,80);
		top.setOpaque(true);
		top.setBackground(Color.cyan);
		top.setHorizontalAlignment(JLabel.CENTER);
		top.setFont(new Font("Arial",Font.BOLD,30));
		add(top);
		
		JButton back_btn = new JButton("Back");
        back_btn.setBounds(10,20,60,30);
        back_btn.setBackground(new Color(70,130,180));
        back_btn.setFont(new Font("Arial",Font.BOLD,10));
         
        top.add(back_btn);
        
        back_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				new Homepage();
				dispose();
			}
		});
		
		
		Object data[][] = {{"",""}};
		String col[] = {"Blood Group", "Available in Stock"};
		DefaultTableModel model = new DefaultTableModel(data,col);
		model.removeRow(0);
		
		JTable table = new JTable(model);
		table.setEnabled(false);
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(0,80,500,400);
		add(sp);
		
		String str = "SELECT Bloodgroup, COUNT(Bloodgroup) FROM donorregistration GROUP BY Bloodgroup ORDER BY COUNT(Bloodgroup)";
		
		rs = db.donorList(str);
		
		try {
			while(rs.next()) {
				String blood = rs.getString(1);
				String stockNumber = rs.getString(2);
				
				Object temp[]= {blood,stockNumber};
				model.addRow(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
