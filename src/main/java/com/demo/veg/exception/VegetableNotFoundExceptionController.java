package com.demo.veg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class VegetableNotFoundExceptionController {
	
	
	public ResponseEntity<Object> exception(VegetableNotFoundException exception){
		return new ResponseEntity<>("Currently item isnot available", HttpStatus.NOT_FOUND
				);
		
	}

}
