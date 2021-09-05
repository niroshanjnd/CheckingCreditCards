package com.janaka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.janaka.model.CreditCardInfo;
import com.janaka.repository.CreditCardInfoRepository;

@Service
public class CreditCardInfoService {
	
	@Autowired
	CreditCardInfoRepository creditCardInfoRepository;
	
	public void getCreditCardInfo(CreditCardInfo creditCardInfo) {
		creditCardInfo.setCreditCardValidity(isValid(creditCardInfo.getCreditCardNumber()));
		//isValid(creditCardInfo.getCreditCardNumber());
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
        //System.out.println("ABC "+ num);
        return num.length();
    }
 
    public static long getPrefix(long creditCardNumber, int k) {
        if (getCreditCardLength(creditCardNumber) > k) {
            String num = creditCardNumber + "";
            //System.out.println("substring "+ Long.parseLong(num.substring(0, k)));
            
            return Long.parseLong(num.substring(0, k));
        }
        
        return creditCardNumber;
    }
	
	

}
