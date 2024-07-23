package app;

import java.util.Scanner;

import service.LibraryAdminService;
import service.LibraryLibrarianService;
import serviceimpl.AdminServiceimpl;
import serviceimpl.LibrarianServiceimpl;

public class LibApp {
	static Scanner sc=new Scanner(System.in);
	
	public static void LoginPage() {
		System.out.println("=====Welcome To Library=====");
		System.out.println("1. Admin Login");
		System.out.println("2. Librarian Login");
		int ch=sc.nextInt();
		switch(ch) {
		case 1:
			LibraryAdminService la=new AdminServiceimpl();
			la.AdminLoginForm();
			break;
		case 2:
			LibraryLibrarianService ll=new LibrarianServiceimpl();
			ll.librarianLoginForm();	
			break;
		default:
			System.err.println("Invalid Selection");
			System.out.println();
			LoginPage();
		}
	}
	
	public static void main(String[] args) {
		
		LoginPage();
	
	}
}
