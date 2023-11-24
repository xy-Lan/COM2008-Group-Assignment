package project.dao;

import project.model.product.Carriage;

import java.util.List;

public interface CarriageDao {
    void addCarriage(Carriage carriage);
    Carriage getCarriage(String id); 
    List<Carriage> getAllCarriages();
    void updateCarriage(Carriage carriage);
    void deleteCarriage(String id);
}
