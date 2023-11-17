package project.model.bankcard;

import project.model.user.*;

public class BankCard {

	private User customer;
	private String cardNumber;
	private Integer expiryMonth;
	private Integer expiryYear;
	private Integer securityCode;

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Integer getExpiryMonth() {
		return expiryMonth;
	}

	public void setExpiryMonth(Integer expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	public Integer getExpiryYear() {
		return expiryYear;
	}

	public void setExpiryYear(Integer expiryYear) {
		this.expiryYear = expiryYear;
	}

	public Integer getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(Integer securityCode) {
		this.securityCode = securityCode;
	}

//	public void processPayment() {
//		// TODO - implement BankCard.processPayment
//		throw new UnsupportedOperationException();
//	}
//
//	public void validatePaymentDetails() {
//		// TODO - implement BankCard.validatePaymentDetails
//		throw new UnsupportedOperationException();
//	}

}