package ch.heig.poo.labo6.école;

/**
 * Représente une Personne comportant un nom et un prénom
 * Date de création 17.11.2022
 *
 * @author Kevin Farine, Timothée Van Hove
 */
public class Personne {

    private final String nom;

    private final String prénom;

    /**
     * Constructeur prenant un nom et un prénom
     *
     * @param nom Le nom de famille de la personne
     * @param prénom Le prénom de la personne
     */
    public Personne(String nom, String prénom) {
        this.nom = nom;
        this.prénom = prénom;
    }

    /**
     * Convertit et retourne un String représentant les attributs d'une personne
     *
     * @return Un String représentant les attributs d'une personne
     */
    @Override
    public String toString() {
        return prénom + " " + nom;
    }
}
