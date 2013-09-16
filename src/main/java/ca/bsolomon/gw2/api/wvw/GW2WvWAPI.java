package ca.bsolomon.gw2.api.wvw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;

import ca.bsolomon.gw2.api.GW2APIConstants;
import ca.bsolomon.gw2.api.wvw.dao.Maps;
import ca.bsolomon.gw2.api.wvw.dao.WvWMatch;

public class GW2WvWAPI extends GW2APIConstants {

	private static final String WVW_MATCHES = "wvw_matches";
	private static final String MAPS = "maps";

	public List<WvWMatch> getMatches() {
		if (httpclient == null)
			httpclient = sslConn.createConnection();
		
		HttpGet httppost = new HttpGet(API_GUILDWARS2_URL+API_VERSION+WvW_MATCHES_JSON);
		
		try {
	        // Add your data
	        HttpResponse response = httpclient.execute(httppost);

	        BufferedReader rd = new BufferedReader
	        		  (new InputStreamReader(response.getEntity().getContent()));
	        		    
	        StringBuffer longline = new StringBuffer();
    		String line = "";
    		while ((line = rd.readLine()) != null) {
    			longline.append(line);
    		}
    		
    		int startIndex = longline.indexOf(WVW_MATCHES)+WVW_MATCHES.length()+2;
    		
    		List<WvWMatch> result = objectMapper.readValue(longline.substring(startIndex), 
    				objectMapper.getTypeFactory().constructCollectionType(List.class, WvWMatch.class));
    		
    		return result;
		} catch (ClientProtocolException e) {
	    	System.out.println("Protocol exception");
	    } catch (IOException e) {
	    	System.out.println("Can not connect to server");
	    } finally {
	    	httppost.releaseConnection();
	    }
		
		return null;
	}
	
	public List<Maps> getMatcheObjectives(String matchId) {
		if (httpclient == null)
			httpclient = sslConn.createConnection();
		
		HttpGet httppost = new HttpGet(API_GUILDWARS2_URL+API_VERSION+WvW_MATCH_DETAILS+matchId);
		
		try {
	        // Add your data
	        HttpResponse response = httpclient.execute(httppost);

	        BufferedReader rd = new BufferedReader
	        		  (new InputStreamReader(response.getEntity().getContent()));
	        		    
	        StringBuffer longline = new StringBuffer();
    		String line = "";
    		while ((line = rd.readLine()) != null) {
    			longline.append(line);
    		}
    		
    		int startIndex = longline.indexOf(MAPS)+MAPS.length()+2;
    		
    		List<Maps> result = objectMapper.readValue(longline.substring(startIndex), 
    				objectMapper.getTypeFactory().constructCollectionType(List.class, Maps.class));
    		
    		return result;
		} catch (ClientProtocolException e) {
	    	System.out.println("Protocol exception");
	    } catch (IOException e) {
	    	System.out.println("Can not connect to server");
	    } finally {
	    	httppost.releaseConnection();
	    }
		
		return null;
	}
}
