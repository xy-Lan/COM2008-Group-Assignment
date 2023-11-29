package project.dao;

import java.util.List;

import project.model.address.Address;

public interface AddressDao {
    void addAddress(Address address);

    Address getAddress(int addressId);

    List<Address> getAllAddresses();

    void updateAddress(Address address);

    void deleteAddress(String houseNumber, String postCode);
}
