package ca.bsolomon.gw2event.api.dao;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MapDetailsMapper {

	@JsonProperty("maps")
	private List<Map<String, MapDetail>> maps;

	public List<Map<String, MapDetail>> getMaps() {
		return maps;
	}

	public void setMaps(List<Map<String, MapDetail>> maps) {
		this.maps = maps;
	}
}
