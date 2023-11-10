package main.java.com.system.model.payment;
import java.math.BigDecimal;
import java.util.Date;

public class Payment {

	private String transactionID;
	private String userID;
	private BigDecimal amount;
	private Date paymentDate;
	private PaymentStatus paymentStatus;
	private PaymentMethod paymentMethod;

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