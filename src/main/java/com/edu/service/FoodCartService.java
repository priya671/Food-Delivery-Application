package com.edu.service;

import java.util.List;

import com.edu.dao.Customer;
import com.edu.dao.FoodCart;
import com.edu.dao.Item;
import com.edu.error.GlobalException;

public interface FoodCartService {

	FoodCart savecart(FoodCart foodCart);

	FoodCart getCartById(Integer id);

	List<FoodCart> getAllCart();

	List<Item> getItemByCartId(Integer id) throws GlobalException;
	
	FoodCart updateCartByItem(Integer id, Item item) throws GlobalException;

	FoodCart updateCartbyCustomer(Integer id, Customer cust);

	FoodCart getCartBYEmail(String email) throws GlobalException;

//	FoodCart deleteItemInCartByID(Integer cartID) throws GlobalException;

//	String deleteCartByCustID(Integer custID);

	//FoodCart updateItemToNull(Integer id);

	FoodCart updatePaymentStatus(Integer id);

}
