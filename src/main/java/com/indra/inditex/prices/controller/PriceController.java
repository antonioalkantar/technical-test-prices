package com.indra.inditex.prices.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.indra.inditex.prices.common.Constants;
import com.indra.inditex.prices.common.Response;
import com.indra.inditex.prices.common.ServiceException;
import com.indra.inditex.prices.entity.Price;
import com.indra.inditex.prices.model.PriceDTO;
import com.indra.inditex.prices.service.IPriceService;

/**
 * @author Antonio Alcantar Valencia
 *
 */
@RestController
@RequestMapping("/api")
public class PriceController {
	
	private static final Logger logger = LoggerFactory.getLogger(PriceController.class);
	
	@Autowired
	private IPriceService priceService;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/prices")
	public @ResponseBody Response getAllPrices() {
		logger.info("#### Entering PricesController.getAllPrices() ####");
		Response response = new Response();
		try {
			List<Price> listaPrecios = priceService.findAll();
			if (listaPrecios.isEmpty() || listaPrecios.size() == Constants.EMPTY_LIST) {
				response.setCode(HttpStatus.NO_CONTENT);
				response.setMessage(Constants.NO_RECORD_FOUND);
				logger.info("No Record Found");
				return response;
			}
			response.setData(listaPrecios);
			logger.info("Successfully obtained records");
			response.setCode(HttpStatus.OK);
			response.setMessage(Constants.SUCCESS);
			logger.info("#### Exting PricesController.findAll() ####");
			return response;
		} catch (ServiceException se) {
			response.setCode(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessage(se.getMessage());
			logger.error("Custom Error: ", se.getMessage());
			return response;
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/prices/{id}")
	public @ResponseBody Response getPrice(@PathVariable Long id) {
		logger.info("#### Entering PricesController.getPrice() ####");
		Response response = new Response();
		try {
			Optional<Price> prices = priceService.findById(id);
			if (prices.isPresent()) {
				response.setData(Arrays.asList(prices.get()));
				logger.info("Register obtained successfully");
				response.setCode(HttpStatus.OK);
				response.setMessage(Constants.SUCCESS);
				logger.info("#### Exting PricesController.getPrice() ####");
				return response;
			}
			response.setCode(HttpStatus.NOT_FOUND);
			response.setMessage(Constants.NO_RECORD_FOUND);
			logger.info("No Record Found");
			return response;	
		} catch (ServiceException se) {
			response.setCode(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessage(se.getMessage());
			logger.error("Custom Error: ", se.getMessage());
			return response;
		}
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/prices")
	public @ResponseBody Response savePrice(@RequestBody Price prices) {
		logger.info("#### Entering PricesController.savePrice() ####");
		Response response = new Response();
		try {
			response.setData((List<Price>) priceService.save(prices));
			logger.info("Record saved successfully");
			response.setCode(HttpStatus.CREATED);
			response.setMessage(Constants.SUCCESS);
			logger.info("#### Exting PricesController.savePrice() ####");
			return response;
		} catch (ServiceException se) {
			response.setCode(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessage(se.getMessage());
			logger.error("Custom Error: ", se.getMessage());
			return response;
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping("/prices")
	public @ResponseBody Response updatePrice(@RequestBody Price prices) {
		logger.info("#### Entering PricesController.updatePrice() ####");
		Response response = new Response();
		try {
			response.setData((List) priceService.save(prices));
			logger.info("Record updated successfully");
			response.setCode(HttpStatus.OK);
			response.setMessage(Constants.SUCCESS);
			logger.info("#### Exting PricesController.updatePrice() ####");
			return response;
		} catch (ServiceException se) {
			response.setCode(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessage(se.getMessage());
			logger.error("Custom Error: ", se.getMessage());
			return response;
		}
	}
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping("/prices/{id}")
	public @ResponseBody Response deletePrice(@PathVariable Long id) {
		logger.info("#### Entering PricesController.deletePrice() ####");
		Response response = new Response();
		try {
			Optional<Price> prices = priceService.findById(id);
			logger.info("Register obtained successfully");
			if (prices.isPresent()) {
				priceService.delete(prices.get());
				logger.info("Registry deleted successfully");
				response.setCode(HttpStatus.OK);
				response.setMessage(Constants.SUCCESS);
				logger.info("#### Exting PricesController.deletePrice() ####");
				return response;
			}
			response.setCode(HttpStatus.NO_CONTENT);
			response.setMessage(Constants.NO_RECORD_FOUND);
			logger.info("No Record Found");
			return response;
		} catch (ServiceException se) {
			response.setCode(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessage(se.getMessage());
			logger.error("Custom Error: ", se.getMessage());
			return response;
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/prices/search")
	public @ResponseBody Response searchPrice(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date applicationDate, @RequestParam Integer productId, @RequestParam Integer brandId) {
		logger.info("#### Entering PricesController.searchPrice() ####");
		Response response = new Response();
		try {
			List<PriceDTO> prices = priceService.findData(applicationDate, productId, brandId);
			if (prices.isEmpty() || prices.size() == Constants.EMPTY_LIST) {
				response.setCode(HttpStatus.NO_CONTENT);
				response.setMessage(Constants.NO_RECORD_FOUND);
				logger.info("No Record Found");
				return response;
			}
			response.setData(prices);
			logger.info("Successfully obtained records");
			response.setCode(HttpStatus.OK);
			response.setMessage(Constants.SUCCESS);
			logger.info("#### Exting PricesController.searchPrice() ####");
			return response;	
		} catch (ServiceException se) {
			response.setCode(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessage(se.getMessage());
			logger.error("Custom Error: ", se.getMessage());
			return response;
		}
		
	}
	
}