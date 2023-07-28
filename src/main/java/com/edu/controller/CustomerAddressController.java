package com.edu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.dao.CustomerAddress;
import com.edu.error.GlobalException;
import com.edu.service.CustomerAddressService;

@CrossOrigin(origins = "http://localhost:4200")//connect with ang
@RestController
public class CustomerAddressController {
	
	@Autowired
	private CustomerAddressService customerAddressService;
	
	
	//http://localhost:8990/saveCustomerAddress
//	@PostMapping("/saveCustomerAddress")
//	CustomerAddress saveCustomerAddress(@RequestBody CustomerAddress customeraddress) {
//		return customerAddressService.saveCustomerAddress(customeraddress);
//	}
	
	@PostMapping("/saveCustomerAddress")
	public ResponseEntity<CustomerAddress> saveCustomerAddress(@Valid @RequestBody CustomerAddress customeraddress){
		CustomerAddress cust = customerAddressService.saveCustomerAddress(customeraddress);
		return new ResponseEntity<CustomerAddress>(cust, HttpStatus.CREATED);
	}
	
	
	
	//http://localhost:8990/getAllCustomerAddress
	@GetMapping("/getAllCustomerAddress")
	List<CustomerAddress> getAllCustomerAddress(){
		return customerAddressService.getAllCustomerAddress();
	}
	
	//http://localhost:8990/deleteCustomerAddressById/{addid}
	@DeleteMapping("/deleteCustomerAddressById/{addid}")
	String deleteCustomerAddressById(@PathVariable("addid") Integer addressid) throws GlobalException {
		customerAddressService.deleteCustomerAddressById(addressid);
		return "Record Deleted";
	}
	
	@GetMapping("/getCustomerAddById/{id}")
	public CustomerAddress getCustomerAddById(@PathVariable("id") Integer id) {
		return customerAddressService.getCustomerAddById(id);
	}
	
	//http://localhost:8990/updateCustomerAddressById/{addid}
	@PutMapping("/updateCustomerAddressById/{addid}")
	CustomerAddress updateCustomerAddressById(@PathVariable("addid") Integer addressid, @RequestBody CustomerAddress customeraddress) throws GlobalException {
		return customerAddressService.updateCustomerAddressById(addressid,customeraddress);
	}
	
	@GetMapping("/customerAssigncustomeraddress/customer/{custid}/customerAddress/{addid}")
	public CustomerAddress customerAssigncustomeraddress(@PathVariable Integer custid, @PathVariable Integer addid) {
		return customerAddressService.customerAssigncustomeraddress(custid, addid);
	}
//	
//	@GetMapping("/getCustomerAddressByCustomerEmail/{email}")
//	List<CustomerAddress> getCustomerAddressByCustomerEmail(@path){
//		return customerAddressService.getCustomerAddressByCustomerEmail();
//	}
	
}
