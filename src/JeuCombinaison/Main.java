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
                   System.out.println("=============== JEU DU RECHERCHE PLUS OU MOINS  ================");
                   jeu1.jeuRecherchePlus();
                    break;
                case 2:
                    System.out.println("=============== JEU MASTERMIND  ================");
                    jeu2.jeuMastermind();
                    break;
           }
        }
        while (premierJoueur.rejouer());

    }
}
