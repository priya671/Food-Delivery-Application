package com.edu.controller;

import java.util.List;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edu.dao.Item;
import com.edu.dao.Restaurant;
import com.edu.error.GlobalException;
import com.edu.repository.RestaurantRepository;
import com.edu.service.RestaurantService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	// http://localhost:8990/saveRestaurantAddress
//	@PostMapping("/saveRestaurantAddress")
//	RestaurantAddress saveRestaurantAddress(@RequestBody RestaurantAddress restaurantaddress) {
//		return restaurantAddressService.saveRestaurantAddress(restaurantaddress);
//	}
	
	@PostMapping("/saveRestaurant")
	public ResponseEntity<Restaurant> saveRestaurant(@Valid @RequestBody Restaurant restaurant){
		Restaurant cust = restaurantService.saveRestaurant(restaurant);
		return new ResponseEntity<Restaurant>(cust, HttpStatus.CREATED);
	}
	
	//http://localhost:9999/getAllRestaurantAddress
	@GetMapping("/getAllRestaurant")
	List<Restaurant> getAllRestaurant(){
		return restaurantService.getAllRestaurant();
	}
	
	//http://localhost:8990/deleteRestaurantById/{addid}
	@DeleteMapping("/deleteRestaurantById/{restid}")
	List<Restaurant> deleteRestaurantById(@PathVariable("restid") Integer restid) throws GlobalException {
		return restaurantService.deleteRestaurantById(restid);
		//return "Record Deleted";
	}
	
	//http://localhost:8990/updateRestaurantAddressById/{addid}
	@PutMapping("/updateRestaurantById/{restid}")
	Object updateRestaurantById(@PathVariable("restid") Integer restid, @RequestBody Restaurant restaurant) throws GlobalException {
		return restaurantService.updateRestaurantById(restid, restaurant);
	}
	
//	@RequestMapping(method = RequestMethod.GET,value = "/findByName/{name}")
//	public ResponseEntity<Restaurant> findRetaurantByName(@PathVariable("name") String restname) throws GlobalException {
//		Restaurant restaurant  = restaurantService.findRestaurantByName(restname);
//		return new ResponseEntity<Restaurant>(restaurant,HttpStatus.FOUND);
//	}
//	
//	@RequestMapping(method = RequestMethod.PUT,value = "/updateManagerName/{id}/{managerName}")
//	public ResponseEntity<Restaurant> updaterestaurantManagerName(@Valid @PathVariable("id") Integer id,@Valid  @PathVariable("managerName") String managerName) throws GlobalException {
//		Restaurant restaurant = restaurantService.updateRestaurantManagerName(id, managerName);
//		return new ResponseEntity<Restaurant>(restaurant,HttpStatus.ACCEPTED);
//	}
	
	@GetMapping("/getRestaurantById/{restid}")
	public Restaurant getRestaurantById(@PathVariable("restid") Integer restid) {
		return restaurantService.getRestaurantById(restid);
	}
//	@PostMapping("/saveItemByRestIdi/{restid}")
//	public  Restaurant saveItemByRestIdi(@Valid @RequestBody Item item, @PathVariable("restid") Integer restid) throws GlobalException {
//		return restaurantService.saveItemByRestIdi(item,restid);
//		 
//	}
	
	@PostMapping("/saveItemByRestIdi/{restid}")
	public  Restaurant saveItemByRestIdi(@Valid @RequestBody Item item,	 @PathVariable("restid") Integer restid) throws GlobalException {
		 restaurantService.saveItemByRestIdi(item,restid);
		 return restaurantRepository.findById(restid).get();
	}
	
//	@PostMapping("/saveItemByRestIdi/{restid}")
//	public List<Restaurant> saveItemByRestIdi(@Valid @RequestBody Item item, @PathVariable("restid") Integer restid) throws GlobalException {
//		return restaurantService.saveItemByRestIdi(item,restid);
//	}
	
	@GetMapping("/getRestaurantByEmail/{email}/{password}")
	public Restaurant getRestaurantByEmail(@PathVariable("email") String email,@PathVariable("password") String password) throws GlobalException {
		return restaurantService.getRestaurantByEmail(email,password);
	}
	
	//search
	@GetMapping("/getAllRestaurantsearch")
	public List<Restaurant> getAllRestaurantsearch(@RequestParam(defaultValue = "") String searchkey){
		List<Restaurant> result = restaurantService.getAllRestaurantsearch(searchkey);
		//System.out.println("Result size is: " + result.size());
		return result;
		
		//return restaurantService.getAllRestaurantsearch(searchkey);
	}
}
