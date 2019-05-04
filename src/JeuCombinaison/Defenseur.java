package JeuCombinaison;

public class Defenseur extends Joueur {
    Joueur joueur = new Joueur();
    Colors tableCouleurs = new Colors();
    Combinaison Result=new Combinaison();
    int [] tabRep;
    /**
     * Method for the defender in order to choice the secret code numbers
     * @param x number of numbers
     * @return the secret code numbers as string
     */
    public String saisir(int x){
        boolean problem=true;
        System.out.println();
        System.out.println(" *********************** JOUEUR DEFENSEUR *********************************");
        System.out.println("Vous êtes le défenseur et vous devez choisir votre code secret en toute discrétion !!!");
        System.out.println("Vous devez taper un nombre de "+ x +" chiffres pour votre code secret");
        do {
            rep1=sc.nextLine();
            problem=verificationformatcodesecret(rep1,x);
        } while (problem);
        System.out.println("Vous avez choisi la combinaison suivante: "+ rep1);
        System.out.println();
        return rep1;
    }

    /**
     * Method for the defender in order to choice the secret code numbers in the Mastermind game
     * @param x number of cases
     * @param y number of allowed colors for example 4 allows 1 and 2 and 3 and 4
     * @return the secret code numbers as string
     */
    public String saisirMaster(int x,int y){
        boolean problem=true;
        System.out.println();
        System.out.println(" *********************** JOUEUR DEFENSEUR *********************************");
        System.out.println("Vous êtes le défenseur et vous devez choisir votre code secret en toute discrétion !!!");
        System.out.println("Vous devez taper un nombre de "+ x +" couleurs pour votre code secret");
        System.out.println("Les " + x + " couleurs doivent chacune être comprise entre 1 et "+ (y+1));
        tableCouleurs.setTableCouleurs();
        tableCouleurs.afficherCouleursDisponibles(y);
        do {
            rep1=sc.nextLine();
            problem=verificationformatcodesecret(rep1,x);
        } while (problem);
        tabRep = Result.decouper(rep1,x);
        String codeSecret = String.join(",",tableCouleurs.transformerNumerosEnCouleurs(tabRep,x));
        System.out.println("Vous avez choisi la combinaison suivante: "+ codeSecret);
        System.out.println();
        return rep1;
    }

}
