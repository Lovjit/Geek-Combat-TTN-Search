package com.ttn.service;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ttn.dto.UserDTO;

@Service
public class AuthServiceImpl {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	public ResponseEntity<String> authenticate(JSONObject jObjAuth) throws ClientProtocolException, URISyntaxException, IOException{
		String token = jObjAuth.getString("token");
		UserDTO userDTO = userServiceImpl.getUserInfo(token);
		if(userDTO != null){
			return new ResponseEntity<String>(jObjAuth.toString(),HttpStatus.OK);
		}
		return new ResponseEntity<String>(new JSONObject().toString(),HttpStatus.UNAUTHORIZED);
	}

}
