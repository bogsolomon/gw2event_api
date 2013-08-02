package ca.bsolomon.gw2event.api.dao;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EventStatusMapper {

	@JsonProperty("events")
	private List<Map<String, EventStatus>> events;

	public List<Map<String, EventStatus>> getEvents() {
		return events;
	}

	public void setEvents(List<Map<String, EventStatus>> events) {
		this.events = events;
	}
}
