package ca.bsolomon.gw2event.api.dao;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MapDetail {

	@JsonProperty("map_name")
	private String mapName;
	
	@JsonProperty("min_level")
	private Integer minLevel;
	
	@JsonProperty("max_level")
	private Integer maxLevel;
	
	@JsonProperty("default_floor")
	private Integer defaultFloor;
	
	@JsonProperty("floors")
	private List<Integer> floors;
	
	@JsonProperty("region_id")
	private Integer regionId;
	
	@JsonProperty("region_name")
	private String regionName;
	
	@JsonProperty("continent_id")
	private Integer continentId;
	
	@JsonProperty("continent_name")
	private String continentName;
	
	@JsonProperty("map_rect")
	private List<List<Integer>> mapRect;
	
	@JsonProperty("continent_rect")
	private List<List<Integer>> continentRect;

	public String getMapName() {
		return mapName;
	}

	public void setMapName(String mapName) {
		this.mapName = mapName;
	}

	public Integer getMinLevel() {
		return minLevel;
	}

	public void setMinLevel(Integer minLevel) {
		this.minLevel = minLevel;
	}

	public Integer getMaxLevel() {
		return maxLevel;
	}

	public void setMaxLevel(Integer maxLevel) {
		this.maxLevel = maxLevel;
	}

	public Integer getDefaultFloor() {
		return defaultFloor;
	}

	public void setDefaultFloor(Integer defaultFloor) {
		this.defaultFloor = defaultFloor;
	}

	public List<Integer> getFloors() {
		return floors;
	}

	public void setFloors(List<Integer> floors) {
		this.floors = floors;
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public Integer getContinentId() {
		return continentId;
	}

	public void setContinentId(Integer continentId) {
		this.continentId = continentId;
	}

	public String getContinentName() {
		return continentName;
	}

	public void setContinentName(String continentName) {
		this.continentName = continentName;
	}

	public List<List<Integer>> getMapRect() {
		return mapRect;
	}

	public void setMapRect(List<List<Integer>> mapRect) {
		this.mapRect = mapRect;
	}

	public List<List<Integer>> getContinentRect() {
		return continentRect;
	}

	public void setContinentRect(List<List<Integer>> continentRect) {
		this.continentRect = continentRect;
	}
}
