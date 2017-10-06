package com.ttn.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionSynchronization;

import com.ttn.service.SearchableService;

/**
 */
public class UpdateSynchronisation implements TransactionSynchronization {

	/**
	 * The Searchable service.
	 */
	SearchableService searchableService;

	private Object object;

	/**
	 * Instantiates a new Update synchronisation.
	 *
	 * @param searchableService
	 *            the searchable service
	 * @param o
	 *            the o
	 */
	@Autowired
	public UpdateSynchronisation(SearchableService searchableService, Object o) {
		this.searchableService = searchableService;
		setObject(o);
	}

	@Override
	public void suspend() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void flush() {

	}

	@Override
	public void beforeCommit(boolean readOnly) {

	}

	@Override
	public void beforeCompletion() {

	}

	@Override
	public void afterCommit() {
		try {
			searchableService.updateData(object);
		} catch (Exception e) {
			e.printStackTrace();
			// log.error("Exception :: inside afterCommit while updating " +
			// e.getMessage());
		} catch (Throwable e) {
			e.printStackTrace();
			// log.fatal("Error :: inside afterCommit while updating " +
			// e.getMessage());
		}
	}

	@Override
	public void afterCompletion(int status) {

	}

	/**
	 * Gets object.
	 *
	 * @return the object
	 */
	public Object getObject() {
		return object;
	}

	/**
	 * Sets object.
	 *
	 * @param object
	 *            the object
	 */
	public synchronized void setObject(Object object) {
		this.object = object;
	}
}
