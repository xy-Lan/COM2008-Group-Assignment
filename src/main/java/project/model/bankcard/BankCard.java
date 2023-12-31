package project.model.bankcard;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project.model.user.*;
import project.utils.EncryptionUtils;
import java.util.logging.Logger;


public class BankCard {
	private static final Logger LOGGER = Logger.getLogger(BankCard.class.getName());

	private User customer;
	private String cardNumber;
	private Integer expiryMonth;
	private Integer expiryYear;
	private String securityCode;

	private String firstName;

	private String lastName;

	private String cardName;

	public BankCard(){}

	public BankCard(User customer, String cardNumber, Integer expiryMonth, Integer expiryYear, String securityCode,
					String firstName, String lastName, String cardName) {
		this.customer = customer;
		this.cardNumber = cardNumber;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		this.securityCode = securityCode;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cardName = cardName;
	}

	public void setPreparedStatement(PreparedStatement stmt) throws SQLException {
        stmt.setInt(1, this.getCustomer().getUserID()); 
        stmt.setString(2, this.getEncryptedCardNumber());
        stmt.setInt(3, this.getExpiryMonth());         
        stmt.setInt(4, this.getExpiryYear());
		stmt.setString(5, this.getEncryptedSecurityCode());
    }

	 public static BankCard fromResultSet(ResultSet rs) throws SQLException {
        BankCard bankCard = new BankCard();
		int userID = rs.getInt("customer_id");
        bankCard.setCustomer(new User(userID));
		 bankCard.setCardNumber(rs.getString("card_number"));
		 bankCard.setExpiryMonth(rs.getInt("expiry_month"));
		 bankCard.setExpiryYear(rs.getInt("expiry_year"));
		 bankCard.setSecurityCode(rs.getString("security_code"));
		 bankCard.setFirstName(rs.getString("first_name"));
		 bankCard.setLastName(rs.getString("last_name"));
		 bankCard.setCardName(rs.getString("card_name"));
        return bankCard;
    }
	

	public String getFirstName(){ return firstName;}

	public void setFirstName(String firstName){ this.firstName = firstName; }

	public String getLastName(){ return lastName;}

	public void setLastName(String lastName){ this.lastName = lastName;}

	public String getCardName(){ return cardName;}

	public void setCardName(String cardName){ this.cardName = cardName; }
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


    public String getEncryptedCardNumber() {
	return this.cardNumber;
}

	public String getEncryptedSecurityCode() {
		return this.securityCode;
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
		this.securityCode = securityCode;
	}


	public String getSecurityCode() {
	return this.securityCode;
}

}