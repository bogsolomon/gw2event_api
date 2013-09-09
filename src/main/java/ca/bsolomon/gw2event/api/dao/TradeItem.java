package ca.bsolomon.gw2event.api.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TradeItem {

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("data_id")
	private int data_id;
	
	@JsonProperty("type_id")
	private int type_id;
	
	@JsonProperty("item_image_hash")
	private String item_image_hash;
	
	@JsonProperty("guid")
	private String guid;

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getData_id() {
		return data_id;
	}

	public void setData_id(int data_id) {
		this.data_id = data_id;
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public String getItem_image_hash() {
		return item_image_hash;
	}

	public void setItem_image_hash(String item_image_hash) {
		this.item_image_hash = item_image_hash;
	}
	
	public String toString() {
		return name;
	}
}
