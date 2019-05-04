package JeuCombinaison;

import java.util.Arrays;

public class Rechercheplus {
    int nber=4;
    int colo=8;
    int turn=0;
    final int tmax=12;
    Defenseur premierJoueur = new Defenseur();
    Attaquant deuxiemeJoueur = new Attaquant();
    Ordinateur ordiJoueur = new Ordinateur();
    int [] tableau1;
    int [] tableau2;
    int [] tableau1Ordi;
    int [] tableau2Ordi;
    int [] tableau1Joueur;
    int [] tableau2Joueur;
    int menu;
    String[] resultat1;
    String[] resultat2;
    String [] resultat;
    Combinaison Result=new Combinaison();
    Affichage resultJoueur=new Affichage();
    Affichage resultOrdi=new Ordinateur();
    boolean continuer;

    /**
     * Method to launch the Rechercheplus game
     */
    public void lancementJeuRecherchePlus() {
        System.out.println("=============== JEU DU RECHERCHE PLUS OU MOINS  ================");
        System.out.println();
        int mode = premierJoueur.choixduModejeu();
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
    public void modeChallenger(){
        System.out.println("****** Mode Challenger **********");
        tableau1 = ordiJoueur.saisirCodeSecret(nber,colo);
        System.out.println(Arrays.toString(tableau1));
        continuer = true;
        while (continuer) {
            String codeProposer = deuxiemeJoueur.proposer(nber);
            System.out.println(codeProposer);
            tableau2 = Result.decouper(codeProposer, nber);
            resultat = Result.comparer(tableau1, tableau2, nber);
            turn = turn + 1;
            resultJoueur.afficherResultat(tableau1, tableau2, resultat, turn, tmax, nber);
            continuer =resultJoueur.verificationvictoire(tableau1,tableau2,turn,tmax);
            System.out.println();
        }
    }

    /**
     * Method to launch the Défenseur mode
     */
    public void modeDefenseur(){
        System.out.println("****** Mode Défenseur **********");
        String autreCode1 = premierJoueur.saisir(nber);
        System.out.println(autreCode1);
        continuer = true;
        tableau2 = ordiJoueur.trouverCodeSecret(nber,colo);
        while (continuer) {
            tableau1 = Result.decouper(autreCode1, nber);
            resultat = Result.comparer(tableau1, tableau2, nber);
            turn = turn + 1;
            resultOrdi.afficherResultat(tableau1, tableau2, resultat, turn, tmax, nber);
            continuer =resultOrdi.verificationvictoire(tableau1,tableau2,turn,tmax);
            tableau2 = ordiJoueur.AnalyseOrdi(tableau1, tableau2, nber);
            System.out.println();
        }
    }

    /**
     * Method to launch the Duel mode
     */
    public void modeDuel(){
        System.out.println("****** Mode Duel **********");
        String autreCode2 = premierJoueur.saisir(nber);
        tableau1Ordi = ordiJoueur.saisirCodeSecret(nber,colo);
        tableau2Ordi = ordiJoueur.trouverCodeSecret(nber,colo);
        boolean continuer1 = true;
        boolean continuer2 = true;
        while (continuer1 && continuer2) {
            String codeProposer = deuxiemeJoueur.proposer(nber);
            tableau1Joueur = Result.decouper(autreCode2, nber);
            tableau2Joueur = Result.decouper(codeProposer, nber);
            resultat1 = Result.comparer(tableau1Ordi, tableau2Joueur, nber);
            resultat2 = Result.comparer(tableau1Joueur, tableau2Ordi, nber);
            turn = turn + 1;
            resultJoueur.afficherResultat(tableau1Ordi, tableau2Joueur, resultat1, turn, tmax, nber);
            System.out.println();
            continuer1=resultOrdi.verificationvictoire(tableau1Joueur,tableau2Ordi,turn,tmax);
            resultOrdi.afficherResultat(tableau1Joueur, tableau2Ordi, resultat2, turn, tmax, nber);
            System.out.println();
            continuer2=resultJoueur.verificationvictoire(tableau1Ordi,tableau2Joueur,turn,tmax);
            tableau2Ordi = ordiJoueur.AnalyseOrdi(tableau1Joueur, tableau2Ordi, nber);
            System.out.println();
        }
    }


}
