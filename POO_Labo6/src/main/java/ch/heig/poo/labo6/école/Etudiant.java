package ch.heig.poo.labo6.école;

/**
 * La classe Etudiant est une sous-classe de Personne et contient le matricule et le groupe associé en plus
 *
 * @author Kevin Farine, Timothée Von Hove
 */
public class Etudiant extends Personne{
    //Attributs
    private int matricule;
    private Groupe groupe = null;

    //Méthodes

    /**
     * Construit un objet de classe Etudiant en fournissant un nom, un prénom et un matricule
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
     * @param groupe Le groupe auquel l'étudiant en est membre
     */
    void setGroupe(Groupe groupe){
        this.groupe = groupe;
    }

    /**
     * Convertit et retourne les informations de l'étudiant en chaîne de caractères
     * @return Retourne les informations liées à l'étudiant
     */
    public String toString(){
        return super.toString() + ", Matricule : " + matricule;
    }
}
