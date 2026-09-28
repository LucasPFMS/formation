package fr.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import fr.demo.entities.Formation;

public class FormationDaoImpl implements FormationDao {

    @Override
    public Formation findById(long id, Connection connection) {
        String sql = "SELECT id, name, description, time, type, price FROM formation WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Formation(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("time"),
                        rs.getString("type"),
                        rs.getDouble("price")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Aucun produit trouvé
    }

    @Override
    public List<Formation> findAll(Connection connection) {
        String sql = "SELECT id, name, description, time, type, price FROM formation ORDER BY id";
        List<Formation> formation = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                formation.add(new Formation(
                		rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("time"),
                        rs.getString("type"),
                        rs.getDouble("price")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return formation;
    }

    @Override
    public void save(Formation formation, Connection connection) {
    	String str = "INSERT INTO Product (name, description, time, type, price) VALUES (?,?,?,?,?);";
    	try (PreparedStatement ps = connection.prepareStatement(str)){
    		ps.setString(1, formation.getName());
    		ps.setString(2, formation.getDescription());
    		ps.setInt(3, formation.getTime());
    		ps.setString(4, formation.getType());
    		ps.setDouble(5, formation.getPrice());
    		if (ps.executeUpdate() == 1) {
    			System.out.println("Insertion ok");
    		}
    	} catch(SQLException e) {
    		throw new RuntimeException("Erreur de sauvegarde" + e);
    	}
    }

	@Override
	public void updateQuantity(long id, int quantity, Connection connection) {
		// TODO Auto-generated method stub
		
	}
}
