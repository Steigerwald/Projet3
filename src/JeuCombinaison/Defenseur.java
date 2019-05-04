package JeuCombinaison;

public class Defenseur extends Joueur {
    Joueur joueur = new Joueur();
    /**
     * Method for the defender in order to choice the secret code numbers
     * @param x number of numbers
     * @param y number of allowed numbers for example 4 allows 1 and 2 and 3 and 4
     * @return the secret code numbers as string
     */
    public String saisir(int x,int y,int menu){
        boolean problem=true;
        System.out.println();
        System.out.println(" *********************** JOUEUR DEFENSEUR *********************************");
        System.out.println("Vous êtes le défenseur et vous devez choisir votre code secret en toute discrétion !!!");
        System.out.println("Vous devez taper un nombre de "+ x +" chiffres pour votre code secret");
        if (menu==2){
            System.out.println("Les " + x + " chiffres doivent chacun être compris entre 1 et "+ (y+1));
        }
        do {
            rep1=sc.nextLine();
            problem=verificationformatcodesecret(rep1,x);
        } while (problem);
        System.out.println("Vous avez choisi la combinaison suivante: "+ rep1);
        System.out.println();
        return rep1;
    }
}
