package main.java.Class;


public class Defenseur extends Joueur {

    private Affichage codeSecret = new Affichage();
    private Affichage tableCouleurs = new Affichage();
    private Combinaison result = new Combinaison();

    /**
     * Method for the defender in order to choice the secret code numbers
     *
     * @param x number of numbers
     * @return the secret code numbers as string
     */
    public String saisir(int x) {
        boolean problem = true;
        getCodeSecret().saisirLesChiffresDuCode(x);
        do {
            rep1 = sc.nextLine();
            problem = verificationFormatCodeSecret(rep1, x);
        } while (problem);
        getCodeSecret().choixDeLaCombinaison(rep1);
        return rep1;
    }

    /**
     * Method for the defender in order to choice the secret code numbers in the Mastermind game
     *
     * @param x number of cases
     * @param y number of allowed colors for example 4 allows 1 and 2 and 3 and 4
     * @return the secret code numbers as string
     */
    public int[] saisirMaster(int x, int y) {
        boolean problem;
        int[] tab;
        getTableCouleurs().saisirLesCouleursDuCode(x);
        getTableCouleurs().afficherCouleursDisponibles(y);
        do {
            rep1 = sc.nextLine();
            tab = getResult().transformerPremieresLettresEnNumero(rep1, x);
            problem = verificationFormatCodeSecretMaster(rep1, x, y);
        } while (problem);
        String codeSecret = String.join(",", getResult().transformerNumerosEnCouleurs(tab, x));
        getTableCouleurs().choixDeLaCombinaison(codeSecret);
        return tab;
    }

    //Getters
    public Affichage getCodeSecret() {
        return codeSecret;
    }

    public Affichage getTableCouleurs() {
        return tableCouleurs;
    }

    public Combinaison getResult() {
        return result;
    }
}
