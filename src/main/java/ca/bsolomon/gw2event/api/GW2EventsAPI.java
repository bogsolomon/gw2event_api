package ca.bsolomon.gw2event.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

import ca.bsolomon.gw2event.api.util.SSLConn;

public class GW2EventsAPI {

	private static final String API_GUILDWARS2_URL = "http://api.guildwars2.com/";
	private static final String API_VERSION = "v1/";
	
	private static final String EVENT_NAMES_JSON = "event_names.json";
	private static final String MAP_NAMES_JSON = "map_names.json";
	private static final String WORLD_NAMES_JSON = "world_names.json";
	private static final String EVENTS_JSON = "events.json?";
	
	private static final String MAP_ID = "map_id=";
	private static final String WORLD_ID = "world_id=";
	private static final String EVENT_ID = "event_id=";
	private static final String BUILD_VERSION = "build.json";
	
	public static Map<String, String> eventIdToName = new HashMap<String, String>();
	public static Map<String, String> mapIdToName = new HashMap<String, String>();
	public static Map<Integer, String> worldIdToName = new HashMap<Integer, String>();
	
	private HttpClient httpclient;
	private static SSLConn sslConn = new SSLConn();

	public static void generateEventIds() {
		HttpClient httpclient = sslConn.createConnection();
		
		HttpGet httppost = new HttpGet(API_GUILDWARS2_URL+API_VERSION+EVENT_NAMES_JSON);
		
		try {
	        // Add your data
	        HttpResponse response = httpclient.execute(httppost);

	        BufferedReader rd = new BufferedReader
	        		  (new InputStreamReader(response.getEntity().getContent()));
	        		    
	        String longline = "";
    		String line = "";
    		while ((line = rd.readLine()) != null) {
    			longline+=line;
    		}
    		JSONArray result = (JSONArray) JSONSerializer.toJSON( longline );
    		
    		for (int i=0;i< result.size();i++) {
    			JSONObject obj = result.getJSONObject(i);
    			
    			String eventId = obj.getString("id");
    			String name = obj.getString("name");
    			
    			eventIdToName.put(eventId, name);
    		}
	    } catch (ClientProtocolException e) {
	    	e.printStackTrace();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	}
	
	public static void generateMapIds() {
		HttpClient httpclient = sslConn.createConnection();
		
		HttpGet httppost = new HttpGet(API_GUILDWARS2_URL+API_VERSION+MAP_NAMES_JSON);
		
		try {
	        // Add your data
	        HttpResponse response = httpclient.execute(httppost);

	        BufferedReader rd = new BufferedReader
	        		  (new InputStreamReader(response.getEntity().getContent()));
	        		    
	        String longline = "";
    		String line = "";
    		while ((line = rd.readLine()) != null) {
    			longline+=line;
    		}
    		JSONArray result = (JSONArray) JSONSerializer.toJSON( longline );
    		
    		for (int i=0;i< result.size();i++) {
    			JSONObject obj = result.getJSONObject(i);
    			
    			String eventId = obj.getString("id");
    			String name = obj.getString("name");
    			
    			mapIdToName.put(eventId, name);
    		}
	    } catch (ClientProtocolException e) {
	    	e.printStackTrace();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	}
	
	public JSONArray queryEventIds() {
		if (httpclient == null)
			httpclient = sslConn.createConnection();
		
		HttpGet httppost = new HttpGet(API_GUILDWARS2_URL+API_VERSION+EVENT_NAMES_JSON);
		
		try {
	        // Add your data
	        HttpResponse response = httpclient.execute(httppost);

	        BufferedReader rd = new BufferedReader
	        		  (new InputStreamReader(response.getEntity().getContent()));
	        		    
	        String longline = "";
    		String line = "";
    		while ((line = rd.readLine()) != null) {
    			longline+=line;
    		}
    		JSONArray result = (JSONArray) JSONSerializer.toJSON( longline );
    		
    		return result;
	    } catch (ClientProtocolException e) {
	    	e.printStackTrace();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
		
		return null;
	}
	
	public static void generateNAWorldIds() {
		HttpClient httpclient = sslConn.createConnection();
		
		HttpGet httppost = new HttpGet(API_GUILDWARS2_URL+API_VERSION+WORLD_NAMES_JSON);
		
		try {
	        // Add your data
	        HttpResponse response = httpclient.execute(httppost);

	        BufferedReader rd = new BufferedReader
	        		  (new InputStreamReader(response.getEntity().getContent()));
	        		    
	        String longline = "";
    		String line = "";
    		while ((line = rd.readLine()) != null) {
    			longline+=line;
    		}
    		JSONArray result = (JSONArray) JSONSerializer.toJSON( longline );
    		
    		for (int i=0;i< result.size();i++) {
    			JSONObject obj = result.getJSONObject(i);
    			
    			Integer worldId = obj.getInt("id");
    			String name = obj.getString("name");
    			
    			if (worldId < 2000)
    				worldIdToName.put(worldId, name);
    		}
	    } catch (ClientProtocolException e) {
	    	e.printStackTrace();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	}

	public JSONArray queryServer(int worldId, int mapId) {
		if (httpclient == null)
			httpclient = sslConn.createConnection();
		
		HttpGet httppost = new HttpGet(API_GUILDWARS2_URL+API_VERSION+EVENTS_JSON+WORLD_ID+worldId+"&"+MAP_ID+mapId);
		
		try {
	        // Add your data
	        HttpResponse response = httpclient.execute(httppost);

	        BufferedReader rd = new BufferedReader
	        		  (new InputStreamReader(response.getEntity().getContent()));
	        		    
	        String longline = "";
    		String line = "";
    		while ((line = rd.readLine()) != null) {
    			longline+=line;
    		}
    		JSONObject json = (JSONObject) JSONSerializer.toJSON( longline );
    		JSONArray result = json.getJSONArray("events");
    		
    		return result;
		} catch (ClientProtocolException e) {
	    	e.printStackTrace();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }	
		
		return null;
	}
	
	public JSONObject queryServer(String worldId,String eventId) {
		if (httpclient == null)
			httpclient = sslConn.createConnection();
		
		HttpGet httppost = new HttpGet(API_GUILDWARS2_URL+API_VERSION+EVENTS_JSON+EVENT_ID+eventId+"&"+WORLD_ID+worldId);
		
		try {
	        // Add your data
	        HttpResponse response = httpclient.execute(httppost);

	        BufferedReader rd = new BufferedReader
	        		  (new InputStreamReader(response.getEntity().getContent()));
	        		    
	        String longline = "";
    		String line = "";
    		while ((line = rd.readLine()) != null) {
    			longline+=line;
    		}
    		JSONObject json = (JSONObject) JSONSerializer.toJSON( longline );
    		JSONArray result = json.getJSONArray("events");
    		
    		return result.getJSONObject(0);
		} catch (ClientProtocolException e) {
			System.out.println("Protocol exception");
	    } catch (IOException e) {
	    	System.out.println("Can not connect to server");
	    } catch (JSONException e) {	
	    	System.out.println("JSON exception");
	    } catch (Exception e) {
	    	return null;
	    }
		
		return null;
	}
	
	public JSONArray queryServer(String eventId) {
		if (httpclient == null)
			httpclient = sslConn.createConnection();
		
		HttpGet httppost = new HttpGet(API_GUILDWARS2_URL+API_VERSION+EVENTS_JSON+EVENT_ID+eventId);
		
		try {
	        // Add your data
	        HttpResponse response = httpclient.execute(httppost);

	        BufferedReader rd = new BufferedReader
	        		  (new InputStreamReader(response.getEntity().getContent()));
	        		    
	        String longline = "";
    		String line = "";
    		while ((line = rd.readLine()) != null) {
    			longline+=line;
    		}
    		JSONObject json = (JSONObject) JSONSerializer.toJSON( longline );
    		JSONArray result = json.getJSONArray("events");
    		
    		return result;
		} catch (ClientProtocolException e) {
	    	System.out.println("Protocol exception");
	    } catch (IOException e) {
	    	System.out.println("Can not connect to server");
	    } catch (JSONException e) {	
	    	System.out.println("JSON exception");
	    }
		
		return null;
	}

	public String getEventMap(String eventId) {
		if (httpclient == null)
			httpclient = sslConn.createConnection();
		
		HttpGet httppost = new HttpGet(API_GUILDWARS2_URL+API_VERSION+EVENTS_JSON+EVENT_ID+eventId);
		
		try {
	        // Add your data
	        HttpResponse response = httpclient.execute(httppost);

	        BufferedReader rd = new BufferedReader
	        		  (new InputStreamReader(response.getEntity().getContent()));
	        		    
	        String longline = "";
    		String line = "";
    		while ((line = rd.readLine()) != null) {
    			longline+=line;
    		}
    		JSONObject json = (JSONObject) JSONSerializer.toJSON( longline );
    		JSONArray result = json.getJSONArray("events");
    		
			JSONObject obj = result.getJSONObject(0);
			
			String mapId = obj.getString("map_id");
			return mapIdToName.get(mapId);
		} catch (ClientProtocolException e) {
	    	System.out.println("Protocol exception");
	    } catch (IOException e) {
	    	System.out.println("Can not connect to server");
	    } catch (JSONException e) {	
	    	System.out.println("JSON exception");
	    }
		
		return null;
	}
	
	public String queryBuildVersion() {
		if (httpclient == null)
			httpclient = sslConn.createConnection();
		
		HttpGet httppost = new HttpGet(API_GUILDWARS2_URL+API_VERSION+BUILD_VERSION);
		
		try {
	        // Add your data
	        HttpResponse response = httpclient.execute(httppost);

	        BufferedReader rd = new BufferedReader
	        		  (new InputStreamReader(response.getEntity().getContent()));
	        		    
	        String longline = "";
    		String line = "";
    		while ((line = rd.readLine()) != null) {
    			longline+=line;
    		}
    		JSONObject json = (JSONObject) JSONSerializer.toJSON( longline );
    		
    		return json.getString("build_id");
		} catch (ClientProtocolException e) {
	    	e.printStackTrace();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }	
		
		return null;
	}
}