package fr.demo.business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import fr.demo.dao.FormationDao;
import fr.demo.entities.Formation;

public class VenteFormationImpl implements VenteFormation {
    private final FormationDao formationDao;
    private Connection connection;
    
    private Connection initConnection() {
    		try {
    			Class.forName("org.mariadb.jdbc.Driver");
        } catch(ClassNotFoundException e) {
    			e.printStackTrace();
        }
    		
    		String url = "http://127.0.0.1/phpmyadmin/index.php?route=/database/structure&db=formation";
    		String login = "formation";
    		String password = "Rhp8eOjaS3!0BFp)";
    		
    		try {
    			return connection = DriverManager.getConnection(url,login,password);
    		} catch (SQLException e) {
    			e.printStackTrace();
    			return null;
    		}
    			
    	
    }

    public VenteFormationImpl(FormationDao formationDao) {
        this.formationDao = formationDao;
        this.connection = this.initConnection();
    }

    @Override
    public void addFormation(long id, String name,String description, int time, String type, double price) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom est obligatoire");
        }
        if (formationDao.findById(id, connection) != null) {
            throw new IllegalArgumentException("Cet identifiant existe déjà");
        }
        formationDao.save(new Formation(id, name, description, time, type, price), connection);
    }


    @Override
    public List<Formation> listFormations() {
        return formationDao.findAll(connection);
    }
    
    @Override
    public void closeConnection() {
    		try {
    			this.connection.close();
    		} catch(SQLException e){
    			e.printStackTrace();
    		}
    }
}
