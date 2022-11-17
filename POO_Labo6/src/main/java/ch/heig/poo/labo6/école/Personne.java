package ch.heig.poo.labo6.école;

/**
 * La classe Personne contient les informations basiques, communes à tout le monde
 *
 * @author Kevin Farine, Timothée Von Hove
 */
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

    protected String getNom(){
        return nom;
    }

    protected String getPrénom(){
        return prénom;
    }
}
