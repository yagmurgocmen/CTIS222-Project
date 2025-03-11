package Is_A_Classes;

import java.util.LinkedList;

import Has_A_Classes.*;

public class Member extends User {
    private LinkedList<Book> borrowedBooks;
    private static final int MAX_BORROW_LIMIT=3;//Maximum books allowed per user
   	
    public Member () {
    	super();
    	borrowedBooks = null;
    }
    
    public Member(int userID, String name, String email, String password, String userType) {
    	super(userID, name, email, password, userType);
    	this.borrowedBooks = new LinkedList<>();
    }

	public boolean borrowBook(int userID, Book book) {
    	if(borrowedBooks.size() > MAX_BORROW_LIMIT) {
    		System.out.println("Borrowing limit reached! You can only borrow up to " + MAX_BORROW_LIMIT + "books");
    		return false;
    	}
    	
    	if (book.isAvailable()) {
    		borrowedBooks.addLast(book);
    		book.borrow(book.getBookID(), userID);
    		System.out.println("Book borrowed successfully: " + book.getTitle());
    		return true;
    	}
    	else {
    		System.out.println("Book is not available: " + book.getTitle());
        	return false;
    	}
    	
    }
    	
   public boolean returnBook(int userID, Book book) {
    	if (borrowedBooks.contains(book)) {
    		if (book.getBorrowedUserID()==userID) {
    			borrowedBooks.remove(book);
        		book.returningBook(book.getBookID());
        		System.out.println("Book returned successfully: " + book.getTitle());
        		return true;
    		}
    		else {
    			System.out.println("You did not borrowed this book, so you cannot return it.");
    		}
    	}
    	
    	System.out.println("Book not found in borrowed list: " + book.getTitle());
    	return false;
    }
    
    public String displayBorrowedBooks(int memberID) {
    	String out = "";
    	for (Book b : borrowedBooks) {
    		if (b.getBorrowedUserID()==memberID)
    			out += b.toString() + "\n";
		}
    	return out;
    }

	@Override
	public String toString() {
		return super.toString();
	}
    
}