package Has_A_Classes;

import java.util.Scanner;

import MainAndSystemClasses.BookITSys;
import Is_A_Classes.*;

public abstract class User {
	protected int userID;
	protected String name;
	protected String email;
	protected String password;
	protected String userType;
	
	public User() {
		userID=0;
		name = "No name";
		email = "No email";
		password = "No password";
		userType = "No type";
	}
	
	public User(int userID, String name, String email, String password, String userType) {
		this.userID= userID;
		this.name=name;
		this.email=email;
		this.password=password;
		this.userType=userType;
	}

	public Book searchBook(String bookName, int bookID) {
		Book searchBook=null;
		searchBook = BookITSys.searchBooks(bookName, bookID);
		return searchBook;
	}
	
	public String viewBorrowedBooks(){
		String out = "";
		for (Book book : BookITSys.books) {
			if (!book.isAvailable()) {
				 out += book.toString();
				}
			}
		return out;
	}
	
	public boolean findId(int userID) {
		return this.userID == userID;
	}

	public int getUserID() {
		return userID;
	}

	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
	public String getUserType() {
		return userType;
	}

	@Override
	 public String toString() {
	  return "\nUser" +"\nUserID=" + userID + "\nName=" + name + "\nEmail=" + email + "\nPassword=" + password + "\n";
	 }
}