package ch.heig.poo.labo6.personnes;

public class Etudiant extends Personne{
    //Attributs
    private int matricule;

    //Méthodes
    public Etudiant(String unNom, String unPrénom, int uneMatricule){
        super(unNom, unPrénom);
        matricule = uneMatricule;
    }

    public String toString(){
        return super.toString() + ", Matricule : " + matricule;
    }
}
