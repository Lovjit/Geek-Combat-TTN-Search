package com.ttn.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ttn.domain.Country;
import com.ttn.dto.UserDTO;
import com.ttn.repository.CountryRepository;
import com.ttn.util.RestUtil;

@Service
public class CountryServiceImpl {
	
	@Autowired
	CountryRepository countryRepository;
	
	public ResponseEntity<List<Country>> getAllCountries(){
		List<Country> countries = (List<Country>) countryRepository.findAll();
		return new ResponseEntity<List<Country>>(countries,HttpStatus.OK);
	}

}
