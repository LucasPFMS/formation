package fr.demo;

import fr.demo.business.VenteFormation;
import fr.demo.business.VenteFormationImpl;
import fr.demo.dao.FormationDaoImpl;
import fr.demo.dao.FormationDao;
import fr.demo.entities.Formation;

public class App {
    public static void main(String[] args) {
        FormationDao dao = new FormationDaoImpl();
        VenteFormation formations = new VenteFormationImpl(dao);

        System.out.println("voici la liste des formations disponibles : ");
        for (Formation formation : formations.listFormations()) {
            System.out.println(formation);
        }
  
        formations.closeConnection();
    }
}
