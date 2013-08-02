package ca.bsolomon.gw2event.api.dao;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EventStatus {

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("level")
	private Integer level;
	
	@JsonProperty("map_id")
	private String mapId;
	
	@JsonProperty("location")
	private Location location;
	
	@JsonProperty("flags")
	private List<String> flags;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getMapId() {
		return mapId;
	}

	public void setMapId(String mapId) {
		this.mapId = mapId;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<String> getFlags() {
		return flags;
	}

	public void setFlags(List<String> flags) {
		this.flags = flags;
	}
}
