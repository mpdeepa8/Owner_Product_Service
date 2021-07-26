package com.demo.veg.service;

import java.util.List;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.veg.entity.VegItems;
import com.demo.veg.exception.VegetableNotFoundException;
import com.demo.veg.repository.VegItemsRepository;

@Service
public class VegItemsServiceImpl implements VegItemsService{
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(VegItemsServiceImpl.class);
	
	@Autowired
	private VegItemsRepository vegItemsRepository;

	@Override
	public List<VegItems> getAllItems() {
		
		LOGGER.info("Inside getAllItems()");
		List<VegItems> findAll = vegItemsRepository.findAll();
		
		return findAll;
	}

	@Override
	public VegItems addVegItems(VegItems items) {
		
		LOGGER.info("Inside addVegItems()");
		
		VegItems item = vegItemsRepository.save(items);
		return item;
	}
	
	// to update the item

	@Override
	public VegItems updateVegItems(VegItems items) throws VegetableNotFoundException {
		
		LOGGER.info("Inside updateVegItems()");
		
		
		long itemId = items.getItemId();
		
		if(!vegItemsRepository.findById(itemId).isPresent()) throw new VegetableNotFoundException();
		
		Optional<VegItems> findById = vegItemsRepository.findById(itemId);
		VegItems vegItems = findById.get();
		vegItems.setItemName(items.getItemName());
		vegItems.setItemPrice(items.getItemPrice());
		vegItems.setItemStock(items.getItemStock());
		
		vegItemsRepository.save(items);
		return vegItemsRepository.getOne(itemId);
	}
	
	// to delete the item

	@Override
	public void deleteVegItemById(Long itemId) throws VegetableNotFoundException  {
		
		LOGGER.info("Inside deleteVegItemById ()");
		if(!vegItemsRepository.findById(itemId).isPresent()) throw new VegetableNotFoundException();
		
	    
		vegItemsRepository.deleteById(itemId);
		
	}

	@Override
	public List<VegItems> searchItemByName(String itemName) throws VegetableNotFoundException {
		
		LOGGER.info("Inside searchItemByName()");
		
		List<VegItems> searchByItemNameLike = vegItemsRepository.searchByItemNameLike(itemName);
		return searchByItemNameLike;
	}

	@Override
	public Optional<VegItems> vegItemById(Long itemId) throws VegetableNotFoundException {
		LOGGER.info("Inside vegItemById()");
		
		Optional<VegItems> findById = vegItemsRepository.findById(itemId);
		return findById;
	}

	

	
	

	
	

}
