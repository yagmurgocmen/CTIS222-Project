package Is_A_Classes;

import MainAndSystemClasses.BookITSys;
import Has_A_Classes.*;

public class ScienceBook extends Book {
	private String field;
	
	public ScienceBook() {
		super();
		field = "No field";
	}
	
	public ScienceBook(int bookID,String author, String title, String field) {
		super(bookID,author, title);
		this.field=field;
	}

	@Override
	public String displayCategory() {
		String out = "";
		
		for (Book b : BookITSys.books) {
			if (b instanceof ScienceBook) {
				out += b;
			}
		}
		return out;		
	}
	
	public String getField() {
		return field;
	}
	
	public void setField (String field) {
		this.field = field;
	}

	@Override
	public String toString() {
		return super.toString() + "Field: " + field + "\n";
	}

}
