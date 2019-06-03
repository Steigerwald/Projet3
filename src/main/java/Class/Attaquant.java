package main.java.Class;


public class Attaquant extends Joueur {

    private Joueur joueur = new Joueur();
    private Affichage tableCouleurs = new Affichage();
    private Combinaison reponse= new Combinaison();
    private String rep2;

    //Getters
    public Joueur getJoueur() {
        return joueur;
    }

    public Affichage getTableCouleurs() {
        return tableCouleurs;
    }

    public Combinaison getReponse() {
       return reponse;
    }

    public String getRep2() {
        return rep2;
    }

    //Setters
    public void setRep2(String rep2) {
        this.rep2 = rep2;
    }


    /**
     * Method for the attacker in order to suggest code numbers
     * @param x number of numbers
     * @return the answer of the attacker as string
     */
    public String proposer(int x){
        boolean problem;
        System.out.println(" **************** JOUEUR DOIT TROUVER LE CODE SECRET **************************************");
        System.out.println("Vous devez maintenant taper un nombre de " + x + " chiffres pour trouver le code secret");
        do {
            setRep2(sc.nextLine());
            problem=getJoueur().verificationFormatCodeSecret(getRep2(),x);
        } while (problem);
        return getRep2();
    }

    /**
     * Method to display the result for the attacker in the Mastermind game
     * @param x number of cases
     * @param y number of colors
     * @return the answer of the attacker, the purposed code colors
     */
    public int [] proposerCodeMaster(int x,int y){
        boolean problem;
        int [] tab;
        System.out.println(" ***************** JOUEUR DOIT TROUVER LES COULEURS DU CODE SECRET ************************");
        System.out.println("Vous devez maintenant sélectionner un nombre de " +x+ " couleurs parmi les "+y+" couleurs disponibles ci-dessous");
        getTableCouleurs().afficherCouleursDisponibles(y);
        do {
            setRep2(sc.nextLine());
            problem=getJoueur().verificationFormatCodeSecretMaster(getRep2(),x,y);

        } while (problem);
            tab=getReponse().transformerPremieresLettresEnNumero(getRep2(),x);
            //System.out.println(Arrays.toString(tab));
        return tab;
    }

}
