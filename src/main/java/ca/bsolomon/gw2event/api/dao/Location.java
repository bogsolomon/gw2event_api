package ca.bsolomon.gw2event.api.dao;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {

	@JsonProperty("type")
	private String type;
	
	@JsonProperty("radius")
	private Integer radius;
	
	@JsonProperty("rotation")
	private Float rotation;
	
	@JsonProperty("center")
	private List<Integer> center;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getRadius() {
		return radius;
	}

	public void setRadius(Integer radius) {
		this.radius = radius;
	}

	public Float getRotation() {
		return rotation;
	}

	public void setRotation(Float rotation) {
		this.rotation = rotation;
	}

	public List<Integer> getCenter() {
		return center;
	}

	public void setCenter(List<Integer> center) {
		this.center = center;
	}
}

