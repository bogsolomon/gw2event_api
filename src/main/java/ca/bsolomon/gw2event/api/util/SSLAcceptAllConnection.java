package ca.bsolomon.gw2event.api.util;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;

public class SSLAcceptAllConnection {
	
	private static SSLSocketFactory ssf = null;
	
	public HttpClient createConnection() {
		HttpClient httpclient = new DefaultHttpClient();
		
		try {
			ClientConnectionManager ccm = httpclient.getConnectionManager();
			SchemeRegistry sr = ccm.getSchemeRegistry();
			sr.register(new Scheme("https", 443, createSocketFactory()));
			
			httpclient = new DefaultHttpClient(ccm, httpclient.getParams());
			
			return httpclient;
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (CertificateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	private SSLSocketFactory createSocketFactory() throws CertificateException,
			IOException, NoSuchAlgorithmException, KeyStoreException,
			KeyManagementException {
		if (ssf == null) {
			SSLContext sslCon = SSLContext.getInstance("TLS");
			sslCon.init(null, new TrustManager[]{new TrustManager()}, null);
			ssf = new SSLSocketFactory(sslCon);
		}
	
		return ssf;
	}
}
