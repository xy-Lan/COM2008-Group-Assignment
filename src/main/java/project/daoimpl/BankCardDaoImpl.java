package project.daoimpl;

import java.util.ArrayList;
import java.util.List;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import project.dao.BankCardDao;
import project.model.bankcard.BankCard;
import project.model.user.User;
import project.service.MySqlService;
import project.utils.EncryptionUtils;

public class BankCardDaoImpl implements BankCardDao {
    private static final Logger LOGGER = Logger.getLogger(BankCardDaoImpl.class.getName());

    @Override
    public void addBankCard(BankCard bankCard) {
        String sql = "INSERT INTO bank_card (user_id, card_number, expiry_month, expiry_year, security_code, first_name, last_name, card_name) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        // SQL query to insert a BankCard into the database

        try (Connection conn = MySqlService.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Using BankCard object to set parameters of the PreparedStatement
            stmt.setInt(1, bankCard.getCustomer().getUserID());
            stmt.setString(2, bankCard.getCardNumber());
            stmt.setInt(3, bankCard.getExpiryMonth());
            stmt.setInt(4, bankCard.getExpiryYear());
            stmt.setString(5, bankCard.getSecurityCode());
            stmt.setString(6, bankCard.getFirstName());
            stmt.setString(7, bankCard.getLastName());
            stmt.setString(8, bankCard.getCardName());

            // Executing the insert operation
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                // Handle the situation when the insert fails
                throw new SQLException("Inserting bank card failed, no rows affected.");
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error adding bank card to the database", e);
            // Handle exceptions and possibly throw a runtime exception
            throw new RuntimeException("Database operation failed", e);
        }
    }



    @Override
    public BankCard getBankCardByNumber(String cardNumber) {
        String sql = "SELECT * FROM bank_card WHERE card_number = ?";
        // SQL query to retrieve a BankCard by its encrypted card number

        try (Connection conn = MySqlService.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Encrypt the card number before querying the database
            String encryptedCardNumber = EncryptionUtils.encrypt(cardNumber);
            stmt.setString(1, encryptedCardNumber);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    BankCard bankCard = BankCard.fromResultSet(rs);
                    return bankCard;
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving bank card from the database", e);
            // Handle exceptions and possibly throw a runtime exception
            throw new RuntimeException("Database operation failed", e);
        }
        return null;
    }

    @Override
    public BankCard getBankCardByUserID(int userId) {
        String sql = "SELECT * FROM bank_card WHERE user_id = ?";
        // SQL query to retrieve a BankCard associated with a specific user

        try (Connection conn = MySqlService.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapRowToBankCard(rs);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving bank card for user ID " + userId, e);
            throw new RuntimeException("Database operation failed", e);
        }
        return null;
    }

    private BankCard mapRowToBankCard(ResultSet rs) throws SQLException {
        BankCard bankCard = new BankCard();
        int userId = rs.getInt("user_id");
        bankCard.setCustomer(new User(userId));
        bankCard.setCardNumber(rs.getString("card_number"));
        bankCard.setExpiryMonth(rs.getInt("expiry_month"));
        bankCard.setExpiryYear(rs.getInt("expiry_year"));
        bankCard.setSecurityCode(rs.getString("security_code"));
        bankCard.setFirstName(rs.getString("first_name"));
        bankCard.setLastName(rs.getString("last_name"));
        bankCard.setCardName(rs.getString("card_name"));

        return bankCard;
    }


    @Override
    public void deleteBankCard(int userId) {
        String sql = "DELETE FROM bank_card WHERE user_id = ?";
        // SQL query to delete a BankCard associated with a specific user

        try (Connection conn = MySqlService.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Deleting bank card failed, no rows affected.");
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error deleting bank card from the database", e);
            throw new RuntimeException("Database operation failed", e);
        }
    }

    @Override
    public boolean userHasBankCard(int userId) {
        String sql = "SELECT COUNT(*) FROM bank_card WHERE user_id = ?";
        try (Connection conn = MySqlService.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error checking if user has bank card", e);
        }
        return false;
    }


}
