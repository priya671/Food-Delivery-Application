package com.edu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity

public class FoodCart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "foodCart_Id")
	private Integer id;
	
	@Column(name = "paymentStatus")
	private String paymentStatus;
	
	@OneToOne(targetEntity = Customer.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "custId",referencedColumnName = "customerid")
	private Customer cust;
	

	@OneToMany(mappedBy = "cart")
	private List<Item> itemList = new ArrayList<>();


	public FoodCart() {
		super();
		// TODO Auto-generated constructor stub
	}


	public FoodCart(String paymentStatus, Customer cust, List<Item> itemList) {
		super();
		this.paymentStatus = paymentStatus;
		this.cust = cust;
		this.itemList = itemList;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getPaymentStatus() {
		return paymentStatus;
	}


	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}


	public Customer getCust() {
		return cust;
	}


	public void setCust(Customer cust) {
		this.cust = cust;
	}


	public List<Item> getItemList() {
		return itemList;
	}


	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	
	

}
