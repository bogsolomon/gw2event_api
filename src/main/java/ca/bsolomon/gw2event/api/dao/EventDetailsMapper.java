package ca.bsolomon.gw2event.api.dao;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EventDetailsMapper {

	@JsonProperty("events")
	private List<Map<String, EventDetails>> events;

	public List<Map<String, EventDetails>> getEvents() {
		return events;
	}

	public void setEvents(List<Map<String, EventDetails>> events) {
		this.events = events;
	}
}
