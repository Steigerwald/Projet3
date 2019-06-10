package main.java.type;

public enum Colors {
    //Objets directement construits
    Rouge(1, "Rouge"),
    Bleu(2, "Bleu"),
    Jaune(3, "Jaune"),
    Orange(4, "Orange"),
    Vert(5, "Vert"),
    Gris(6, "Gris"),
    Turquoise(7, "Turquoise"),
    Saumon(8, "Saumon"),
    Marron(9, "Marron");

    private Integer numero;
    private String couleur;

    //Constructeur
    Colors(Integer numero, String couleur) {
        this.numero = numero;
        this.couleur = couleur;
    }

    public Integer toNumero() {
        return numero;
    }

    public String toString() {
        return couleur;
    }


}