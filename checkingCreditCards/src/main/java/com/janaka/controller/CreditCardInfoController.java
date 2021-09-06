package com.janaka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.janaka.model.CreditCardInfo;
import com.janaka.service.CreditCardInfoService;

@RestController
@RequestMapping("creditcardinfo")
public class CreditCardInfoController {
	
	@Autowired
	CreditCardInfoService creditCardInfoService;
	
	@RequestMapping(value="creditcardnumber", method=RequestMethod.POST)
	@ResponseBody
	private CreditCardInfo getCreditCardInfo(@RequestBody CreditCardInfo creditCardInfo) {
		creditCardInfoService.getCreditCardInfo(creditCardInfo);
		return creditCardInfo;
	}

}
