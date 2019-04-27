package JeuCombinaison;


public class Main {
    public static void main(String [] args){
        Joueur premierJoueur = new Defenseur();
        Rechercheplus jeu1 = new Rechercheplus();
        Masterminnd jeu2=new Masterminnd();

        do  {
            System.out.println();
            System.out.println("============  Jeux de Logique  ===========================");
            int Menu=premierJoueur.choixdujeu();
           switch (Menu) {
               case 1:
                   jeu1.lancementJeuRecherchePlus();
                    break;
                case 2:
                    jeu2.lancementjeuMastermind();
                    break;
           }
        }
        while (premierJoueur.rejouer());

    }
}
