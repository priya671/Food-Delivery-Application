package com.edu.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.Customer;
import com.edu.dao.CustomerAddress;
import com.edu.dao.Item;
import com.edu.dao.Restaurant;
import com.edu.error.GlobalException;
import com.edu.repository.CustomerAddressRepository;
import com.edu.repository.CustomerRepository;
import com.edu.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerAddressRepository cusAddRepo;

	@Override
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	

	@Override
	public List<Customer> deleteCustomerById(Integer customerid) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(customerid);
		return customerRepository.findAll();
	}


	@Override
	public Customer updateCustomerById(Integer customerid, @Valid Customer customer) {
		// TODO Auto-generated method stub
		Customer cus = customerRepository.findById(customerid).get();
		if(cus!=null) {
			cus.setCustomername(customer.getCustomername());
			cus.setCustomermobilenumber(customer.getCustomermobilenumber());
			cus.setCustomeremail(customer.getCustomeremail());
			cus.setPassword(customer.getPassword());
			customerRepository.save(cus);
		}
		return cus;
	}

//	@Override
//	public List<Customer> findByCustomernameAndCustomerpassword(String cname, String cpass) {
//		// TODO Auto-generated method stub
//		return customerRepository.findByCustomernameAndCustomerpassword(cname, cpass);
//	}

	//login
	@Override
	public Customer getCustomerByEmail(String email,String password) {
		// TODO Auto-generated method stub
		Customer cust = customerRepository.getCustomerByEmail(email,password);
		System.out.println(cust);
		return cust;
	}

	@Override
	public Customer getCustomerById(Integer customerid) {
		// TODO Auto-generated method stub
		return customerRepository.findById(customerid).get();
	}

	@Override
	public Customer updateCustomerAddByid(Integer customerid, CustomerAddress cob) {
		// TODO Auto-generated method stub
		Optional<Customer> cus = customerRepository.findById(customerid);

		if(cus.isPresent()) {
			Customer customer = customerRepository.findById(customerid).get();
			Set<CustomerAddress> add = customer.getCob();
			if(add.isEmpty()) {
				Set<CustomerAddress> newaddress = new HashSet<>();
				newaddress.add(cusAddRepo.save(cob));
				int id=cob.getAddressid();
				CustomerAddress newadd=cusAddRepo.findById(id).get();
				Customer dob= customerRepository.findById(id).get();
				newadd.addressAssignedCustomer(dob);
				customer.setCob(newaddress);
				return customerRepository.save(customer);
			}
			else {
				add.add(cusAddRepo.save(cob));
				int id=cob.getAddressid();
				CustomerAddress newadd=cusAddRepo.findById(id).get();
				Customer dob= customerRepository.findById(id).get();
				newadd.addressAssignedCustomer(dob);
//				customer.setCob(add);
				return customerRepository.save(dob);
			}
		}
		else {
//			throw new GlobalException("")
			return null;
		}
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		// TODO Auto-generated method stub
	return	customerRepository.getCustomerByEmail1(email);
		
	}

	@Override
	public Set<CustomerAddress> getCustomerAddByEmail(String email) {
		Customer customer = customerRepository.getCustomerByEmail1(email);
		// TODO Auto-generated method stub
	Set<CustomerAddress> cutomerAddList = customer.getCob();
		return cutomerAddList;
	}

	


}
