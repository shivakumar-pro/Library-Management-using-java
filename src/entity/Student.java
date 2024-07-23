package entity;

public class Student {
	private int sid;
	private String sname;
	private long phone;
	private Book bookIssued;
	public Student(int sid, String sname, long phone, Book bookIssued) {

		this.sid = sid;
		this.sname = sname;
		this.phone = phone;
		this.bookIssued = bookIssued;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public Book getBookIssued() {
		return bookIssued;
	}
	public void setBookIssued(Book bookIssued) {
		this.bookIssued = bookIssued;
	}
	
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", phone=" + phone + ", bookIssued=" + bookIssued + "]";
	}
	
	
}
