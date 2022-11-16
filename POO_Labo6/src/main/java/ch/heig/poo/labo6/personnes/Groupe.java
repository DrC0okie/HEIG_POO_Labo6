package ch.heig.poo.labo6.personnes;

import ch.heig.poo.labo6.leçon.Leçon;

import java.util.ArrayList;

public class Groupe {
    //Attributs
    private int numéro;
    private String orientation;
    private int trimestre;

    //Méthodes
    public Groupe(int unNuméro, String uneOrientation, int unTrimestre){
        numéro = unNuméro;
        orientation = uneOrientation;
        trimestre = unTrimestre;
        ArrayList<Etudiant> Etudiants; //ArrayList à redéfinir
        ArrayList<Leçon> Leçons; //Pareil, à redéfinir
    }

    public String horaire(){
        return "";
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
