package JeuCombinaison;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Affichage {

    /**
     * Method to print the result and see if the player has win for the game Rechercheplus
     * @param tableau1 the secret code number
     * @param tableau2 the code numbers of the attacker
     * @param resultat the result of the comparison between the secret number and the attacker 's code numbers
     * @param turn number of current turn
     * @param tmax number of allowed turn in order to find the secret code numbers
     * @param nber number of code numbers
     * @return true or false in order to continue
     */

    public boolean afficherResultat(int[] tableau1,int[] tableau2,String [] resultat,int turn, int tmax,int nber){
        String [] atrouver=new String [nber];
        for (int i=0;i<nber;i++) {
            atrouver[i] = "=";
        }
        String joinedResult = String.join("",resultat);
        String joinedarray2 = Arrays.stream(tableau2).mapToObj(String::valueOf).collect(Collectors.joining(""));
        System.out.println(" *********************** RESULTAT DU JOUEUR ******************************************");
        System.out.println("Proposition: "+ joinedarray2 +"   réponse: "+ joinedResult);
        boolean continuer;
        if ((Arrays.equals(resultat,atrouver))&&(turn<tmax)) {
            continuer = false;
            System.out.println();
            System.out.println("******************** FELICIATIONS *************************************************");
            System.out.println("Bravo! vous  avez trouvé le code secret en " +turn+" tour(s)!!");
        } else if (turn==tmax){
            System.out.println();
            System.out.println("******************** PERDU ********************************************************");
            System.out.println(" Malheureusement, vous avez perdu, le nombre de tentatives autorisées est dépassé !");
            String joinedarray1 = Arrays.stream(tableau1).mapToObj(String::valueOf).collect(Collectors.joining(""));
            System.out.println("La solution était: "+ joinedarray1);
            continuer = false;
        } else {
            System.out.println("Il reste "+ (tmax-turn) + " tentative(s) pour trouver le code secret");
            continuer=true;
        }
        return continuer;
    }

    /**
     * Method to print the result and see if the player has win for the game Mastermind
     * @param tableau1 the secret code number
     * @param tableau2 the code numbers of the attacker
     * @param resultat the result of the comparison between the secret number and the attacker 's code numbers
     * @param turn number of current turn
     * @param tmax number of allowed turn in order to find the secret code numbers
     * @param nber number of code numbers
     * @return true or false in order to continue
     */
    public boolean afficherResultatMaster(int[] tableau1,int[] tableau2,String [] resultat,int turn, int tmax,int nber){
        Combinaison cpresent=new Combinaison();
        Combinaison cbienplace=new Combinaison();
        int present= cpresent.nombreChiffrePresent(resultat,nber);
        int bienplace=cbienplace.nombreChiffreBienPlace(resultat,nber);
        String joinedarray2 = Arrays.stream(tableau2).mapToObj(String::valueOf).collect(Collectors.joining(""));
        System.out.println(" *********************** RESULTAT DU JOUEUR ********************************");
        System.out.println("Proposition: "+ joinedarray2 +"   réponse: "+" bien placé(s):"+bienplace + "  présent(s):"+present);
        boolean continuer;
        if ((Arrays.equals(tableau1,tableau2))&&(turn<tmax)) {
            continuer = false;
            System.out.println();
            System.out.println("******************** FELICIATIONS ****************************************");
            System.out.println("Bravo! vous  avez trouvé le code secret en " +turn+" tour(s)!!");
        } else if (turn==tmax){
            System.out.println();
            System.out.println("******************** PERDU ************************************************");
            System.out.println(" Malheureusement, vous avez perdu, le nombre de tentatives autorisées est dépassé !");
            String joinedarray1 = Arrays.stream(tableau1).mapToObj(String::valueOf).collect(Collectors.joining(""));
            System.out.println("La solution était: "+ joinedarray1);
            continuer = false;
        } else {
            System.out.println("Il reste "+ (tmax-turn) + " tentative(s) pour trouver le code secret");
            continuer=true;
        }
        return continuer;
    }
}
