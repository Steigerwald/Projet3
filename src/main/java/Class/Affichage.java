package main.java.Class;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import main.java.Enum.Colors;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Affichage {

    public final Logger logger = LogManager.getLogger(Affichage.class);
    private Combinaison Result = new Combinaison();
    private int nber;

    /**
     * Method to display the result and see if the player has win for the game Rechercheplus
     *
     * @param tableau1 the secret code number
     * @param tableau2 the code numbers of the attacker
     * @param resultat the result of the comparison between the secret number and the attacker 's code numbers
     * @param turn     number of current turn
     * @param tmax     number of allowed turn in order to find the secret code numbers
     * @param nber     number of code numbers
     */
    public void afficherResultat(int[] tableau1, int[] tableau2, String[] resultat, int turn, int tmax, int nber) {
        String joinedResult = String.join("", resultat);
        String joinedarray2 = Arrays.stream(tableau2).mapToObj(String::valueOf).collect(Collectors.joining(""));
        resultatDuJoueur(joinedarray2, joinedResult);
    }

    /**
     * Method to display the result and see if the player has win for the game Mastermind
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
        System.out.println("\n *********************** RESULTAT DU JOUEUR **********************************************");
        System.out.println("Proposition: " + joinedarray2 + "   réponse: " + " bien placé(s): " + bienplace + "  présent(s): " + present);
    }

    /**
     * Method to diplay the result of the player
     *
     * @param resultat1 purposed code secret numbers
     * @param resultat2 result + or - or =
     */
    public void resultatDuJoueur(String resultat1, String resultat2) {
        System.out.println("\n *********************** RESULTAT DU JOUEUR **********************************************");
        System.out.println("Proposition: " + resultat1 + "   réponse: " + resultat2);
    }

    /**
     * Method to display the victory of the player
     *
     * @param turn number of turn that the player use in order to find all code secret numbers
     */
    public static void victoireDuJoueur(int turn) {
        System.out.println("\n ******************** FELICIATIONS AU JOUEUR ***********************************************");
        System.out.println("Bravo! vous  avez trouvé le code secret en " + turn + " tour(s).");
    }

    /**
     * Method to display the defeat of the player
     *
     * @param tableau1 the code secret numbers that the player had to find
     */
    public void defaiteDuJoueurNbreTour(int[] tableau1) {
        System.out.println("\n ******************** DEFAITE DU JOUEUR ******************************************************");
        System.out.println(" Malheureusement, vous avez perdu, le nombre de tentatives autorisées est dépassé !");
        String joinedarray1 = Arrays.stream(tableau1).mapToObj(String::valueOf).collect(Collectors.joining(""));
        System.out.println("La solution était: " + joinedarray1);
    }

    /**
     * Method to display the defeat of the player for the Mastermind game
     *
     * @param tableau1 the code secret numbers that the player had to find
     */
    public void defaiteDuJoueurMaster(int[] tableau1) {
        System.out.println("\n ******************** DEFAITE DU JOUEUR ***********************************************************");
        System.out.println(" Malheureusement, vous avez perdu, le nombre de tentatives autorisées est dépassé !");
        String[] tabC = getResult().transformerNumerosEnCouleurs(tableau1, getNber());
        String joinedarray1 = String.join(",", tabC);
        System.out.println("La solution était: " + joinedarray1);
    }

    /**
     * Method to check if the player has won or no
     *
     * @param tableau1 the code secret numbers that the player has to find
     * @param tableau2 the code secret numbers purposed by the player
     * @param turn     number of turn that the player takes
     * @param tmax     maxi number of allowed turns in order to find all code secret numbers
     * @return true if the game need to continue or false in other case (victory or defeat)
     */
    public boolean verificationVictoire(int[] tableau1, int[] tableau2, int turn, int tmax) {
        boolean continuer;
        if ((Arrays.equals(tableau1, tableau2)) && (turn < tmax)) {
            continuer = false;
            victoireDuJoueur(turn);
        } else if (turn == tmax) {
            defaiteDuJoueurNbreTour(tableau1);
            continuer = false;
        } else {
            System.out.println("Le JOUEUR a encore " + (tmax - turn) + " tentative(s) pour trouver le code secret.\n");
            continuer = true;
        }
        return continuer;
    }

    /**
     * Method for checking the victory for the dual mode
     *
     * @param tableau1Joueur the code number of the player as array of integer
     * @param tableau2Ordi   the code number purposed by the computer as array of integer
     * @param tableau1Ordi   the code number of the computer as array of integer
     * @param tableau2Joueur the code number purposed by the player as array of integer
     * @param turn           number of turn in order to find the code number
     * @param tmax           the maxi allowed turn for the player and the computer to find the code number
     * @return true if the game need to continue or false in other case (victory or defeat)
     */
    public boolean verificationVictoireDuel(int[] tableau1Joueur, int[] tableau2Ordi, int[] tableau1Ordi, int[] tableau2Joueur, int turn, int tmax) {
        boolean continuer;
        if ((Arrays.equals(tableau1Joueur, tableau2Ordi)) && ((Arrays.equals(tableau1Ordi, tableau2Joueur)) && (turn < tmax))) {
            continuer = false;
            System.out.println("Egalité parfaite entre le JOUEUR et L'ORDINATEUR");
        } else if ((Arrays.equals(tableau1Joueur, tableau2Ordi)) && !((Arrays.equals(tableau1Ordi, tableau2Joueur)) && (turn < tmax))) {
            System.out.println("Défaite du JOUEUR et victoire de L'ORDINATEUR");
            AffichageSolutionsNumeriques(tableau1Joueur, tableau1Ordi, turn);
            continuer = false;
        } else if (!(Arrays.equals(tableau1Joueur, tableau2Ordi)) && ((Arrays.equals(tableau1Ordi, tableau2Joueur)) && (turn < tmax))) {
            System.out.println("Victoire du JOUEUR et défaite de L'ORDINATEUR");
            AffichageSolutionsNumeriques(tableau1Joueur, tableau1Ordi, turn);
            continuer = false;
        } else if (turn == tmax) {
            System.out.println("Défaite du JOUEUR et de L'ORDINATEUR");
            AffichageSolutionsNumeriques(tableau1Joueur, tableau1Ordi, turn);
            continuer = false;
        } else {
            System.out.println("Le JOUEUR et l'ORDINATEUR  ont encore " + (tmax - turn) + " tentative(s) pour trouver le code secret.\n");
            continuer = true;
        }
        return continuer;
    }

    /**
     * Method for display solutions
     *
     * @param tableau1 code number of the player as array of integer
     * @param tableau2 code number of the computer as array of integer
     */
    public void AffichageSolutionsNumeriques(int[] tableau1, int[] tableau2, int turn) {
        String liaisonTableau1 = Arrays.stream(tableau1).mapToObj(String::valueOf).collect(Collectors.joining(""));
        String liaisonTableau2 = Arrays.stream(tableau2).mapToObj(String::valueOf).collect(Collectors.joining(""));
        System.out.println("les solutions étaient : ");
        System.out.println("Le code " + liaisonTableau1 + " pour le JOUEUR"+"\nLe code " + liaisonTableau2 + " pour l'ORDINATEUR");
        System.out.println("Le nombre de tours effectués: " + turn);
    }

    /**
     * Method to check if the player has won or no for the Mastermind game
     *
     * @param tableau1 the code secret numbers that the player has to find
     * @param tableau2 the code secret numbers purposed by the player
     * @param turn     number of turn that the player takes
     * @param tmax     maxi number of allowed turns in order to find all code secret numbers
     * @return true if the game need to continue or false in other case (victory or defeat)
     */
    public boolean verificationVictoireMaster(int[] tableau1, int[] tableau2, int turn, int tmax) {
        boolean continuer;
        if ((Arrays.equals(tableau1, tableau2)) && (turn < tmax)) {
            continuer = false;
            victoireDuJoueur(turn);
        } else if (turn == tmax) {
            defaiteDuJoueurMaster(tableau1);
            continuer = false;
        } else {
            System.out.println("Le JOUEUR a encore " + (tmax - turn) + " tentative(s) pour trouver les couleurs du code secret.\n");
            continuer = true;
        }
        return continuer;
    }

    /**
     * Method for checking the victory for the dual mode of Mastermind game
     *
     * @param tableau1Joueur the code number of the player as array of integer
     * @param tableau2Ordi   the code number purposed by the computer as array of integer
     * @param tableau1Ordi   the code number of the computer as array of integer
     * @param tableau2Joueur the code number purposed by the player as array of integer
     * @param turn           number of turn in order to find the code number
     * @param tmax           the maxi allowed turn for the player and the computer to find the code number
     * @return true if the game need to continue or false in other case (victory or defeat)
     */
    public boolean verificationVictoireDuelMaster(int[] tableau1Joueur, int[] tableau2Ordi, int[] tableau1Ordi, int[] tableau2Joueur, int turn, int tmax, int nber) {
        boolean continuer;
        if ((Arrays.equals(tableau1Joueur, tableau2Ordi)) && ((Arrays.equals(tableau1Ordi, tableau2Joueur)) && (turn < tmax))) {
            continuer = false;
            System.out.println("Egalité parfaite entre le JOUEUR et L'ORDINATEUR");
        } else if ((Arrays.equals(tableau1Joueur, tableau2Ordi)) && !((Arrays.equals(tableau1Ordi, tableau2Joueur)) && (turn < tmax))) {
            System.out.println("Défaite du JOUEUR et victoire de L'ORDINATEUR");
            AffichageSolutionsCouleurs(tableau1Joueur, tableau1Ordi, turn, nber);
            continuer = false;
        } else if (!(Arrays.equals(tableau1Joueur, tableau2Ordi)) && ((Arrays.equals(tableau1Ordi, tableau2Joueur)) && (turn < tmax))) {
            System.out.println("Victoire du JOUEUR et défaite de L'ORDINATEUR");
            AffichageSolutionsCouleurs(tableau1Joueur, tableau1Ordi, turn, nber);
            continuer = false;
        } else if (turn == tmax) {
            System.out.println("Défaite du JOUEUR et de L'ORDINATEUR");
            AffichageSolutionsCouleurs(tableau1Joueur, tableau1Ordi, turn, nber);
            continuer = false;
        } else {
            System.out.println("Le JOUEUR et l'ORDINATEUR  ont encore " + (tmax - turn) + " tentative(s) pour trouver le code secret.\n");
            continuer = true;
        }
        return continuer;
    }

    /**
     * Method for display solutions of Colors chosen by player and Computer
     *
     * @param tableau1 code number of the player as array of integer that we will transform to String of colors
     * @param tableau2 code number of the computer as array of integer that we will transform to String of colors
     */
    public void AffichageSolutionsCouleurs(int[] tableau1, int[] tableau2, int turn, int nber) {
        String[] resultat1 = getResult().transformerNumerosEnCouleurs(tableau1, nber);
        String[] resultat2 = getResult().transformerNumerosEnCouleurs(tableau2, nber);
        String joinedresult1 = String.join(",", resultat1);
        String joinedresult2 = String.join(",", resultat2);
        System.out.println("\nles solutions étaient : ");
        System.out.println("Le code  " + joinedresult1 + "  pour le JOUEUR"+"\nLe code  " + joinedresult2 + "  pour l'ORDINATEUR");
        System.out.println("Le nombre de tours effectués: " + turn);
    }

    /**
     * Method to display keys and values of table of allowed colors
     *
     * @param colo number of allowed colors
     */
    public void afficherCouleursDisponibles(int colo) {
        for (int i = 1; i < colo + 1; i++) {
            switch (i) {
                case 1:
                    System.out.print("(" + Colors.Rouge.toString().charAt(0) + ")" + (Colors.Rouge.toString()).substring(1) + ", ");
                    break;
                case 2:
                    System.out.print("(" + (Colors.Bleu.toString()).charAt(0) + ")" + (Colors.Bleu.toString()).substring(1) + ", ");
                    break;
                case 3:
                    System.out.print("(" + (Colors.Jaune.toString()).charAt(0) + ")" + (Colors.Jaune.toString()).substring(1) + ", ");
                    break;
                case 4:
                    System.out.print("(" + (Colors.Orange.toString()).charAt(0) + ")" + (Colors.Orange.toString()).substring(1) + ", ");
                    break;
                case 5:
                    System.out.println("(" + (Colors.Vert.toString()).charAt(0) + ")" + (Colors.Vert.toString()).substring(1) + ", ");
                    break;
                case 6:
                    System.out.print("(" + (Colors.Gris.toString()).charAt(0) + ")" + (Colors.Gris.toString()).substring(1) + ", ");
                    break;
                case 7:
                    System.out.print("(" + (Colors.Turquoise.toString()).charAt(0) + ")" + (Colors.Turquoise.toString()).substring(1) + ", ");
                    break;
                case 8:
                    System.out.print("(" + (Colors.Saumon.toString()).charAt(0) + ")" + (Colors.Saumon.toString()).substring(1) + ", ");
                    break;
                case 9:
                    System.out.print("(" + (Colors.Marron.toString()).charAt(0) + ")" + (Colors.Marron.toString()).substring(1));
                    break;
            }
        }
        System.out.println("\nRentrez la lettre entre parenthèse pour sélectionner la couleur !!!");
    }

    /**
     * Method to print message for asking the code that you need to choice in order to find the secret code
     *
     * @param x number of numbers
     */
    public void afficherMessageTrouverCodeSecret(int x) {
        System.out.println(" **************** JOUEUR DOIT TROUVER LE CODE SECRET **************************************");
        System.out.println("Vous devez maintenant taper un nombre de " + x + " chiffres pour trouver le code secret");
    }

    /**
     * Method to print message for asking colors of the code that you need to choice in order to find the secret code
     *
     * @param x number of colors
     * @param y number of allowed colors
     */
    public void afficherMessageTrouverCouleursCodeSecret(int x, int y) {
        System.out.println(" ***************** JOUEUR DOIT TROUVER LES COULEURS DU CODE SECRET ************************");
        System.out.println("Vous devez maintenant sélectionner un nombre de " + x + " couleurs parmi les " + y + " couleurs disponibles ci-dessous");
    }

    /**
     * Method to print message for asking the Secret code that you need to choice
     *
     * @param x number of numbers
     */

    public void saisirLesChiffresDuCode(int x) {
        System.out.println("\n *********************** JOUEUR DEFENSEUR *****************************************************");
        System.out.println("Vous êtes le défenseur et vous devez choisir votre code secret en toute discrétion !!!");
        System.out.println("Vous devez taper un nombre de " + x + " chiffres pour votre code secret");
    }

    /**
     * Method to print message for asking colors of the Secret code that you need to choice
     *
     * @param x number of colors
     */
    public void saisirLesCouleursDuCode(int x) {
        System.out.println("\n *********************** JOUEUR DEFENSEUR *****************************************************");
        System.out.println("Vous êtes le défenseur et vous devez choisir votre code secret en toute discrétion !!!");
        System.out.println("Vous devez sélectionner un nombre de " + x + " couleurs parmi les couleurs proposées ci-dessous");
    }

    /**
     * Method to print the purposed code
     * @param Choice the choice in String
     */
    public void choixDeLaCombinaison(String Choice){
        System.out.println("Vous avez choisi la combinaison suivante: " + Choice+"\n");
    }

    /**
     * Method to print the allowed choice of games mode
     */
    public void affichageModeDeJeu(){
        System.out.println("A quel mode de jeu voulez-vous jouer? ");
        System.out.println("\n1 Mode Challenger");
        System.out.println("2 Mode Défenseur");
        System.out.println("3 Mode Duel");
    }

    /**
     * Method to print the choice that the player selected for the game mode
     * @param mode the number of the choice in integer
     */
    public void affichageChoixDuMode(int mode){
        switch (mode) {
            case 1:
                System.out.println("Vous avez choisi de jouer au Mode Challenger");
                break;
            case 2:
                System.out.println("Vous avez choisi de jouer au Mode Défenseur");
                break;
            case 3:
                System.out.println("Vous avez choisi de jouer au Mode Duel");
                break;
            default:
                System.out.println("Vous n'avez pas saisi le bon numéro pour le choix de votre jeu !!!\nRessaisissez votre choix de jeu");
                break;
        }
    }

    /**
     * Method to print the allowed choice of games
     */
    public void affichageDesJeux(){
        System.out.println("A quel jeu voulez-vous jouer? ");
        System.out.println("\n1 RECHERCHE PLUS OU MOINS ");
        System.out.println("2 MASTERMIND");
        System.out.println("3 QUITTER");
    }

    /**
     * Method to print the choice that the player selected for the game
     * @param choice the number of the choice in integer
     */
    public void affichageChoixDuJeu(int choice){
        switch (choice) {
            case 1:
                System.out.println("Vous avez choisi de jouer à RECHERCHE PLUS OU MOINS");
                break;
            case 2:
                System.out.println("Vous avez choisi de jouer à MASTERMIND");
                break;
            case 3:
                System.out.println("Vous avez choisi de quitter le jeu, au revoir !!!");
                break;
            default:
                System.out.println("Vous n'avez pas saisi le bon numéro pour le choix de votre jeu !!!\nRessaisissez votre choix de jeu");
                break;
        }
    }

    /**
     * Method to print message as soon as the number of selected characters is too many
     * @param x number of numbers
     */
    public void tropDeCaracteresChoisisChiffres(int x){
        System.out.println("vous avez choisi trop de caractères, vous ne devez saisir que " + x + " caractère(s)");
        System.out.println("retapez un nouveau code à " + x + " chiffre(s) svp !");
    }

    /**
     * Method to print message as soon as the number of selected characters is too many
     * @param x number of colors
     */
    public void tropDeCaracteresChoisisCouleurs(int x){
        System.out.println(" vous avez choisi trop de caractères, vous ne devez saisir que " + x + " caractère(s)");
        System.out.println("retapez un nouveau code à " + x + " couleur(s) svp !");
    }

    /**
     * Method to print message as soon as the number of selected characters is not enough
     * @param x number of numbers
     */
    public void pasAssezDeCaracteresChoisisChiffres(int x){
        System.out.println("vous n'avez pas choisi assez de caractères, vous devez saisir " + x + " caractère(s)");
        System.out.println("retapez un nouveau code à " + x + " chiffre(s) svp !");
    }

    /**
     * Method to print message as soon as the number of selected characters is not enough
     * @param x number of colors
     */
    public void pasAssezDeCaracteresChoisisCouleurs(int x){
        System.out.println(" vous n'avez pas choisi assez de caractères, vous devez saisir " + x + " caractère(s)");
        System.out.println("retapez " + x + " couleurs(s) svp !");
    }


    //Getters
    public int getNber() {
        return nber;
    }

    public Combinaison getResult() {
        return Result;
    }

}

