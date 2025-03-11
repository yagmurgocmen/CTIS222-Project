package Has_A_Classes;

import MainAndSystemClasses.BookITSys;
import Is_A_Classes.*;

public class Transaction {
	private int transactionID;
	private User user;
	private Book book;
	private int transactionDay, transactionMonth;
	private int dueDay, dueMonth;
	private int returnDay, returnMonth;
	private static final double LATE_FEE_PER_DAY= 3.0;
	private String transactionType;
	
	public Transaction(User user, Book book, String transactionType, int returnDay, int returnMonth, int transactionDay, int transactionMonth) {
		this.user=user;
		this.book=book;
		this.transactionType=transactionType;
		this.returnDay=returnDay;
		this.returnMonth=returnMonth;
		this.transactionDay=transactionDay;
		this.transactionMonth=transactionMonth;
	}
		
	public double calculateLateFee(Book book, int returnDay, int returnMonth, int transactionDay, int transactionMonth) {
	    int[] daysInMonth = BookITSys.DAYS_IN_MONTH;

	    int transactionTotalDays = 0;
	    for (int i = 0; i < transactionMonth - 1; i++) {
	        transactionTotalDays += daysInMonth[i];
	    }
	    transactionTotalDays += transactionDay;

	    int returnTotalDays = 0;
	    for (int i = 0; i < returnMonth - 1; i++) {
	        returnTotalDays += daysInMonth[i];
	    }
	    returnTotalDays += returnDay;

	    int totalDaysDifference = returnTotalDays - transactionTotalDays;

	    int allowedDays = 0;
	    if (book instanceof FictionBook) {
	        allowedDays = 20; // Fiction books
	    } else {
	        allowedDays = 10; // Non-fiction books
	    }

	    int lateDays = totalDaysDifference - allowedDays;

	    if (lateDays <= 0) {
	        return 0.0;
	    }

	    return lateDays * LATE_FEE_PER_DAY;
	}
	public int getTransactionMonth() {
		return transactionMonth;
	}

	public void setTransactionMonth(int transactionMonth) {
		this.transactionMonth = transactionMonth;
	}

	public int getDueMonth() {
		return dueMonth;
	}

	public void setDueMonth(int dueMonth) {
		this.dueMonth = dueMonth;
	}

	public int getReturnMonth() {
		return returnMonth;
	}

	public void setReturnMonth(int returnMonth) {
		this.returnMonth = returnMonth;
	}

	public int getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getTransactionDay() {
		return transactionDay;
	}

	public void setTransactionDay(int transactionDay) {
		this.transactionDay = transactionDay;
	}

	public int getDueDay() {
		return dueDay;
	}

	public void setDueDay(int dueDay) {
		this.dueDay = dueDay;
	}

	public int getReturnDay() {
		return returnDay;
	}

	public void setReturnDay(int returnDay) {
		this.returnDay = returnDay;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getLATE_FEE_PER_DAY() {
		return LATE_FEE_PER_DAY;
	}

	@Override
	public String toString() {
		return "Transaction \ntransactionID=" + transactionID + "\nuser=" + user + "\nbook=" + book + "\ntransactionDay="
				+ transactionDay + "\ntransactionMonth=" + transactionMonth + "\ndueDay=" + dueDay + "\ndueMonth="
				+ dueMonth + "\nreturnDay=" + returnDay + "\nreturnMonth=" + returnMonth + "\ntransactionType=" + transactionType;
	}

}