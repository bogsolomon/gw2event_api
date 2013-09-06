package ca.bsolomon.gw2event.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import ca.bsolomon.gw2event.api.dao.TradeItem;
import ca.bsolomon.gw2event.api.dao.TradeListing;
import ca.bsolomon.gw2event.api.util.SSLAcceptAllConnection;

public class GW2TradeAPI {

	private static final String BUYS = "buys";
	private static final String SELLS = "sells";
	private static final String GW2_TRADE_LISTINGS = "https://tradingpost-live.ncplatform.net/ws/listings.json?type=";
	private static final String GW2_TRADE = "https://tradingpost-live.ncplatform.net";
	private static final String GW2_TRADE_SEARCH = "https://tradingpost-live.ncplatform.net/ws/search.json?typeahead=1&count=0&text=";
	private static final String GW2_ACCOUNT_LOGIN = "https://account.guildwars2.com/login";
	private static final String GW2_TRADE_LOGIN = "https://account.guildwars2.com/login?redirect_uri=http%3A%2F%2Ftradingpost-live.ncplatform.net%2Fauthenticate%3Fsource%3D%252F&game_code=gw2";
	private static CookieStore cs = new BasicCookieStore();

	private HttpContext localContext = new BasicHttpContext();
	private SSLAcceptAllConnection sslConn = new SSLAcceptAllConnection();
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	public boolean login(String uname, String password) {
		HttpClient client = sslConn.createConnection();
		
		HttpPost httppost = new HttpPost(GW2_TRADE_LOGIN);
	    localContext.setAttribute(ClientContext.COOKIE_STORE, cs);
	    
	    try {
	        // Add your data
	        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
	        nameValuePairs.add(new BasicNameValuePair("email", uname));
	        nameValuePairs.add(new BasicNameValuePair("password", password));
	        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	        httppost.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.BROWSER_COMPATIBILITY);

	        //Add headers
	        httppost.addHeader("Referer",GW2_ACCOUNT_LOGIN);
	        
	        // Execute HTTP Post Request
	        HttpResponse response = client.execute(httppost, localContext);
	        
	        if (response.getStatusLine().getStatusCode() == 200 &&
	        		cs.getCookies().size() > 0) {
	        	return true;
	        }
	    } catch (ClientProtocolException e) {
	    	e.printStackTrace();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    } finally {
	    	httppost.releaseConnection();
	    }
	    
	    return false;
	}
	
	public List<TradeItem> searchItems(String text) {
		HttpClient client = sslConn.createConnection();
		
		HttpGet get = new HttpGet(GW2_TRADE_SEARCH+text);
		get.addHeader("Referer",GW2_TRADE);
		
		try {
			HttpResponse response = client.execute(get, localContext);
			
			BufferedReader rd = new BufferedReader
	        		  (new InputStreamReader(response.getEntity().getContent()));
			
			StringBuffer longline = new StringBuffer();
    		String line = "";
    		while ((line = rd.readLine()) != null) {
    			longline.append(line);
    		}
    		
    		int startIndex = longline.indexOf("results")+"results".length()+2;
    		
    		List<TradeItem> result = objectMapper.readValue(longline.substring(startIndex), 
    				objectMapper.getTypeFactory().constructCollectionType(List.class, TradeItem.class));
    		
    		return result;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<TradeListing> getBuyListings(TradeItem item) {
		HttpClient client = sslConn.createConnection();
		
		HttpGet get = new HttpGet(GW2_TRADE_LISTINGS+BUYS+"&id="+item.getData_id());
		get.addHeader("Referer",GW2_TRADE);
		
		try {
			HttpResponse response = client.execute(get, localContext);
			
			BufferedReader rd = new BufferedReader
	        		  (new InputStreamReader(response.getEntity().getContent()));
			
			StringBuffer longline = new StringBuffer();
    		String line = "";
    		while ((line = rd.readLine()) != null) {
    			longline.append(line);
    		}
    		
    		int startIndex = longline.indexOf(BUYS)+BUYS.length()+2;
    		
    		List<TradeListing> result = objectMapper.readValue(longline.substring(startIndex), 
    				objectMapper.getTypeFactory().constructCollectionType(List.class, TradeListing.class));
    		
    		return result;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<TradeListing> getSellListings(TradeItem item) {
		HttpClient client = sslConn.createConnection();
		
		HttpGet get = new HttpGet(GW2_TRADE_LISTINGS+SELLS+"&id="+item.getData_id());
		get.addHeader("Referer",GW2_TRADE);
		
		try {
			HttpResponse response = client.execute(get, localContext);
			
			BufferedReader rd = new BufferedReader
	        		  (new InputStreamReader(response.getEntity().getContent()));
			
			StringBuffer longline = new StringBuffer();
    		String line = "";
    		while ((line = rd.readLine()) != null) {
    			longline.append(line);
    		}
    		
    		int startIndex = longline.indexOf(SELLS)+SELLS.length()+2;
    		
    		List<TradeListing> result = objectMapper.readValue(longline.substring(startIndex), 
    				objectMapper.getTypeFactory().constructCollectionType(List.class, TradeListing.class));
    		
    		return result;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
