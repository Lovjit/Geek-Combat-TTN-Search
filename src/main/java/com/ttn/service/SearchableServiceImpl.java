package com.ttn.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.ttn.config.SearchRabbitConfiguration;
import com.ttn.contants.SearchConstants;
import com.ttn.dto.GenericCO;
import com.ttn.dto.SearchPropertiesDTO;
import com.ttn.enums.DomainNameEnum;

import java.util.HashMap;
import java.util.List;

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
		switch (domainName) {
		case PROJECT:
			SearchPropertiesDTO<Long> searchPropertiesDTO = new SearchPropertiesDTO<>();
			// RRChannelCO rrChannelCO = new RRChannelCO();
			// RRLiveChannel rrLiveChannel = extractDataFromObject(domainName,
			// object, rrChannelCO, searchPropertiesDTO);
			// rrChannelCO.setLogoURL(rrLiveChannel.getImageUrl());
			// rrChannelCO.setTitle_en(rrLiveChannel.getChannelName());
			// rrChannelCO.setIsHD(rrLiveChannel.isHD());
			// rrChannelCO.setIsPublished(rrLiveChannel.isPublished());
			return searchPropertiesDTO;

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

}
