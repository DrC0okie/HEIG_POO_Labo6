package ch.heig.poo.labo6.école;

import ch.heig.poo.labo6.école.Professeur;

public class Leçon {
    //Attributs
    private String matière;
    private int jourSemaine;
    private int périodeDébut;
    private int durée;
    private String salle;
    private Professeur professeur;

    //Méthodes
    public Leçon(String matière, int jourSemaine, int périodeDébut, int durée, String salle){
        this.matière = matière;
        this.jourSemaine = jourSemaine;
        this.périodeDébut = périodeDébut;
        this.durée = durée;
        this.salle = salle;
        this.professeur = null;
    }

    void setProfesseur(Professeur professeur){
        this.professeur = professeur;
    }

    static public String horaire(Object args){
        return "";
    }
}
