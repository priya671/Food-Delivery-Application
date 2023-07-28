package com.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edu.dao.Customer;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
//	//Login functionality using native sql query
//	@Query(value="select * from customer where customername=? and password=?",nativeQuery = true)
//	public List<Customer> findByCustomernameAndCustomerpassword(String uname, String pass);
	
	//login through email
	@Query(value = "select * from customer where customeremail=? and password=?",nativeQuery = true)
	public Customer getCustomerByEmail(String email,String password);
	
	@Query(value = "select * from customer where customeremail=?",nativeQuery = true)
	public Customer getCustomerByEmail1(String email);
	
	
}
