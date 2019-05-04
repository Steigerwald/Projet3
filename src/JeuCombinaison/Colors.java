package JeuCombinaison;

public enum Colors {
    Rouge ("R"),
    Bleu ("B"),
    Vert ("V"),
    Jaune ("J"),
    Violet ("Vi"),
    Rose ("Ros"),
    Marron ("Ma"),
    Orange ("O"),
    Gris ("G"),
    Bleuciel ("Bc"),
    Blanc ("B"),
    Noir ("N");

    private String name="";

    Colors(String name) {
        this.name = name;
    }
    public String toString(){
        return name;
    }
}
