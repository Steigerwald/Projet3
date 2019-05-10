package Classe;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import Enum.Colors;

public class Affichage {

    Combinaison Result = new Combinaison();
    int nber;
    /**
     * Method to display the result and see if the player has win for the game Rechercheplus
     * @param tableau1 the secret code number
     * @param tableau2 the code numbers of the attacker
     * @param resultat the result of the comparison between the secret number and the attacker 's code numbers
     * @param turn number of current turn
     * @param tmax number of allowed turn in order to find the secret code numbers
     * @param nber number of code numbers
     */
    public void afficherResultat(int[] tableau1,int[] tableau2,String [] resultat,int turn, int tmax,int nber){
        String joinedResult = String.join("",resultat);
        String joinedarray2 = Arrays.stream(tableau2).mapToObj(String::valueOf).collect(Collectors.joining(""));
        resultatdujoueur(joinedarray2,joinedResult);
    }

    /**
     * Method to display the result and see if the player has win for the game Mastermind
     * @param tableau1 the secret code number
     * @param tableau2 the code numbers of the attacker
     * @param resultat the result of the comparison between the secret number and the attacker 's code numbers
     * @param turn number of current turn
     * @param tmax number of allowed turn in order to find the secret code numbers
     * @param nber number of code numbers
     */
    public void afficherResultatMaster(int[] tableau1, int[] tableau2, ArrayList<String> resultat, int turn, int tmax, int nber){
        Combinaison cpresent=new Combinaison();
        Combinaison cbienplace=new Combinaison();
        int present= cpresent.nombreChiffrePresent(resultat,nber);
        int bienplace=cbienplace.nombreChiffreBienPlace(resultat,nber);
        String [] tabC=Result.transformerNumerosEnCouleurs(tableau2,nber);
        String joinedarray2 = String.join(",",tabC);
        System.out.println();
        System.out.println(" *********************** RESULTAT DU JOUEUR ********************************");
        System.out.println("Proposition: "+ joinedarray2 +"   réponse: "+" bien placé(s): "+bienplace + "  présent(s): "+present);
    }

    /**
     * Method to diplay the result of the player
     * @param resultat1 purposed code secret numbers
     * @param resultat2 result + or - or =
     */
    public void resultatdujoueur(String resultat1,String resultat2){
        System.out.println();
        System.out.println(" *********************** RESULTAT DU JOUEUR ******************************************");
        System.out.println("Proposition: "+ resultat1 +"   réponse: "+ resultat2);
    }

    /**
     * Method to display the victory of the player
     * @param turn number of turn that the player use in order to find all code secret numbers
     */
    public static void victoiredujoueur(int turn) {
        System.out.println();
        System.out.println("******************** FELICIATIONS AU JOUEUR *************************************************");
        System.out.println("Bravo! vous  avez trouvé le code secret en " + turn + " tour(s)!!");
    }

    /**
     * Method to display the defeat of the player
     * @param tableau1 the code secret numbers that the player had to find
     */
    public void defaiteDuJoueur(int[] tableau1){
        System.out.println();
        System.out.println("******************** DEFAITE DU JOUEUR ************************************************");
        System.out.println(" Malheureusement, vous avez perdu, le nombre de tentatives autorisées est dépassé !");
        String joinedarray1 = Arrays.stream(tableau1).mapToObj(String::valueOf).collect(Collectors.joining(""));
        System.out.println("La solution était: "+ joinedarray1);
    }
    /**
     * Method to display the defeat of the player for the Mastermind game
     * @param tableau1 the code secret numbers that the player had to find
     */
    public void defaiteDuJoueurMaster(int[] tableau1){
        System.out.println();
        System.out.println("******************** DEFAITE DU JOUEUR ************************************************");
        System.out.println(" Malheureusement, vous avez perdu, le nombre de tentatives autorisées est dépassé !");
        String [] tabC= Result.transformerNumerosEnCouleurs(tableau1,nber);
        String joinedarray1 = String.join(",",tabC);
        System.out.println("La solution était: "+ joinedarray1);
    }

    /**
     * Method to check if the player has won or no
     * @param tableau1 the code secret numbers that the player has to find
     * @param tableau2 the code secret numbers purposed by the player
     * @param turn number of turn that the player takes
     * @param tmax maxi number of allowed turns in order to find all code secret numbers
     * @return true if the game need to continue or false in other case (victory or defeat)
     */
    public boolean verificationVictoire(int [] tableau1,int [] tableau2, int turn, int tmax){
        boolean continuer;
        if ((Arrays.equals(tableau1,tableau2))&&(turn<tmax)) {
            continuer = false;
            victoiredujoueur(turn);
        } else if (turn==tmax){
            defaiteDuJoueur(tableau1);
            continuer = false;
        } else {
            System.out.println("Il reste "+ (tmax-turn) + " tentative(s) pour trouver le code secret");
            continuer=true;
        }
        return continuer;
    }

    /**
     * Method to check if the player has won or no for the Mastermind game
     * @param tableau1 the code secret numbers that the player has to find
     * @param tableau2 the code secret numbers purposed by the player
     * @param turn number of turn that the player takes
     * @param tmax maxi number of allowed turns in order to find all code secret numbers
     * @return true if the game need to continue or false in other case (victory or defeat)
     */
    public boolean verificationVictoireMaster(int [] tableau1,int [] tableau2, int turn, int tmax){
        boolean continuer;
        if ((Arrays.equals(tableau1,tableau2))&&(turn<tmax)) {
            continuer = false;
            victoiredujoueur(turn);
        } else if (turn==tmax){
            defaiteDuJoueurMaster(tableau1);
            continuer = false;
        } else {
            System.out.println("Il reste "+ (tmax-turn) + " tentative(s) pour trouver le code secret");
            continuer=true;
        }
        return continuer;
    }

    /**
     * Method to display keys and values of table of allowed colors
     * @param colo number of allowed colors
     */
    public void afficherCouleursDisponibles(int colo){
        for (int i=1;i<colo+1;i++){
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
                    System.out.print("(" + (Colors.Orange.toString()).charAt(0) + ")" + (Colors.Orange.toString()).substring(1)+", ");
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
        System.out.println();
        System.out.println("Rentrez la lettre entre parenthèse pour sélectionner la couleur !!!");
    }

}
