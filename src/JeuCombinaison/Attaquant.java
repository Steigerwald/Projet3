package JeuCombinaison;

import java.util.HashMap;

public class Attaquant extends Joueur {
    Joueur joueur = new Joueur();
    Colors tableCouleurs = new Colors();
    /**
     * Method for the attacker in order to suggest code numbers
     * @param x number of numbers
     * @return the answer of the attacker as string
     */
    public String proposer(int x){
        boolean problem=true;
        System.out.println();
        System.out.println(" *********************** JOUEUR ATTAQUANT **********************************");
        System.out.println(" Le joueur attaquant doit trouver le code secret !!!");
        System.out.println("Vous devez maintenant taper un nombre de " + x + " chiffres pour trouver le code secret");
        do {
            rep2 = sc.nextLine();
            problem=verificationformatcodesecret(rep2,x);
        } while (problem);
        return rep2;
    }

    /**
     * Method to display the result for the attacker in the Mastermind game
     * @param x number of cases
     * @param y number of colors
     * @return the answer of the attacker, the purposed code colors
     */
    public String proposerCodeMaster(int x,int y){
        boolean problem=true;
        System.out.println();
        System.out.println(" *********************** JOUEUR ATTAQUANT **********************************");
        System.out.println(" Le joueur attaquant doit trouver les couleurs du code secret !!!");
        System.out.println("Et vous devez maintenant taper un nombre de " + x + " couleurs pour trouver le code secret");
        System.out.println("Les " + x + " couleurs doivent chacune être comprise entre 1 et "+ (y+1));
        tableCouleurs.setTableCouleurs();
        tableCouleurs.afficherCouleursDisponibles(y);
        do {
            rep2 = sc.nextLine();
            problem=verificationformatcodesecret(rep2,x);
        } while (problem);
        return rep2;
    }

}
