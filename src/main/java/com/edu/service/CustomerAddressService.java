package com.edu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edu.dao.CustomerAddress;
import com.edu.error.GlobalException;

public interface CustomerAddressService {

	public CustomerAddress saveCustomerAddress(CustomerAddress customeraddress);

	public List<CustomerAddress> getAllCustomerAddress();

	public void deleteCustomerAddressById(Integer addressid) throws GlobalException;

	public CustomerAddress updateCustomerAddressById(Integer addressid, CustomerAddress customeraddress) throws GlobalException;

	

	CustomerAddress customerAssigncustomeraddress(Integer custid, Integer addid);

	public CustomerAddress getCustomerAddById(Integer id);

}
