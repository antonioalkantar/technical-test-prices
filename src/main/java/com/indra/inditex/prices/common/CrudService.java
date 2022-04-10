/**
 * 
 */
package com.indra.inditex.prices.common;

import java.util.List;
import java.util.Optional;

/**
 * @author Antonio Alcantar Valencia
 *
 */
public interface CrudService<T> {

	List<T> findAll() throws ServiceException;
	Optional<T> findById(Long id) throws ServiceException;
	List<T> save(T e) throws ServiceException;
	void delete(T e) throws ServiceException;
	
}
