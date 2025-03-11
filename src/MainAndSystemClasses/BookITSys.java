package MainAndSystemClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import Has_A_Classes.*;
import Is_A_Classes.*;
import BookComparator.BookComparator;

public class BookITSys {
	private static ArrayList<User> users = new ArrayList<User>();
	public static Set<Book> books = new HashSet<Book>();
	public static ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	public static final int[] DAYS_IN_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	public static boolean readBooks() throws FileNotFoundException {
		File file = new File("books.txt");
		
		if (!file.exists()) {
			return false;
		}
		
		Scanner input = new Scanner(file);
		
		int bookID;
		String author; 
		String title;
		String bookType;
		String extraDetail;
		
		while (input.hasNext()) {
			bookID = input.nextInt();
			author = input.next();
			title = input.next();
			bookType = input.next();
			extraDetail = input.nextLine();
			
			if (bookType.equals("Science")) {
				ScienceBook sBook = new ScienceBook(bookID, author, title, extraDetail);
				books.add(sBook);
			}
			else if (bookType.equals("History")) {
				HistoryBook hBook = new HistoryBook(bookID, author, title, extraDetail);
				books.add(hBook);
			}
			else {
				FictionBook fBook = new FictionBook(bookID, author, title, extraDetail);
				books.add(fBook);
			}
		}
		
		return true;
	}
	public static boolean readUsers() throws FileNotFoundException {
		File file = new File("admins.txt");
		
		if (!file.exists()) {
			return false;
		}
		
		Scanner input = new Scanner(file);
		
		int userID;
		String name;
		String email;
		String password;
		
		while (input.hasNext()) {
			userID = input.nextInt();
			name = input.next();
			email = input.next();
			password = input.next();
			
			Admin admin = new Admin(userID, name, email, password, "admin");
			users.add(admin);
		}
		
		return true;
	}
	
    public static int calculateDateDifference(int borrowDay, int borrowMonth, int returnDay, int returnMonth) {
        int totalDays1 = convertToDays(borrowDay, borrowMonth);
        int totalDays2 = convertToDays(returnDay, returnMonth);

        return totalDays1-totalDays2;
    }

    private static int convertToDays(int day, int month) {
        int days = 0;

        for (int i = 0; i < month - 1; i++) {
            days += DAYS_IN_MONTH[i];
        }

        days += day;  // Add the remaining days of the current month

        return days;
    }
    
	public static String displayBooksById() {
		String out = "";
		
		TreeSet<Book> ts = new TreeSet<Book>();
		
		ts.addAll(books);
		
		for (Book b : ts) {
			out += b.toString() + "\n";
		}
		
		return out;		
	}
	
	public static String displayBooksByAuthor() {
		String out = "";
		
		TreeSet<Book> ts = new TreeSet<Book>(new BookComparator());
		
		ts.addAll(books);
		
		for (Book b : ts) {
			out += b.toString() + "\n";
		}
		
		return out;		
	}
	
	public static String displaySelectedCategory(String category) {
		String out = ""; 
		if (category.equals("Science")) {
			FictionBook temp = new FictionBook();
			out = temp.displayCategory();
		}
		else if (category.equals("History")) {
			HistoryBook temp = new HistoryBook();
			out = temp.displayCategory();
		}
		else {
			ScienceBook temp = new ScienceBook();
			out = temp.displayCategory();
		}
		return out;
	}
	
	public static boolean checkID(int id) {

		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).findId(id)) { 
				return true; //id is found 
			}
		}
		return false; 
	}
	
	public static boolean registerUser(int userID, String name, String email, String password, String userType) {
		User newUser;
		
		if (checkID(userID))
			return false;
		
		if (userType.equals("Member")) {
			newUser = new Member(userID, name, email, password, "Member");
        } 
		else {
			newUser = new Admin(userID, name, email, password, "Admin");
		}
		users.add(newUser);
        return true;
        	
	}	
	
	public static User authenticateUser(String email, String password, String userType) {
        for (int i = 0; i<users.size(); i++) {
            if (users.get(i).getEmail().equals(email) && users.get(i).getPassword().equals(password) && users.get(i).getUserType().equalsIgnoreCase(userType)) {
                return users.get(i);
            }
        }

        return null;
    }
	
	public static Transaction generateTransaction(User user, Book book, String transactionType, int returnDay, int returnMonth, int transactionDay, int transactionMonth ) { //type is return or borrow
        Transaction transaction = new Transaction(user, book, transactionType, returnDay, returnMonth, transactionDay, transactionMonth);
        transactions.add(transaction);
        System.out.println("Transaction generated!");
        return transaction;
    }
	
	public static Book searchBooks(String bookName, int bookID) {
		Book temp = null;
		for (Book book: books) {
			if (book.getTitle().equalsIgnoreCase(bookName) || book.getBookID() == bookID)
				return book;			
		}
		return temp;
	}
	
	public static User searchUsers(int userID) {
		User temp = null;
		for (User user: users) {
			if (user.getUserID()==userID)
				return user;			
		}
		return temp;
	}
	
	public static String displayMembers() {
		String out = "";
		for (User user: users) {
			if (user instanceof Member) {
				out += user.toString();
			}
		}
		return out;
	}
	
	public static String displayAdmins() {
		String out = "";
		for (User user : users) {
			if (user instanceof Admin) {
				out += user.toString();
			}
		}
		return out;
	}
	
	public static String displayAvailableBooks() {
		String out = "";
		for (Book book: books) {
				if(book.isAvailable())
				out += book.toString();
			}
		return out;
	}
	
	public static String displayBorrowedBooks() {
		String out = "";
		for (Book book: books) {
				if(!book.isAvailable())
				out += book.toString();
			}
		return out;
	}
	
	public static String displayAll() {
	    String output = "";

	    // Display all users with their associated books
	    for (Transaction transaction : transactions) {
	        User user = transaction.getUser();
	        Book book = transaction.getBook();

	        // Format the output line
	        output += "UserID: " + user.getUserID() +
	                  " Name: " + user.getName() +
	                  " BookID: " + book.getBookID() +
	                  " BookName: " + book.getTitle() + 
	                  " Author:" + book.getAuthor()+"\n";
	    }

	    return output;
	}
	
	public static String displayTransactions() {
		String out = "";
		for (Transaction transaction: transactions) {
				out += transaction.toString();
			}
		return out;
	}
		
}
