package ch.heig.poo.labo6.école;

import java.util.ArrayList;
import java.util.Arrays;

public class Groupe {
    //Attributs
    private int numéro;
    private String orientation;
    private int trimestre;

    private ArrayList<Etudiant> étudiants;

    private ArrayList<Leçon> leçons;

    //Méthodes
    public Groupe(int numéro, String orientation, int trimestre){
        this.numéro = numéro;
        this.orientation = orientation;
        this.trimestre = trimestre;
    }

    void ajouterLeçon(Leçon leçon){
        leçons.add(leçon);
    }

    void ajouterEtudiant(Etudiant étudiant){
        étudiants.add(étudiant);
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

}
