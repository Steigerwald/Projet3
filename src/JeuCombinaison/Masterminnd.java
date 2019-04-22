package JeuCombinaison;

public class Masterminnd {

    public void jeuMastermind () {
        int nber=4;
        int turn=0;
        final int tmax=12;
        Joueur premierJoueur = new Defenseur();
        Joueur deuxiemeJoueur = new Attaquant();
        Ordinateur ordiJoueur = new Ordinateur();
        int [] tableau1;
        int [] tableau2;
        int [] tableau1Ordi;
        int [] tableau2Ordi;
        int [] tableau1Joueur;
        int [] tableau2Joueur;
        String[] resultat1;
        String[] resultat2;
        String [] resultat;
        Combinaison Result=new Combinaison();
        Affichage resultJoueur=new Affichage();
        Affichage resultOrdi=new Ordinateur();
        boolean continuer;

        int mode = premierJoueur.choixduModejeu();
        switch (mode) {
            case 1:
                System.out.println("****** Mode Challenger **********");
                tableau1 = ordiJoueur.saisirCodeSecret(nber);
                continuer = true;
                while (continuer) {
                    String codeProposer = deuxiemeJoueur.proposer(nber);
                    tableau2 = Result.decouper(codeProposer, nber);
                    resultat = Result.comparerMaster(tableau1, tableau2, nber);
                    turn = turn + 1;
                    continuer = resultJoueur.afficherResultatMaster(tableau1, tableau2, resultat, turn, tmax, nber);
                    System.out.println();
                }
                break;

            case 2:
                System.out.println("****** Mode Défenseur **********");
                String autreCode1 = premierJoueur.saisir(nber);
                continuer = true;
                tableau2 = ordiJoueur.trouverCodeSecret(nber);
                while (continuer) {
                    tableau1 = Result.decouper(autreCode1, nber);
                    resultat = Result.comparerMaster(tableau1, tableau2, nber);
                    turn = turn + 1;
                    continuer = resultOrdi.afficherResultatMaster(tableau1, tableau2, resultat, turn, tmax, nber);
                    tableau2 = ordiJoueur.AnalyseOrdi(tableau1, tableau2, nber);
                    System.out.println();
                }
                break;

            case 3:
                System.out.println("****** Mode Duel **********");
                String autreCode2 = premierJoueur.saisir(nber);
                tableau1Ordi = ordiJoueur.saisirCodeSecret(nber);
                tableau2Ordi = ordiJoueur.trouverCodeSecret(nber);
                boolean continuer1 = true;
                boolean continuer2 = true;
                while (continuer1 && continuer2) {
                    String codeProposer = deuxiemeJoueur.proposer(nber);
                    tableau1Joueur = Result.decouper(autreCode2, nber);
                    tableau2Joueur = Result.decouper(codeProposer, nber);
                    resultat1 = Result.comparerMaster(tableau1Ordi, tableau2Joueur, nber);
                    resultat2 = Result.comparerMaster(tableau1Joueur, tableau2Ordi, nber);
                    turn = turn + 1;
                    continuer2 = resultJoueur.afficherResultatMaster(tableau1Ordi, tableau2Joueur, resultat1, turn, tmax, nber);
                    System.out.println();
                    continuer1 = resultOrdi.afficherResultatMaster(tableau1Joueur, tableau2Ordi, resultat2, turn, tmax, nber);
                    System.out.println();
                    tableau2Ordi = ordiJoueur.AnalyseOrdi(tableau1Joueur, tableau2Ordi, nber);
                    System.out.println();
                }
                break;
        }
    }


}
