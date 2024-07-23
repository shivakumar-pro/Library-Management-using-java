package exception;

public class StudentNotFoundException extends Exception {
	
	public StudentNotFoundException() {
		super("Student Not Found");
	}
	
	public StudentNotFoundException(String msg) {
		super(msg);
	}
}
