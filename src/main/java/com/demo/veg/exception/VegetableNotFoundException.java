package com.demo.veg.exception;

public class VegetableNotFoundException extends RuntimeException {
	

	private static final long serialVersionUID = 6767842854104562279L;
	
   public VegetableNotFoundException() {
		
	}
	public VegetableNotFoundException(String msg) {
		super(msg);
	}

}
