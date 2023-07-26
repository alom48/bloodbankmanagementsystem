package bloodbankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Homepage extends JFrame {

	public Homepage() {

		setSize(600, 500);
		setDefaultCloseOperation(3);
		setLocationRelativeTo(null);
		setLayout(null);

	 
		Font font = ((new Font("Arial", Font.BOLD, 25)));
		 

		JPanel p1 = new JPanel();
		p1.setBounds(0, 0, 600, 80);
		p1.setBackground(new Color(51, 153, 153));
		p1.setLayout(null);

		JLabel label1 = new JLabel("Homepage");
		label1.setBounds(0, 0, 600, 80);
		label1.setHorizontalAlignment(label1.CENTER);
		label1.setFont(new Font("Arial",Font.BOLD,40));
		label1.setLayout(null);
		p1.add(label1);
		add(p1);

		JPanel p2 = new JPanel();
		p2.setBounds(0, 80, 600, 420);
		p2.setBackground(new Color(255, 102, 102));
		p2.setLayout(null);
		add(p2);

		JButton newDonorbtn = new JButton("Donor Registration");
		newDonorbtn.setBounds(150, 40,300, 40);
		newDonorbtn.setFont(font);
		p2.add(newDonorbtn);

		newDonorbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new newDoner();
			}
		});

		JButton SearchDonor = new JButton("Search Donor ");
		SearchDonor.setBounds(150, 110, 300, 40);
		SearchDonor.setFont(font);
		p2.add(SearchDonor);
		
		SearchDonor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new SearchDonor();
			}
		});

		JButton Bloodrequest = new JButton("Blood Request");
		Bloodrequest.setBounds(150, 175, 300, 40);
		Bloodrequest.setFont(font);
		p2.add(Bloodrequest);
		
		Bloodrequest.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new BloodRequest();
			}
		});
		

		JButton Stockbtn = new JButton("Stock  ");
		Stockbtn .setBounds(150, 245, 300, 40);
		Stockbtn .setFont(font);
		p2.add(Stockbtn );
		Stockbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Stock();
			}
		});

		JButton Aboutusbtn = new JButton("About us");
		Aboutusbtn.setBounds(150, 310, 300, 40);
		Aboutusbtn.setFont(font);
		p2.add(Aboutusbtn);
		
		Aboutusbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Aboutus();
			}
		});
		
		ImageIcon home = new ImageIcon(
				new ImageIcon("D:\\6th semester\\JAVA\\project\\9.jpg").getImage().getScaledInstance(600, 420, 1));
		
		JLabel img = new JLabel();
		img.setBounds(0,0,600,420);
		img.setIcon(home);
		p2.add(img);


		setVisible(true);
	}
}
