package Classe;

import java.util.Scanner;

public class Joueur {

    Scanner sc = new Scanner (System.in);
    String rep1;
    String rep2;
    String rep;
    int mode;

    /**
     * Method to choice the game for players
     * @return the first character of the answer as integer
     */
    public int choixduModejeu(){
        boolean problem=false;
       do {
           do {
               System.out.println("A quel mode de jeu voulez-vous jouer? ");
               System.out.println();
               System.out.println("1 Mode Challenger");
               System.out.println("2 Mode Défenseur");
               System.out.println("3 Mode Duel");
               rep = (sc.nextLine());
               problem = verificationSaisieChiffre(rep);
           } while (problem);
           mode=Integer.parseInt(Character.toString(rep.charAt(0)));
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
                   System.out.println("Vous n'avez pas saisi le bon numéro pour le choix de votre jeu !!!");
                   System.out.println("Ressaisissez votre choix de jeu");
                   break;
           }
       } while (mode>3);

        return mode;
    }

    /**
     * Method in order to get O or N to play again
     * @return boolean false or true
     */
    public boolean rejouer (){
        boolean r=true;
        System.out.println("Voulez vous rejouer (O/N)?");
        String answer = sc.nextLine();
        answer = answer.toUpperCase();
        char carc = answer.charAt(0);
        if (carc == 'O') {
            r=true;
        }
        else {
            r=false;
        }
        return r;
    }

    /**
     * Method to select the game for the player
     * @return the choice of the player integer 1 or 2
     */
    public int choixdujeu(){
        int choice;
        boolean problem=false;
        do {
            do {
                System.out.println("A quel jeu voulez-vous jouer? ");
                System.out.println();
                System.out.println("1 RECHERCHE PLUS OU MOINS ");
                System.out.println("2 MASTERMIND");
                rep1=(sc.nextLine());
                problem = verificationSaisieChiffre(rep1);
            }
            while (problem);
            choice = Integer.parseInt(Character.toString(rep1.charAt(0)));
            switch (choice) {
                case 1:
                    System.out.println("Vous avez choisi de jouer à RECHERCHE PLUS OU MOINS");
                    break;
                case 2:
                    System.out.println("Vous avez choisi de jouer à MASTERMIND");
                    break;
                default:
                    System.out.println("Vous n'avez pas saisi le bon numéro pour le choix de votre jeu !!!");
                    System.out.println("Ressaisissez votre choix de jeu");
                    break;
            }
        }
        while (choice>2);
        return choice;
    }

    /**
     * Method to check the format of code secret numbers
     * @param rep the code secret numbers
     * @param x number of code numbers
     * @return true if there is a problem or false if it is ok
     */
    public static boolean verificationformatcodesecret(String rep, int x){
        boolean value=false;

        if ((rep.length()) > x) {
            System.out.println(" vous avez choisi trop de caractères, vous ne devez saisir que " + x + " caractère(s)");
            System.out.println("retapez un nouveau code à "+ x +" chiffre(s) svp !");
            value=true;
        } else if (rep.length() < x) {
            System.out.println(" vous n'avez pas choisi assez de caractères, vous devez saisir " + x + " caractère(s)");
            System.out.println("retapez un nouveau code à "+ x + " chiffre(s) svp !");
            value=true;
        } else{
            value=verificationSaisieChiffre(rep);
        }
        return value;
    }

    /**
     * Method to check the format of code secret numbers
     * @param rep the code secret numbers
     * @param x number of code numbers
     * @return true if there is a problem or false if it is ok
     */
    public static boolean verificationformatcodesecretMaster(String rep, int x){
        boolean value=false;

        if ((rep.length()) > x) {
            System.out.println(" vous avez choisi trop de caractères, vous ne devez saisir que " + x + " caractère(s)");
            System.out.println("retapez un nouveau code à "+ x +" couleur(s) svp !");
            value=true;
        } else if (rep.length() < x) {
            System.out.println(" vous n'avez pas choisi assez de caractères, vous devez saisir " + x + " caractère(s)");
            System.out.println("retapez "+ x + " couleurs(s) svp !");
            value=true;
        } else{
            value=verificationSaisieLettre(rep,x);
        }
        return value;
    }


    /**
     * Method to check the format of the purposed code numbers : is it a number?
     * @param rep1 the purposed code numbers
     * @return true if there is a problem or false if it is ok
     */
    public static boolean verificationSaisieChiffre(String rep1){
        boolean problem=false;
        try {
            Integer.parseInt(rep1);
        } catch (NumberFormatException e1) {
            System.out.println("Un des chiffres du code tapé est une lettre, le code ne doit comporter que des chiffres !!");
            System.out.println("vous devez ressaisir ce code");
            problem = true;
        }
        return problem;
    }
    /**
     * Method to check the format of the purposed code colors, is it a letter?
     * @param rep1 the purposed code colors
     * @return true if there is a problem or false if it is ok
     */
    public static boolean verificationSaisieLettre(String rep1, int x){
        boolean problem=false;
        int i=0;
        while (i<x && !problem){
                problem = Character.isDigit(rep1.charAt(i));
                if (problem) {
                    System.out.println("Un des charactères du code saisi est un chiffre ou une lettre qui ne correspond pas avec les couleurs disponibles !!");
                    System.out.println("vous devez ressaisir ce code");
                    problem=true;
                } else {
                    problem = false;
                }
                i++;
        }
        return problem;
    }




}
