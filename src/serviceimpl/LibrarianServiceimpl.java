package serviceimpl;

import java.util.Collections;
import java.util.Scanner;

import app.LibApp;
import comparator.book.BookAuthorComparator;
import comparator.book.BookNameComparator;
import comparator.book.BookPublisherComparator;
import comparator.book.BookQuantityComparator;
import dao.LibraryRepository;
import entity.Address;
import entity.Book;
import entity.Librarian;
import entity.Student;
import exception.BookNotFoundException;
import exception.StudentNotFoundException;
import service.LibraryLibrarianService;

public class LibrarianServiceimpl implements LibraryLibrarianService, LibraryRepository {

	static Scanner sc = new Scanner(System.in);

	{
		// Dummy Librarian Adding
		Address a1 = new Address("123", "kodathi", "bangalore", 560035);
		ld.put("rocky", new Librarian("shiva", "1234", "rocky", a1, 7890987612L));
		Address a2 = new Address("111", "chamaraj", "bangalore", 560032);
		ld.put("rsk", new Librarian("rama", "12345", "rsk", a2, 9986001236L));
	}

	{
		// Dummy Books Adding
		bk.add(new Book("k@1", "java", "Keshav", "Jspider", 5));
		bk.add(new Book("d@2", "Prgmg", "Darshan", "Jspider", 4));
		bk.add(new Book("s@1", "Sql", "Sharath", "Qspider", 2));
		bk.add(new Book("p@1", "Web", "prajwal", "pspider", 3));
		bk.add(new Book("b@1", "jdbc", "sathish", "Jspider", 1));

	}

	{
		// Dummy Student Adding

		st.put(new Student(100, "Hari", 789632145L, bk.get(0)), bk.get(0));
		st.put(new Student(101, "logesh", 654632145L, bk.get(1)), bk.get(1));
		st.put(new Student(102, "shiva", 963632145L, bk.get(2)), bk.get(2));
		st.put(new Student(103, "chai", 852632145L, bk.get(3)), bk.get(3));

	}

	@Override
	public void librarianLoginForm() {

		System.out.println("=== Librarian Login Page ===");
		System.out.println("Enter the User Name");
		String uname = sc.nextLine();
		System.out.println("Enter the password");
		String pass = sc.nextLine();

		if (!ld.containsKey(uname)) {
			System.out.println("User name invalid\n");
			librarianLoginForm();
		} else if (!ld.get(uname).getPassword().equals(pass)) {
			System.out.println("Password Incorrect\n");
			librarianLoginForm();
		}

		librarianSection();
	}

	public void librarianSection() {
		System.out.println("=== Librarian Section ===");

		System.out
				.println("1. Add Books\n2. View Books\n3. Issue Book\n4. View Issued Books\n5. Return Book\n6. Logout");
		int ch = sc.nextInt();
		switch (ch) {
		case 1:
			addBook();
			break;
		case 2:
			viewBook();
			break;
		case 3:
			issueBook();
			break;
		case 4:
			displayIssuedBook();
			break;
		case 5:
			returnBook();
			break;
		case 6:
			LibApp.LoginPage();
			break;
		default:
			System.out.println("Invalid Choice");

		}

	}

	public void returnBook() {

		System.out.println("=== Returning Book page ===");
		System.out.println("Enter the book id");
		int bid = sc.nextInt();
		System.out.println("Enter the Student  id");
		int sid = sc.nextInt();
		boolean flag = false;
		for (Student std : st.keySet()) {
			if (std.getSid() == sid && std.getBookIssued().getBid() == bid) {
				st.remove(std);
				System.out.println("Book Returned Successufully");
				flag = true;
				break;
			}
		}
		if (!flag) {
			System.out.println("Unable to return Book");
		} else {
			for (Book b : bk) {
				if (b.getBid() == bid) {
					b.setBquantity(b.getBquantity() + 1);
					break;
				}
			}
		}

		librarianSection();
	}

	public void displayIssuedBook() {
		if (st.size() > 0) {
			System.out.println("===== Issued Books =====");
			System.out.println("B_Id\tB_Name\tS_Id\tS_Name\tS_Phone");

			for (Student std : st.keySet()) {
				System.out.println(std.getBookIssued().getBid() + "\t" + std.getBookIssued().getBname() + "\t"
						+ std.getSid() + "\t" + std.getSname() + "\t" + std.getPhone());
			}
		} else {
			try {
				throw new StudentNotFoundException();
			} catch (StudentNotFoundException e) {
				System.out.println(e);
			}
		}
		librarianSection();
	}

	public void issueBook() {
		System.out.println("=== Enter the student Details ===");
		System.out.println("Book id");
		int bid = sc.nextInt();
		System.out.println("Student id");
		int sid = sc.nextInt();
		System.out.println("Student Name");
		sc.nextLine();
		String sname = sc.nextLine();
		System.out.println("Student phone");
		long sphone = sc.nextLong();

		Book sb = null;
		Book b = null;
		for (Book book : bk) {
			if (book.getBid() == (bid) && book.getBid() > 0) {
				sb = new Book(bid, book.getBcallno(), book.getBname(), book.getBauthor(), book.getBpublisher());
				b = book;
			}
		}

		if (b != null && b.getBquantity() > 0) {
			Student std = new Student(sid, sname, sphone, sb);
			st.put(std, sb);
			b.setBquantity(b.getBquantity() - 1);
			System.out.println("Book issued Successfully");
		} else {
			try {
				throw new BookNotFoundException();
			} catch (BookNotFoundException e) {
				System.out.println(e);
			}
		}
		librarianSection();

	}

	public static void sortby() {
		System.out.println("===== Books Availabale =====");
		System.out.println("Id\tCallNo\tName\tAuthor\tPublisher\tQuantity");
		if (bk.size() > 0) {
			for (Book book : bk) {
				System.out.println(book.getBid() + "\t" + book.getBcallno() + "\t" + book.getBname() + "\t"
						+ book.getBauthor() + "\t" + book.getBpublisher() + "\t\t" + book.getBquantity());
			}
		} else {
			try {
				throw new BookNotFoundException();
			} catch (BookNotFoundException e) {
				System.out.println(e);
			}
		}
	}

	public void viewBook() {
		System.out.println("===== Select Sort By..? =====");
		System.out.println("1. Id\t2. Name\t3. Author\t4. Publisher\t5. Quantity");
		int n = sc.nextInt();
		switch (n) {
		case 1:
			sortby();
			break;
		case 2:
			Collections.sort(bk, new BookNameComparator());
			
			sortby();
			break;
		case 3:
			Collections.sort(bk, new BookAuthorComparator());
			sortby();
			break;
		case 4:
			Collections.sort(bk, new BookPublisherComparator());
			sortby();
			break;
		case 5:
			Collections.sort(bk, new BookQuantityComparator());
			sortby();
			break;
		default:
			System.out.println("Invalid Choice");
		}
		librarianSection();
	}

	public void addBook() {
		System.out.println("=== Enter the Book Details ===");
		System.out.println("Name : ");
		sc.nextLine();
		String bname = sc.nextLine();
		System.out.println("Author : ");
		String bauthor = sc.nextLine();
		System.out.println("Publisher : ");
		String bpublisher = sc.nextLine();
		System.out.println("Quantity : ");
		int bquantity = sc.nextInt();

		System.out.println("Call No : ");
		sc.nextLine();
		String bcallno = sc.nextLine();

		Book b1 = new Book(bcallno, bname, bauthor, bpublisher, bquantity);
		bk.add(b1);
		System.out.println("Book Added Successfully\n");
		librarianSection();
	}

}
