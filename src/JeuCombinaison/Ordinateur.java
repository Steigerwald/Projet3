package JeuCombinaison;


import java.util.Arrays;
import java.util.stream.Collectors;

public class Ordinateur extends Affichage {

    /**
     * Method for the computer to choice the secret code number
     * @param x number of code numbers
     * @return the secret code number
     */
    public int [] saisirCodeSecret(int x){
        System.out.println();
        System.out.println("C'est au tour de l'ordinateur: ");
        System.out.println(" *********************** L'ORDINATEUR CHOISIT UN CODE SECRET ************************************");
        System.out.println("L'ordinateur a fait son choix de " + x +" chiffres pour le code secret !!!");
        int [] tab = new int [x];
        for (int counter=0;counter<x;counter++){
            int nbreH=1+(int)(Math.random()*8);
            tab[counter]= nbreH;
        }
        return tab;
    }

    /**
     * Method for the computer to find the secret code number
     * @param x number of code numbers
     * @return the purposed code numbers
     */
    public int [] trouverCodeSecret(int x){
        System.out.println();
        System.out.println("C'est au tour de l'ordinateur: ");
        System.out.println(" *********************** L'ORDINATEUR COMMENCE A CHERCHER VOTRE CODE SECRET ******************************");
        System.out.println();
        System.out.println(" *********************** L'ORDINATEUR A FAIT SA PROPOSITION ******************************");
        int [] tab = new int [x];
        for (int counter=0;counter<x;counter++){
            int nbreH=1+(int)(Math.random()*8);
            tab[counter]= nbreH;
        }
        return tab;
    }

    /**
     * Method for the computer to analysis and compare 2 arrays in order to purpose others numbers
     * @param tab1 array of integer which includes numbers of player
     * @param tab2 array of integer which includes computer numbers
     * @param x number of code numbers
     * @return the new array of integer which includes new purposed computer numbers
     */
    public int [] AnalyseOrdi(int [] tab1,int [] tab2,int x){
        int [] newtab = new int [x];
        for (int counter=0;counter< x;counter=counter+1){
            if (tab1[counter]==tab2[counter]){
                newtab[counter]=tab2[counter];
            } else if (tab1[counter]>tab2[counter]){
                newtab[counter]=tab2[counter]+1;
            } else if (tab1[counter]<tab2[counter]){
                newtab[counter]=tab2[counter]-1;
            }
        }
        return newtab;
    }

    /**
     * Method to print result in order to inform the winner, the looser or that you must continue
     * @param tableau1 the secret code number
     * @param tableau2 the code numbers of the  computer in mode attacker
     * @param resultat the result of the comparison between the secret number and the attacker 's code numbers
     * @param turn nomber of current turn
     * @param tmax nomber of allowed turn in order to find the secret code numbers
     * @param nber number of code numbers
     * @return boolean false or true for continuer
     */
    public void afficherResultat(int[] tableau1,int[] tableau2,String [] resultat,int turn, int tmax,int nber){
        String joinedResult = String.join("",resultat);
        String joinedarray2 = Arrays.stream(tableau2).mapToObj(String::valueOf).collect(Collectors.joining(""));
        affichageOrdiPropose();
        System.out.println("Proposition: "+ joinedarray2 +"   réponse: "+ joinedResult);
    }

    public void afficherResultatMaster(int[] tableau1,int[] tableau2,String [] resultat,int turn, int tmax,int nber){
        Combinaison cpresent=new Combinaison();
        Combinaison cbienplace=new Combinaison();
        int present= cpresent.nombreChiffrePresent(resultat,nber);
        int bienplace=cbienplace.nombreChiffreBienPlace(resultat,nber);
        String joinedarray2 = Arrays.stream(tableau2).mapToObj(String::valueOf).collect(Collectors.joining(""));
        affichageOrdiPropose();
        System.out.println("Proposition: "+ joinedarray2 +"   réponse: "+ " bien placé(s):"+ bienplace + "  présent(s):"+present);

    }


    public void affichageOrdiPropose(){
        System.out.println();
        System.out.println("C'est au tour de l'ordinateur: ");
        System.out.println("*************** L'ORDINATEUR ANALYSE ET PROPOSE UN CODE **************");
        System.out.println(" *********************** RESULTAT ********************************");
    }

    public void affichageOrdiFelicitation(int turn){
        System.out.println();
        System.out.println("******************** L'ORDINATEUR A GAGNE  ****************************");
        System.out.println("Bravo a l'Ordinateur qui a trouvé le code secret en " +turn+" tour(s)!!");
    }

    public void affichageOrdiDefaite(int [] tableau1){
        System.out.println();
        System.out.println("******************** L'ORDINATEUR A PERDU ************************************");
        System.out.println(" Cet ordinateur est nul!!, le nombre de tentatives autorisées est dépassé !");
        String joinedarray1 = Arrays.stream(tableau1).mapToObj(String::valueOf).collect(Collectors.joining(""));
        System.out.println("La solution était: "+ joinedarray1);
    }
}

