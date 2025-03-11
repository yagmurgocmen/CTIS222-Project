package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MainAndSystemClasses.BookITSys;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewMember extends JFrame {

	private JPanel contentPane;
	private JTextField userIDtxt;
	private JTextField nameTxt;
	private JTextField emailTxt;
	private JTextField passwordTxt;

	HomePage hp;
	
	/**
	 * Create the frame.
	 */
	public NewMember(HomePage frame) {
		hp = frame;
		setTitle("New Member");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserID:");
		lblNewLabel.setForeground(new Color(128, 64, 64));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(24, 51, 73, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setForeground(new Color(128, 64, 64));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(24, 88, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email:");
		lblNewLabel_2.setForeground(new Color(128, 64, 64));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(24, 122, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password:");
		lblNewLabel_3.setForeground(new Color(128, 64, 64));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(24, 156, 73, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel InfoLabelFail = new JLabel("");
		InfoLabelFail.setForeground(new Color(128, 0, 0));
		InfoLabelFail.setBounds(52, 183, 286, 13);
		contentPane.add(InfoLabelFail);
		
		JLabel InfoLabelSuccessful = new JLabel("");
		InfoLabelSuccessful.setForeground(new Color(0, 128, 0));
		InfoLabelSuccessful.setBounds(52, 183, 286, 13);
		contentPane.add(InfoLabelSuccessful);
		
		JButton backbtn = new JButton("Go Back");
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				hp.setVisible(true);	
			}
		});
		backbtn.setForeground(new Color(128, 64, 64));
		backbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		backbtn.setBounds(266, 275, 108, 21);
		contentPane.add(backbtn);
		
		userIDtxt = new JTextField();
		userIDtxt.setBounds(138, 48, 200, 19);
		contentPane.add(userIDtxt);
		userIDtxt.setColumns(10);
		
		nameTxt = new JTextField();
		nameTxt.setBounds(138, 88, 200, 19);
		contentPane.add(nameTxt);
		nameTxt.setColumns(10);
		
		emailTxt = new JTextField();
		emailTxt.setBounds(138, 119, 200, 19);
		contentPane.add(emailTxt);
		emailTxt.setColumns(10);
		
		passwordTxt = new JTextField();
		passwordTxt.setBounds(138, 153, 200, 19);
		contentPane.add(passwordTxt);
		passwordTxt.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (BookITSys.registerUser(Integer.parseInt(userIDtxt.getText()), nameTxt.getText(), emailTxt.getText(), passwordTxt.getText(), "Member")) {
					InfoLabelFail.setText("");
					InfoLabelSuccessful.setText("User is successfully added to the system.");
				}
				else {
					InfoLabelSuccessful.setText("");
					InfoLabelFail.setText("Cannot register, user already exists.");
				}
				
			}
		});
		btnRegister.setForeground(new Color(128, 64, 64));
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegister.setBounds(138, 220, 121, 32);
		contentPane.add(btnRegister);
		
		
	}

}
