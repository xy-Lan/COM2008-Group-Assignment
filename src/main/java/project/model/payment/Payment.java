package project.model.payment;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.google.protobuf.Timestamp;

public class Payment {

	private String transactionID;
	private String userID;
	private BigDecimal amount;
	private Date paymentDate;
	private PaymentStatus paymentStatus;
	private PaymentMethod paymentMethod;

	// Constructor for Payment
	public Payment(String transactionID, String userID, BigDecimal amount, Date paymentDate,
			PaymentStatus paymentStatus, PaymentMethod paymentMethod) {
		this.transactionID = transactionID;
		this.userID = userID;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.paymentStatus = paymentStatus;
		this.paymentMethod = paymentMethod;
	}

	//Static method to create a Payment instance from a ResultSet
	public static Payment fromResultSet(ResultSet resultSet) throws SQLException {
		String transactionID = resultSet.getString("transaction_id");
		String userID = resultSet.getString("user_id");
		BigDecimal amount = resultSet.getBigDecimal("amount");

		// Get payment_date of type java.sql.
		java.sql.Date paymentDateSql = resultSet.getDate("payment_date");
		// Convert java.sql.Date to java.util.
		Date paymentDate = paymentDateSql != null ? new Date(paymentDateSql.getTime()) : null;

		PaymentStatus paymentStatus = PaymentStatus.valueOf(resultSet.getString("payment_status"));
		PaymentMethod paymentMethod = PaymentMethod.valueOf(resultSet.getString("payment_method"));
		return new Payment(transactionID, userID, amount, paymentDate, paymentStatus, paymentMethod);
	}

	public void processPayment() {
		// TODO - implement Payment.processPayment
		throw new UnsupportedOperationException();
	}

	public void refund() {
		// TODO - implement Payment.refund
		throw new UnsupportedOperationException();
	}

	public void verifyPayment() {
		// TODO - implement Payment.verifyPayment
		throw new UnsupportedOperationException();
	}

	public void updatePaymentStatus() {
		// TODO - implement Payment.updatePaymentStatus
		throw new UnsupportedOperationException();
	}

}