package bloodbankmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Aboutus extends JFrame {

	 	public Aboutus() {

			setSize(500, 500);
			setDefaultCloseOperation(3);
			setLocationRelativeTo(null);
			setLayout(null);

			Font font = ((new Font("Arial", Font.BOLD, 10)));
			Font font1 = ((new Font("Arial", Font.BOLD, 30)));
			 

			JPanel p1 = new JPanel();
			p1.setBounds(0, 0, 500, 80);
			p1.setBackground(new Color(51, 153, 153));
			p1.setLayout(null);

			JLabel label1 = new JLabel("About Us");
			label1.setBounds(0, 0, 500, 80);
			label1.setHorizontalAlignment(label1.CENTER);
			label1.setFont(font1);
			label1.setLayout(null);
			p1.add(label1);
			add(p1);
			
			JPanel p2 = new JPanel();
			p2.setBounds(0, 80,500, 420);
			p2.setBackground(new Color(51, 153, 153));
			p2.setLayout(null);
			add(p2);
			
			JTextArea area=new JTextArea("Across Bangladesh, every day there remains an urgent need for all types of blood groups\n"
					 +"Especially donors with rare blood groups such as O Negative, B Negative, and A Negative are in high demand.\n"
					
					 +"Your timely response is essential to the supply of healthy blood for the massive daily demand we face.\n"
                     +"Your donation can save the lives of many, make a difference or\n "
                     + "simply make you feel great about your contribution to humanity.\n"
                     +"Whatever your reason, whatever your motivation\n"
                     + "we welcome you to learn more about the eligibility and \n"
                     +"benefits of donating blood with a trusted organization like us.\n"
                     +"Fostering high-quality, equitable care, transformative research,\n" 
                     +"and innovative education to improve the lives of patients with blood and bone marrow disorders.\n"

                     +"Let us help with any questions you might have.\n "
                     + "Contact our helpful customer service number.\n"
                     +"01777285400\n"
                     
                      +"Donate blood, save lives.");
			area.setEditable(false);
			area.setFont(new Font("Arial",Font.BOLD,15));
		    
            area.setBounds(5,5,475,375);
            JScrollPane sp = new JScrollPane(area,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            sp.setBounds(5,5,475,375);         
	        p2.add(sp);
 				 
			JButton back_btn = new JButton("Back");
	        back_btn.setBounds(30,20,100,50);
	        back_btn.setBackground(new Color(70,130,180));
	        back_btn.setFont(font);
	        //back_btn.setBorder(emptyBorder);
	        p1.add(back_btn);
	        
	        back_btn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					new Homepage();
				}
			});
			
			
			
			setVisible(true);
	
	
}
}