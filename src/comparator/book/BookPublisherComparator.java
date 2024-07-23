package comparator.book;

import java.util.Comparator;

import entity.Book;

public class BookPublisherComparator implements Comparator<Book>{

	@Override
	public int compare(Book b1, Book b2) {
		
		return b1.getBpublisher().compareToIgnoreCase(b2.getBpublisher());
	}
}
