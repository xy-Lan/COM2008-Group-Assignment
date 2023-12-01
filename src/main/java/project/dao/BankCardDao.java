package project.dao;

import java.util.List;

import project.model.bankcard.BankCard;

public interface BankCardDao {
    // Method to add a BankCard to the data source
    void addBankCard(BankCard bankCard);

    // Method to retrieve a BankCard by its card number
    BankCard getBankCardByNumber(String cardNumber);

    BankCard getBankCardByUserID(int userId);

    // Method to delete a BankCard from the data source
    void deleteBankCard(int userID);

    boolean userHasBankCard(int userId);

}
