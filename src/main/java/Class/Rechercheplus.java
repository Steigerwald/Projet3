package main.java.Class;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;

public class Rechercheplus {
    public final Logger logger = LogManager.getLogger(Rechercheplus.class);
    private int nber = 4;
    private int colo = 8;
    private int turn = 0;
    private final int tmax = 12;
    private Defenseur premierJoueur = new Defenseur();
    private Attaquant deuxiemeJoueur = new Attaquant();
    private Ordinateur ordiJoueur = new Ordinateur();
    private int[] tableau1;
    private int[] tableau2;
    private int[] tableau1Ordi;
    private int[] tableau2Ordi;
    private int[] tableau1Joueur;
    private int[] tableau2Joueur;
    private String[] resultat1;
    private String[] resultat2;
    String[] resultat;
    private Combinaison Result = new Combinaison();
    private Affichage resultJoueur = new Affichage();
    private Affichage resultOrdi = new Ordinateur();
    private boolean continuer;


    /**
     * Method to launch the Rechercheplus game
     */
    public void lancementJeuRecherchePlus() {
        System.out.println("====================== JEU DU RECHERCHE PLUS OU MOINS  =====================================\n");
        int mode = getPremierJoueur().choixduModejeu();
        switch (mode) {
            case 1:
                modeChallenger();
                break;
            case 2:
                modeDefenseur();
                break;
            case 3:
                modeDuel();
                break;
        }
    }

    /**
     * Method to launch the Challenger mode
     */
    public void modeChallenger() {
        System.out.println("********* Mode Challenger R+ ************");
        setTurn(0);
        setTableau1(getOrdiJoueur().saisirCodeSecret(getNber(), getColo()));
        logger.debug(Arrays.toString(getTableau1()));
        setContinuer(true);
        while (isContinuer()) {
            String codeProposer = getDeuxiemeJoueur().proposer(getNber());
            setTableau2(getResult().decouper(codeProposer, getNber()));
            setResultat(getResult().comparer(getTableau1(), getTableau2(), getNber()));
            setTurn(getTurn() + 1);
            getResultJoueur().afficherResultat(getTableau1(), getTableau2(), getResultat(), getTurn(), getTmax(), getNber());
            setContinuer(getResultJoueur().verificationVictoire(getTableau1(), getTableau2(), getTurn(), getTmax()));
            System.out.println();
        }
    }

    /**
     * Method to launch the Défenseur mode
     */
    public void modeDefenseur() {
        System.out.println("******** Mode Défenseur R+ ************");
        setTurn(0);
        String autreCode1 = getPremierJoueur().saisir(getNber());
        System.out.println(autreCode1);
        setContinuer(true);
        setTableau2(getOrdiJoueur().trouverCodeSecret(getNber(), getColo()));
        logger.debug("première proposition de l'ordinateur: " + Arrays.toString(getTableau2()));
        while (isContinuer()) {
            setTableau1(getResult().decouper(autreCode1, getNber()));
            setResultat(getResult().comparer(getTableau1(), getTableau2(), getNber()));
            setTurn(getTurn() + 1);
            getResultOrdi().afficherResultat(getTableau1(), getTableau2(), getResultat(), getTurn(), getTmax(), getNber());
            setContinuer(getResultOrdi().verificationVictoire(getTableau1(), getTableau2(), getTurn(), getTmax()));
            setTableau2(getOrdiJoueur().AnalyseOrdi(getTableau1(), getTableau2(), getNber()));
            System.out.println();
        }
    }

