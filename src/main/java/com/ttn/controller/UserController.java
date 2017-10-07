package com.ttn.controller;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ttn.dto.UserDTO;
import com.ttn.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserServiceImpl userService;
	
	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<UserDTO> getUserDetails(@RequestHeader(value="Authorization") String authToken) throws ClientProtocolException, URISyntaxException, IOException{
		UserDTO userDTO = userService.getUserInfo(authToken);
		if(userDTO != null){
			return new ResponseEntity<UserDTO>(userDTO,HttpStatus.OK);
		}
		return new ResponseEntity<UserDTO>(HttpStatus.REQUEST_TIMEOUT);
	}
	
}
