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
import org.springframework.web.bind.annotation.RestController;

import com.edu.dao.Item;
import com.edu.error.GlobalException;
import com.edu.service.ItemService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;

	@PostMapping("/saveItem")
	public ResponseEntity<Item> saveItem(@Valid @RequestBody Item item) {
		Item ite = itemService.saveItem(item);
		return new ResponseEntity<Item>(ite, HttpStatus.CREATED);
	}

	// http://localhost:8990/getAllItems
	@GetMapping("/getAllItems")
	List<Item> getAllItem() {
		return itemService.getAllItems();
	}

	
	@DeleteMapping("/deleteItemById/{itemid}/{restid}")
	public List<Item> deleteItemById(@PathVariable Integer itemid, @PathVariable Integer restid) {
		return itemService.deleteItemById(itemid,restid);
//		return "delete";
	}

	
//	

	// http://localhost:8990/updateItemById/{itemid}
	@PutMapping("/updateItemById/{itemid}")
	Item updateItemById(@PathVariable("itemid") Integer itemid,
			@RequestBody Item item) throws GlobalException {
		return itemService.updateItemById(itemid, item);
	}

	//http://localhost:8990/itemAssignedRestaurant/item/{itemid}/restaurant/{restid}
	@GetMapping("/itemAssignedRestaurant/item/{itemid}/restaurant/{restid}")
	public Item itemAssignedRestaurantAddress(@PathVariable Integer itemid, @PathVariable Integer restid) {
		return itemService.itemAssignedRestaurant(itemid, restid);
	}
	
	//http://localhost:8990/getItemByRestId/{addressid}
	@GetMapping("/getItemByRestId/{restid}")
	public List<Item> getItemByRestId(@PathVariable Integer restid) throws GlobalException {
		return itemService.getItemByRestId(restid);
	}
	
	@PostMapping("/saveItemByRestId/{restid}")
	public Item saveItemByRestId(@Valid @RequestBody Item item, @PathVariable("restid") Integer restid) throws GlobalException {
		return itemService.saveItemByRestId(item,restid);
	}
	
	
	@GetMapping("/getItemById/{itemid}")	
	public Item getItemById(@PathVariable Integer itemid) {
		return itemService.getItemById(itemid);
	}
	
//	@GetMapping("/assignItemToCart/{itemId}/{cartID}")
//	public Item assignItemToCart(@PathVariable("itemId") Integer itemID,@PathVariable("cartID") Integer cartID) {
//		return itemService.assignItemToCart(itemID,cartID);
//		
//	}
	
	
	
//	@PostMapping("/saveItemByRestId/{restid}")
//	public List<Item> saveItemByRestId(@Valid @RequestBody Item item, @PathVariable("restid") Integer restid) throws GlobalException {
//		return itemService.saveItemByRestId(item,restid);
//	}
	
	

}
