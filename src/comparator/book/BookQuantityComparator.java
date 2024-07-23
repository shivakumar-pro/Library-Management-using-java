package comparator.book;

import java.util.Comparator;

import entity.Book;

public class BookQuantityComparator implements Comparator<Book>{

	@Override
	public int compare(Book b1, Book b2) {
		
		if(b1.getBquantity()==b2.getBquantity())  
			return 0;  
			else if(b1.getBquantity()>b2.getBquantity())  
			return 1;  
			else  
			return -1;  
		
		
	}

}
