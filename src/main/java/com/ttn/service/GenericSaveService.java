package com.ttn.service;

import java.util.Map;

import javax.validation.groups.Default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenericSaveService {
	
	@Autowired
	ProjectServiceImpl projectServiceImpl;

	public Object save(String contentType, Map<String, Object> data) {
		String contentTypeInUC = contentType.toUpperCase();
		switch(contentTypeInUC){
			case "PROJECT" : 
				return projectServiceImpl.save(data);
			//case "COMPANY"
		}
		return null;
	}

}
