package com.edu.dao;

import java.util.Date;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;

//This is the invoice file

@Entity
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer invoiceid;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date ordersdate;
	
	
	@PrePersist
	private void onCreate() {
		ordersdate = new Date();
	}
	
	@Min(value = 1, message = "item cost cannot be empty")
	@Column(nullable = false)
	private float invoicetotalcost;
	
	@Min(value = 1, message = "item cannot be empty")
	@Column(nullable = false)
	private int invoicetotalitem;
	
	

	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}	


	public Invoice(float invoicetotalcost, int invoicetotalitem) {
		super();
		this.invoicetotalcost = invoicetotalcost;
		this.invoicetotalitem = invoicetotalitem;
	}


	public Integer getInvoiceid() {
		return invoiceid;
	}


	public void setInvoiceid(Integer invoiceid) {
		this.invoiceid = invoiceid;
	}


	public Date getOrdersdate() {
		return ordersdate;
	}


	public void setOrdersdate(Date ordersdate) {
		this.ordersdate = ordersdate;
	}


	public float getInvoicetotalcost() {
		return invoicetotalcost;
	}


	public void setInvoicetotalcost(float invoicetotalcost) {
		this.invoicetotalcost = invoicetotalcost;
	}


	public int getInvoicetotalitem() {
		return invoicetotalitem;
	}


	public void setInvoicetotalitem(int invoicetotalitem) {
		this.invoicetotalitem = invoicetotalitem;
	}


	

	@Override
	public String toString() {
		return "Invoice [invoiceid=" + invoiceid + ", ordersdate=" + ordersdate + ", invoicetotalcost="
				+ invoicetotalcost + ", invoicetotalitem=" + invoicetotalitem + "]";
	}
	
}
