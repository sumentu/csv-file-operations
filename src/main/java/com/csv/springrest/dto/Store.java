package com.csv.springrest.dto;
//import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.Data;

@SuppressWarnings({ "unused"})
@Data
public class Store {
	private String storeId;
	private String postcode;
	private String city;
	private String address;
	private Date opendate;
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getOpendate() {
		return opendate;
	}
	public void setOpendate(Date opendate) {
		this.opendate = opendate;
	}
	public Store(String storeId, String postcode, String city, String address, Date opendate) {
		super();
		this.storeId = storeId;
		this.postcode = postcode;
		this.city = city;
		this.address = address;
		this.opendate = opendate;
	}
	public Store() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Store [storeId=" + storeId + ", postcode=" + postcode + ", city=" + city + ", address=" + address
				+ ", opendate=" + opendate + "]";
	}
	
	
}
