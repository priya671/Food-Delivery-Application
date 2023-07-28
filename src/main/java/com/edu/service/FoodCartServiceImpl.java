package com.edu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.Customer;
import com.edu.dao.FoodCart;
import com.edu.dao.Item;
import com.edu.error.GlobalException;
import com.edu.repository.CustomerRepository;
import com.edu.repository.FoodCartRepository;
import com.edu.repository.ItemRepository;

@Service
public class FoodCartServiceImpl implements FoodCartService {

	@Autowired
	FoodCartRepository cartRepo;

	@Autowired
	ItemRepository itemRepo;

	@Autowired
	CustomerRepository custrepo;

	@Override
	public FoodCart savecart(FoodCart foodCart) {
		foodCart.setPaymentStatus("unpaid");
		// TODO Auto-generated method stub
		return cartRepo.save(foodCart);
	}

	@Override
	public FoodCart getCartById(Integer id) {
		// TODO Auto-generated method stub
		
		FoodCart cart =cartRepo.getCartByvalidItem(id);
		System.out.println(cart.getItemList());
		return cart;
	}

	@Override
	public List<FoodCart> getAllCart() {
		// TODO Auto-generated method stub
		return cartRepo.getAllFoodCart();
	}

	@Override
	public List<Item> getItemByCartId(Integer id) throws GlobalException {
		// TODO Auto-generated method stub
		FoodCart cart = cartRepo.findById(id).get();
		if(cart!=null) {
			List<Item> itemList = cart.getItemList();
			return itemList;
		}
		else
			throw new GlobalException("cart with id not exist");
		//return null;
	}

	@Override
	public FoodCart updateCartByItem(Integer id, Item item) throws GlobalException {
		// TODO Auto-generated method stub
		Optional<FoodCart> existingcart = cartRepo.findById(id);
		if (existingcart.isPresent()) {
			FoodCart cart = existingcart.get();
			List<Item> itemList = cart.getItemList();

			// List<Item> itemsss = new ArrayList<>();
			itemList.add(itemRepo.save(item));
			int itemId = item.getItemid();
			Item assigingitem = itemRepo.findById(itemId).get();
			assigingitem.assignCart(cart);
			return cartRepo.save(cart);
			// return assigingitem;

		} else {
			throw new GlobalException("cart not exist");
		}

	}

	@Override
	public FoodCart updateCartbyCustomer(Integer id, Customer cust) {
		// TODO Auto-generated method stub
		FoodCart cart = cartRepo.findById(id).get();
		Integer custId = cust.getCustomerid();
		cart.setCust(cust);
//		System.out.println(cus
		return cartRepo.save(cart) ;
//		FoodCart cart1 = cart.get(); 
//		Customer cut = custrepo.findById(custId).get();
////		cut.assignCartToCustomer(cart1);
//		cartRepo.save(cart1);
//		System.out.println( cartRepo.findById(cart1.getId()));
//		return null;

	}

	@Override
	public FoodCart getCartBYEmail(String email) throws GlobalException {
		// TODO Auto-generated method stub
		Customer customer = custrepo.getCustomerByEmail1(email);
		if (customer == null) {
			throw new GlobalException("customer with emailID: " + email + " not exist");

		} else {
			int custId = customer.getCustomerid();
			FoodCart cart = cartRepo.getCartByCustomerId(custId);
			return cart;
		}
	}

//	@Override
//	public FoodCart deleteItemInCartByID(Integer cartID) throws GlobalException {
//		// TODO Auto-generated method stub
//		FoodCart existingcart = cartRepo.findById(cartID).get();
////		if (existingcart.isPresent()) {
//			FoodCart cart = cartRepo.findById(cartID).get();
//			List<Item> itemList = cart.getItemList();
//			
//			for (int i = 0; i < itemList.size();i++) {
//				itemList.remove(i);
//			
//			}
//			cart.setItemList(itemList);
//			//System.out.println(itemList);
//	
////			return cartRepo.save(cart);
////
////		} else {
////			throw new GlobalException("cart not exist");
////		}
//			System.out.println(existingcart);
//		return cartRepo.save(existingcart);
//		
//
//	}

//	@Override
//	public String deleteCartByID(Integer cartID) {
//		// TODO Auto-generated method stub
//		cartRepo.deleteById(cartID);;
//				return "cart deleted";
//	}

	@SuppressWarnings("null")
//	@Override
//	public FoodCart updateItemToNull(Integer id) {
//		// TODO Auto-generated method stub
//		FoodCart existingcart = cartRepo.findById(id).get();
//		List<Item> itemList = null;
//		itemList.add(itemRepo.save(null));
//		int itemId = item.getItemid();
//		Item assigingitem = itemRepo.findById(itemId).get();
//		assigingitem.assignCart(cart);
//		return cartRepo.save(cart);
//		Item item = null;
//		item.assignCart(existingcart);
//		existingcart.setItemList(null);
//		return cartRepo.save(existingcart);
//	}

	@Override
	public FoodCart updatePaymentStatus(Integer id) {
		// TODO Auto-generated method stub
		Optional<FoodCart> existingcart = cartRepo.findById(id);
		if(existingcart.isPresent()) {
			FoodCart cart = cartRepo.findById(id).get();
			cart.setPaymentStatus("paid");
		return	cartRepo.save(cart);
		}
		else {
			return null;
		}
	}

}
