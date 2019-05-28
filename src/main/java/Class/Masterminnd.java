package main.java.Class;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;

public class Masterminnd {
    public final Logger logger= LogManager.getLogger(Masterminnd.class);
    private int nber=4;
    private int colo=7;
    private int turn=0;
    private final int tmax=12;
    private Defenseur premierJoueur = new Defenseur();
    private Attaquant deuxiemeJoueur = new Attaquant();
    private Ordinateur ordiJoueur = new Ordinateur();
    private int [] tableau1;
    private int [] tableau2;
    private int [] tableau1Ordi;
    private int [] tableau2Ordi;
    private int [] tableau1Joueur;
    private int [] tableau2Joueur;
    private ArrayList<String> resultat1;
    private ArrayList<String> resultat2;
    private ArrayList<String> resultat;
    private Combinaison Result=new Combinaison();
    private Affichage resultJoueur=new Affichage();
    private Affichage resultOrdi=new Ordinateur();
    private boolean continuer;

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

    public ArrayList<String> getResultat1() {
        return resultat1;
    }

    public ArrayList<String> getResultat2() {
        return resultat2;
    }

    public ArrayList<String> getResultat() {
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

    //Setters
    public void setTurn(int turn) {
        this.turn = turn;
    }

    public void setTableau1(int[] tableau1) {
        this.tableau1 = tableau1;
    }

    public void setContinuer(boolean continuer) {
        this.continuer = continuer;
    }

    public void setTableau2(int[] tableau2) {
        this.tableau2 = tableau2;
    }

    public void setResultat(ArrayList<String> resultat) {
        this.resultat = resultat;
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

    public void setResultat1(ArrayList<String> resultat1) {
        this.resultat1 = resultat1;
    }

    public void setResultat2(ArrayList<String> resultat2) {
        this.resultat2 = resultat2;
    }

    /**
     * Method to launch the Mastermind game
     */
    public void lancementJeuMastermind () {
        System.out.println("========================== JEU MASTERMIND  ============================");
        System.out.println();
        int mode = getPremierJoueur().choixduModejeu();
        switch (mode) {
            case 1:
                modeChallengerMaster();
                break;
            case 2:
                modeDefenseurMaster();
                break;
            case 3:
                modeDuelMaster();
                break;
        }
    }

    /**
     * Method to launch the Challenger mode for Mastermind game
     */
    public void modeChallengerMaster(){
        System.out.println("********** Mode Challenger MASTERMIND ************");
        setTurn(0);
        setTableau1(getOrdiJoueur().saisirCodeSecretMaster(getNber(),getColo()));
        logger.debug(Arrays.toString(getTableau1()));
        setContinuer(true);
        while (isContinuer()) {
            setTableau2(getDeuxiemeJoueur().proposerCodeMaster(getNber(),getColo()));
            setResultat(getResult().comparerMaster(getTableau1(), getTableau2(), getNber()));
            setTurn(getTurn()+1);
            getResultJoueur().afficherResultatMaster(getTableau1(), getTableau2(), getResultat(), getTurn(), getTmax(), getNber());
            setContinuer(getResultJoueur().verificationVictoireMaster(getTableau1(),getTableau2(),getTurn(),getTmax()));
            System.out.println();
        }
    }

    /**
     * Method to launch the Defender mode for Mastermind game
     */
    public void modeDefenseurMaster(){
        System.out.println("********** Mode Défenseur MASTERMIND *************");
        setTurn(0);
        getResultJoueur().afficherCouleursDisponibles(getColo());
        setTableau1(getPremierJoueur().saisirMaster(getNber(),getColo()));
        setContinuer(true);
        setTableau2(getOrdiJoueur().trouverCodeSecret(getNber(),getColo()));
        logger.debug("première proposition de l'ordinateur: "+ Arrays.toString(getTableau2()));
        while (isContinuer()) {
            setResultat(getResult().comparerMaster(getTableau1(), getTableau2(), getNber()));
            setTurn(getTurn()+ 1);
            getResultOrdi().afficherResultatMaster(getTableau1(), getTableau2(), getResultat(), getTurn(), getTmax(), getNber());
            setContinuer(getResultOrdi().verificationVictoireMaster(getTableau1(),getTableau2(),getTurn(), getTmax()));
            setTableau2(getOrdiJoueur().AnalyseOrdi(getTableau1(), getTableau2(), getNber()));
            System.out.println();
        }
    }

    /**
     * Method to launch the Dual mode for Mastermind game
     */
    public void modeDuelMaster(){
        System.out.println("************* Mode Duel MASTERMIND ***************");
        setTurn(0);
        setTableau1Joueur(getPremierJoueur().saisirMaster(getNber(),getColo()));
        setTableau1Ordi(getOrdiJoueur().saisirCodeSecretMaster(getNber(),getColo()));
        logger.debug("le code secret de l'ordinateur est: "+ Arrays.toString(getTableau1Joueur()));
        logger.debug("le code proposé de l'ordinateur est: "+ Arrays.toString(getTableau1Ordi()));
        setTableau2Ordi(getOrdiJoueur().trouverCodeSecret(getNber(),getColo()));
        boolean continuer1 = true;
        while (continuer1) {
            setTableau2Joueur(getDeuxiemeJoueur().proposerCodeMaster(getNber(),getColo()));
            setResultat1(getResult().comparerMaster(getTableau1Ordi(), getTableau2Joueur(), getNber()));
            setResultat2(getResult().comparerMaster(getTableau1Joueur(), getTableau2Ordi(), getNber()));
            setTurn(getTurn()+ 1);
            getResultJoueur().afficherResultatMaster(getTableau1Ordi(), getTableau2Joueur(), getResultat1(), getTurn(), getTmax(), getNber());
            getResultOrdi().afficherResultatMaster(getTableau1Joueur(), getTableau2Ordi(), getResultat2(), getTurn(), getTmax(), getNber());
            System.out.println("========================================================================================================");
            continuer1=getResultJoueur().verificationVictoireDuelMaster(getTableau1Joueur(),getTableau2Ordi(),getTableau1Ordi(),getTableau2Joueur(),getTurn(),getTmax(),getNber());
            setTableau2Ordi(getOrdiJoueur().AnalyseOrdi(getTableau1Joueur(), getTableau2Ordi(), getNber()));
            System.out.println();
        }
    }
}
