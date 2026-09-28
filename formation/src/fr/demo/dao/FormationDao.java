package fr.demo.dao;

import java.sql.Connection;
import java.util.List;
import fr.demo.entities.Formation;

public interface FormationDao {
    Formation findById(long id, Connection connection);
    List<Formation> findAll(Connection connection);
    void save(Formation formation, Connection connection);
    void updateQuantity(long id, int quantity, Connection connection);
}