    /**
     * Method to launch the Duel mode
     */
    public void modeDuel() {
        System.out.println("************ Mode Duel R+ ***************");
        setTurn(0);
        String autreCode2 = getPremierJoueur().saisir(getNber());
        setTableau1Ordi(getOrdiJoueur().saisirCodeSecret(getNber(), getColo()));
        logger.debug("le code secret de l'ordinateur est: " + Arrays.toString(getTableau1Ordi()));
        setTableau2Ordi(getOrdiJoueur().trouverCodeSecret(getNber(), getColo()));
        logger.debug("le code proposé de l'ordinateur est: " + Arrays.toString(getTableau2Ordi()));
        boolean continuer1 = true;
        while (continuer1) {
            String codeProposer = getDeuxiemeJoueur().proposer(getNber());
            setTableau1Joueur(getResult().decouper(autreCode2, getNber()));
            setTableau2Joueur(getResult().decouper(codeProposer, getNber()));
            setResultat1(getResult().comparer(getTableau1Ordi(), getTableau2Joueur(), getNber()));
            setResultat2(getResult().comparer(getTableau1Joueur(), getTableau2Ordi(), getNber()));
            setTurn(getTurn() + 1);
            getResultJoueur().afficherResultat(getTableau1Ordi(), getTableau2Joueur(), getResultat1(), getTurn(), getTmax(), getNber());
            getResultOrdi().afficherResultat(getTableau1Joueur(), getTableau2Ordi(), getResultat2(), getTurn(), getTmax(), getNber());
            System.out.println("========================================================================================");
            continuer1 = getResultJoueur().verificationVictoireDuel(getTableau1Joueur(), getTableau2Ordi(), getTableau1Ordi(), getTableau2Joueur(), getTurn(), getTmax());
            setTableau2Ordi(getOrdiJoueur().AnalyseOrdi(getTableau1Joueur(), getTableau2Ordi(), getNber()));
            System.out.println();
        }
    }


    //getters
    public int getNber() {
        return nber;
    }

    public int getColo() {
        return colo;
    }

    public int getTurn() {
        return turn;
    }

    public int getTmax() {
        return tmax;
    }

    public Defenseur getPremierJoueur() {
        return premierJoueur;
    }

    public Attaquant getDeuxiemeJoueur() {
        return deuxiemeJoueur;
    }

    public Ordinateur getOrdiJoueur() {
        return ordiJoueur;
    }

    public int[] getTableau1() {
        return tableau1;
    }

    public int[] getTableau2() {
        return tableau2;
    }

    public int[] getTableau1Ordi() {
        return tableau1Ordi;
    }

    public int[] getTableau2Ordi() {
        return tableau2Ordi;
    }

    public int[] getTableau1Joueur() {
        return tableau1Joueur;
    }

    public int[] getTableau2Joueur() {
        return tableau2Joueur;
    }

    public String[] getResultat1() {
        return resultat1;
    }

    public String[] getResultat2() {
        return resultat2;
    }

    public String[] getResultat() {
        return resultat;
    }

    public Combinaison getResult() {
        return Result;
    }

    public Affichage getResultJoueur() {
        return resultJoueur;
    }

    public Affichage getResultOrdi() {
        return resultOrdi;
    }

    public boolean isContinuer() {
        return continuer;
    }

    //setters
    public void setTurn(int turn) {
        this.turn = turn;
    }

    public void setTableau1(int[] tableau1) {
        this.tableau1 = tableau1;
    }

    public void setTableau2(int[] tableau2) {
        this.tableau2 = tableau2;
    }

    public void setTableau1Ordi(int[] tableau1Ordi) {
        this.tableau1Ordi = tableau1Ordi;
    }

    public void setTableau2Ordi(int[] tableau2Ordi) {
        this.tableau2Ordi = tableau2Ordi;
    }

    public void setTableau1Joueur(int[] tableau1Joueur) {
        this.tableau1Joueur = tableau1Joueur;
    }

    public void setTableau2Joueur(int[] tableau2Joueur) {
        this.tableau2Joueur = tableau2Joueur;
    }

    public void setResultat1(String[] resultat1) {
        this.resultat1 = resultat1;
    }

    public void setResultat2(String[] resultat2) {
        this.resultat2 = resultat2;
    }

    public void setResultat(String[] resultat) {
        this.resultat = resultat;
    }

    public void setContinuer(boolean continuer) {
        this.continuer = continuer;
    }


}
