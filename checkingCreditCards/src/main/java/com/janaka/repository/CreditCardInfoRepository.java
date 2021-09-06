package com.janaka.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.janaka.model.CreditCardInfo;

@Repository
public interface CreditCardInfoRepository extends CrudRepository<CreditCardInfo, Long>{
	
}