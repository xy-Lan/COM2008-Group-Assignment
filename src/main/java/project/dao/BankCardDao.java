package project.dao;

import java.util.List;

import project.model.bankcard.BankCard;

public interface BankCardDao {
    // Method to add a BankCard to the data source
    void addBankCard(BankCard bankCard);

    // Method to retrieve a BankCard by its card number
    BankCard getBankCardByNumber(String cardNumber);

    // Method to update a BankCard's details
    void updateBankCard(BankCard bankCard);

    // Method to delete a BankCard from the data source
    void deleteBankCard(String cardNumber);

    // Method to list all BankCards
    List<BankCard> getAllBankCards();
}
