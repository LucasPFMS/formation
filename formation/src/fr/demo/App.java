package fr.demo;

import java.util.Scanner;

import fr.demo.business.VenteFormation;
import fr.demo.business.VenteFormationImpl;
import fr.demo.dao.FormationDaoImpl;
import fr.demo.dao.FormationDao;
import fr.demo.entities.Formation;

public class App {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        FormationDao dao = new FormationDaoImpl();
        VenteFormation formations = new VenteFormationImpl(dao);

        System.out.println("voici la liste des formations disponibles : ");
        for (Formation formation : formations.listFormations()) {
            System.out.println(formation);
        }
        
        System.out.println("quelle formation voulez-vous recherchez ?");
        String my_formation = sc.nextLine();
        for (Formation formation : formations.listFormations()) {
        	if (formation.getDescription().contains(my_formation)){
        		System.out.println(formation);
        	}	
        }
        System.out.println("quelle type de formation voulez-vous recherchez (présentiel/distentiel) ?");
        String type_my_formation = sc.nextLine();
        for (Formation formation : formations.listFormations()) {
        	if (formation.getType() == type_my_formation){
        		System.out.println(formation);
        	}
        }
  
        formations.closeConnection();
    }
}
