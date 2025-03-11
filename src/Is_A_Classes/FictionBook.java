package Is_A_Classes;

import MainAndSystemClasses.BookITSys;
import Has_A_Classes.*;

public class FictionBook extends Book {
	
	private String subCategory;
	
	public FictionBook() {
		super();
		subCategory = "No Sub-Category";
	}
	
	public FictionBook(int bookID, String author, String title, String subCategory) {
		super(bookID, author, title);
		this.subCategory = subCategory;
	}

	@Override
	public String displayCategory() {
		String out = "";
		
		for (Book b : BookITSys.books) {
			if (b instanceof FictionBook) {
				out += b;
			}
		}
		return out;
		
	}
	
	public String getSubCategory() {
		return subCategory;
	}
	
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	@Override
	public String toString() {
		return super.toString() + "FictionBook: " + subCategory + "\n";
	}
	
}
