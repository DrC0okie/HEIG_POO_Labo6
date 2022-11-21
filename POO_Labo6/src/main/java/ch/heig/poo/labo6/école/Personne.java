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

    /**
     * Construit un objet de classe Personne en fournissant un nom et un prénom
     * @param nom Nom de la personne
     * @param prénom Prénom de la personne
     */
    public Personne(String nom, String prénom){
        this.nom = nom;
        this.prénom = prénom;
    }

    /**
     * Convertit et retourne l'objet de type Personne en chaîne de caractères
     * @return Retourne les informations relatives à la personne
     */
    public String toString(){
        return "Nom : " + nom + ", Prénom : " + prénom;
    }

    /**
     * Récupère le nom de la personne
     * @return Retourne le nom de la personne
     */
    protected String getNom(){
        return nom;
    }

    /**
     * Récupère le prénom de la personne
     * @return Retourne le prénom de la personne
     */
    protected String getPrénom(){
        return prénom;
    }
}
