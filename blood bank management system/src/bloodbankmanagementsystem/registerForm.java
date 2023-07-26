package bloodbankmanagementsystem;

import java.awt.Color;
import java.text.Format;
import java.util.regex.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class registerForm extends JFrame {

	public registerForm() {

		setSize(650, 600);
		setDefaultCloseOperation(3);
		setLocationRelativeTo(null);
		setLayout(null);
		

		JPanel p1 = new JPanel();
		p1.setBounds(0, 0, 650, 80);
		p1.setBackground(new Color(51, 153, 153));
		p1.setLayout(null);

		Font font = ((new Font("Arial", Font.BOLD, 25)));
		Font font1 = ((new Font("Arial", Font.BOLD, 40)));
	 
		
		JLabel label1 = new JLabel("Registration");
		label1.setBounds(0, 0, 650, 80);
		label1.setHorizontalAlignment(label1.CENTER);
		label1.setFont(font1);
		label1.setLayout(null);
		p1.add(label1);
		add(p1);
		
		JPanel p2 = new JPanel();
		p2.setBounds(0, 80,650,520);
		p2.setBackground(new Color(255, 102, 102));
		p2.setLayout(null);
		add(p2);
		
		

		JLabel username = new JLabel("User Name:");
		username.setFont(font);
		username.setBounds(100, 20, 170, 70);

		JTextField txt = new JTextField();
		txt.setFont(font);
		txt.setBounds(250, 30, 310, 50);
		p2.add(username);
		p2.add(txt);

		JLabel Email = new JLabel("Email:");
		Email.setFont(font);
		Email.setBackground(new Color(70,130,180));
		Email.setBounds(165, 80, 170, 70);

		JTextField EmailTxt = new JTextField();
		EmailTxt.setFont(font);
		EmailTxt.setBounds(250, 90,310, 50);
		p2.add(Email);
		p2.add(EmailTxt);

		JLabel Mobile = new JLabel("Mobile:");
		Mobile.setFont(font);
		Mobile.setBounds(155, 140, 170, 70);

		JTextField MobileTxt = new JTextField();
		MobileTxt.setBounds(250, 150, 310, 50);
		MobileTxt.setFont(font);
		
		p2.add(Mobile);
		p2.add(MobileTxt);

		JLabel Password = new JLabel("Password:");
		Password.setFont(font);
		Password.setBounds(115, 200, 170, 70);

		JPasswordField PasswordTxt = new JPasswordField();
		PasswordTxt.setFont(font);
		PasswordTxt.setBounds(250, 210, 310, 50);

		p2.add(Password);
		p2.add(PasswordTxt);

		JLabel ConfirmPassword = new JLabel("Confirm Password:");
		ConfirmPassword.setFont(font);
		ConfirmPassword.setBounds(15, 260, 300, 70);

		JPasswordField ConfirmPasswordTxt = new JPasswordField();
		ConfirmPasswordTxt.setFont(font);
		ConfirmPasswordTxt.setBounds(250, 270, 310, 50);
		p2.add(ConfirmPassword);
		p2.add(ConfirmPasswordTxt);

		JLabel Address = new JLabel("Address:");
		Address.setFont(font);
		Address.setBounds(135, 320, 170, 70);

		JTextField AddressTxt = new JTextField();
		AddressTxt.setFont(font);
		AddressTxt.setBounds(250, 330, 310, 50);

		p2.add(Address);
		p2.add(AddressTxt);

		JButton loginbtn = new JButton("Login");
		loginbtn.setBounds(100, 410, 115, 40);
		loginbtn.setFont(font);
		p2.add(loginbtn);

		JButton Registerbtn = new JButton("Register");
		Registerbtn.setBounds(420, 410, 140, 40);
		Registerbtn.setFont(font);
		p2.add(Registerbtn);

		loginbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new loginForm();
			}
		});
	
		ImageIcon image1 = new ImageIcon(new ImageIcon("D:\\6th semester\\JAVA\\project\\7.jpg").getImage().getScaledInstance(650,520,1));
		JLabel image = new JLabel();
		image.setBounds(0,0,650,520);
		image.setIcon(image1);
		p2.add(image);
		

		Registerbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String username = txt.getText();
				String email = EmailTxt.getText();
				String mobile = MobileTxt.getText();
				String password = PasswordTxt.getText();
				String confirmpassword = ConfirmPasswordTxt.getText();
				String Address = AddressTxt.getText();

				// Validation

				String userNameRegex = "^[a-zA-Z]+$";
				String emailRegex = "^[a-z0-9]+@[a-z]+.[a-z]+$";
				String mobileRegex = "(\\88)?-?01[3-9]\\d{8}";
				String passRegex = "(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%&*()]).{6,20}";

 
				if (!Pattern.matches(userNameRegex, username)) {

					JOptionPane.showMessageDialog(null, "only char is allowed!!");
				}

				else if (!Pattern.matches(emailRegex, email)) {
					JOptionPane.showMessageDialog(null, "In-valid email!!");
					
				}
				else if (!Pattern.matches(mobileRegex, mobile)) {
					JOptionPane.showMessageDialog(null, "In-valid in mobile");
				}

				else if (!Pattern.matches(passRegex, password)) {
					JOptionPane.showMessageDialog(null, "Must be use one Uppercase, lowercase, special characters, and number !!");
				}

				else if (!confirmpassword.equals(password)) {
					JOptionPane.showMessageDialog(null, "Must enter the same password twice!!");
				}

				else if (Address.equals("")) {
					JOptionPane.showMessageDialog(null, "Enter address");
				} 
				
				else {
					JOptionPane.showMessageDialog(null, " successfully registered !!");

					String insertQuery = "INSERT INTO `register`(`username`, `email`, `pass`, `mobile`, `Address`)"
							+ " VALUES ('"+ username + "','" + email + "','" + password + "','" + mobile + "','" + Address + "')";
					//System.out.println(insertQuery);
					Dbconnect db = new Dbconnect();
					db.InsertRegister(insertQuery);
					
				}		

				}
			
		});
		setVisible(true);
	}
}
