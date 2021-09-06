package com.janaka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.janaka.CardTypeConstants;
import com.janaka.model.CreditCardInfo;
import com.janaka.repository.CreditCardInfoRepository;

@Service
public class CreditCardInfoService {
	
	@Autowired
	CreditCardInfoRepository creditCardInfoRepository;
	
	public void getCreditCardInfo(CreditCardInfo creditCardInfo) {
		creditCardInfo.setCreditCardValidity(isValid(creditCardInfo.getCreditCardNumber()));		
		getCardType(creditCardInfo.getCreditCardNumber(), creditCardInfo);
	}
	
	public static boolean isValid(Long creditCardNumber) {
		
		return (getCreditCardLength(creditCardNumber) >= 15 &&
	               getCreditCardLength(creditCardNumber) <= 16) &&
	               (matchGivenPrefix(creditCardNumber, 4) ||
	            	matchGivenPrefix(creditCardNumber, 5) ||
	            	matchGivenPrefix(creditCardNumber, 6)) &&
	              ((totalOfEvenPlaceDigit(creditCardNumber) +
	              totalOfOddPlaceDigit(creditCardNumber)) % 10 == 0);	
	}
	
    public static int totalOfEvenPlaceDigit(long creditCardNumber) {
    	
        int total = 0;
        String number = creditCardNumber + "";
        for (int i = getCreditCardLength(creditCardNumber) - 2; i >= 0; i -= 2)
        	
        	total += getNumberOfDigits(Integer.parseInt(number.charAt(i) + "") * 2);
         
        //System.out.println("total "+ total);
        return total;
    }
 
    public static int getNumberOfDigits(int creditCardNumber){
    	
        if (creditCardNumber < 9)
            return creditCardNumber;
        return creditCardNumber / 10 + creditCardNumber % 10;
    }
 
    public static int totalOfOddPlaceDigit(long creditCardNumber){
    	
        int total = 0;
        String num = creditCardNumber + "";
        for (int i = getCreditCardLength(creditCardNumber) - 1; i >= 0; i -= 2)
            total += Integer.parseInt(num.charAt(i) + "");       
        return total;
    }
 
    public static boolean matchGivenPrefix(long creditCardNumber, int d){
    	
        return getPrefix(creditCardNumber, getCreditCardLength(d)) == d;
    }
 
    public static int getCreditCardLength(long d) {
    	
        String num = d + "";
        return num.length();
    }
 
    public static long getPrefix(long creditCardNumber, int k) {
        if (getCreditCardLength(creditCardNumber) > k) {
            String num = creditCardNumber + "";
            return Long.parseLong(num.substring(0, k));
        }
        
        return creditCardNumber;
    }

	public static void getCardType(Long creditCardNumber, CreditCardInfo creditCardInfo) {
		
		String num = creditCardNumber + "";
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
