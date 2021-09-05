package com.janaka.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CreditCardInfo {
	
	@Id
	@Column
	private Long creditCardNumber;
	
	@Column
	private String creditCardType;
	
	@Column
	private Boolean creditCardValidity;

	public Long getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(Long creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getCreditCardType() {
		return creditCardType;
	}

	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}

	public Boolean getCreditCardValidity() {
		return creditCardValidity;
	}

	public void setCreditCardValidity(Boolean creditCardValidity) {
		this.creditCardValidity = creditCardValidity;
	}
	
	
}
