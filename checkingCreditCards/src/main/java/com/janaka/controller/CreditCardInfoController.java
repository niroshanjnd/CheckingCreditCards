package com.janaka.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.janaka.model.CreditCardInfo;
import com.janaka.service.CreditCardInfoService;

@RestController
@RequestMapping("/creditcardinfo")
public class CreditCardInfoController {
	
	private final CreditCardInfoService creditCardInfoService;
	
	public CreditCardInfoController(CreditCardInfoService creditCardInfoService) {
		this.creditCardInfoService = creditCardInfoService;
	}

	@PostMapping("/creditcardnumber")
	@ResponseBody
	private CreditCardInfo getCreditCardInfo(@RequestBody CreditCardInfo creditCardInfo) {
		creditCardInfoService.getCreditCardInfo(creditCardInfo);
		return creditCardInfo;
	}

}
