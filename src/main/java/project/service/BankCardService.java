package project.service;

import java.util.List;
import java.util.logging.Logger;

import project.dao.BankCardDao;
import project.dao.OrderDao;
import project.daoimpl.BankCardDaoImpl;
import project.daoimpl.OrderDaoImpl;
import project.exceptions.InvalidBankCardException;
import project.model.bankcard.BankCard;
import project.model.order.Order;
import project.utils.BankCardUtils;

public class BankCardService {
    private static final Logger LOGGER = Logger.getLogger(BankCardService.class.getName());
    private MysqlService mysqlService = new MysqlService();
    private BankCardDao bankCardDao = new BankCardDaoImpl(mysqlService);
    private OrderDao orderDao = new OrderDaoImpl(mysqlService);
    private OrderService orderService = new OrderService(orderDao);
    private List<BankCard> bankCards;

    public BankCard getBankCardDetails(int userId) {
        // Getting card information from the database
        return bankCardDao.getBankCardByUserID(userId);
    }

    public void addBankCardDetails(BankCard bankCard) {
        // Save or update card information to the database
        bankCardDao.addBankCard(bankCard);
    }

    public void deleteBankCardDetails(int userId) {
        // Implement the logic to delete the user's card information from the database
        bankCardDao.deleteBankCard(userId);
    }

    public void processPayment(BankCard bankCard, Order order) {
        if (!isValidBankCard(bankCard)) {
            throw new IllegalArgumentException("Invalid bank card details");
        }

        if (!hasSufficientBalance(bankCard)) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        orderService.confirmOrder(order);
    }

    public boolean isValidBankCard(BankCard bankCard) {
        // Verification of bank card number
        if (!BankCardUtils.isValidCardNumber(bankCard.getCardNumber())) {
            return false;
        }

        // Validation Validity Period
        if (!BankCardUtils.isValidExpiryDate(bankCard.getExpiryMonth(), bankCard.getExpiryYear())) {
            return false;
        }

        // Verify Security Code
        if (!BankCardUtils.isValidSecurityCode(bankCard.getSecurityCode())) {
            return false;
        }

        // Returns true if all validations are passed
        return true;
    }

    private boolean hasSufficientBalance(BankCard bankCard) {
        // Returns true directly, assuming that the balance is always sufficient
        return true;
    }

}
