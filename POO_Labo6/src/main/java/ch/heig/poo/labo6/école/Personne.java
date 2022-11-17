package ch.heig.poo.labo6.école;

public class Personne {
    //Attributs
    private String nom;
    private String prénom;

    //Méthodes
    public Personne(String nom, String prénom){
        this.nom = nom;
        this.prénom = prénom;
    }


    public String toString(){
        return "Nom : " + nom + ", Prénom : " + prénom;
    }
}
