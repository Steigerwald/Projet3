package main.java;

import main.java.Class.*;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.File;


public class Main { public static void main(String[] args){

    PropertyConfigurator.configure("src/main/ressources/log4j.properties");
    //System.setProperty("log4j.configurationFile", "src/main/resources/log4j2.xml");
    //DOMConfigurator.configure("src/main/ressources/log4j2.xml");
    Joueur premierJoueur=new Defenseur();
    Rechercheplus jeu1=new Rechercheplus();
    Masterminnd jeu2=new Masterminnd();
    int menu;

    boolean quitter=true;
    do{
        System.out.println();
        System.out.println("==================== Jeux de Logique ===========================");
        menu=premierJoueur.choixdujeu();
        switch (menu) {
            case 1:
                jeu1.lancementJeuRecherchePlus();
                quitter=premierJoueur.rejouer();
                break;
            case 2:
                jeu2.lancementJeuMastermind();
                quitter=premierJoueur.rejouer();
                break;
            case 3:
                quitter=false;
                break;
        }
    }
    while (quitter);
}
}
