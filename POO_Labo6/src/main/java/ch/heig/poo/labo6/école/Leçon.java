package ch.heig.poo.labo6.école;

import ch.heig.poo.labo6.école.Professeur;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Leçon {
    final private static int nbJours = 5, nbHeures = 11;

    final private static String[] NOM_JOURS = {"Lun", "Mar", "Mer", "Jeu", "Ven"};

    final private static String[] NOM_HORAIRES = {"","","","","","","","","",""};
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

    Leçon[][] créerHoraire(ArrayList<Leçon> leçons){
        Leçon[][] = new Leçon[][]
    }

    static public String horaire(ArrayList<Leçon> leçons){
        return "";
    }
}
