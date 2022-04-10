package com.indra.inditex.prices.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.indra.inditex.prices.entity.Price;
import com.indra.inditex.prices.model.PriceDTO;

/**
 * @author Antonio Alcantar Valencia
 *
 */
@Repository
public interface IPriceRepo extends JpaRepository<Price, Long> {

	@Query("select new com.indra.inditex.prices.model.PriceDTO(p.brandId, p.endDate, p.price, p.priceList, p.productId, p.startDate) from Price p where p.productId = ?2 and p.brandId = ?3 and ?1 BETWEEN p.startDate AND p.endDate")
	List<PriceDTO> findData(Date applicationDate, Integer productId, Integer brandId);
	
}