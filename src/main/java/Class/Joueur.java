package main.java.Class;

import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Joueur {
    public final Logger logger = LogManager.getLogger(Joueur.class);
    protected Scanner sc = new Scanner(System.in);
    private Combinaison couleurPossible = new Combinaison();
    private Affichage modeDeJeu =new Affichage();
    private Affichage jeu = new Affichage();

    protected String rep1;
    private String rep;
    private int mode;

    /**
     * Method to choice the game for players
     *
     * @return the first character of the answer as integer
     */
    public int choixduModejeu() {
        boolean problem;
        do {
            do {
                getModeDeJeu().affichageModeDeJeu();
                setRep((getSc().nextLine()));
                problem = verificationSaisieChiffre(getRep());
            } while (problem);
            setMode(Integer.parseInt(Character.toString(getRep().charAt(0))));
            getModeDeJeu().affichageChoixDuMode(getMode());
        } while (getMode() > 3);

        return getMode();
    }

    /**
     * Method in order to get O or N to play again used in main class
     *
     * @return boolean false or true
     */
    public boolean rejouer() {
        boolean r;
        System.out.println("Voulez vous rejouer? Tapez (O) pour OUI sinon tapez une autre touche pour quitter!");
        String answer = getSc().nextLine();
        answer = answer.toUpperCase();
        char carc = answer.charAt(0);
        if (carc == 'O') {
            r = true;
        } else {
            r = false;
            System.out.println("Vous avez choisi de quitter le jeu, bonne continuation !!!");
        }
        return r;
    }

    /**
     * Method to select the game for the player
     *
     * @return the choice of the player integer 1 or 2
     */
    public int choixdujeu() {
        int choice;
        boolean problem = false;
        do {
            do {
                getJeu().affichageDesJeux();
                setRep1((getSc().nextLine()));
                problem = verificationSaisieChiffre(getRep1());
            }
            while (problem);
            choice = Integer.parseInt(Character.toString(getRep1().charAt(0)));
            getJeu().affichageChoixDuJeu(choice);
        }
        while (choice > 3);
        return choice;
    }

    /**
     * Method to check the format of code secret numbers
     *
     * @param rep the code secret numbers
     * @param x   number of code numbers
     * @return true if there is a problem or false if it is ok
     */
    public boolean verificationFormatCodeSecret(String rep, int x) {
        boolean value;

        if ((rep.length()) > x) {
            logger.error("trop de caractères saisis");
            getJeu().tropDeCaracteresChoisisChiffres(x);
            value = true;
        } else if (rep.length() < x) {
            logger.error("pas assez de caractères saisis");
            getJeu().pasAssezDeCaracteresChoisisChiffres(x);
            value = true;
        } else {
            value = verificationSaisieChiffre(rep);
        }
        return value;
    }

    /**
     * Method to check the format of code secret numbers
     *
     * @param rep  the code secret numbers
     * @param x    number of code numbers
     * @param colo number of allowed colors
     * @return true if there is a problem or false if it is ok
     */
    public boolean verificationFormatCodeSecretMaster(String rep, int x, int colo) {
        boolean vrai = false;
        if ((rep.length()) > x) {
            logger.error("trop de caractères saisis");
            getJeu().tropDeCaracteresChoisisCouleurs(x);
            vrai = true;
        } else if (rep.length() < x) {
            logger.error("pas assez de caractères saisis");
            getJeu().pasAssezDeCaracteresChoisisCouleurs(x);
            vrai = true;
        } else if (verificationSaisieLettre(rep)) {
            logger.error("erreur de caractères saisis");
            System.out.println("vous avez une erreur de saisie de lettre");
            vrai = true;
        } else if (verificationCouleurPossible(rep, x, colo)) {
            logger.error("couleur non disponible");
            System.out.println("vous avez une erreur de saisie de choix de couleurs autorisées");
            vrai = true;
        }
        if (vrai) {
            System.out.println("Vous devez ressaisir ce code");
        }
        return vrai;
    }

    /**
     * Method to check the format of the purposed code numbers : is it a number?
     *
     * @param rep2 the purposed code numbers
     * @return true if there is a problem or false if it is ok
     */
    public boolean verificationSaisieChiffre(String rep2) {
        boolean problem = false;
        try {
            Integer.parseInt(rep2);
        } catch (NumberFormatException e1) {
            logger.error("problem de caractère saisi");
            System.out.println("Un des chiffres du code tapé est une lettre, le code ne doit comporter que des chiffres !!");
            System.out.println("Vous devez ressaisir ce code");
            problem = true;
        }
        return problem;
    }

    /**
     * Method to check the format of the purposed code colors, is it a letter?
     *
     * @param rep2 the purposed code colors
     * @return true if there is a problem or false if it is ok
     */
    public boolean verificationSaisieLettre(String rep2) {
        boolean problem = false;
        for (int i = 0; i < rep2.length(); i++) {
            problem = Character.isDigit(rep2.charAt(i));
            if (problem) {
                logger.error("erreur de caractère saisi");
                System.out.println("le caractère en position: " + (i + 1) + " du code saisi est un chiffre et non une lettre !!");
                problem = true;
            }
        }
        return problem;
    }

    /**
     * Method for checking if the color choice
     *
     * @param rep2 code of color purposed
     * @param x    number of cases for chosen colors
     * @param colo number of allowed colors
     * @return true or false if the checking is ok or no
     */
    public boolean verificationCouleurPossible(String rep2, int x, int colo) {
        boolean problem = false;
        int[] tabcouleurReponse = getCouleurPossible().transformerPremieresLettresEnNumero(rep2, x);
        for (int i = 0; i < rep2.length(); i++) {
            if (tabcouleurReponse[i] == 0 || tabcouleurReponse[i] > colo) {
                logger.error("erreur de caractère saisi");
                System.out.println("le caractère en position: " + (i + 1) + " du code saisi n'est pas une lettre autorisée !!");
                problem = true;
            }
        }
        return problem;
    }

    //Getters
    public String getRep1() {
        return rep1;
    }

    public String getRep() {
        return rep;
    }

    public int getMode() {
        return mode;
    }

    public Scanner getSc() {
        return sc;
    }

    public Combinaison getCouleurPossible() {
        return couleurPossible;
    }

    public Affichage getModeDeJeu(){ return modeDeJeu;}

    public Affichage getJeu() { return jeu;}

    //Setters
    public void setMode(int mode) {
        this.mode = mode;
    }

    public void setRep1(String rep1) {
        this.rep1 = rep1;
    }

    public void setRep(String rep) {
        this.rep = rep;
    }

}
