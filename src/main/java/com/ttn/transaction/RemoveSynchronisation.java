package com.ttn.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionSynchronization;

import com.ttn.service.SearchableService;

/**
 */
public class RemoveSynchronisation implements TransactionSynchronization {

	/**
	 * The Searchable service.
	 */
	SearchableService searchableService;

	private Object object;

	/**
	 * Instantiates a new Insert synchronisation.
	 *
	 * @param searchableService
	 *            the searchable service
	 * @param o
	 *            the o
	 */
	@Autowired
	public RemoveSynchronisation(SearchableService searchableService, Object o) {
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
			searchableService.removeData(object);
		} catch (Exception e) {
			e.printStackTrace();
			// log.error("Exception :: inside after commit while removing " +
			// e.getMessage());
		} catch (Throwable e) {
			e.printStackTrace();
			// log.fatal("Error :: inside after commit while removing " +
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
