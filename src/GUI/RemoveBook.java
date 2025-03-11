package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Has_A_Classes.Book;
import MainAndSystemClasses.BookITSys;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RemoveBook extends JFrame {

	private JPanel contentPane;
	private JTextField txtBookName;
	Book b;
	AdminPage ap;

	/**
	 * Create the frame.
	 */
	public RemoveBook() {
		setTitle("Remove Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 387, 231);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBookName = new JLabel("Book Name:");
		lblBookName.setForeground(new Color(128, 64, 64));
		lblBookName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBookName.setBounds(10, 25, 117, 13);
		contentPane.add(lblBookName);
		
		txtBookName = new JTextField();
		txtBookName.setColumns(10);
		txtBookName.setBounds(125, 23, 211, 19);
		contentPane.add(txtBookName);
		
		JLabel InfoLabel = new JLabel("");
		InfoLabel.setForeground(new Color(128, 0, 0));
		InfoLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		InfoLabel.setBounds(10, 105, 326, 13);
		contentPane.add(InfoLabel);
		
		JLabel InfoLabelSuccessful = new JLabel("");
		InfoLabelSuccessful.setForeground(new Color(0, 128, 0));
		InfoLabelSuccessful.setFont(new Font("Tahoma", Font.BOLD, 11));
		InfoLabelSuccessful.setBounds(10, 105, 326, 13);
		contentPane.add(InfoLabelSuccessful);
		
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtBookName.getText().isEmpty())
				{
					b = BookITSys.searchBooks(txtBookName.getText(), 0);
					if(b!=null) {						
						if(BookITSys.books.remove(b))
							InfoLabelSuccessful.setText("The book " + txtBookName.getText() + " is successfully removed.");
						else
							InfoLabel.setText("Cannot remove the " + txtBookName.getText());
					}
					else
						InfoLabel.setText("There is no book as " + txtBookName.getText());
				}
				
				else
					InfoLabel.setText("Please enter a book name!");
			}
		});
		btnRemove.setForeground(new Color(128, 64, 64));
		btnRemove.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRemove.setBounds(227, 53, 109, 21);
		contentPane.add(btnRemove);
		
		JButton backbtn = new JButton("Go Back");
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ap = new AdminPage();
				setVisible(false);
				dispose();
				ap.setVisible(true);				
			}
		});
		backbtn.setForeground(new Color(128, 64, 64));
		backbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		backbtn.setBounds(150, 151, 101, 21);
		contentPane.add(backbtn);
		
		JButton closebtn = new JButton("Close");
		closebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
				System.exit(0);
			}
		});
		closebtn.setForeground(new Color(128, 64, 64));
		closebtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		closebtn.setBounds(275, 151, 94, 21);
		contentPane.add(closebtn);
		
		
	
	}
}
