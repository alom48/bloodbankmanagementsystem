package bloodbankmanagementsystem;

import java.text.Format;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class loginForm extends JFrame {

	public loginForm() {

		setSize(500, 400);
		setDefaultCloseOperation(3);
		setLocationRelativeTo(null);
		setLayout(null);

		JPanel p1 = new JPanel();
		p1.setBounds(0, 0, 500, 80);
		p1.setBackground(new Color(51, 153, 153));
		p1.setLayout(null);

		Font font = ((new Font("Arial", Font.BOLD, 15)));
		Font font1 = ((new Font("Arial", Font.BOLD, 20)));

		JLabel label1 = new JLabel("Login");
		label1.setBounds(0, 0, 500, 80);
		label1.setHorizontalAlignment(label1.CENTER);
		label1.setFont(new Font("Arial",Font.BOLD,40));
		label1.setBackground(Color.cyan);
		label1.setLayout(null);
		p1.add(label1);
		add(p1);

		JPanel p2 = new JPanel();
		p2.setBounds(0, 80, 500, 320);
		p2.setBackground(new Color(255, 255, 204));
		p2.setLayout(null);
		add(p2);

		JLabel email = new JLabel("Email: ");
		email.setFont(font1);
		email.setBounds(80,20,100, 70);

		JTextField t1 = new JTextField();
		t1.setFont(font1);
		t1.setBounds(150, 30, 250, 50);

		p2.add(email);
		p2.add(t1);

		// .......................Password............................//

		JLabel password = new JLabel("Password: ");
		password.setFont(font1);
		password.setBounds(40, 80, 200, 70);

		JPasswordField pass = new JPasswordField();
		pass.setFont(font1);
		pass.setBounds(150,90, 250, 50);
		p2.add(password);
		p2.add(pass);

		JLabel not = new JLabel("Don't Have Account? ");
		not.setFont(font);
		not.setBounds(20,200, 200, 70);
		p2.add(not);
		
		JButton Registerbtn = new JButton("Click Here");
		Registerbtn.setBounds(180,220, 110,30);
		Registerbtn.setFont(font);
		p2.add(Registerbtn);

		// .........................Log in Button................................//

		JButton loginbtn = new JButton("Login");
		loginbtn.setBounds(290, 160, 110, 40);
		loginbtn.setFont(new Font("Arial",Font.BOLD,25));
		p2.add(loginbtn);
		
		
		
		ImageIcon home = new ImageIcon(new ImageIcon("D:\\6th semester\\JAVA\\project\\r.jpg").getImage().getScaledInstance(500,320,0));
		JLabel img = new JLabel();
		img.setBounds(0,0,500,320);
		img.setIcon(home);
		p2.add(img);

		setVisible(true);

		Registerbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new registerForm();
			}
		});
		setVisible(true);
		
		
		loginbtn.addActionListener(new ActionListener() {
			
			 

			@Override
			public void actionPerformed(ActionEvent e) {
				String email = t1.getText(); 
				String password = pass.getText();
				
				Dbconnect db = new Dbconnect ();
				
				String querylogin = "SELECT * FROM `register`";
				
				db.login(querylogin, email, password);
				dispose();
			}
			
		});
	}
}
