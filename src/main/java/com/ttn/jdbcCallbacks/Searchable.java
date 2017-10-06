package com.ttn.jdbcCallbacks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.ttn.config.AutowireHelper;
import com.ttn.service.SearchableService;
import com.ttn.transaction.InsertSynchronisation;
import com.ttn.transaction.RemoveSynchronisation;
import com.ttn.transaction.UpdateSynchronisation;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;

/**
 */
@Service
@ConditionalOnProperty("search.rabbitmq.port")
public class Searchable {

	/**
	 * The Searchable service.
	 */
	@Autowired
	SearchableService searchableService;

	/**
	 * After persist.
	 *
	 * @param object
	 *            the object
	 */
	@PostPersist
	public void afterPersist(Object object) {
		try {
			AutowireHelper.autowire(this, this.searchableService);
			String classname = object.getClass().getSimpleName();
			// log.info("Request :: postPersist in Searchable for class " +
			// classname);
			TransactionSynchronizationManager
					.registerSynchronization(new InsertSynchronisation(searchableService, object));
			// log.info("Insert request for for class " + classname + "completed
			// successfully");
		} catch (Exception e) {
			e.printStackTrace();
			// log.error("Exception :: after persist in Searchable " +
			// e.getMessage());
		} catch (Throwable e) {
			e.printStackTrace();
			// log.fatal("Error :: after persist in Searchable " +
			// e.getMessage());
		}
	}

	/**
	 * After update.
	 *
	 * @param object
	 *            the object
	 */
	@PostUpdate
	public void afterUpdate(Object object) {
		try {
			AutowireHelper.autowire(this, this.searchableService);
			String classname = object.getClass().getSimpleName();
			// log.info("Request :: postUpdate in Searchable for class " +
			// classname);
			TransactionSynchronizationManager
					.registerSynchronization(new UpdateSynchronisation(searchableService, object));
			// log.info("Update request for for class " + classname + "completed
			// successfully");
		} catch (Exception e) {
			e.printStackTrace();
			// log.error("Exception :: after update in Searchable " +
			// e.getMessage());
		} catch (Throwable e) {
			e.printStackTrace();
			// log.fatal("Error :: after update in Searchable " +
			// e.getMessage());
		}
	}

	/**
	 * After remove.
	 *
	 * @param object
	 *            the object
	 */
	@PostRemove
	public void afterRemove(Object object) {
		try {
			AutowireHelper.autowire(this, this.searchableService);
			String classname = object.getClass().getSimpleName();
			// log.info("Request :: after remove in Searchable for class " +
			// classname);
			TransactionSynchronizationManager
					.registerSynchronization(new RemoveSynchronisation(searchableService, object));
			// log.info("Remove request for for class " + classname + "completed
			// successfully");
		} catch (Exception e) {
			e.printStackTrace();
			// log.error("Exception :: after remove in Searchable " +
			// e.getMessage());
		} catch (Throwable e) {
			e.printStackTrace();
			// log.fatal("Error :: after remove in Searchable " +
			// e.getMessage());
		}
	}

}
