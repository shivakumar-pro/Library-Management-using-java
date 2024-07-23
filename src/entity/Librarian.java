package entity;

public class Librarian {
	private String name;
	private String userName;
	private String password;
	private Address address;
	private Long phone;

	public Librarian(String name, String password, String userName, Address address, Long phone) {
		this.name = name;
		this.password = password;
		this.userName = userName;
		this.address = address;
		this.phone = phone;
	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	
	
	@Override
	public String toString() {
		return "Librarian [name=" + name + ", password=" + password + ", userName=" + userName + ", address=" + address
				+ ", phone=" + phone + "]";
	}
}
