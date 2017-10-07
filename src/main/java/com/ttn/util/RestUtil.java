package com.ttn.util;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;

public class RestUtil {
	
	public static HttpResponse callGetAPI(String schemeType,String baseUrl,String path,Map<String,String> getParams) throws URISyntaxException, ClientProtocolException, IOException{
        URIBuilder builder = new URIBuilder(); 
        builder.setScheme(schemeType);
        builder.setHost(baseUrl);
        builder.setPath(path);
        Iterator<Entry<String, String>> it = getParams.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String,String> pair = it.next();
            builder.setParameter(pair.getKey(), pair.getValue());
        }
        URI uri = builder.build(); 
        HttpGet httpGet = new HttpGet(uri); 
        httpGet.setHeader(HttpHeaders.ACCEPT,"application/json");
        httpGet.setHeader(HttpHeaders.CONTENT_TYPE,"application/json");
        HttpClient httpclient = HttpClients.createDefault();
        return httpclient.execute(httpGet);
    }
	
	public static boolean isValidResponse(HttpResponse response) {
        int responseCode = response.getStatusLine().getStatusCode();
        if(responseCode == 200){
            return true;
        }
        return false;
    }

}
