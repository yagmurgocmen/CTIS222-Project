package GUI;

import java.awt.EventQueue;
import Has_A_Classes.Book;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Is_A_Classes.Admin;
import MainAndSystemClasses.BookITSys;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import Is_A_Classes.*;

public class AddBook extends JFrame {

	private JPanel contentPane;
	private JTextField Authortxt;
	private JTextField titletxt;
	
	Admin admin = new Admin();
	private JTextField txtBookID;
	
	AdminPage ap;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField extraTxt;

	/**
	 * Create the frame.
	 */
	public AddBook() {
		setTitle("AddBook");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setForeground(new Color(128, 64, 64));
		lblAuthor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAuthor.setBounds(10, 95, 117, 13);
		contentPane.add(lblAuthor);
		
		JLabel extra = new JLabel("");
		extra.setForeground(new Color(128, 64, 64));
		extra.setFont(new Font("Tahoma", Font.BOLD, 13));
		extra.setBounds(10, 235, 117, 13);
		contentPane.add(extra);
		
		Authortxt = new JTextField();
		Authortxt.setColumns(10);
		Authortxt.setBounds(125, 91, 345, 19);
		contentPane.add(Authortxt);
		
		JLabel lblTittle = new JLabel("Title:");
		lblTittle.setForeground(new Color(128, 64, 64));
		lblTittle.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTittle.setBounds(10, 137, 117, 13);
		contentPane.add(lblTittle);
		
		titletxt = new JTextField();
		titletxt.setColumns(10);
		titletxt.setBounds(125, 133, 345, 19);
		contentPane.add(titletxt);
		
		JLabel Categorylbl = new JLabel("Category:");
		Categorylbl.setForeground(new Color(128, 64, 64));
		Categorylbl.setBounds(10, 179, 103, 18);
		Categorylbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(Categorylbl);
		
		JLabel lblBookID = new JLabel("Book ID: ");
		lblBookID.setForeground(new Color(128, 64, 64));
		lblBookID.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBookID.setBounds(10, 45, 107, 16);
		contentPane.add(lblBookID);
		
		txtBookID = new JTextField();
		txtBookID.setBounds(125, 44, 345, 19);
		contentPane.add(txtBookID);
		txtBookID.setColumns(10);
		
		JLabel output = new JLabel("");
		output.setBounds(46, 326, 345, 14);
		contentPane.add(output);	
		
		JRadioButton history = new JRadioButton("History");
		history.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				extra.setText("Period: ");
				extraTxt.setEnabled(true);
			}
		});
		buttonGroup.add(history);
		history.setBounds(141, 177, 103, 23);
		contentPane.add(history);
		
		JRadioButton science = new JRadioButton("Science");
		science.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				extra.setText("Field: ");
				extraTxt.setEnabled(true);
			}
		});
		buttonGroup.add(science);
		science.setBounds(277, 177, 117, 23);
		contentPane.add(science);
		
		JRadioButton fiction = new JRadioButton("Fiction");
		fiction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				extra.setText("Sub Category: ");
				extraTxt.setEnabled(true);
			}
		});
		buttonGroup.add(fiction);
		fiction.setBounds(405, 177, 117, 23);
		contentPane.add(fiction);
	
		
		extraTxt = new JTextField();
		extraTxt.setEnabled(false);
		extraTxt.setColumns(10);
		extraTxt.setBounds(125, 231, 345, 19);
		contentPane.add(extraTxt);
		
		JButton addBtn = new JButton("Add");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtBookID.getText().isEmpty() || Authortxt.getText().isEmpty() || titletxt.getText().isEmpty() || extraTxt.getText().isEmpty() || !history.isSelected() && !fiction.isSelected() && !science.isSelected() )
					output.setText("Please fill the necessary areas first.");
				else {
					String category;
					Book book;
					
					if (BookITSys.searchBooks(titletxt.getText(), Integer.parseInt(txtBookID.getText()))==null) {
						if (history.isSelected()) {
							category = "History";
							book = new HistoryBook(Integer.parseInt(txtBookID.getText()), Authortxt.getText(), titletxt.getText(), extra.getText());
						}
						else if (science.isSelected()) {
							category = "Science";
							book = new ScienceBook(Integer.parseInt(txtBookID.getText()), Authortxt.getText(), titletxt.getText(), extra.getText());
						}
						else {
							category = "Fiction";
							book = new FictionBook(Integer.parseInt(txtBookID.getText()), Authortxt.getText(), titletxt.getText(), extra.getText());
						}
						BookITSys.books.add(book);
						output.setText("Successfully added.");

					}				
					else
						output.setText("Book already exists.");
				}
			}
		});
		addBtn.setForeground(new Color(128, 64, 64));
		addBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		addBtn.setBounds(10, 294, 527, 21);
		contentPane.add(addBtn);
		
		JButton backbtn = new JButton("Go Back");
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ap = new AdminPage();
				ap.setVisible(true);
			}
		});
		backbtn.setForeground(new Color(128, 64, 64));
		backbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		backbtn.setBounds(330, 352, 101, 21);
		contentPane.add(backbtn);
		
		JButton closebtn = new JButton("Close");
		closebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
			}
		});
		closebtn.setForeground(new Color(128, 64, 64));
		closebtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		closebtn.setBounds(443, 351, 94, 21);
		contentPane.add(closebtn);
		
		
		
		
	}
}
