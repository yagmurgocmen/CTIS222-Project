package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Has_A_Classes.*;
import Is_A_Classes.*;
import MainAndSystemClasses.BookITSys;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class ReturnBook extends JFrame {

    private JPanel contentPane;
    private JTextField bookname;
    private User currentUser; // User who is returning the book
    private Book currentBook; // The book being returned

    int daysInMonth;
    int returnDay;
    int selectedMonth;
    private JTextField memberid;

    /**
     * Create the frame.
     */
    public ReturnBook() {
        setTitle("Return Book");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel bookNametxt = new JLabel("Book Name:");
        bookNametxt.setForeground(new Color(128, 64, 64));
        bookNametxt.setFont(new Font("Tahoma", Font.BOLD, 13));
        bookNametxt.setBounds(42, 56, 117, 13);
        contentPane.add(bookNametxt);

        bookname = new JTextField();
        bookname.setColumns(10);
        bookname.setBounds(157, 54, 211, 19);
        contentPane.add(bookname);

        JLabel lblReturnDay = new JLabel("Return Day: ");
        lblReturnDay.setForeground(new Color(128, 64, 64));
        lblReturnDay.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblReturnDay.setBounds(261, 147, 94, 13);
        contentPane.add(lblReturnDay);
        
        JLabel info = new JLabel("");
        info.setBounds(42, 190, 326, 14);
        contentPane.add(info);

        JComboBox<Integer> ReturnDaycomboBox = new JComboBox<>();
        ReturnDaycomboBox.setEnabled(false);
        ReturnDaycomboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                returnDay = ReturnDaycomboBox.getSelectedIndex();
            }
        });

        ReturnDaycomboBox.setBounds(353, 144, 51, 21);
        contentPane.add(ReturnDaycomboBox);

        JLabel ReturnMonth = new JLabel("Return Month:");
        ReturnMonth.setForeground(new Color(128, 64, 64));
        ReturnMonth.setFont(new Font("Tahoma", Font.BOLD, 13));
        ReturnMonth.setBounds(31, 150, 109, 13);
        contentPane.add(ReturnMonth);

        JComboBox<String> ReturnMonthcomboBox = new JComboBox<>();
        ReturnMonthcomboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectedMonth = ReturnMonthcomboBox.getSelectedIndex();
                daysInMonth = BookITSys.DAYS_IN_MONTH[selectedMonth];

                ReturnDaycomboBox.removeAllItems();

                for (int i = 1; i <= daysInMonth; i++) {
                    ReturnDaycomboBox.addItem(i);
                }

                ReturnDaycomboBox.setEnabled(true);
            }
        });

        String[] months = new String[] {
            "January", "February", "March", "April", "May", "June", 
            "July", "August", "September", "October", "November", "December"
        };

        for (String month : months) {
            ReturnMonthcomboBox.addItem(month);
        }

        ReturnMonthcomboBox.setBounds(134, 144, 95, 21);
        contentPane.add(ReturnMonthcomboBox);

        JButton backbtn = new JButton("Go Back");
        backbtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		MemberPage mp = new MemberPage();
        		setVisible(false);
        		mp.setVisible(true);        		
        	}
        });
        backbtn.setForeground(new Color(128, 64, 64));
        backbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
        backbtn.setBounds(169, 232, 101, 21);
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
        closebtn.setBounds(292, 232, 94, 21);
        contentPane.add(closebtn);

        JButton btnReturn = new JButton("Return");
        btnReturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentUser = BookITSys.searchUsers(Integer.parseInt(memberid.getText()));
                currentBook = BookITSys.searchBooks(bookname.getText(), 0);

                if (currentUser != null && currentBook != null) {
                	if (currentBook.getBorrowedUserID()==Integer.parseInt(memberid.getText())){
                		currentBook.toggleAvailability();
                    	currentBook.setBorrowedUserID(0);
                    	
                        Transaction transaction = new Transaction(currentUser, currentBook, "Return",
                                returnDay, selectedMonth + 1, 15, 12); // Example transaction day and month
                        
                    
                        int transactionDay;
                        int transactionMonth;
                        double lateFee = 0.0;
                        
                        for (Transaction t : BookITSys.transactions) {
                        	if (t.getUser().getUserID()==currentUser.getUserID()) {
                        		transactionDay = t.getTransactionDay();
                        		transactionMonth = t.getTransactionMonth();
                        		lateFee = transaction.calculateLateFee(currentBook, returnDay, selectedMonth + 1,
                                		transactionDay, transactionMonth);
                        	}
                        	else {
                        		info.setText("Invalid User or Book");
                        	}
                        }                       
                        

                        // Display late fee or no payment message
                        if (lateFee > 0) {
                        	info.setText("Payment of " + lateFee + " is needed");
                        } else {
                        	info.setText("No payment needs to be made.");
                        }
                	}
                	else {
                    	info.setText("You did not borrow this book!");
                	}
                	
                } else {
                	info.setText("Invalid User or Book");
                }
            }
        });
        btnReturn.setForeground(new Color(128, 64, 64));
        btnReturn.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnReturn.setBounds(154, 96, 101, 21);
        contentPane.add(btnReturn);

        JLabel lblMemberId = new JLabel("Member ID:");
        lblMemberId.setForeground(new Color(128, 64, 64));
        lblMemberId.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblMemberId.setBounds(42, 29, 94, 13);
        contentPane.add(lblMemberId);

        memberid = new JTextField();
        memberid.setColumns(10);
        memberid.setBounds(157, 26, 211, 19);
        contentPane.add(memberid);
       
    }
}