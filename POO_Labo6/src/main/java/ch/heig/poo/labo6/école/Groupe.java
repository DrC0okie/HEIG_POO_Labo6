package ch.heig.poo.labo6.école;

import java.util.ArrayList;

public class Groupe {
    //Attributs
    private int numéro;
    private String orientation;
    private int trimestre;

    //Méthodes
    public Groupe(int numéro, String orientation, int trimestre){
        this.numéro = numéro;
        this.orientation = orientation;
        this.trimestre = trimestre;
        ArrayList<Etudiant> Etudiants; //ArrayList à redéfinir
        ArrayList<Leçon> Leçons; //Pareil, à redéfinir
    }

    public String horaire(){
        return "-- Horaire du groupe " + nom() + " (" + nombreEtudiants() + " etudiants)";
    }

    public String nom(){
        return orientation + trimestre + "-" + numéro; //Demandé et confirmé par RRH
    }

    public int nombreEtudiants(){
        return 0; //retourner la longueur de la liste
    }

    public void définirLeçons(Object args){

    }
}
