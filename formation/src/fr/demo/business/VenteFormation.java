package fr.demo.business;

import java.util.List;
import fr.demo.entities.Formation;

public interface VenteFormation {
    void addFormation(long id, String name,String description, int time, String type, double price);
    List<Formation> listFormations();
    void closeConnection();
}
