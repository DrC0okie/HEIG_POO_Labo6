package ch.heig.poo.labo6.personnes;

import ch.heig.poo.labo6.leçon.Leçon;

import java.util.ArrayList;

public class Professeur extends Personne{
    //Attributs
    private String abreviation;
    private ArrayList<Leçon> leçons;

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
