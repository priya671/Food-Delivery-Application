package com.edu.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.Admin;
import com.edu.dao.Customer;
import com.edu.error.GlobalException;
import com.edu.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Admin saveAdmin(@Valid Admin admin) {
		// TODO Auto-generated method stub
		return adminRepository.save(admin);
	}

	@Override
	public List<Admin> getAllAdmin() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}

	@Override
	public void deleteAdminById(Integer adminid) throws GlobalException {
		// TODO Auto-generated method stub
		Optional<Admin> admin = adminRepository.findById(adminid);
		if(!admin.isPresent()) {
			throw new GlobalException("Admin id= " + adminid + " does not exist");
		}
		adminRepository.deleteById(adminid);
	}

	@Override
	public Admin updateAdminById(Integer adminid, Admin admin) throws GlobalException {
		// TODO Auto-generated method stub
		Admin a = null;
		Optional<Admin> admin1 = adminRepository.findById(adminid);
		if(!admin1.isPresent()) {
			throw new GlobalException("Admin id= " + adminid + " does not exist");
		}
		else {
			a = adminRepository.findById(adminid).get();
			a.setUsername(admin.getUsername());
			a.setPassword(admin.getPassword());
		}
		
		return adminRepository.save(a);
	}

	@Override
	public Admin getAdminById(Integer adminid) {
		// TODO Auto-generated method stub
		return adminRepository.findById(adminid).get();
	}

	@Override
	public Admin getAdminByusername(String username, String password) {
		// TODO Auto-generated method stub
		return adminRepository.getAdminByusername(username,password);
	}

	
	
	
}
