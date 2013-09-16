package ca.bsolomon.gw2.api;

import org.apache.http.client.HttpClient;

import ca.bsolomon.gw2event.api.util.SSLConn;

import com.fasterxml.jackson.databind.ObjectMapper;

public class GW2APIConstants {

	protected static final String API_GUILDWARS2_URL = "http://api.guildwars2.com/";
	protected static final String API_VERSION = "v1/";
	protected static final String EVENT_NAMES_JSON = "event_names.json";
	protected static final String MAP_NAMES_JSON = "map_names.json";
	protected static final String WORLD_NAMES_JSON = "world_names.json";
	protected static final String EVENTS_JSON = "events.json?";
	protected static final String EVENT_DETAILS_JSON = "event_details.json";
	protected static final String MAP_DETAILS_JSON = "maps.json";
	protected static final String MAP_ID = "map_id=";
	protected static final String WORLD_ID = "world_id=";
	protected static final String EVENT_ID = "event_id=";
	protected static final String BUILD_VERSION = "build.json";
	
	protected static final String WvW_MATCHES_JSON = "wvw/matches.json";
	protected static final String WvW_MATCH_DETAILS = "wvw/match_details.json?match_id=";

	protected HttpClient httpclient;
	protected static SSLConn sslConn = new SSLConn();

	protected static ObjectMapper objectMapper = new ObjectMapper();
	
	public GW2APIConstants() {
		super();
	}

}