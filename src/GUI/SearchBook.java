package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MainAndSystemClasses.BookITSys;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchBook extends JFrame {

	private JPanel contentPane;
	private JTextField BookNametxt;
	
	HomePage hp;

	/**
	 * Create the frame.
	 */
	public SearchBook() {
		setTitle("Search Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book Name:");
		lblNewLabel.setForeground(new Color(128, 64, 64));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(41, 40, 117, 13);
		contentPane.add(lblNewLabel);
		
		BookNametxt = new JTextField();
		BookNametxt.setColumns(10);
		BookNametxt.setBounds(156, 38, 211, 19);
		contentPane.add(BookNametxt);
		
		JTextArea BookInformationtextArea = new JTextArea();
		BookInformationtextArea.setBounds(41, 147, 326, 130);
		contentPane.add(BookInformationtextArea);
		
		JLabel lblNewLabel_1 = new JLabel("Book Information");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setForeground(new Color(128, 64, 64));
		lblNewLabel_1.setBounds(141, 123, 140, 13);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Go Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				hp = new HomePage();
				hp.setVisible(true);
			}
		});
		btnNewButton.setBounds(205, 299, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(305, 299, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookInformationtextArea.setText(BookITSys.searchBooks(BookNametxt.getText(), 0).toString());
			}
		});
		btnSearch.setBounds(41, 77, 326, 23);
		contentPane.add(btnSearch);
	}

}
