package bloodbankmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class BloodRequest extends JFrame {

	String blood;
 

	 	public BloodRequest() {

			setSize(500, 600);
			setDefaultCloseOperation(3);
			setLocationRelativeTo(null);
			setLayout(null);

			Font font = ((new Font("Arial", Font.BOLD, 18)));
			 

			JLabel top = new JLabel("BloodRequest");
			top.setBounds(0,0,500,80);
			top.setOpaque(true);
			top.setBackground(Color.cyan);
			top.setHorizontalAlignment(JLabel.CENTER);
			top.setFont(new Font("Arial",Font.BOLD,35));
			add(top);

			
			JPanel p2 = new JPanel();
			p2.setBounds(0, 80, 500, 520);
			p2.setLayout(null);
			add(p2);
			JLabel name = new JLabel("Enter You Name ");
			name.setFont(font);
			name.setBounds(10,0,200,50);

			JTextField txt1 = new JTextField();
			txt1.setFont(font);
			txt1.setBounds(10,35,470,30);
			p2.add(name);
			p2.add(txt1);

			JLabel address = new JLabel("What is the problem of the patient ");
			address.setFont(font);
			address.setBounds(10,65,350,30);

			JTextField txt2 = new JTextField();
			txt2.setFont(font);
			txt2.setBounds(10,90,470,30);
			p2.add(address);
			p2.add(txt2);

			JLabel amount = new JLabel("Amount ");
			amount.setFont(new Font("Arial",Font.BOLD,19));
			amount.setBounds(10,120,250,30);

			JTextField txt3 = new JTextField();
			txt3.setBounds(10,145,470,30);
			txt3.setFont(font);
			p2.add(amount);
			p2.add(txt3);
			
			
			JLabel loction = new JLabel("Loction ");
			loction.setFont(new Font("Arial",Font.BOLD,19));
			loction.setBounds(10,170,250,30);

			JTextField txt4 = new JTextField();
			txt4.setBounds(10,200,470,30);
			txt4.setFont(font);
			p2.add(loction);
			p2.add(txt4);
			
			
			JLabel Mobile = new JLabel("Enter You mobile number :");
			Mobile.setFont(font);
			Mobile.setBounds(10,230,250,30);
 

			JTextField txt5 = new JTextField();
			txt5.setBounds(10,260,470,30);
			txt5.setFont(font);
			p2.add(Mobile);
			p2.add(txt5);
			
		 
			 
			
			JLabel bloodgroup = new JLabel("Blood Group:");
			bloodgroup.setFont(font);
			bloodgroup.setBounds(10,310,250,50);
			p2.add(bloodgroup);
			
			
			String course[] = {"A+","A-","B+","B-","AB+","AB-","O+","O-"};
			
			JComboBox cb= new JComboBox(course);
			cb.setBounds(150,330,80,20);
			name.setFont(font);
			p2.add(cb);
			
			JButton Registerbtn = new JButton("Submit");
			Registerbtn.setBounds(325,400,140,50);
			Registerbtn.setFont(new Font("Arial",Font.BOLD,25));
			Registerbtn.setBackground(new Color(70,130,180));
			p2.add(Registerbtn);
			

			
			JButton back_btn = new JButton("Back");
	        back_btn.setBounds(20,400,140,50);
	        back_btn.setBackground(new Color(70,130,180));
	        back_btn.setFont(font);
	        back_btn.setFont(new Font("Arial",Font.BOLD,25));
	        p2.add(back_btn);
	        
	        back_btn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					new Homepage();
					dispose();
				}
			});
			
	        ImageIcon home = new ImageIcon(
					new ImageIcon("D:\\6th semester\\JAVA\\project\\12.jpg").getImage().getScaledInstance(600, 520, 1));
			
			JLabel img = new JLabel();	
			img.setBounds(0,0,600,520);
			img.setIcon(home);
			p2.add(img);
			
			
			
			
			Registerbtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					String name = txt1.getText();
					String problem = txt2.getText();
					String amount = txt3.getText();
					String loction = txt4.getText();
					String number = txt5.getText();
					
					 
					
					
					// Object is converted to String for finding gender
					blood = cb.getSelectedItem().toString();
					
					
					

					// Validation

				String NameRegex = "^[a-zA-z\\s\\.]+$";
				String problemRegex = "^[a-zA-z\\s\\.]+$";
				String numberRegex = "(\\88)?-?01[3-9]\\d{8}";
				String amountRegex ="\\d";
				 

				
					
					if (!Pattern.matches(NameRegex, name)) {

					JOptionPane.showMessageDialog(null, "Enter valid name!!");
					}

				else if (!Pattern.matches(problemRegex, problem)) {
						JOptionPane.showMessageDialog(null, "please !!");
				}	
				  
                
				else if (!Pattern.matches(amountRegex, amount)) {
						JOptionPane.showMessageDialog(null, "only digit!!");
					}
			
				else if (loction.equals("")) {
					JOptionPane.showMessageDialog(null, "Enter address");
				} 
					
				else if (!Pattern.matches(numberRegex,number)) {
					JOptionPane.showMessageDialog(null, "In-valid in mobile");
				}
				
					
					else {
						JOptionPane.showMessageDialog(null, " successfully requset send !!");
						 
					String insertQuery = "INSERT INTO `request`(`Name`, `problem`, `Amount`, `Location`, `number`, `bloodgroup`)"
                                      +"VALUES ('"+ name +"','"+problem+ "','"+ amount + "','"+ loction + "', '"+number+"','"+blood+"')" ;
					System.out.println(insertQuery);
						
					
					 
					reguestdb dbc = new reguestdb();
					dbc.bloodInsertRegister(insertQuery);
					
					}
					
	
			
					}
				
			});
		
		
	 
		setVisible(true);
	 
}
}	 


			
			 
	
	


	
	
