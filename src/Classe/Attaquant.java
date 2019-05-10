package Classe;


public class Attaquant extends Joueur {
    Joueur joueur = new Joueur();
    Affichage tableCouleurs = new Affichage();
    Combinaison reponse= new Combinaison();
    /**
     * Method for the attacker in order to suggest code numbers
     * @param x number of numbers
     * @return the answer of the attacker as string
     */
    public String proposer(int x){
        boolean problem=true;
        System.out.println();
        System.out.println(" *********************** JOUEUR ATTAQUANT QUI DOIT TROUVER LE CODE SECRET **********************************");
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
    public int [] proposerCodeMaster(int x,int y){
        boolean problem=true;
        int [] tab=new int[x];
        System.out.println();
        System.out.println(" *********************** JOUEUR ATTAQUANT QUI DOIT TROUVER LE CODE SECRET **********************************");
        System.out.println("Vous devez maintenant sélectionner un nombre de " + x + " couleurs parmi les "+y+" couleurs disponibles ci-dessous");
        tableCouleurs.afficherCouleursDisponibles(y);
        do {
            rep2 = sc.nextLine();
            tab=reponse.transformerPremieresLettresEnNumero(rep2,x);
            problem=verificationformatcodesecretMaster(rep2,x);
        } while (problem);
        return tab;
    }

}
