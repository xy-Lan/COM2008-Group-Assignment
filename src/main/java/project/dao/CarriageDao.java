package project.dao;

import project.model.product.Carriage;

import java.util.List;

public interface CarriageDao {
    void addCarriage(Carriage carriage);
    Carriage getCarriage(String id); // 假设有一个唯一标识符
    List<Carriage> getAllCarriages();
    void updateCarriage(Carriage carriage);
    void deleteCarriage(String id);
}
