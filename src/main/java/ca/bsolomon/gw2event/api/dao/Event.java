package ca.bsolomon.gw2event.api.dao;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Event {

	@JsonProperty("world_id")
	private String worldId;
	
	@JsonProperty("map_id")
	private String mapId;
	
	@JsonProperty("event_id")
	private String eventId;
	
	@JsonProperty("state")
	private String state;

	public String getWorldId() {
		return worldId;
	}

	public void setWorldId(String worldId) {
		this.worldId = worldId;
	}

	public String getMapId() {
		return mapId;
	}

	public void setMapId(String mapId) {
		this.mapId = mapId;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
