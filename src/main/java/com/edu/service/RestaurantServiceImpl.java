package com.edu.service;

import java.awt.print.Pageable;
import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.dao.Item;
import com.edu.dao.Restaurant;
import com.edu.error.GlobalException;
import com.edu.repository.ItemRepository;
import com.edu.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private ItemRepository itemRepository;

	@Override
	public Restaurant saveRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		return restaurantRepository.save(restaurant);
	}

	@Override
	public List<Restaurant> getAllRestaurant() {
		// TODO Auto-generated method stub
		return restaurantRepository.findAll();
	}

	@Override
	public List<Restaurant> deleteRestaurantById(Integer restid) throws GlobalException {
		// TODO Auto-generated method stub
		Optional<Restaurant> rob = restaurantRepository.findById(restid);
		if(!rob.isPresent()) {
			throw new GlobalException("Restaurant Address id=" + restid + " does not exist");
		}
	
		 restaurantRepository.deleteById(restid);
		return restaurantRepository.findAll();
	}

	@Override
	public Restaurant updateRestaurantById(Integer restid, Restaurant restaurantaddress) throws GlobalException {
		// TODO Auto-generated method stub
		Restaurant restaurant = null;
		Optional<Restaurant> rob = restaurantRepository.findById(restid);
		if(!rob.isPresent()) {
			throw new GlobalException("Restaurant Address id=" + restid + " does not exist");
		}
		else {
			restaurant = restaurantRepository.findById(restid).get();
			restaurant.setArea(restaurantaddress.getArea());
			restaurant.setCity(restaurantaddress.getCity());
			restaurant.setCountry(restaurantaddress.getCountry());
			restaurant.setPincode(restaurantaddress.getPincode());
			restaurant.setState(restaurantaddress.getState());
			restaurant.setPic(restaurantaddress.getPic());
			restaurant.setRestname(restaurantaddress.getRestname());
			restaurant.setManagerName(restaurantaddress.getManagerName());
			restaurant.setContactNumber(restaurantaddress.getContactNumber());
			restaurant.setEmail(restaurantaddress.getEmail());
			restaurant.setPassword(restaurantaddress.getPassword());	
			restaurant.setStatus(restaurantaddress.isStatus());
		}
		
		return restaurantRepository.save(restaurant);
	}

	@Override
	public Restaurant saveItemByRestIdi(Item item, Integer restid) throws GlobalException{
		// TODO Auto-generated method stub
		
		Optional<Restaurant> res = restaurantRepository.findById(restid);
		
		if(!res.isPresent()) {
			throw new GlobalException(restid+ " is not present");
		}
		else {
			Restaurant restaurant = restaurantRepository.findById(restid).get();
			List<Item> list = restaurant.getItem();
			if(list.isEmpty()){
				List<Item> newList = new ArrayList<>();
				newList.add(itemRepository.save(item));
//				restaurant.setItem(newList);
//				
//				System.out.println(newList);
//				restaurantRepository.save(restaurant);
				int id=item.getItemid();
				
				Item eob=itemRepository.findById(id).get();
				Restaurant dob= restaurantRepository.findById(restid).get();
				eob.itemAssignedRestaurantAddress(dob);
				
				itemRepository.save(eob);
				
				return restaurant;
				}
			else {
				list.add(itemRepository.save(item));
				System.out.println(list);

				int id=item.getItemid();
				
				Item eob=itemRepository.findById(id).get();
				Restaurant dob= restaurantRepository.findById(restid).get();
				eob.itemAssignedRestaurantAddress(dob);
				
				itemRepository.save(eob);
				return restaurant;
			}
		}
	}
	
	
	@Override
	public List<Restaurant> getAllRestaurantsearch(String searchkey){
		
		if(searchkey.equals("")) {
			List<Restaurant> res = restaurantRepository.findAll();
			
			  if(res!=null) 
			  { res= restaurantRepository.searchByStatus(res); } else 
			  {
			  res=null; }
			 
			return res;
		}
		else {
		List<Restaurant>ress= restaurantRepository.findByRestnameContainingIgnoreCase(searchkey);
		System.out.println("***"+ress);
		/*
		 * if(ress!=null) { if(!ress.isEmpty()) ress=
		 * restaurantRepository.searchByStatus(ress); } else { ress=null; }
		 */
		return ress;
		}
		
		
	}

	

	@Override
	public Restaurant getRestaurantById(Integer restid) {
		// TODO Auto-generated method stub
		return restaurantRepository.findById(restid).get();
	}
	
	@Override
	public Restaurant getRestaurantByEmail(String email, String password) {
		// TODO Auto-generated method stub
		 return restaurantRepository.getRestaurantByEmail(email,password);
	}




//	@Override
//	public Restaurant getRestaurantByEmail1(String email, String password) {

//	@Override
//	public Restaurant getRestaurantByEmail(String email, String password) {

//		// TODO Auto-generated method stub
//		return restaurantRepository.getRestaurantByEmail(email,password);
//	}

//	@Override
//	public Restaurant findRestaurantByName(String restname) throws GlobalException {
//		// TODO Auto-generated method stub
//		return restaurantRepository.findByrestaurantName(restname);
//	}
//
//	@Override
//	public Restaurant updateRestaurantManagerName(@Valid Integer id, @Valid String managerName) throws GlobalException {
//		// TODO Auto-generated method stub
//		Optional<Restaurant> res = restaurantRepository.findById(id);
//		if (!res.isPresent())
//			throw new GlobalException("Restaurnat with id : " + id + " not exist");
//
//		Restaurant restaurant = restaurantRepository.findById(id).get();
//		restaurant.setManagerName(managerName);
//		return restaurantRepository.save(restaurant);
//	}
	
	
	

}
