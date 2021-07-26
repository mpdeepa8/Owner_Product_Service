package com.demo.veg.service;

import java.util.List;
import java.util.Optional;

import com.demo.veg.entity.VegItems;
import com.demo.veg.exception.VegetableNotFoundException;


public interface VegItemsService {
	
         
	public List<VegItems> getAllItems()throws VegetableNotFoundException;
	
	public VegItems addVegItems(VegItems items) throws VegetableNotFoundException;
	public VegItems updateVegItems(VegItems items) throws VegetableNotFoundException;
	public void deleteVegItemById(Long itemId) throws VegetableNotFoundException;
	public List<VegItems> searchItemByName(String itemName) throws VegetableNotFoundException;
	public Optional<VegItems> vegItemById(Long itemId) throws VegetableNotFoundException;
	
	

}
