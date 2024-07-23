package comparator.book;

import java.util.Comparator;

import entity.Book;

public class BookAuthorComparator implements Comparator<Book>{

	@Override
	public int compare(Book b1, Book b2) {
		
		return b1.getBauthor().compareToIgnoreCase(b2.getBauthor());
	}

}
