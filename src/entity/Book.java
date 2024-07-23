package entity;

public class Book implements Comparable<Book>{
	private static int id=0; 
	private int bid;
	private String bcallno;
	private String bname;
	private String bauthor;
	private String bpublisher;
	private int bquantity;
	public Book(String bcallno, String bname, String bauthor, String bpublisher, int bquantity) {
		this.setBid(++id);
		this.bcallno = bcallno;
		this.bname = bname;
		this.bauthor = bauthor;
		this.bpublisher = bpublisher;
		this.bquantity = bquantity;
	}
	
	public Book(int bid,String bcallno, String bname, String bauthor, String bpublisher) {
		this.bid=bid;
		this.bcallno = bcallno;
		this.bname = bname;
		this.bauthor = bauthor;
		this.bpublisher = bpublisher;
	}
	
	
	public String getBcallno() {
		return bcallno;
	}
	public void setBcallno(String bcallno) {
		this.bcallno = bcallno;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBauthor() {
		return bauthor;
	}
	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}
	public String getBpublisher() {
		return bpublisher;
	}
	public void setBpublisher(String bpublisher) {
		this.bpublisher = bpublisher;
	}
	public int getBquantity() {
		return bquantity;
	}
	public void setBquantity(int bquantity) {
		this.bquantity = bquantity;
	}
	@Override
	public String toString() {
		return "Book [bcallno=" + bcallno + ", bname=" + bname + ", bauthor=" + bauthor + ", bpublisher=" + bpublisher
				+ ", bquantity=" + bquantity + "]";
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	@Override
	public int compareTo(Book b) {	
		return this.bid-b.bid;
	}
	
	

	
}
