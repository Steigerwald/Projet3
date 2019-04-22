package JeuCombinaison;

public class Attaquant extends Joueur {

    /**
     * Method for the attacker in order to suggest code numbers
     * @param x number of numbers
     * @return the answer of the attacker as string
     */
    public String proposer(int x){
        boolean problem=true;
        do {
            System.out.println();
            System.out.println(" *********************** JOUEUR ATTAQUANT **********************************");
            System.out.println(" Le joueur attaquant doit trouver le code secret !!!");
            System.out.println("Vous devez maintenant taper un nombre de " + x + " chiffres pour trouver le code secret");
            rep2 = sc.nextLine();
            if ((rep2.length()) > x) {
                System.out.println(" vous avez choisi trop de chiffres, vous ne devez saisir que " + x + " chiffre(s)!!!");
                problem=true;
            } else if (rep2.length() < x) {
                System.out.println(" vous n'avez pas choisi assez de chiffre, vous devez saisir " + x + " chiffre(s)!!!");
                problem=true;
            } else{
                problem=false;
            }
            try {
                Integer.parseInt(rep2);
                } catch (NumberFormatException e1) {
                    System.out.println("Un des chiffres du code tapé est une lettre, le code ne doit comporter que de chiffres compris entre 1 et 9");
                    System.out.println("vous devez resaissir ce code");
                    problem = true;
                }
        } while (problem);

        return rep2;
    }
}
