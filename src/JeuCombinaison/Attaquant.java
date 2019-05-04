package JeuCombinaison;

public class Attaquant extends Joueur {
    Joueur joueur = new Joueur();
    /**
     * Method for the attacker in order to suggest code numbers
     * @param x number of numbers
     * @param y number of allowed numbers for example 4 allows 1 and 2 and 3 and 4
     * @return the answer of the attacker as string
     */
    public String proposer(int x,int y,int menu){
        boolean problem=true;
        System.out.println();
        System.out.println(" *********************** JOUEUR ATTAQUANT **********************************");
        System.out.println(" Le joueur attaquant doit trouver le code secret !!!");
        System.out.println("Vous devez maintenant taper un nombre de " + x + " chiffres pour trouver le code secret");
        if (menu==2){
        System.out.println("Les " + x + " chiffres doivent chacun être compris entre 1 et "+ (y+1));
        }
        do {
            rep2 = sc.nextLine();
            problem=verificationformatcodesecret(rep2,x);
        } while (problem);
        return rep2;
    }
}
