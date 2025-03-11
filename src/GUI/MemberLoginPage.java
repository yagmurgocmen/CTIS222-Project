package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MainAndSystemClasses.BookITSys;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberLoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField email;
	private JTextField password;
	HomePage hp;
	MemberPage mp = new MemberPage();

	/**
	 * Create the frame.
	 */
	public MemberLoginPage(HomePage frame) {
		setTitle("Member Login Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 418, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		email = new JTextField();
		email.setBounds(139, 50, 210, 19);
		contentPane.add(email);
		email.setColumns(10);

		password = new JTextField();
		password.setBounds(139, 100, 210, 19);
		contentPane.add(password);
		password.setColumns(10);

		JLabel lblNewLabel = new JLabel("Email:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(44, 52, 45, 13);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(44, 102, 73, 13);
		contentPane.add(lblNewLabel_1);

		JLabel infoLabelFail = new JLabel("");
		infoLabelFail.setForeground(new Color(128, 0, 0));
		infoLabelFail.setFont(new Font("Tahoma", Font.BOLD, 10));
		infoLabelFail.setBounds(44, 145, 305, 13);
		contentPane.add(infoLabelFail);
		
		JLabel infoLabelSuccessful = new JLabel("");
		infoLabelSuccessful.setForeground(new Color(0, 128, 0));
		infoLabelSuccessful.setFont(new Font("Tahoma", Font.BOLD, 10));
		infoLabelSuccessful.setBounds(44, 145, 305, 13);
		contentPane.add(infoLabelSuccessful);

		JButton btnNewButton = new JButton("Go Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				hp = new HomePage();
				hp.setVisible(true);				
			}
		});
		btnNewButton.setForeground(new Color(128, 64, 64));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(295, 263, 97, 31);
		contentPane.add(btnNewButton);
		
		JButton btnLogIn = new JButton("Login");
		btnLogIn.setEnabled(false);
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				mp.setVisible(true);
			}
		});
		btnLogIn.setForeground(new Color(128, 64, 64));
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogIn.setBounds(139, 222, 97, 31);
		contentPane.add(btnLogIn);
		
		JButton btnCheck = new JButton("Check Account Credentials");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (BookITSys.authenticateUser(email.getText(), password.getText(), "Member")== null) {
					infoLabelSuccessful.setText("");
					infoLabelFail.setText("Authentication failed. Invalid credentials!");
				}
				else {
					infoLabelFail.setText("");
					infoLabelSuccessful.setText("Authentication successful! You can Login.");
					btnLogIn.setEnabled(true);
				}
			}
		});
		btnCheck.setForeground(new Color(128, 64, 64));
		btnCheck.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCheck.setBounds(74, 169, 226, 31);
		contentPane.add(btnCheck);
		
		
	}
}
