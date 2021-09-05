package com.janaka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.janaka.repository.CreditCardInfoRepository;

@Service
public class CreditCardInfoService {
	
	@Autowired
	CreditCardInfoRepository creditCardInfoRepository;

}
