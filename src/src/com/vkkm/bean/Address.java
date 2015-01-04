package src.com.vkkm.bean;

public class Address {
	private int addressId;
	private String address; 
	private String city;
	private int pincode; //6 digit int
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public int getAddressId() {
		return addressId;
	}
	
	
	

}
