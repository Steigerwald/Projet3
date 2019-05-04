package JeuCombinaison;

public class Main {
    public static void main(String [] args){
        Joueur premierJoueur = new Defenseur();
        Rechercheplus jeu1 = new Rechercheplus();
        Masterminnd jeu2=new Masterminnd();
        int menu;
        do  {
            System.out.println();
            System.out.println("============  Jeux de Logique  ===========================");
            menu=premierJoueur.choixdujeu();
           switch (menu) {
               case 1:
                   jeu1.lancementJeuRecherchePlus();
                    break;
                case 2:
                    jeu2.lancementJeuMastermind();
                    break;
           }
        }
        while (premierJoueur.rejouer());

    }
}
