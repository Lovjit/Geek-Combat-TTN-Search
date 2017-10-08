package com.ttn.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.ttn.config.SearchRabbitConfiguration;
import com.ttn.contants.SearchConstants;
import com.ttn.domain.Company;
import com.ttn.domain.Project;
import com.ttn.domain.Technology;
import com.ttn.dto.GenericCO;
import com.ttn.dto.SearchPropertiesDTO;
import com.ttn.dto.search.domains.CompanyDTO;
import com.ttn.dto.search.domains.DocumentDTO;
import com.ttn.dto.search.domains.ProjectDTO;
import com.ttn.dto.search.domains.TechnologyDTO;
import com.ttn.enums.ContentTypeEnum;
import com.ttn.enums.DomainNameEnum;

/**
 */
@Service
@ConditionalOnProperty("search.rabbitmq.port")
public class SearchableServiceImpl implements SearchableService {

	/**
	 * The Search rabbit configuration.
	 */
	@Autowired
	SearchRabbitConfiguration searchRabbitConfiguration;

	public void insertData(Object object) throws Exception {
		String classname = object.getClass().getSimpleName();
		// log.info("Request :: about to push data in RabbitMQ for class " +
		// classname);
		searchRabbitConfiguration.publishDataToQueue(processObject(object, CRUD.INSERT), SearchConstants.INSERT);
	}

	public void updateData(Object object) throws Exception {
		String classname = object.getClass().getSimpleName();
		// log.info("Request :: after update in Searchable for class " +
		// classname);
		SearchPropertiesDTO searchPropertiesDTO = processObject(object, CRUD.UPDATE);
		searchRabbitConfiguration.publishDataToQueue(searchPropertiesDTO, SearchConstants.UPDATE);
	}

	public void removeData(Object object) throws Exception {
		String classname = object.getClass().getSimpleName();
		// log.info("Request :: after remove in Searchable for class " +
		// classname);
		searchRabbitConfiguration.publishDataToQueue(processObject(object, CRUD.DELETE), SearchConstants.REMOVE);
	}

	@Override
	public <T> void removeDataByIdList(List<T> idList, String index) {
		try {
			searchRabbitConfiguration.publishRemovedIDDataToQueue(processList(idList, index));
		} catch (Exception e) {
			e.printStackTrace();
			// log.error("Exception occurred while removing ids for " + index +
			// ":" + e.getMessage());
		} catch (Throwable e) {
			e.printStackTrace();
			// log.fatal("Error occurred while removing ids for " + index + ":"
			// + e.getMessage());
		}
	}

	private SearchPropertiesDTO processObject(Object object, CRUD crud) {
		String classname = object.getClass().getSimpleName();
		// log.debug("Dumping search data for " + classname);
		DomainNameEnum domainName = DomainNameEnum.getDomainName(classname);
		if (domainName == null) {
			return null;
		}

		switch (domainName) {
		case PROJECT:
			SearchPropertiesDTO<Long> projectSearchProperties = new SearchPropertiesDTO<>();
			ProjectDTO projectCO = new ProjectDTO();
			Project project = extractDataFromObject(domainName, object, projectCO, projectSearchProperties);
			projectCO.update(project);
			projectCO.setContentType(ContentTypeEnum.PROJECT.getName());
			return projectSearchProperties;

		case COMPANY:
			SearchPropertiesDTO<Long> companySearchProperties = new SearchPropertiesDTO<>();
			CompanyDTO companyCO = new CompanyDTO();
			Company company = extractDataFromObject(domainName, object, companyCO, companySearchProperties);
			companyCO.update(company);
			companyCO.setContentType(ContentTypeEnum.COMPANIES.getName());
			return companySearchProperties;
		case TECHNOLOGY:
			SearchPropertiesDTO<Long> genreSearchProperties = new SearchPropertiesDTO<>();
			TechnologyDTO technologyCO = new TechnologyDTO();
			Technology technology = extractDataFromObject(domainName, object, technologyCO, genreSearchProperties);
			technologyCO.update(technology);
			technologyCO.setContentType(ContentTypeEnum.TECHNOLOGY.getName());
			return genreSearchProperties;

		case DOCUMENT:
			SearchPropertiesDTO<String> documentSearchProperties = new SearchPropertiesDTO<>();
			File file = new File("/home/aniket/geek/Geek-Combat-TTN-Search/src/main/resources/test.pdf");
			DocumentDTO documentCO = new DocumentDTO();
			documentCO.setData(this.encodeFile(file));
			documentCO.setCompany(null);
			documentCO.setDownloadLink(null);
			documentCO.setProject(null);
			documentCO.setContentType(ContentTypeEnum.CONTENT.getName());
			documentSearchProperties.setIndex(domainName.getIndexName());
			documentSearchProperties.setId("1");
			documentSearchProperties.setObject(documentCO);
			return documentSearchProperties;

		default:
			// log.error("This class: " + classname + " is not mapped in
			// search");
			return null;
		}
	}

	private <T> HashMap<String, Object> processList(List<T> list, String index) {
		HashMap<String, Object> searchProperties = new HashMap<>();
		searchProperties.put(SearchConstants.OBJECT, list);
		searchProperties.put(SearchConstants.INDEX, index);
		return searchProperties;
	}

	private <T, U> T extractDataFromObject(DomainNameEnum domainName, Object object, GenericCO<U> objectCO,
			SearchPropertiesDTO<U> searchPropertiesDTO) {
		T obj = (T) object;
		BeanUtils.copyProperties(obj, objectCO);
		searchPropertiesDTO.setObject(objectCO);
		searchPropertiesDTO.setIndex(domainName.getIndexName());
		searchPropertiesDTO.setId(objectCO.getId());
		return obj;
	}

	public String encodeFile(File file) {
		String base64 = null;
		try (InputStream is = new FileInputStream(file)) {
			byte bytes[] = null;
			try {
				bytes = IOUtils.toByteArray(is);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			base64 = Base64.getEncoder().encodeToString(bytes);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return base64;

	}

}
