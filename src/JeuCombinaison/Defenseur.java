package JeuCombinaison;

public class Defenseur extends Joueur {

    /**
     * Method for the defender in order to choice the secret code numbers
     * @param x number of numbers
     * @return the secret code numbers as string
     */
    public String saisir(int x){
        System.out.println();
        System.out.println(" *********************** JOUEUR DEFENSEUR *********************************");
        System.out.println("Vous êtes le défenseur et vous devez choisir votre code secret en toute discrétion !!!");
        System.out.println("Vous devez taper un nombre de "+ x +" chiffres pour votre code secret");
        rep1=sc.nextLine();
        System.out.println("Vous avez choisi la combinaison suivante: "+ rep1);
        System.out.println();
        return rep1;
    }
}
