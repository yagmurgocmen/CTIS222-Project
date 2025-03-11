package BookComparator;
import java.util.Comparator;

import Has_A_Classes.Book;

public class BookComparator implements Comparator<Book>{
	@Override
	public int compare(Book o1, Book o2) {
		return o1.getAuthor().compareTo(o2.getAuthor());
	}
}
