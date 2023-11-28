package project.model.bankcard;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project.model.user.*;
import project.utils.EncryptionUtils;

public class BankCard {

	private User customer;
	private String cardNumber;
	private Integer expiryMonth;
	private Integer expiryYear;
	private String securityCode;

	public void setPreparedStatement(PreparedStatement stmt) throws SQLException {
        stmt.setInt(1, this.getCustomer().getUserID()); 
        stmt.setString(2, this.getCardNumber());       
        stmt.setInt(3, this.getExpiryMonth());         
        stmt.setInt(4, this.getExpiryYear());
		stmt.setString(5, this.getSecurityCode());
    }

	 public static BankCard fromResultSet(ResultSet rs) throws SQLException {
        BankCard bankCard = new BankCard();
		int userID = rs.getInt("customer_id");
        bankCard.setCustomer(new User(userID));
        bankCard.setCardNumber(rs.getString("card_number"));
        bankCard.setExpiryMonth(rs.getInt("expiry_month"));
        bankCard.setExpiryYear(rs.getInt("expiry_year"));
        return bankCard;
    }
	

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public String getCardNumber() {
		return EncryptionUtils.decrypt(this.cardNumber);
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = EncryptionUtils.encrypt(cardNumber);
		System.out.println(cardNumber);
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

	public void setSecurityCode(String securityCode) {
		this.securityCode = EncryptionUtils.encrypt(securityCode);
	}

	public String getSecurityCode() {
		String decryptedCode = EncryptionUtils.decrypt(this.securityCode);
        return decryptedCode;
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