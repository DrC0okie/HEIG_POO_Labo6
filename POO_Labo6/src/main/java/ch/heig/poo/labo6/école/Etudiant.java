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
    public Etudiant(String nom, String prénom, int matricule){
        super(nom, prénom);
        this.matricule = matricule;
    }

    public Etudiant(String nom, String prénom, int matricule, Groupe groupe){
        this(nom, prénom, matricule);
        this.groupe = groupe;
    }

    void setGroupe(Groupe groupe){
        this.groupe = groupe;
    }

    public String toString(){
        return super.toString() + ", Matricule : " + matricule;
    }
}
