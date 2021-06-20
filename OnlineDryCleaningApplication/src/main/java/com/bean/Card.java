package com.bean;
import java.time.LocalDate;

import javax.persistence.Embeddable;
import javax.validation.Valid;

import com.sun.istack.NotNull;

@Embeddable
public class Card {
	
	@NotNull
	private String cardName;
	private String cardNumber;
	@NotNull
	private LocalDate expiryDate;
	private String bankName;

	public Card() {
		super();
	}

	public Card(long id, @NotNull String cardName, String cardNumber,@Valid LocalDate expiryDate, String bankName) {
		super();
		//this.id = id;
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.bankName = bankName;
	}

	
	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Override
	public String toString() {
		return "Card [id="  + ", cardName=" + cardName + ", cardNumber=" + cardNumber + ", expiryDate=" + expiryDate
				+ ", bankName=" + bankName + "]";
	}

}
