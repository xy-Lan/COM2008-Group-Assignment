package project.daoimpl;

import java.util.ArrayList;
import java.util.List;

import java.sql.*;

import project.dao.BankCardDao;
import project.model.bankcard.BankCard;
import project.service.MysqlService;

public class BankCardDaoImpl implements BankCardDao {

    private MysqlService mysqlService;

    public BankCardDaoImpl(MysqlService mysqlService) {
        this.mysqlService = mysqlService;
    }

    @Override
    public void addBankCard(BankCard bankCard) {
        // Implementation for adding a BankCard to the database
    }

    @Override
    public BankCard getBankCardByNumber(String cardNumber) {
        // Implementation for retrieving a BankCard by card number
        return null;
    }

    @Override
    public void updateBankCard(BankCard bankCard) {
        // Implementation for updating a BankCard's details
    }

    @Override
    public void deleteBankCard(String cardNumber) {
        // Implementation for deleting a BankCard from the database
    }

    @Override
    public List<BankCard> getAllBankCards() {
        // Implementation for listing all BankCards
        return new ArrayList<>();
    }
}
