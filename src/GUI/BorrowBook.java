package GUI;

import java.awt.EventQueue;

import Has_A_Classes.*;
import Is_A_Classes.*;
import MainAndSystemClasses.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MainAndSystemClasses.BookITSys;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.*;

public class BorrowBook extends JFrame {

	private JPanel contentPane;
	private JTextField bookNametxt;
	private JTextField memberid;

	/**
	 * Create the frame.
	 */
	
	private int getDaysInMonth(int month) {
		int year= Calendar.getInstance().get(Calendar.YEAR);
		switch(month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
			return 31;
		case 4:
		case 6:
		case 9: 
		case 11:
			return 30;
		case 2:
			if(year % 4 == 0 )
				return 29;
			else 
				return 28;
		default:
			return 0;
		}
			
	
}
	public BorrowBook() {
		setTitle("Borrow Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 404, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book Name:");
		lblNewLabel.setForeground(new Color(128, 64, 64));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(36, 56, 94, 13);
		contentPane.add(lblNewLabel);
		
		JButton backbtn = new JButton("Go Back");
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MemberPage memberPage = new MemberPage();
				memberPage.setVisible(true);
			}
		});
		backbtn.setForeground(new Color(128, 64, 64));
		backbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		backbtn.setBounds(163, 232, 101, 21);
		contentPane.add(backbtn);
		
		JButton closebtn = new JButton("Close");
		closebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		closebtn.setForeground(new Color(128, 64, 64));
		closebtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		closebtn.setBounds(286, 232, 94, 21);
		contentPane.add(closebtn);
		
		JLabel lblDueDay = new JLabel("Due Day");
		lblDueDay.setForeground(new Color(128, 64, 64));
		lblDueDay.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDueDay.setBounds(223, 121, 75, 13);
		contentPane.add(lblDueDay);
		
		JLabel lblDueMonth = new JLabel("Due Month");
		lblDueMonth.setForeground(new Color(128, 64, 64));
		lblDueMonth.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDueMonth.setBounds(36, 124, 75, 13);
		contentPane.add(lblDueMonth);
		
		bookNametxt = new JTextField();
		bookNametxt.setBounds(151, 54, 211, 19);
		contentPane.add(bookNametxt);
		bookNametxt.setColumns(10);
		
		JComboBox DueDaycomboBox = new JComboBox();
		DueDaycomboBox.setBounds(311, 118, 51, 21);
		contentPane.add(DueDaycomboBox);
				
		JComboBox DueMonthcomboBox = new JComboBox();
		DueMonthcomboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedMonth= DueMonthcomboBox.getSelectedIndex() +1;
				int daysInMonth= getDaysInMonth(selectedMonth);
				
				for(int day = 1; day <= daysInMonth ; day++) {
					DueDaycomboBox.addItem(String.valueOf(day));
				}
				
			}
		});
		DueMonthcomboBox.setBounds(137, 121, 51, 21);
		contentPane.add(DueMonthcomboBox);
		
		for(int month=1; month <= 12; month++) {
			DueMonthcomboBox.addItem(String.valueOf(month));
		}		
		
		JLabel info = new JLabel("");
		info.setBounds(36, 194, 344, 13);
		contentPane.add(info);
		
		JButton borrowbtn = new JButton("Borrow");
		borrowbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookName=bookNametxt.getText();
				int dueDay = DueDaycomboBox.getSelectedIndex() + 1;
				int dueMonth = DueMonthcomboBox.getSelectedIndex() + 1;
				
				
				
				Book book = BookITSys.searchBooks(bookName, 0);
							
				if(book != null && book.isAvailable()) {
					int userid = Integer.parseInt(memberid.getText());
					if (BookITSys.searchUsers(userid) == null) {
						info.setText("There is no such user!");
					} 
					else {
						if(book.borrow(book.getBookID(), userid)) {
							BookITSys.generateTransaction(BookITSys.searchUsers(userid), book, "Borrow", 0 ,0, dueDay, dueMonth);
							info.setText("Book borrowed successfully");
						}
						else {
							info.setText("Failed to borrow book.");
						}
					}					
				}
				else {
					info.setText("Book not found.");
				}
			}
		});
		borrowbtn.setForeground(new Color(128, 64, 64));
		borrowbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		borrowbtn.setBounds(261, 153, 101, 21);
		contentPane.add(borrowbtn);
		
		JLabel lblMemberId = new JLabel("Member ID:");
		lblMemberId.setForeground(new Color(128, 64, 64));
		lblMemberId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMemberId.setBounds(36, 24, 94, 13);
		contentPane.add(lblMemberId);
		
		memberid = new JTextField();
		memberid.setColumns(10);
		memberid.setBounds(151, 21, 211, 19);
		contentPane.add(memberid);
		
		
	}
}