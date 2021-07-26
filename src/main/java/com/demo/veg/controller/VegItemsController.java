package com.demo.veg.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.veg.entity.VegItems;
import com.demo.veg.service.VegItemsService;
import com.demo.veg.service.VegItemsServiceImpl;

@RestController
@RequestMapping("/veg")
public class VegItemsController {

	private static final Logger LOGGER = LoggerFactory.getLogger(VegItemsController.class);

	@Autowired
	private VegItemsService vegItemsService;

	// http://localhost:8085/vegowner/veg/item
	// get all vegetables

	@GetMapping(path = "/item", produces = "application/json")
	public List<VegItems> getAllVegItems() {

		LOGGER.info("Inside getAllVegItems()");

		List<VegItems> allItems = vegItemsService.getAllItems();
		return allItems;

	}

	// http://localhost:8085/vegowner/veg/add
	// to add one vegetable

	@PostMapping(path = "/add", produces = "application/json")
	public ResponseEntity<VegItems> addVegItem(@RequestBody VegItems vegItems) {

		LOGGER.info("Inside addVegItem()");

		VegItems addVegItems = vegItemsService.addVegItems(vegItems);

		return new ResponseEntity<VegItems>(addVegItems, HttpStatus.CREATED);

	}
	// http://localhost:8085/vegowner/veg/update/
	// to update existing vegetable

	@PutMapping(path = "/update", produces = "application/json") // To update the items details in the menu
	public VegItems updateItem(@RequestBody VegItems vegItems) {

		LOGGER.info("Inside updateItem()");

		VegItems updateVegItem = vegItemsService.updateVegItems(vegItems);

		return updateVegItem;

	}

	// http://localhost:8085/vegowner/veg/delete/id
	// to delete existing vegetable

	@DeleteMapping("/delete/{itemId}")
	public void deleteItem(@PathVariable("itemId") Long itemId) {

		LOGGER.info("Inside deleteItem()");

		vegItemsService.deleteVegItemById(itemId);

	}
	// http://localhost:8085/vegowner/veg/search/
	// to search existing item by name

	@GetMapping(path = "/search/{itemName}", produces = "application/json")

	public List<VegItems> searchByItemName(@PathVariable("itemName") String itemName) {

		LOGGER.info("Inside searchByItemName()");
		List<VegItems> searchItemByName = vegItemsService.searchItemByName(itemName);
		return searchItemByName;

	}
	// http://localhost:8085/vegowner/veg/searchbyid/
	// search item by id

	@GetMapping(path = "/searchbyid/{itemID}", produces = "application/json")
	public Optional<VegItems> vegItemById(@PathVariable("itemID") Long itemID) {

		Optional<VegItems> vegItemById = vegItemsService.vegItemById(itemID);
		return vegItemById;

	}

}
