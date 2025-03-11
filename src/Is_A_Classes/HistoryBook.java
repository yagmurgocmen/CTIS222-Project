package Is_A_Classes;

import MainAndSystemClasses.BookITSys;
import Has_A_Classes.*;

public class HistoryBook extends Book {
	
	private String period;
	
	public HistoryBook() {
		super();
		period = "No period";
	}

	public HistoryBook(int bookID, String author, String title, String period) {
		super(bookID,author, title);
		this.period=period;
	}

	@Override
	public String displayCategory() {
		String out = "";
		
		for (Book b : BookITSys.books) {
			if (b instanceof HistoryBook) {
				out += b;
			}
		}
		return out;
		
	}
	
	public String getPeriod() {
		return period;
	}
	
	public void setPeriod(String period) {
		this.period = period;
	}

	@Override
	public String toString() {
		return super.toString() + "Period: " + period + "\n";
	}

}
