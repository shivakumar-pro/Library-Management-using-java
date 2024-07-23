package exception;

public class LibrarianNotFoundException extends Exception{
	
	public LibrarianNotFoundException(String message){
		super(message);
	}
	
	public LibrarianNotFoundException(){
		
		super("Librarian Not Found");
		
	}
}	
