package ch.heig.poo.labo6.école;

import java.util.ArrayList;

public class Professeur extends Personne{
    //Attributs
    private String abreviation;
    private ArrayList<Leçon> leçons;

    //Méthodes
    public Professeur(String nom, String prénom, String abreviation){
        super(nom, prénom);
        this.abreviation = abreviation;
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
