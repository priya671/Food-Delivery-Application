package com.edu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.edu.service.RestaurantService;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer itemid;

	@NotEmpty(message = "Item name cannot be null")
	@NotBlank(message = "Item name cannot be null")
	@Column(length = 50, nullable = false)
	private String itemname;

	@NotEmpty(message = "Item name cannot be null")
	@NotBlank(message = "Item name cannot be null")
	@Column(nullable = false)
	private String itemstatus;

	@Column(nullable = false)
	private Double itemcost;
	
	@Column(nullable = true)
	private String itemimage;
	
	
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name="restid" , referencedColumnName="restid")
	Restaurant rest;
	
	

	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name="cartId" , referencedColumnName="foodCart_Id")
	FoodCart cart; 
	


	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Item(String itemname,String itemstatus,Double itemcost, String itemimage) {
		super();
		this.itemname = itemname;
		this.itemstatus = itemstatus;
		this.itemcost = itemcost;
		this.itemimage = itemimage;
	}
	

	public String getItemimage() {
		return itemimage;
	}



	public void setItemimage(String itemimage) {
		this.itemimage = itemimage;
	}



	public Restaurant getRest() {
		return rest;
	}



	public void setRest(Restaurant rest) {
		this.rest = rest;
		
		if(!rest.getItem().contains(this)) {
			rest.getItem().add(this);
		}
	}



	public Integer getItemid() {
		return itemid;
	}

	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getItemstatus() {
		return itemstatus;
	}

	public void setItemstatus(String itemstatus) {
		this.itemstatus = itemstatus;
	}

	public Double getItemcost() {
		return itemcost;
	}

	public void setItemcost(Double itemcost) {
		this.itemcost = itemcost;
	}


	@Override
	public String toString() {
		return "Item [itemid=" + itemid + ", itemname=" + itemname + ", itemstatus=" + itemstatus + ", itemcost="
				+ itemcost + ", itemimage=" + itemimage + "]";
	}



	public void itemAssignedRestaurantAddress(Restaurant dob) {
		// TODO Auto-generated method stub
		this.rest = dob;
		
	}



	public void assignCart(FoodCart cart) {
		// TODO Auto-generated method stub
		this.cart = cart;
	}
}
