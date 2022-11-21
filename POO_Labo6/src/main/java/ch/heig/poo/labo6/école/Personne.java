package ch.heig.poo.labo6.école;

/**
 * Représente une Personne comportant un nom et un prénom
 *
 * @author Kevin Farine, Timothée Van Hove
 */
public class Personne {

    private final String nom;

    private final String prénom;

    /**
     * Constructeur prenant un nom et un prénom
     * @param nom Nom de la personne
     * @param prénom Prénom de la personne
     */
    public Personne(String nom, String prénom){
        this.nom = nom;
        this.prénom = prénom;
    }

    /**
     * Convertit et retourne un String représentant les attributs d'une personne
     * @return Retourne un String représentant les attributs d'une personne
     */
    @Override
    public String toString(){
        return prénom + " " + nom;
    }
}
