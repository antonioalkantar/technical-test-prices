/**
 * 
 */
package com.indra.inditex.prices.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.inditex.prices.common.ServiceException;
import com.indra.inditex.prices.entity.Price;
import com.indra.inditex.prices.model.PriceDTO;
import com.indra.inditex.prices.repository.IPriceRepo;

/**
 * @author Antonio Alcantar Valencia
 *
 */
@Service
public class PriceServiceImpl implements IPriceService {

	private static final Logger logger = LoggerFactory.getLogger(PriceServiceImpl.class);
	
	@Autowired
	private IPriceRepo priceRepository;

	/**
	 * Este metodo obtiene todos los registros de la BD
	 * con todos las columnas de la tabla
	 */
	@Override
	public List<Price> findAll() throws ServiceException {
		logger.info("**** Entering PriceService.findAll() ****");
		try {
			return priceRepository.findAll();
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Este metodo obtiene solo un registro de la BD
	 * con todos las columnas de la tabla
	 */
	@Override
	public Optional<Price> findById(Long id) throws ServiceException {
		logger.info("**** Entering PriceService.findById() ****");
		try {
			return priceRepository.findById(id);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Este metodo permite guardar un registro nuevo y/o
	 * actualizar los valores de un registro de la BD ya existente
	 */
	@Override
	public List<Price> save(Price e) throws ServiceException {
		logger.info("**** Entering PriceService.save() ****");
		try {
			return Arrays.asList(priceRepository.save(e));
		} catch (Exception ex) {
			throw new ServiceException(ex.getMessage());
		}
	}

	/**
	 * Este metodo elimina un registro de la tabla Prices de la BD
	 */
	@Override
	public void delete(Price e) throws ServiceException {
		logger.info("**** Entering PriceService.delete() ****");
		try {
			priceRepository.delete(e);
		} catch (Exception ex) {
			throw new ServiceException(ex.getMessage());
		}
	}

	/**
	 * Este metodo permite realizar una busqueda en la BD
	 * con los siguientes parametros:
	 * @param applicationDate = fecha de aplicacion
	 * @param productId = identificador de producto
	 * @param brandId = identificador de cadena
	 * @return una lista con los siguientes valores (identificador de producto, 
	 * identificador de cadena, tarifa a aplicar, fechas de aplicación 
	 * y precio final a aplicar)
	 */
	@Override
	public List<PriceDTO> findData(Date applicationDate, Integer productId, Integer brandId) throws ServiceException {
		logger.info("**** Entering PriceService.findData() ****");
		try {
			return priceRepository.findData(applicationDate, productId, brandId);
		} catch (Exception ex) {
			throw new ServiceException(ex.getMessage());
		}
	}
	
	
	
}
