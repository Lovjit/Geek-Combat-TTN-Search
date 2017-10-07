package com.ttn.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ttn.domain.Project;
import com.ttn.service.ProjectServiceImpl;

@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	ProjectServiceImpl projectService;

	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody ResponseEntity<Project> saveProject(@RequestBody Map<String,Object> projectDataMap) {
		//projectService.save(project)
		return null;
    }
	
	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST, consumes = {"multipart/form-data", "image/jpeg", "image/png"})
	public @ResponseBody ResponseEntity<String> update(@RequestParam("file") MultipartFile file) {
		 return null;
	}

}
