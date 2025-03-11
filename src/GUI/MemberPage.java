package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberPage extends JFrame {

	private JPanel contentPane;

	HomePage hp;
	MemberLoginPage mlp;
	BorrowBook bb;
	ReturnBook rb;
	DisplayingBooks db;
	SearchBook sb;
	/**
	 * Create the frame.
	 */
	public MemberPage() {
		setTitle("Member Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 281, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton borrowbtn = new JButton("Borrow Book");
		borrowbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bb = new BorrowBook();
				setVisible(false);
				dispose();
				bb.setVisible(true);
			}
		});
		borrowbtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		borrowbtn.setForeground(new Color(128, 64, 64));
		borrowbtn.setBounds(10, 30, 245, 21);
		contentPane.add(borrowbtn);
		
		JButton returnbtn = new JButton("Return Book");
		returnbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rb = new ReturnBook();
				setVisible(false);
				dispose();
				rb.setVisible(true);
			}
		});
		returnbtn.setForeground(new Color(128, 64, 64));
		returnbtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		returnbtn.setBounds(10, 79, 245, 21);
		contentPane.add(returnbtn);
		
		JButton displaybtn = new JButton("Display Books");
		displaybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				db = new DisplayingBooks();
				db.setVisible(true);
			}
		});
		displaybtn.setForeground(new Color(128, 64, 64));
		displaybtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		displaybtn.setBounds(10, 129, 245, 21);
		contentPane.add(displaybtn);
		
		JButton searchbtn = new JButton("Search Book");
		searchbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				sb = new SearchBook();
				sb.setVisible(true);
			}
		});
		searchbtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		searchbtn.setForeground(new Color(128, 64, 64));
		searchbtn.setBounds(10, 181, 245, 21);
		contentPane.add(searchbtn);
		
		JButton backbtn = new JButton("Go Back");
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				mlp = new MemberLoginPage(hp);
				mlp.setVisible(true);
			}
		});
		backbtn.setForeground(new Color(128, 64, 64));
		backbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		backbtn.setBounds(58, 229, 100, 21);
		contentPane.add(backbtn);
		
		JButton closebtn = new JButton("Close");
		closebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				System.exit(0);
			}
		});
		closebtn.setForeground(new Color(128, 64, 64));
		closebtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		closebtn.setBounds(170, 229, 85, 21);
		contentPane.add(closebtn);
	}
}
