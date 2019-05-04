package JeuCombinaison;


import java.util.HashMap;

public class Colors {

    public HashMap<Integer, String> tableCouleurs =new HashMap<Integer,String>();

    /**
     * Method to set the table of allowed colors
     */
    public void setTableCouleurs(){
        tableCouleurs.put (1,"Rouge");
        tableCouleurs.put (2,"Bleu");
        tableCouleurs.put (3,"Jaune");
        tableCouleurs.put (4,"Orange");
        tableCouleurs.put (5,"Vert");
        tableCouleurs.put (6,"Violet");
        tableCouleurs.put (7,"Bleu ciel");
        tableCouleurs.put (8,"Rose");
        tableCouleurs.put (9,"Marron");
    }

    /**
     * Method to display keys and values of table of allowed colors
     * @param colo number of allowed colors
     */
    public void afficherCouleursDisponibles(int colo){

        System.out.println("Les numéros pour choisir les couleurs disponibles sont listés ci-dessous: ");
        for (int i=1;i<(colo+2); i++){
            System.out.println("*** N° " + i + " pour la couleur " + tableCouleurs.get(i));
        }
    }

    /**
     * Method to transform arrai of integer in array of string (allowed colors)
     * @param tab1 table of colors from array of integer
     * @param x number of cases of the array
     * @return the table of colors
     */
    public String [] transformerNumerosEnCouleurs(int[] tab1, int x) {
        String[] tab2=new String[x];
        for (int i = 0; i < x; i++) {
        tab2[i]=tableCouleurs.get(tab1[i]);
        }
        return tab2;
    }
}
