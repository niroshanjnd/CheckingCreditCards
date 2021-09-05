package com.janaka.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CreditCardInformation {
	
	@Id
	@Column
	private Long creditCardNumber;
	
	@Column
	private String creditCardType;
	
	@Column
	private Boolean creditCardValidity;
	

}
