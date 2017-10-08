package com.ttn.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ttn.service.GenericSaveService;

@Controller
@CrossOrigin
public class GenericSaveController {
	
	@Autowired
	GenericSaveService genericSaveService;
	
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Object> save(@RequestParam String contentType,@RequestBody Map<String,Object> data){
		genericSaveService.save(contentType,(Map<String, Object>) ((List)data.get("data")).get(0));
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
