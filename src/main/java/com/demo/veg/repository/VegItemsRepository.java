package com.demo.veg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.veg.entity.VegItems;

public interface VegItemsRepository extends JpaRepository<VegItems, Long> {
	
	@Query("SELECT v FROM VegItems v WHERE v.itemName LIKE %:itemName%")
	
    List<VegItems> searchByItemNameLike(@Param("itemName") String ItemName);
	

}
