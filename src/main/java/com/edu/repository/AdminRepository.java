package com.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edu.dao.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

	@Query(value = "select * from admin where username=? and password=?",nativeQuery = true)


    Admin getAdminByusername(String username, String password);

//	Admin getAdminByusername(String username, String password);

}
