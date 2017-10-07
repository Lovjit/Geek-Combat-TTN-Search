package com.ttn.dto;

/**
 * @param <T>
 *            the type parameter
 */
public class SearchPropertiesDTO<T> {

	private GenericCO<T> object;

	private String index;

	private T id;

	/**
	 * Gets object.
	 *
	 * @return the object
	 */
	public GenericCO<T> getObject() {
		return object;
	}

	/**
	 * Sets object.
	 *
	 * @param object
	 *            the object
	 */
	public void setObject(GenericCO<T> object) {
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
