package JeuCombinaison;


import java.util.ArrayList;

public class Combinaison {

    /**
     * Method to separate each number and to record it in an array
     * @param rep String answer which is converted in integer
     * @param x number of numbers for secret code
     * @return the array with all numbers
     */
    public int [] decouper(String rep,int x){
        int [] tab = new int [x];
        for (int counter=0;counter< x;counter=counter+1){
            tab[counter]=Character.getNumericValue(rep.charAt(counter));
        }
        return tab;
    }
    /**
     * Method to compare each element of 2 arrays and to indicate if it is = or > or <
     * @param tab1 array of secret code
     * @param tab2 array of purposed code
     * @param x number of numbers for secret code
     * @return array with all indications for each number of secret code
     */
    public String [] comparer(int [] tab1,int [] tab2,int x){
        String [] result = new String [x];
        for (int counter=0;counter< x;counter=counter+1){
            if (tab1[counter]==tab2[counter]){
                result[counter]="=";
            } else if (tab1[counter]>tab2[counter]){
                result[counter]="-";
            } else if (tab1[counter]<tab2[counter]){
                result[counter]="+";
            }
        }
        return result;
    }

    /**
     * Method to compare 2 arrays for Mastermind game
     * @param tab1 array 1 that includes the secret code number
     * @param tab2 array 2 taht includes the purposed code number
     * @param x number of code numbers
     * @return the result of comparison "bien placé" or "présent" or ""
     */
    public ArrayList <String> comparerMaster(int [] tab1,int [] tab2,int x) {
        ArrayList<String> result = new ArrayList<String>();
        for (int counter = 0; counter < x; counter = counter + 1) {
            for (int j = 0; j < x; j++) {
                if ((tab1[j] == tab2[counter]) && (j == counter)) {
                    result.add("bien placé");
                } else if ((tab1[j] == tab2[counter]) && (j != counter)) {
                    result.add("présent");
                } else {
                    result.add("");
                }
            }
        }
        return result;
    }
    /**
     * Method to get the quantiy of String "présent" in the resultat
     * @param resultat array that includes the result of the comparison
     * @param x number of code numbers
     * @return number of time that you find "présent" in result
     */
    public int nombreChiffrePresent(ArrayList<String> resultat, int x){
        int occurence=0;
        int j=(int)Math.pow(x,2.0);
        for (int i=0;i<j;i++){
            if (resultat.get(i).equals("présent")){
                occurence = occurence +1;
            }
        }
        return occurence;
    }
    /**
     * Method to get the quantiy of String "bien placé" in the resultat
     * @param resultat array that includes the result of the comparison
     * @param x number of code numbers
     * @return number of time that you find "bien placé" in result
     */
    public int nombreChiffreBienPlace(ArrayList<String> resultat, int x){
        int occurence=0;
        int j=(int)Math.pow(x,2.0);
        for (int i=0;i<j;i++){
            if (resultat.get(i).equals("bien placé")){
                occurence = occurence +1;
            }
        }
        return occurence;
    }
}
