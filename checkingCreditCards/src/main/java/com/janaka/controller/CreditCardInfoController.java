package com.janaka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.janaka.service.CreditCardInfoService;

@RestController
@RequestMapping("creditcardinfo")
public class CreditCardInfoController {
	
	@Autowired
	CreditCardInfoService creditCardInfoService;

}
