package com.ttn.filter;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.filter.GenericFilterBean;

import com.ttn.dto.UserDTO;
import com.ttn.service.UserServiceImpl;

@CrossOrigin
public class CustomFilter extends GenericFilterBean {
	
	UserServiceImpl userService = new UserServiceImpl();
	
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/auth");
	}
	 
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
    	HttpServletRequest httpRequest = (HttpServletRequest) request;
    	HttpServletResponse httpResponse = (HttpServletResponse) response;
    	String requestUri = httpRequest.getRequestURI();
    	if("OPTIONS".equalsIgnoreCase(httpRequest.getMethod())){
    		httpResponse.setStatus(HttpServletResponse.SC_OK);
    		AddAllowedHeaders(httpResponse);
    	}else{
    		if("/auth".equals(requestUri.subSequence(requestUri.length()-5, requestUri.length()))){
        		chain.doFilter(request, response);
        	}else{
        		String authToken = httpRequest.getHeader("Authorization");
        		if(authToken == null){
        			httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        		}
        		UserDTO userDTO = null;
    			try {
    				userDTO = userService.getUserInfo(authToken);
    			} catch (URISyntaxException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
        		if(userDTO == null){
    				httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    			}else{
    				chain.doFilter(request, response);
    			}
        	}
    	}

    	
    }
    private void AddAllowedHeaders(HttpServletResponse res) {
    	   res.addHeader("Access-Control-Allow-Origin", "*");
    	   res.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE,OPTIONS");
    	   res.addHeader("Access-Control-Max-Age", "*");
    	   res.addHeader("Access-Control-Allow-Headers",
    	       "X-Requested-With, Content-Type, Accept,Authorization");
    	   res.addHeader("Access-Control-Allow-Credentials", "true");
    	   res.addHeader("Access-Control-Expose-Headers", "X-Auth-Token");
    	 }
}
