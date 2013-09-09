package ca.bsolomon.gw2event.api.dao;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TradeListing {

	@JsonProperty("listings")
	private int listings;
	@JsonProperty("unit_price")
	private int unit_price;
	@JsonProperty("quantity")
	private int quantity;
	
	public int getListings() {
		return listings;
	}
	public void setListings(int listings) {
		this.listings = listings;
	}
	public int getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(int unit_price) {
		this.unit_price = unit_price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public boolean equals(Object obj) {
		TradeListing that = (TradeListing)obj;
		
		if (that.unit_price == this.unit_price) {
			return true;
		}
		
		return false;
	}
	@Override
	public String toString() {
		return unit_price+" "+quantity+" "+listings;
	}
}
