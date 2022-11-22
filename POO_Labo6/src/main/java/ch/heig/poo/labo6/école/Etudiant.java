package ch.heig.poo.labo6.école;

/**
 * Représente un étudiant avec un nom, prénom et un matricule. Hérite de la classe Personne
 * Date de création 17.11.2022
 *
 * @author Kevin Farine, Timothée Van Hove
 */
public class Etudiant extends Personne {

    private final int matricule;

    private Groupe groupe;

    /**
     * Constructeur prenant un nom, un prénom et un matricule
     *
     * @param nom Le nom de l'étudiant
     * @param prénom Le prénom de l'étudiant
     * @param matricule Le matricule de l'étudiant
     * @throws RuntimeException si le matricule est < 0
     */
    public Etudiant(String nom, String prénom, int matricule) {
        super(nom, prénom);
        if (matricule < 0) {
            throw new RuntimeException("Le matricule ne peut pas être < 0");
        }
        this.matricule = matricule;
    }

    /**
     * Met à jour le groupe auquel l'étudiant est associé.
     *
     * @param groupe Le groupe dans lequel l'étudiant se trouve
     */
    void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    /**
     * Convertit et retourne les informations de l'étudiant
     *
     * @return String représentant les attributs de l'étudiant
     */
    @Override
    public String toString() {
        return "Etud. " + super.toString() + " (#" + matricule + ") - " + groupe.nom();
    }
}
