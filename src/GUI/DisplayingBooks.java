package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Is_A_Classes.*;
import MainAndSystemClasses.BookITSys;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class DisplayingBooks extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the frame.
	 */
	public DisplayingBooks() {
		setTitle("Displaying Books");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(21, 6, 526, 321);
		contentPane.add(scrollPane_1);
		
		JTextArea DisplaytextArea = new JTextArea();
		scrollPane_1.setViewportView(DisplaytextArea);
		
		DisplaytextArea.setText(BookITSys.displayAll());
		
		JRadioButton AdminRdBtn = new JRadioButton("Display Admins");
		AdminRdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(AdminRdBtn.isSelected())
					DisplaytextArea.setText(BookITSys.displayAdmins());
			}
		});
		buttonGroup.add(AdminRdBtn);
		AdminRdBtn.setBounds(6, 334, 141, 23);
		contentPane.add(AdminRdBtn);
		
		JRadioButton UserRdBtn = new JRadioButton("Display Members");
		UserRdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(UserRdBtn.isSelected())
					DisplaytextArea.setText(BookITSys.displayMembers());
			}
		});
		buttonGroup.add(UserRdBtn);
		UserRdBtn.setBounds(6, 369, 141, 23);
		contentPane.add(UserRdBtn);
		
		JRadioButton AvailableRdBtn = new JRadioButton("Display Available Books");
		AvailableRdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(AvailableRdBtn.isSelected())
					DisplaytextArea.setText(BookITSys.displayAvailableBooks());
			}
		});
		buttonGroup.add(AvailableRdBtn);
		AvailableRdBtn.setBounds(6, 404, 182, 23);
		contentPane.add(AvailableRdBtn);
		
		JRadioButton BorrowedRdBtn = new JRadioButton("Display Borrowed Books");
		BorrowedRdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(BorrowedRdBtn.isSelected())
					DisplaytextArea.setText(BookITSys.displayBorrowedBooks());
		
			}
		});
		buttonGroup.add(BorrowedRdBtn);
		BorrowedRdBtn.setBounds(6, 439, 218, 23);
		contentPane.add(BorrowedRdBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(89, 61, 2, 2);
		contentPane.add(scrollPane);
		
		JButton back = new JButton("Go Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				HomePage hp = new HomePage();
				hp.setVisible(true);
			}
		});
		back.setBounds(370, 469, 89, 23);
		contentPane.add(back);
		
		JButton close = new JButton("Close");
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				System.exit(0);
			}
		});
		close.setBounds(469, 469, 89, 23);
		contentPane.add(close);
		
		JRadioButton IDRdBtn = new JRadioButton("Display by ID");
		buttonGroup.add(IDRdBtn);
		IDRdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(IDRdBtn.isSelected())
					DisplaytextArea.setText(BookITSys.displayBooksById());
				
			}
		});
		IDRdBtn.setBounds(231, 334, 141, 23);
		contentPane.add(IDRdBtn);
		
		JRadioButton AuthorRdBtn = new JRadioButton("Display by Author");
		buttonGroup.add(AuthorRdBtn);
		AuthorRdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(AuthorRdBtn.isSelected())
					DisplaytextArea.setText(BookITSys.displayBooksByAuthor());
			}
		});
		AuthorRdBtn.setBounds(231, 369, 196, 23);
		contentPane.add(AuthorRdBtn);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(236, 404, 136, 27);
		contentPane.add(comboBox);
		
		comboBox.addItem("Fiction");
        comboBox.addItem("HistoryBook");
        comboBox.addItem("ScienceBook");

        // Add action listener to display books of selected category
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedCategory = (String) comboBox.getSelectedItem().toString();
                
               if(selectedCategory.equals("Fiction"))
               {
            	   FictionBook fb = new FictionBook();
            	   DisplaytextArea.setText(fb.displayCategory());
               }
               else if(selectedCategory.equals("HistoryBook")) 
               {
            	   HistoryBook hb = new HistoryBook();
            	   DisplaytextArea.setText(hb.displayCategory());
            	   
               }
               else if(selectedCategory.equals("ScienceBook"))
               {
            	   ScienceBook sb = new ScienceBook();
            	   DisplaytextArea.setText(sb.displayCategory());
               }
            
            }
        });
	
	}
}