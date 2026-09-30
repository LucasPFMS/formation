package fr.demo;

import fr.demo.business.VenteFormation;
import fr.demo.business.VenteFormationImpl;
import fr.demo.dao.FormationDaoImpl;
import fr.demo.dao.FormationDao;
import fr.demo.entities.Formation;

public class App {
    public static void main(String[] args) {
        FormationDao dao = new FormationDaoImpl();
        VenteFormation formation = new VenteFormationImpl(dao);

        System.out.println("voici la liste des formations disponibles : ");
        System.out.println(formation.listFormations());
        formation.closeConnection();
    }
}
