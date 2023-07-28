package com.edu.dao;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer restid;
	
	@NotBlank(message="Please enter name")
	@Column(nullable = false)
	private String restname;
	
	@NotBlank(message = "Manager name should not be blank")
	@NotEmpty(message = "Manager name should not be empty")
	@Column(length = 20, nullable = false)
	private String managerName;
	
	@NotBlank(message = "contact number should not be blank")
	@NotEmpty(message = "contact number should not be empty")
	@Column(nullable = false, unique= true)
	private String contactNumber;
	
	@Column(nullable = true)
	private String pic;
	
	@NotEmpty(message = "Please enter area")
	@NotBlank(message = "Please enter area")
	@Column(nullable = false)
	private String area;
	
	@NotEmpty(message = "Please enter city")
	@NotBlank(message = "Please enter city")
	@Column(nullable = false)
	private String city;
	
	@NotEmpty(message = "Please enter state")
	@NotBlank(message = "Please enter state")
	@Column(nullable = false)
	private String state;
	
	@NotEmpty(message = "Please enter country")
	@NotBlank(message = "Please enter country")
	@Column(nullable = false)
	private String country;
	
	@NotEmpty(message = "Please enter pincode")
	@NotBlank(message = "Please enter pincode")
	@Length(min = 6, max = 6, message = "6 digit only")
	@Column(length = 6, nullable = false)
	private String pincode;

	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}" , message = "invalid Email")
	@Column(unique = true)
	private String email;
		
//		@Column(unique = true)
	private String password;
	
	@JsonIgnore
	@OneToMany(mappedBy="rest",cascade = CascadeType.ALL)
	List<Item> item = new ArrayList<Item>();
	
	
	
	public Restaurant(String restname,String managerName,String contactNumber,String area, String city,String state,String country,String pincode,String email,
			String password, List<Item> item, boolean status) {
		super();
		this.restname = restname;
		this.managerName = managerName;
		this.contactNumber = contactNumber;
		this.pic = pic;
		this.area = area;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.email = email;
		this.password = password;
		this.item = item;
		this.status = status;
	}

	@Column(columnDefinition="boolean default false")
	private boolean status;
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getRestid() {
		return restid;
	}

	public void setRestid(Integer restid) {
		this.restid = restid;
	}

	public String getRestname() {
		return restname;
	}

	public void setRestname(String restname) {
		this.restname = restname;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Restaurant [restid=" + restid + ", restname=" + restname + ", managerName=" + managerName
				+ ", contactNumber=" + contactNumber + ", pic=" + pic + ", area=" + area + ", city=" + city + ", state="
				+ state + ", country=" + country + ", pincode=" + pincode + ", email=" + email + ", password="
				+ password + ", item=" + item + ", status=" + status + "]";
	}
	
}