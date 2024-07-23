package serviceimpl;

import java.util.Scanner;
import app.LibApp;
import dao.LibraryRepository;
import entity.Address;
import entity.Librarian;
import exception.LibrarianNotFoundException;
import service.LibraryAdminService;

public class AdminServiceimpl implements LibraryAdminService, LibraryRepository {

	private static String userName = "admin";
	private static String password = "1234";

	static Scanner sc = new Scanner(System.in);
	
	
	{
		//Dummy Librarian Adding
		Address a1 = new Address("123", "kodathi", "bangalore", 560035);
		ld.put("rocky", new Librarian("super", "1234", "super1234", a1, 7890987612L));
		Address a2 = new Address("111", "chamaraj", "bangalore", 560032);
		ld.put("skr", new Librarian("Shivaji", "12345", "LGQST", a2, 9986001236L));
	}
	

	@Override
	public void AdminLoginForm() {

		System.out.println("Enter the User Name: ");
		String uname = sc.nextLine();
		System.out.println("Enter the Password: ");
		String pass = sc.nextLine();

		if (userName.equals(uname) && password.equals(pass)) {
			adminSection();
		} else {
			System.err.println("Login credentials Incorrect");
			LibApp.LoginPage();
		}
	}

	public void adminSection() {
		System.out.println("\n<<< Admin Section >>>");
		System.out.println("1. Add Librarian");
		System.out.println("2. View Librarian");
		System.out.println("3. Delete Librarian");
		System.out.println("4. Logout");

		int n = sc.nextInt();
		switch (n) {
		case 1:
			addLibrarian();
			break;
		case 2:
			displayLibrarian();
			break;
		case 3:
			deleteLibrarian();
			break;
		case 4:
			System.out.println("Logged out");
			LibApp.LoginPage();
			break;
		default:
			System.out.println("Invalid Choice Try again");
			adminSection();
		}
	}

	public void deleteLibrarian() {
		System.out.println("Enter the User Name to delete Librarian");
		sc.nextLine();
		String uname=sc.nextLine();
		if(ld.containsKey(uname)) {
			ld.remove(uname);
			System.out.println("Deleted Successfully");

		}else {
			//System.out.println("not found");
			try {
				throw new LibrarianNotFoundException();
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}
		adminSection();		
	}

	public  void displayLibrarian() {
		System.out.println("===== Librarian Lists =====");
		System.out.println("UName\tName\tPass\tPhone\t\tCity");
		for (String li : ld.keySet()) {
			System.out.println(li + "\t" + ld.get(li).getName() + "\t" + ld.get(li).getPassword() + "\t"
					+ ld.get(li).getPhone() + "\t" + ld.get(li).getAddress().getCity());
		}
		adminSection();
	}

	public  Address addr() {

		System.out.println("=== Enter Librarian Address ===");
		System.out.println("Door No : ");
		sc.nextLine();
		String dno = sc.nextLine();
		System.out.println("Area ");
		String area = sc.nextLine();
		System.out.println("City : ");
		String city = sc.nextLine();
		System.out.println("Pincode : ");
		Integer pin = sc.nextInt();

		Address a1 = new Address(dno, area, city, pin);

		return a1;
	}

	public  void addLibrarian() {

		System.out.println("~*~ Enter Librarian Details ~*~");
		System.out.println("User Name : ");
		sc.nextLine();
		String uname = sc.nextLine();

		if (ld.containsKey(uname)) {
			System.out.println("User Name " + uname + " is already taken\n");
			addLibrarian();
		}

		System.out.println("Name : ");
		String name = sc.nextLine();
		System.out.println("Password : ");
		String pass = sc.nextLine();
		System.out.println("Phone : ");
		long phone = sc.nextLong();

		Address a1 = addr();

		Librarian l1 = new Librarian(name, pass, uname, a1, phone);
		ld.put(l1.getUserName(), l1);
		System.out.println("Librarian Added Successfully");
		adminSection();

	}
}
