package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import entity.Book;
import entity.Librarian;
import entity.Student;

public interface LibraryRepository {
	ArrayList<Book> bk=new ArrayList<Book>();
	
	LinkedHashMap<String,Librarian> ld=new LinkedHashMap<String,Librarian>();
	
	HashMap<Student, Book> st=new LinkedHashMap<Student, Book>();
}
