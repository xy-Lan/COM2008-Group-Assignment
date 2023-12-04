package project.dao;

import java.util.List;

import project.model.address.Address;

public interface AddressDao {
    Boolean isAddressExist(String houseNumber, String postCode);
    Integer addAddressIfNotExist(Address address);
    void addAddress(Address address);

    int addAddressReturnId(Address address);

    Integer getAddressId(String houseNumber, String postCode);

    Address getAddress(int addressId);

    List<Address> getAllAddresses();

    void updateAddress(Address address);

    void deleteAddress(String houseNumber, String postCode);
}
