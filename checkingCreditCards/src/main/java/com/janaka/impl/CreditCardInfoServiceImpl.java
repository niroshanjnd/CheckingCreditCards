package com.janaka.impl;

import org.springframework.stereotype.Service;

import com.janaka.CardTypeConstants;
import com.janaka.model.CreditCardInfo;
import com.janaka.repository.CreditCardInfoRepository;
import com.janaka.service.CreditCardInfoService;

@Service
public class CreditCardInfoServiceImpl implements CreditCardInfoService {
	
	private final CreditCardInfoRepository creditCardInfoRepository;

    public CreditCardInfoServiceImpl(CreditCardInfoRepository creditCardInfoRepository) {
        this.creditCardInfoRepository = creditCardInfoRepository;
    }
	
	@Override
	public void getCreditCardInfo(CreditCardInfo creditCardInfo) {
		creditCardInfo.setCreditCardValidity(isValid(creditCardInfo.getCreditCardNumber()));		
		getCardType(creditCardInfo.getCreditCardNumber(), creditCardInfo);
	}
	
	public boolean isValid(Long creditCardNumber) {
		
		return (getCreditCardLength(creditCardNumber) >= 15 &&
	               getCreditCardLength(creditCardNumber) <= 16) &&
	               (matchGivenPrefix(creditCardNumber, 4) ||
	            	matchGivenPrefix(creditCardNumber, 5) ||
	            	matchGivenPrefix(creditCardNumber, 6)) &&
	              ((totalOfEvenPlaceDigit(creditCardNumber) +
	              totalOfOddPlaceDigit(creditCardNumber)) % 10 == 0);	
	}
	
    public int totalOfEvenPlaceDigit(Long creditCardNumber) {
    	
        int total = 0;
        String number = creditCardNumber.toString();
        for (int i = getCreditCardLength(creditCardNumber) - 2; i >= 0; i -= 2)
        	
        	total += getNumberOfDigits(Integer.parseInt(number.charAt(i) + "") * 2);
         
        return total;
    }
 
    public int getNumberOfDigits(Integer creditCardNumber){
    	
        if (creditCardNumber < 9)
            return creditCardNumber;
        return creditCardNumber / 10 + creditCardNumber % 10;
    }
 
    public int totalOfOddPlaceDigit(Long creditCardNumber){
    	
        int total = 0;
        String num = creditCardNumber.toString();
        
        for (int i = getCreditCardLength(creditCardNumber) - 1; i >= 0; i -= 2) {
            total += Integer.parseInt(num.charAt(i) + "");  
        }
        return total;
    }
 
    public boolean matchGivenPrefix(Long creditCardNumber, Integer d){
    	
        return getPrefix(creditCardNumber, getCreditCardLength(d.longValue())) == d;
    }
 
    public int getCreditCardLength(Long creditCardNumber) {
    	
        return creditCardNumber.toString().length();
    }
 
    public long getPrefix(Long creditCardNumber, int lengthToPrefix) {
        if (getCreditCardLength(creditCardNumber) < lengthToPrefix) {
        	return creditCardNumber;            
        }
        
        String num = creditCardNumber.toString();
        return Long.parseLong(num.substring(0, lengthToPrefix));
    }

	public void getCardType(Long creditCardNumber, CreditCardInfo creditCardInfo) {
		
		String num = creditCardNumber.toString();
		String prefix = num.substring(0, 1);
		
		switch(prefix) {
		
			case "3" : creditCardInfo.setCreditCardType(CardTypeConstants.AMEX);
			break;
			
			case "6" : creditCardInfo.setCreditCardType(CardTypeConstants.DISCOVER);
			break;
			
			case "5" : creditCardInfo.setCreditCardType(CardTypeConstants.MASTERCARD);
			break;
			
			case "4" : creditCardInfo.setCreditCardType(CardTypeConstants.VISA);
			break;
			
			case "1" : creditCardInfo.setCreditCardType(CardTypeConstants.VISA);
			break;
			
			default : creditCardInfo.setCreditCardType(CardTypeConstants.UNKNOWN);
			break;
		}
		
	}
	
	

}
