package project.service;

import project.dao.AddressDao;
import project.dao.BankCardDao;
import project.dao.UserDao;
import project.daoimpl.AddressDaoImpl;
import project.daoimpl.BankCardDaoImpl;
import project.daoimpl.UserDaoImpl;
import project.model.address.Address;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AddressService {
    private static final Logger LOGGER = Logger.getLogger(AddressService.class.getName());
    private AddressDao addressDao = new AddressDaoImpl();
    private UserDao userDao = new UserDaoImpl();

    public void updateUserAddress(Address address, int userId) {
        try {
            Integer newAddressId = addressDao.addAddressIfNotExist(address);

            userDao.updateUserAddressId(userId, newAddressId);

            LOGGER.info("User's address updated successfully for user ID: " + userId);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error updating user's address", e);
            // Handle exception (possibly re-throw or log)
            throw new RuntimeException("Error updating user's address", e);
        }
    }
}
