package com.ttn.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ttn.service.AuthServiceImpl;

@Controller
public class AuthenticationController {
	
	@Autowired
	AuthServiceImpl authService;
	
	@RequestMapping(value = "/auth", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseEntity<String> authenticate(@RequestBody Map<String, Object> obj) throws ClientProtocolException, URISyntaxException, IOException{
		return authService.authenticate(new JSONObject(obj));
	}

}
