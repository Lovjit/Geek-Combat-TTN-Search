package com.ttn.service;

import java.util.List;

/**
 * The interface Searchable service.
 *
 */
public interface SearchableService {

	public enum CRUD {
		INSERT, UPDATE, DELETE;
	}

	/**
	 * Insert data.
	 *
	 * @param object
	 *            the object
	 * @throws Exception
	 *             the exception
	 */
	public void insertData(Object object) throws Exception;

	/**
	 * Update data.
	 *
	 * @param object
	 *            the object
	 * @throws Exception
	 *             the exception
	 */
	public void updateData(Object object) throws Exception;

	/**
	 * Remove data.
	 *
	 * @param object
	 *            the object
	 * @throws Exception
	 *             the exception
	 */
	public void removeData(Object object) throws Exception;

	/**
	 * Remove databy id list.
	 *
	 * @param idList
	 *            the id list
	 * @param index
	 *            the index
	 */
	public <T> void removeDataByIdList(List<T> idList, String index);
}
