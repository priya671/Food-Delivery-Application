package com.edu.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.edu.dao.Admin;
import com.edu.dao.Customer;
import com.edu.error.GlobalException;

@Service
public interface AdminService {

	public Admin saveAdmin(@Valid Admin admin);

	public List<Admin> getAllAdmin();

	public void deleteAdminById(Integer adminid) throws GlobalException;

	public Admin updateAdminById(Integer adminid, Admin admin) throws GlobalException;



	public Admin getAdminById(Integer adminid);

	public Admin getAdminByusername(String username, String password);

	

}
