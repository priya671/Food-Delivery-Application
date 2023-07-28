package com.edu.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.type.TrueFalseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.edu.FoodDeliveryApplication;
import com.edu.dao.FoodCart;

public interface FoodCartRepository extends JpaRepository<FoodCart, Integer>{

	
	@Query(value = "select * from food_cart where  cust_id =?",nativeQuery = true)
	FoodCart getCartByCustomerId(int custId);

	@Query(value = "select * from food_cart",nativeQuery = true)
	List<FoodCart> getAllFoodCart(); 
	
	@Query(value = " select * from food_cart where  payment_status='unpaid'and cust_id=?1",nativeQuery = true)
	public FoodCart getCartByvalidItem(Integer id);
	
	@Transactional
	@Modifying
	@Query(value = "delete from food_cart where cust_id=?1",nativeQuery = true)
	public void deletCartByCustomer(Integer custID); 
	
	

}
