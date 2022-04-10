package com.indra.inditex.prices.service;

import java.util.Date;
import java.util.List;

import com.indra.inditex.prices.common.CrudService;
import com.indra.inditex.prices.common.ServiceException;
import com.indra.inditex.prices.entity.Price;
import com.indra.inditex.prices.model.PriceDTO;

/**
 * @author Antonio Alcantar Valencia
 *
 */
public interface IPriceService extends CrudService<Price> {

	List<PriceDTO> findData(Date applicationDate, Integer productId, Integer brandId) throws ServiceException;
	
}
