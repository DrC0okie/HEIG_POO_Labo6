package ch.heig.poo.labo6.école;

public class Etudiant extends Personne{
    //Attributs
    private int matricule;
    private Groupe groupe;

    //Méthodes
    public Etudiant(String nom, String prénom, int matricule){
        super(nom, prénom);
        this.matricule = matricule;
    }

    public String toString(){
        return super.toString() + ", Matricule : " + matricule;
    }
}
