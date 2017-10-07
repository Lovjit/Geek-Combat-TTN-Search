package com.ttn.dto;

import com.ttn.domain.AbstractDomain;

/**
 * @param <T>
 *            the type parameter
 */
public class SearchPropertiesDTO<T> {

	private AbstractDomain object;

	private String index;

	private T id;

	public AbstractDomain getObject() {
		return object;
	}

	public void setObject(AbstractDomain object) {
		this.object = object;
	}

	/**
	 * Gets index.
	 *
	 * @return the index
	 */
	public String getIndex() {
		return index;
	}

	/**
	 * Sets index.
	 *
	 * @param index
	 *            the index
	 */
	public void setIndex(String index) {
		this.index = index;
	}

	/**
	 * Gets id.
	 *
	 * @return the id
	 */
	public T getId() {
		return id;
	}

	/**
	 * Sets id.
	 *
	 * @param id
	 *            the id
	 */
	public void setId(T id) {
		this.id = id;
	}
}
