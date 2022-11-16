package ch.heig.poo.labo6.personnes;

public class Professeur extends Personne{
    //Attributs
    private String abreviation;

    //Méthodes
    public Professeur(String unNom, String unPrénom, String uneAbreviation){
        super(unNom, unPrénom);
        abreviation = uneAbreviation;
    }

    public String abréviation(){
        return abreviation;
    }

    public String toString(){
        return super.toString() + ", Abreviation : " + abreviation;
    }

    public String horaire(){
        return "";
    }
}
