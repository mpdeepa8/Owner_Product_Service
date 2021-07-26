package com.demo.veg.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vegtables")
public class VegItems implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5801298221436102973L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemId;
	@Column(name="ITEM_NAME")
	private String itemName;
	@Column(name="PRICE")
	private Double itemPrice;
	@Column(name="ITEM_STOCK")
	private  int itemStock;
	
	
	public VegItems() {
		super();
	}
	public VegItems(Long itemId, String itemName, Double itemPrice, int itemStock) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemStock = itemStock;
	}
	public int getItemStock() {
		return itemStock;
	}
	public void setItemStock(int itemStock) {
		this.itemStock = itemStock;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}
	

}
