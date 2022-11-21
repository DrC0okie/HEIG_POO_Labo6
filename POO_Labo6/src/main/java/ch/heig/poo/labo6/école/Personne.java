package ch.heig.poo.labo6.école;

/**
 * La classe Personne contient les informations basiques, communes à tout le monde
 *
 * @author Kevin Farine, Timothée Van Hove
 */
public class Personne {

    private final String nom;

    private final String prénom;

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
        return prénom + " " + nom;
    }
}
