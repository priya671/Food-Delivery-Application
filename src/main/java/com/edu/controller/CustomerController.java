package com.edu.controller;

import java.util.List;
import java.util.Set;

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

import com.edu.dao.Customer;
import com.edu.dao.CustomerAddress;
import com.edu.error.GlobalException;
import com.edu.service.CustomerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	/*
	 * @PostMapping("/saveCustomer") Customer saveCustomer(@RequestBody Customer
	 * customer) { return customerService.saveCustomer(customer);
	 * 
	 * }
	 */
	//http://localhost:8990/saveCustomer
	@PostMapping("/saveCustomer")
	public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer) {
		
		Customer cus = customerService.saveCustomer(customer);
		return new ResponseEntity<Customer>(cus,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllCustomer")
	public List<Customer> getAllCustomer()throws GlobalException {
		return customerService.getAllCustomer();
	}
	
	@DeleteMapping("/deleteCustomerById/{custid}")
	List<Customer> deleteCustomerById(@PathVariable("custid") Integer customerid) throws GlobalException {
		return customerService.deleteCustomerById(customerid);
		//return "Customer deleted";
	}
	
	@PutMapping("/updateCustomerById/{custid}")
	Customer updateCustomerById(@PathVariable("custid") Integer customerid ,@Valid @RequestBody Customer customer){
		return customerService.updateCustomerById(customerid,customer);
	}
	
//	//login
//	//http://localhost:8990/findByCustomernameAndCustomerpassword/{cname}/{cpass}
//	@GetMapping("/findByCustomernameAndCustomerpassword/{cname}/{cpass}")
//	List<Customer> findByCustomernameAndCustomerpassword(@PathVariable("cname") String cname, @PathVariable("cpass") String cpass){
//		return customerService.findByCustomernameAndCustomerpassword(cname,cpass);
//	}
	
	//sign in get by email
	@GetMapping("/getCustomerByEmail/{email}/{password}")
	public Customer getCustomerByEmail(@PathVariable("email") String email,@PathVariable("password") String password) {
		return customerService.getCustomerByEmail(email,password);
	}
	
	@GetMapping("/getCustomerById/{custid}")
	public Customer getCustomerById(@PathVariable("custid") Integer customerid) {
		return customerService.getCustomerById(customerid);
	}
	
	@PutMapping("/updateCustomerAddByid/{custid}")
	public Customer updateCustomerAddByid(@PathVariable("custid") Integer customerid,@RequestBody CustomerAddress cob) {
		return customerService.updateCustomerAddByid(customerid,cob);
	}
	
	@GetMapping("/getCustomerByEmail/{email}")
	public Customer getCustomerByEmail1(@PathVariable("email") String email) {
		return customerService.getCustomerByEmail(email);
	}
	
	@GetMapping("/getCustomerAddByEmail/{email}")
	public Set<CustomerAddress> getCustomerAddByEmail(@PathVariable("email") String email) {
		return customerService.getCustomerAddByEmail(email);
	}
	
	
	

	
}

	
