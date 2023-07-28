package com.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edu.dao.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{

//	Restaurant findByrestaurantName(String restname);
	
//	@Query("SELECT r.restname FROM restaurant as r WHERE r.restname LIKE %?1%")
//	public List<Restaurant> search(String keyword);
//	
//	
//	@Query("SELECT r FROM restaurant r WHERE CONCAT(r.restname) LIKE %?1%")
//	public List<Restaurant> searchByRestaurantName(String keyword);


	@Query(value = "select * from restaurant where restname like %?% and status=true" ,nativeQuery = true)
	public List<Restaurant> findByRestnameContainingIgnoreCase(String key1);

	
	@Query(value="select * from restaurant where restname=? and password=?",nativeQuery = true)
	public List<Restaurant> findByRestaurantnameAndRestaurantpassword(String uname, String pass);
	

	@Query(value = "select * from restaurant where email=? and password=?",nativeQuery = true)
	public Restaurant getRestaurantByEmail(String email,String password);

	
	@Query(value = "select * from restaurant where status=true ",nativeQuery = true)
	public List<Restaurant> searchByStatus(List<Restaurant> listrest);
	


}





