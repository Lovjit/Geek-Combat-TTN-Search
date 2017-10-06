package com.ttn.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Address;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.ttn.contants.SearchConstants;
import com.ttn.dto.SearchPropertiesDTO;

/**
 * The type Search rabbit configuration.
 */
@Configuration
@ConditionalOnProperty("search.rabbitmq.port")
public class SearchRabbitConfiguration {

	/**
	 * The Port.
	 */
	@Value("${search.rabbitmq.port}")
	String port;
	/**
	 * The Virtual host.
	 */
	@Value("${search.rabbitmq.virtualhost}")
	String virtualHost;
	/**
	 * The User name.
	 */
	@Value("${search.rabbitmq.username}")
	String userName;
	/**
	 * The Password.
	 */
	@Value("${search.rabbitmq.password}")
	String password;
	/**
	 * The Addresses.
	 */
	@Value("${search.rabbitmq.addresses}")
	String addresses;
	/**
	 * The Exchange.
	 */
	@Value("${search.rabbitmq.exchange}")
	String exchange;

	/**
	 * Search connection factory connection factory.
	 *
	 * @return the connection factory
	 */
	@Bean
	@ConditionalOnProperty("search.rabbitmq.port")
	ConnectionFactory searchConnectionFactory() {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setUsername(userName);
		factory.setPassword(password);
		factory.setVirtualHost(virtualHost != null ? virtualHost : "/");
		factory.setPort(Integer.parseInt(port != null ? port : "5672"));
		factory.setConnectionTimeout(ConnectionFactory.DEFAULT_CONNECTION_TIMEOUT);
		factory.setAutomaticRecoveryEnabled(true);
		factory.setTopologyRecoveryEnabled(true);
		factory.setNetworkRecoveryInterval(5000);
		return factory;
	}

	/**
	 * Search connection connection.
	 *
	 * @param searchConnectionFactory
	 *            the search connection factory
	 * @return the connection
	 */
	@Bean
	@ConditionalOnProperty("search.rabbitmq.port")
	Connection searchConnection(@Autowired ConnectionFactory searchConnectionFactory) {
		Connection connection = null;
		try {
			connection = searchConnectionFactory.newConnection(getAddresses());
			// log.info("search client Rabbitmq connected :- " +
			// connection.isOpen());
		} catch (IOException e) {
			e.printStackTrace();
			// log.error("Error occurred", e);
		} catch (Exception e) {
			e.printStackTrace();
			// log.error("Error occurred", e);
		}
		return connection;
	}

	/**
	 * Search channel channel.
	 *
	 * @param searchConnection
	 *            the search connection
	 * @return the channel
	 */
	@Bean
	@ConditionalOnProperty("search.rabbitmq.port")
	Channel searchChannel(@Autowired Connection searchConnection) {
		Channel channel = null;
		try {
			channel = searchConnection.createChannel();
			channel.exchangeDeclare(exchange, "topic", true);
		} catch (IOException e) {
			e.printStackTrace();
			// log.error("Error occurred", e);
		}
		return channel;
	}

	private Address[] getAddresses() {
		String[] arrayOfAddresses = addresses.split(",");
		Address[] addresses = new Address[arrayOfAddresses.length];
		for (int i = 0; i < arrayOfAddresses.length; i++) {
			addresses[i] = new Address(arrayOfAddresses[i], Integer.valueOf(port));
		}
		return addresses;
	}

	public void publishDataToQueue(SearchPropertiesDTO data, String action) throws IOException {
		if (Objects.isNull(data)) {
			return;
		}
		HashMap<String, Object> searchHeaders = buildSearchHeaders(data, action);
		publishData(data.getObject(), searchHeaders);
	}

	/**
	 * Publish removed id data to queue.
	 *
	 * @param data
	 *            the data
	 * @throws IOException
	 *             the io exception
	 */
	public void publishRemovedIDDataToQueue(HashMap data) throws IOException {
		HashMap<String, Object> searchProperties = new HashMap<>();
		searchProperties.put(SearchConstants.INDEX, data.get(SearchConstants.INDEX));
		searchProperties.put(SearchConstants.ACTION, SearchConstants.IDREMOVE);
		searchProperties.put(SearchConstants.ID, data.get(SearchConstants.ID));
		publishData(data.get(SearchConstants.OBJECT), searchProperties);
	}

	private void publishData(Object searchPacket, HashMap<String, Object> searchProperties) throws IOException {
		String jsonStr = new ObjectMapper().writeValueAsString(searchPacket);
		// log.debug("Publishing message in search queue: " + jsonStr);
		// log.debug("Publishing message in search queue with properties: " +
		// searchProperties);
		AMQP.BasicProperties.Builder builder = new AMQP.BasicProperties.Builder();
		builder.headers(searchProperties);
		Channel channel = searchChannel(searchConnection(searchConnectionFactory()));
		channel.basicPublish(exchange, "#", builder.build(), jsonStr.getBytes());
	}

	private HashMap<String, Object> buildSearchHeaders(SearchPropertiesDTO searchPropertiesDTO, String action) {
		HashMap<String, Object> searchProperties = new HashMap<>();
		searchProperties.put(SearchConstants.INDEX, searchPropertiesDTO.getIndex());
		searchProperties.put(SearchConstants.ACTION, action);
		searchProperties.put(SearchConstants.ID, searchPropertiesDTO.getId());
		return searchProperties;
	}

}
