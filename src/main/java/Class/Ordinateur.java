package main.java.Class;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Ordinateur extends Affichage {

    public final Logger logger = LogManager.getLogger(Rechercheplus.class);
    private Combinaison Result = new Combinaison();
    private int nber;

    /**
     * Method for the computer to choice the secret code number
     *
     * @param x number of code numbers
     * @param y number of allowed numbers for example 4 allows 1 and 2 and 3 and 4
     * @return the secret code number as array of integer
     */
    public int[] saisirCodeSecret(int x, int y) {
        System.out.println("\n ******************* L'ORDINATEUR CHOISIT UN CODE SECRET **********************************");
        System.out.println("L'ordinateur a fait son choix de " + x + " chiffres pour le code secret.");
        int[] tab = new int[x];
        for (int counter = 0; counter < x; counter++) {
            int nbreH = 1 + (int) (Math.random() * y);
            tab[counter] = nbreH;
        }
        logger.debug("le code secret de l'ordinateur est: " + Arrays.toString(tab));
        return tab;
    }

    /**
     * Method for the computer to choice the secret code number in the Mastermind game
     *
     * @param x number of cases
     * @param y number of colors
     * @return the secret code number as array of integer
     */
    public int[] saisirCodeSecretMaster(int x, int y) {
        System.out.println("\n ****************** L'ORDINATEUR CHOISIT SES COULEURS POUR LE CODE SECRET *******************");
        System.out.println("L'ordinateur a fait son choix de ses " + x + " couleurs pour son code secret !!!");
        int[] tab = new int[x];
        for (int counter = 0; counter < x; counter++) {
            int nbreH = 1 + (int) (Math.random() * y);
            tab[counter] = nbreH;
        }
        logger.trace("le code secret de l'ordinateur a été choisi");
        return tab;
    }

    /**
     * Method for the computer to find the secret code number
     *
     * @param x number of code numbers
     * @param y number of allowed numbers for example 4 allows 1 and 2 and 3 and 4
     * @return the purposed code numbers
     */
    public int[] trouverCodeSecret(int x, int y) {
        System.out.println("\n ***************** L'ORDINATEUR COMMENCE A CHERCHER VOTRE CODE SECRET ***********************\n");
        int[] tab = new int[x];
        for (int counter = 0; counter < x; counter++) {
            int nbreH = 1 + (int) (Math.random() * y);
            tab[counter] = nbreH;
        }
        logger.trace("le code secret de l'ordinateur a été proposé");
        ;
        return tab;
    }

    /**
     * Method for the computer to analysis and compare 2 arrays in order to purpose others numbers
     *
     * @param tab1 array of integer which includes numbers of player
     * @param tab2 array of integer which includes computer numbers
     * @param x    number of code numbers
     * @return the new array of integer which includes new purposed computer numbers
     */
    public int[] AnalyseOrdi(int[] tab1, int[] tab2, int x) {
        int[] newtab = new int[x];
        for (int counter = 0; counter < x; counter = counter + 1) {
            if (tab1[counter] == tab2[counter]) {
                newtab[counter] = tab2[counter];
            } else if (tab1[counter] > tab2[counter]) {
                newtab[counter] = tab2[counter] + 1;
            } else if (tab1[counter] < tab2[counter]) {
                newtab[counter] = tab2[counter] - 1;
            }
        }
        logger.debug("le nouveau code proposé de l'ordinateur est: " + Arrays.toString(newtab));
        return newtab;
    }

    /**
     * Method to print result in order to inform the winner, the looser or that you must continue
     *
     * @param tableau1 the secret code number
     * @param tableau2 the code numbers of the  computer in mode attacker
     * @param resultat the result of the comparison between the secret number and the attacker 's code numbers
     * @param turn     nomber of current turn
     * @param tmax     nomber of allowed turn in order to find the secret code numbers
     * @param nber     number of code numbers
     */
    public void afficherResultat(int[] tableau1, int[] tableau2, String[] resultat, int turn, int tmax, int nber) {
        String joinedResult = String.join("", resultat);
        String joinedarray2 = Arrays.stream(tableau2).mapToObj(String::valueOf).collect(Collectors.joining(""));
        affichageOrdiPropose();
        System.out.println("Proposition: " + joinedarray2 + "   réponse: " + joinedResult);
    }

    /**
     * Method to result for the Mastermind game
     *
     * @param tableau1 the secret code number
     * @param tableau2 the code numbers of the attacker
     * @param resultat the result of the comparison between the secret number and the attacker 's code numbers
     * @param turn     number of current turn
     * @param tmax     number of allowed turn in order to find the secret code numbers
     * @param nber     number of code numbers
     */
    public void afficherResultatMaster(int[] tableau1, int[] tableau2, ArrayList<String> resultat, int turn, int tmax, int nber) {
        Combinaison cpresent = new Combinaison();
        Combinaison cbienplace = new Combinaison();
        int present = cpresent.nombreChiffrePresent(resultat, nber);
        int bienplace = cbienplace.nombreChiffreBienPlace(resultat, nber);
        String[] tabC = getResult().transformerNumerosEnCouleurs(tableau2, nber);
        String joinedarray2 = String.join(",", tabC);
        affichageOrdiPropose();
        System.out.println("Proposition: " + joinedarray2 + "   réponse: " + " bien placé(s): " + bienplace + "  présent(s): " + present);
    }

    /**
     * Method to print that the computer will purpose a neuw code
     */
    public void affichageOrdiPropose() {
        System.out.println("\n*************** L'ORDINATEUR A CHERCHE ET PROPOSE UN CODE **********************************");
        System.out.println(" *********************** RESULTAT **********************************************************");
    }

    /**
     * Method to print the result when the computer win
     *
     * @param turn number of allowed turns in order to find the secret code numbers
     */
    public void victoireOrdinateur(int turn) {
        System.out.println("\n******************** L'ORDINATEUR A GAGNE  **************************************************");
        System.out.println("Bravo a l'Ordinateur qui a trouvé le code secret en " + turn + " tour(s)!!");
    }

    /**
     * Methode to print the result when the computer loose
     *
     * @param tableau1 the secret code number
     */
    public void defaiteOrdinateur(int[] tableau1) {
        System.out.println("\n******************** L'ORDINATEUR A PERDU ***************************************************");
        System.out.println(" Cet ordinateur est nul!!, le nombre de tentatives autorisées est dépassé.");
        String[] tabC = getResult().transformerNumerosEnCouleurs(tableau1, getNber());
        String joinedarray1 = String.join(",", tabC);
        System.out.println("La solution était: " + joinedarray1);
    }

    /**
     * Methode to print the result when the computer loose for the Mastermind game
     *
     * @param tableau1 the secret code number
     */
    public void defaiteOrdinateurMaster(int[] tableau1) {
        System.out.println("\n******************** L'ORDINATEUR A PERDU ***************************************************");
        System.out.println(" Cet ordinateur est nul!!, le nombre de tentatives autorisées est dépassé.");
        String joinedarray1 = Arrays.stream(tableau1).mapToObj(String::valueOf).collect(Collectors.joining(""));
        System.out.println("La solution était: " + joinedarray1);
    }

    /**
     * Method to check if the player has won or no
     *
     * @param tableau1 the code secret numbers that the computeur has to find
     * @param tableau2 the code secret numbers purposed by the computer
     * @param turn     number of turn that the player takes
     * @param tmax     maxi number of allowed turns in order to find all code secret numbers
     * @return true if the game need to continue or false in other case (victory or defeat)
     */
    @Override
    public boolean verificationVictoire(int[] tableau1, int[] tableau2, int turn, int tmax) {
        boolean continuer;
        if ((Arrays.equals(tableau1, tableau2)) && (turn < tmax)) {
            continuer = false;
            victoireOrdinateur(turn);
        } else if (turn == tmax) {
            defaiteOrdinateur(tableau1);
            continuer = false;
        } else {
            System.out.println("L'ORDINATEUR a encore " + (tmax - turn) + " tentative(s) pour trouver le code secret.\n");
            continuer = true;
        }
        return continuer;
    }

    /**
     * Method to check if the player has won or no for the Mastermind game
     *
     * @param tableau1 the code secret numbers that the computeur has to find
     * @param tableau2 the code secret numbers purposed by the computer
     * @param turn     number of turn that the player takes
     * @param tmax     maxi number of allowed turns in order to find all code secret numbers
     * @return true if the game need to continue or false in other case (victory or defeat)
     */
    @Override
    public boolean verificationVictoireMaster(int[] tableau1, int[] tableau2, int turn, int tmax) {
        boolean continuer;
        if ((Arrays.equals(tableau1, tableau2)) && (turn < tmax)) {
            continuer = false;
            victoireOrdinateur(turn);
        } else if (turn == tmax) {
            defaiteOrdinateurMaster(tableau1);
            continuer = false;
        } else {
            System.out.println("L'ORDINATEUR a encore " + (tmax - turn) + " tentative(s) pour trouver les couleurs du code secret.\n");
            continuer = true;
        }
        return continuer;
    }

    //Getters
    @Override
    public Combinaison getResult() {
        return Result;
    }

    @Override
    public int getNber() {
        return nber;
    }
}


