package main.java;

import main.java.Class.*;
import org.apache.log4j.PropertyConfigurator;


public class Main {
    public static void main(String[] args) {
        PropertyConfigurator.configure("src/main/ressources/log4j.properties");
        Joueur premierJoueur = new Joueur();
        Rechercheplus jeu1 = new Rechercheplus();
        Masterminnd jeu2 = new Masterminnd();
        int menu;
        boolean quitter = true;
        do {
            System.out.println();
            System.out.println("==================== Jeux de Logique ===========================");
            menu = premierJoueur.choixdujeu();
            switch (menu) {
                case 1:
                    jeu1.lancementJeuRecherchePlus();
                    quitter = premierJoueur.rejouer();
                    break;
                case 2:
                    jeu2.lancementJeuMastermind();
                    quitter = premierJoueur.rejouer();
                    break;
                case 3:
                    quitter = false;
                    break;
            }
        }
        while (quitter);
    }
}
