package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class HomePage extends JFrame {

	private JPanel contentPane;
	
	MemberPage mp = new MemberPage();
	AdminPage ap = new AdminPage();
	NewMember nm = new NewMember(this);
	AdminLoginPage alp = new AdminLoginPage(this);
	MemberLoginPage mlp;

	/**
	 * Create the frame.
	 */
	public HomePage() {
		setTitle("Home Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		mlp = new MemberLoginPage(this);
		
		JLabel lblNewLabel = new JLabel("Welcome to BookIt!");
		lblNewLabel.setFont(new Font("Wide Latin", Font.BOLD, 15));
		lblNewLabel.setBounds(69, 44, 357, 13);
		contentPane.add(lblNewLabel);
		
		JButton memberLoginbtn = new JButton("Member Login");
		memberLoginbtn.setFont(new Font("Tahoma", Font.BOLD, 10));
		memberLoginbtn.setForeground(new Color(128, 64, 64));
		memberLoginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				mlp.setVisible(true);
			}
		});
		memberLoginbtn.setBounds(10, 124, 135, 21);
		contentPane.add(memberLoginbtn);
		
		JButton adminLoginbtn = new JButton("Admin Login");
		adminLoginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				alp.setVisible(true);
			}
		});
		adminLoginbtn.setFont(new Font("Tahoma", Font.BOLD, 10));
		adminLoginbtn.setForeground(new Color(128, 64, 64));
		adminLoginbtn.setBounds(150, 124, 135, 21);
		contentPane.add(adminLoginbtn);
		
		JButton newMemberbtn = new JButton("New Member");
		newMemberbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				nm.setVisible(true);
			}
		});
		newMemberbtn.setFont(new Font("Tahoma", Font.BOLD, 10));
		newMemberbtn.setForeground(new Color(128, 64, 64));
		newMemberbtn.setBounds(291, 124, 135, 21);
		contentPane.add(newMemberbtn);
		
		JButton closebtn = new JButton("CLOSE");
		closebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
		closebtn.setFont(new Font("Tahoma", Font.BOLD, 10));
		closebtn.setBounds(341, 232, 85, 21);
		contentPane.add(closebtn);
	}
}
