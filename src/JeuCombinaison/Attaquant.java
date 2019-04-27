package JeuCombinaison;

public class Attaquant extends Joueur {

    /**
     * Method for the attacker in order to suggest code numbers
     * @param x number of numbers
     * @return the answer of the attacker as string
     */
    public String proposer(int x){
        boolean problem=true;

            System.out.println();
            System.out.println(" *********************** JOUEUR ATTAQUANT **********************************");
            System.out.println(" Le joueur attaquant doit trouver le code secret !!!");
            System.out.println("Vous devez maintenant taper un nombre de " + x + " chiffres pour trouver le code secret");
        do {
            rep2 = sc.nextLine();
            problem=verificationformatcodesecret(rep2,x);

        } while (problem);

        return rep2;
    }
}
