package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminPage extends JFrame {

	private JPanel contentPane;
	AddBook ab = new AddBook();
	HomePage hp;
	RemoveBook rb;
	DisplayingBooks db;
	SearchBook sb;
	/**
	 * Create the frame.
	 */
	public AdminPage() {
		
		setTitle("Admin Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 236);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton addBookbtn = new JButton("Add Book");
		addBookbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ab.setVisible(true);
			}
		});
		addBookbtn.setForeground(new Color(128, 0, 0));
		addBookbtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		addBookbtn.setBounds(113, 25, 197, 21);
		contentPane.add(addBookbtn);
		
		JButton removeBookbtn = new JButton("Remove Book");
		removeBookbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rb = new RemoveBook();
				setVisible(false);
				dispose();			
				rb.setVisible(true);
			}
		});
		removeBookbtn.setForeground(new Color(128, 0, 0));
		removeBookbtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		removeBookbtn.setBounds(113, 57, 197, 21);
		contentPane.add(removeBookbtn);
		
		JButton display = new JButton("Display");
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				db = new DisplayingBooks();
				db.setVisible(true);
			}
		});
		display.setForeground(new Color(128, 0, 0));
		display.setFont(new Font("Tahoma", Font.BOLD, 13));
		display.setBounds(113, 89, 197, 21);
		contentPane.add(display);
		
		JButton backbtn = new JButton("Go Back");
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				hp = new HomePage();
				hp.setVisible(true);
			}
		});
		backbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		backbtn.setForeground(new Color(128, 0, 0));
		backbtn.setBounds(209, 165, 101, 21);
		contentPane.add(backbtn);
		
		JButton SearchBookbtn = new JButton("Search Book");
		SearchBookbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				sb = new SearchBook();
				sb.setVisible(true);
			}
		});
		SearchBookbtn.setForeground(new Color(128, 0, 0));
		SearchBookbtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		SearchBookbtn.setBounds(113, 121, 197, 21);
		contentPane.add(SearchBookbtn);
		
		JButton closebtn = new JButton("Close");
		closebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
				System.exit(0);
			}
		});
		closebtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		closebtn.setForeground(new Color(128, 0, 0));
		closebtn.setBounds(331, 165, 94, 21);
		contentPane.add(closebtn);
	}

}
