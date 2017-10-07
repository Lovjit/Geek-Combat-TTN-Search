package com.ttn.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.ttn.dto.UserDTO;
import com.ttn.util.RestUtil;

@Service
public class UserServiceImpl {
	
	public UserDTO getUserInfo(String key) throws ClientProtocolException, URISyntaxException, IOException{
		UserDTO userDTO = null;
		Map<String,String> getParams = new HashMap<String,String>();
		getParams.put("access_token", key);
		HttpResponse httpResponse = RestUtil.callGetAPI("https", "www.googleapis.com", "/plus/v1/people/me", getParams);
		if(RestUtil.isValidResponse(httpResponse)){
			HttpEntity resEntity = httpResponse.getEntity();
	        String response = EntityUtils.toString(resEntity);
	        JSONObject jObjUserDetails = new JSONObject(response);
	        String email = jObjUserDetails.getJSONArray("emails").getJSONObject(0).getString("value");
	        String firstName = jObjUserDetails.getJSONObject("name").getString("givenName");
	        String lastName = jObjUserDetails.getJSONObject("name").getString("familyName");
	        String userName = jObjUserDetails.getString("displayName");
	        String profilePicUrl = jObjUserDetails.getJSONObject("image").getString("url");
			userDTO = new UserDTO();
			userDTO.setEmail(email);
			userDTO.setFirstName(firstName);
			userDTO.setLastName(lastName);
			userDTO.setUserName(userName);
			userDTO.setProfilePicUrl(profilePicUrl);
		}
		return userDTO;
	}
	
	public static void main(String[] args) throws ClientProtocolException, URISyntaxException, IOException {
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		UserDTO userDTO = userServiceImpl.getUserInfo("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJsb3ZqaXQuc2luZ2hAdG90aGVuZXcuY29tIiwiYXVkaWVuY2UiOiJ3ZWIiLCJjcmVhdGVkIjoxNTA3MzYzMDg0MDE2LCJleHAiOjE1MDc0NDk0ODR9.jvhKd1UMQVdJw5YRvpTd9DG6WARJ46LRFzlgkCtWwN9WzrEkhkIBfyac1jfu6_f_D5WDkx-uHUzGl6lkb9Kt1Q");
		System.out.println("Here");
	}

}
