package com.ttn.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ttn.domain.Company;
import com.ttn.domain.CompanyType;
import com.ttn.domain.Document;
import com.ttn.domain.IndustryType;
import com.ttn.domain.Project;
import com.ttn.domain.Technology;
import com.ttn.domain.TechnologyType;
import com.ttn.repository.CompanyRepository;
import com.ttn.repository.ProjectRepository;
import com.ttn.repository.TechnologyRepository;
import com.ttn.service.SearchableService;

/**
 * The type Mm content controller.
 */
@RestController
@RequestMapping("/api/")
@CrossOrigin
public class ContentController {

	@Autowired
	CompanyRepository companyRepository;

	@Autowired
	TechnologyRepository technologyRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	SearchableService searchableService;

	private static AtomicLong counter = new AtomicLong(1);

	@RequestMapping(value = "/company/insert", method = RequestMethod.GET)
	public void createEditorialSection() {

		for (int i = 0; i <2; i++) {
			Company company = new Company();
			company.setName("dummy " + counter.get());

			IndustryType industryType = new IndustryType();
			industryType.setName("Industrial" + counter.get());
			company.setIndustryType(industryType);

			CompanyType companyType = new CompanyType();
			companyType.setName("B2B" + counter.get());
			company.setCompanyType(companyType);

			TechnologyType technologyType = new TechnologyType();
			technologyType.setName("Backend" + counter.get());

			Technology technology = new Technology();
			technology.setName("Java" + counter.get());
			technology.setTechnologyType(technologyType);

			companyRepository.save(company);
			technologyRepository.save(technology);

			Project project = new Project();
			project.setName("Project" + counter.get());
			project.setTechnologies(new ArrayList<>());
			project.getTechnologies().add(technology);
			projectRepository.save(project);

			List<Project> projects = new ArrayList<>();
			projects.add(project);
			company.setProjects(projects);

			counter.incrementAndGet();
		}

	}

	@RequestMapping(value = "/document/insert", method = RequestMethod.GET)
	public void savePDF() {
		try {
			searchableService.insertData(new Document());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
