package entity;

public class Address {
	private String doorno;
	private String area;
	private String city;
	private int pincode;
	
	public Address(String doorno, String area, String city, int pincode) {
		this.doorno = doorno;
		this.area = area;
		this.city = city;
		this.pincode = pincode;
	}

	public String getDoorno() {
		return doorno;
	}

	public void setDoorno(String doorno) {
		this.doorno = doorno;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [doorno=" + doorno + ", area=" + area + ", city=" + city + ", pincode=" + pincode + "]";
	}
}
