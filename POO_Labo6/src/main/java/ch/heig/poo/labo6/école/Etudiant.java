package ch.heig.poo.labo6.école;

/**
 * La classe Etudiant est une sous-classe de Personne et contient le matricule et le groupe associé en plus
 *
 * @author Kevin Farine, Timothée Van Hove
 */
public class Etudiant extends Personne{

    private final int matricule;

    private Groupe groupe = null;

    /**
     * Constructeur prenant un nom, un prénom et un matricule
     * @param nom Le nom de l'étudiant
     * @param prénom Le prénom de l'étudiant
     * @param matricule Le matricule de l'étudiant
     */
    public Etudiant(String nom, String prénom, int matricule){
        super(nom, prénom);
        this.matricule = matricule;
    }

    /**
     * Met à jour le groupe auquel l'étudiant est associé.
     * @param groupe Le groupe dans lequel l'étudiant se trouve
     */
    void setGroupe(Groupe groupe){
        this.groupe = groupe;
    }

    /**
     * Convertit et retourne les informations de l'étudiant
     * @return String représentant les attributs de l'étudiant
     */
    @Override
    public String toString(){
        return "Etud. " + super.toString() + " (#" + matricule + ") - " + groupe.nom();
    }
}
