package project.service;

import java.util.List;

import project.dao.BankCardDao;
import project.model.bankcard.BankCard;

public class BankCardService {

    private BankCardDao bankCardDao;

    private List<BankCard> bankCards;

    public void processPaymnet(BankCard bankCard) {
        // TODO - implement BankCard.processPayment
        throw new UnsupportedOperationException();
    }

    public void validatePaymentDetails(BankCard bankCard) {
        // TODO - implement BankCard.validatePaymentDetails
        throw new UnsupportedOperationException();
    }
}
