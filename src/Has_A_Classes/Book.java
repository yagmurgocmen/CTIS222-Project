package Has_A_Classes;

import java.util.Objects;
import Interface.BookInterface;
import MainAndSystemClasses.BookITSys;

public abstract class Book implements BookInterface, Comparable<Book>{

	protected int bookID;
	protected String author, title;
	protected boolean available = true;
	protected int borrowedUserID = 0; 	
	
	public Book() {
		bookID = 0;
		author = "No author";
		title = "No title";
		available = true;
		borrowedUserID=0;
	}
	
	public Book(int bookID, String author, String title) {
		this.bookID = bookID;
		this.author = author;
		this.title = title;
	}
	
	public int getBookID() {
		return bookID;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getTitle() {
		return title;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	
	public void setAuthor(String author) {
		this.author = author;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public boolean isAvailable() {
		return available;
	}
	
	public void setAvailable(boolean available) {
		this.available = available;
	}

	public void toggleAvailability() {
		this.available =!this.available;
	}
	
	public int getBorrowedUserID() {
		return borrowedUserID;
	}

	public void setBorrowedUserID(int borrowedUserID) {
		this.borrowedUserID = borrowedUserID;
	}

	public abstract String displayCategory();
	
	@Override
	public boolean borrow(int bookID, int borrowedUserID) {
		for (Book book : BookITSys.books) {
			if (book.isAvailable()) {
				if (book.getBookID()==bookID) {
					book.toggleAvailability();
					book.setBorrowedUserID(borrowedUserID);
					System.out.println("Book is successfully borrowed!");
					return true;
				}
			}
		}
		System.out.println("Book cannot be borrowed!");
		return false;
	}
	
	@Override
	public boolean returningBook(int bookID) {
		for (Book book : BookITSys.books) {			
			if (book.getBookID()==bookID) {
				if (book.isAvailable()) {
					System.out.println("Book has not been borrowed");
					return false;
				}
				else {
					book.setBorrowedUserID(0);
					book.toggleAvailability();
				}
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return bookID == other.bookID;
	}
	
	@Override
	public int compareTo(Book o) {
		return bookID - o.getBookID();
	}

	@Override
	 public String toString() {
	  return "\nBookID: " + bookID + "\nauthor: " + author + "\ntitle: " + title + "\navailable: " + available
	    + "\nborrowedUserID: " + borrowedUserID + "\n";
	 }
	
}