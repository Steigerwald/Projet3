package Classe;

public class Defenseur extends Joueur {
    Joueur joueur = new Joueur();
    Affichage tableCouleurs = new Affichage();
    Combinaison result=new Combinaison();
    Combinaison reponse=new Combinaison();
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
    public int [] saisirMaster(int x,int y){
        boolean problem=true;
        int [] tab=new int[x];
        System.out.println();
        System.out.println(" *********************** JOUEUR DEFENSEUR *********************************");
        System.out.println("Vous êtes le défenseur et vous devez choisir votre code secret en toute discrétion !!!");
        System.out.println("Vous devez sélectionner un nombre de "+ x +" couleurs parmis les couleurs proposées ci-dessous");
        tableCouleurs.afficherCouleursDisponibles(y);
        do {
            rep1=sc.nextLine();
            tab=reponse.transformerPremieresLettresEnNumero(rep1,x);
            problem=verificationformatcodesecretMaster(rep1,x);
        } while (problem);
        String codeSecret = String.join(",",result.transformerNumerosEnCouleurs(tab,x));
        System.out.println("Vous avez choisi la combinaison suivante: "+ codeSecret);
        System.out.println();
        return tab;
    }

}
