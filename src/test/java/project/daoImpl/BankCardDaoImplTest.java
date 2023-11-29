package project.daoImpl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.daoimpl.BankCardDaoImpl;
import project.model.bankcard.BankCard;
import project.model.user.User;
import project.service.MySqlService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class BankCardDaoImplTest {
    private static final Logger LOGGER = Logger.getLogger(BankCardDaoImpl.class.getName());
    private BankCardDaoImpl bankCardDao;
    private final int testUserId = 123;

    @BeforeEach
    public void setUp() throws SQLException {
        bankCardDao = new BankCardDaoImpl();

//        addTestUserToUsersTable();
    }

//    private void addTestUserToUsersTable() throws SQLException {
//        String userSql = "INSERT INTO users (user_id) VALUES (?)";
//        try (Connection conn = mysqlService.getConnection();
//             PreparedStatement userStmt = conn.prepareStatement(userSql)) {
//            userStmt.setInt(1, testUserId);
//            userStmt.executeUpdate();
//        }
//    }

////    this test is successful
//    @Test
//    public void testAddBankCard() throws SQLException{
//        // Create a BankCard instance with test data
//        BankCard bankCard = new BankCard();
//        bankCard.setCustomer(new User(123)); // Replace with test data
//        bankCard.setCardNumber("1234567890123456"); // Replace with test data
//        bankCard.setExpiryMonth(12); // Replace with test data
//        bankCard.setExpiryYear(2025); // Replace with test data
//        bankCard.setSecurityCode("123"); // Replace with test data
//
//        // Call addBankCard method
//        bankCardDao.addBankCard(bankCard);
//
//        BankCard retrievedCard = bankCardDao.getBankCardByUserID(123);
//        System.out.println(retrievedCard.getCardNumber());
//        System.out.println(retrievedCard.getSecurityCode());
////        assertNotNull(retrievedCard);
////        assertEquals("1234567890123456", retrievedCard.getCardNumber());
////        assertEquals(12, retrievedCard.getExpiryMonth());
////        assertEquals(2025, retrievedCard.getExpiryYear());
////        assertEquals("123", retrievedCard.getSecurityCode());
//    }

//    @Test
//    public void testGetBankCardByUserID_ExistingUser() {
//        // 假设存在的用户ID
//        int userId = 2;
//
//        // 执行测试
//        BankCard result = bankCardDao.getBankCardByUserID(userId);
//
//        // 验证结果
//        assertNotNull(result, "Bank card should not be null");
////        assertEquals("UserID should match", userId, result.getCustomer().getUserID());
//        // 添加更多的验证...
//    }

//    @AfterEach
//    public void tearDown() {
//        int testUserId = 123;
//
//        // First delete the test data from the bank_card table
//        deleteTestData("DELETE FROM bank_card WHERE user_id = ?", testUserId);
//
//        // Then delete the test user from the users table
//        deleteTestData("DELETE FROM users WHERE user_id = ?", testUserId);
//    }
//
//    private void deleteTestData(String sql, int id) {
//        try (Connection conn = mysqlService.getConnection();
//             PreparedStatement stmt = conn.prepareStatement(sql)) {
//
//            stmt.setInt(1, id);
//            int rowsAffected = stmt.executeUpdate();
//            if (rowsAffected == 0) {
//                System.out.println("No test data to clean up for query: " + sql);
//            }
//        } catch (SQLException e) {
//            LOGGER.log(Level.SEVERE, "Error cleaning up test data for query: " + sql, e);
//            throw new RuntimeException(e);
//        }
//    }
//@Test
//public void testDeleteBankCard() {
//    // 设置测试条件 - 确保数据库中有一个可以被删除的银行卡记录
//    int userId = 123;
//
//    // 执行删除操作
//    bankCardDao.deleteBankCard(userId);
//
//    // 验证 - 确认银行卡已被删除
//    // 这可以通过尝试获取该用户的银行卡记录来完成，
//    // 并检查结果是否为null或记录是否不存在
//    assertNull(bankCardDao.getBankCardByUserID(userId));
//}

}
