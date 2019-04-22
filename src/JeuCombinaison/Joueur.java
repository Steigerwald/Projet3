package JeuCombinaison;

import java.util.Scanner;

public class Joueur {

    Scanner sc = new Scanner (System.in);
    String rep1;
    String rep2;

    /**
     * Method to get the secret code
     * @param x number of numbers
     * @return the secret code in String
     */
    public String saisir(int x){
        System.out.println();
        System.out.println(" *********************** JOUEUR **********************************");
        System.out.println("Vous devez taper un nombre de "+ x +" chiffres pour choisir votre code secret");
        rep1=sc.nextLine();
        System.out.println("Vous avez choisi la combinaison suivante: "+ rep1);
        return rep1;
    }

    /**
     * Method to give the code in order to find the secret code
     * @param x number of numbers
     * @return the purpose in String
     */
    public String proposer(int x){
        System.out.println();
        System.out.println(" *********************** JOUEUR **********************************");
        System.out.println("Vous devez maintenant taper un nombre de "+ x +" chiffres pour trouver le code secret");
        rep2=sc.nextLine();
        System.out.println("Vous avez choisi la combinaison suivante: "+ rep2);
        return rep2;
    }
    /**
     * Method to choice the game for players
     * @return the first character of the answer as integer
     */
    public int choixduModejeu(){
        System.out.println("A quel mode de jeu voulez-vous jouer? ");
        System.out.println();
        System.out.println("1 Mode Challenger");
        System.out.println("2 Mode Défenseur");
        System.out.println("3 Mode Duel");
        int choice=Integer.parseInt(Character.toString((sc.nextLine()).charAt(0)));
        return choice;
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
        do {
            System.out.println("A quel jeu voulez-vous jouer? ");
            System.out.println();
            System.out.println("1 RECHERCHE PLUS OU MOINS ");
            System.out.println("2 MASTERMIND");
            choice = Integer.parseInt(Character.toString((sc.nextLine()).charAt(0)));
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
}
