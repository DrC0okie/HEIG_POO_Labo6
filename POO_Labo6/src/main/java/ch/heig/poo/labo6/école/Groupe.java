package ch.heig.poo.labo6.école;

import java.util.ArrayList;

/**
 * La classe Groupe regroupe un ensemble d'étudiants sous un nom de groupe composé d'une orientation, d'un trimestre et
 * enfin d'un numéro.
 *
 * @author Kevin Farine, Timothée Von Hove
 */
public class Groupe {
    //Attributs
    private int numéro;
    private String orientation;
    private int trimestre;

    private ArrayList<Etudiant> étudiants;

    private ArrayList<Leçon> leçons;

    //Méthodes

    /**
     * Construit un objet de classe Groupe en fournissant un numéro, une orientation et un trimestre
     * @param numéro Le numéro de groupe
     * @param orientation L'orientation (filiaire) du groupe
     * @param trimestre Le trimestre auquel il participe
     */
    public Groupe(int numéro, String orientation, int trimestre, ArrayList<Etudiant> étudiants){
        this.numéro = numéro;
        this.orientation = orientation;
        this.trimestre = trimestre;
        this.étudiants = étudiants;
        for(Etudiant étudiant : étudiants){
            étudiant.setGroupe(this);
        }
    }

    /**
     * Ajoute une leçon à la liste de leçons du groupe
     * @param leçons La leçon à ajouter
     */
    public void définirLeçons(ArrayList<Leçon> leçons){
        this.leçons = leçons;
    }

    /**
     * Fournit la grille horaire du groupe en se basant sur les cours suivis.
     * @return Retourne une chaîne de caractères de la grille horaire du groupe
     */
    public String horaire(){
        return "-- Horaire du groupe " + nom() + " (" + nombreEtudiants() + " etudiants)\n" +
                Leçon.horaire(leçons);
    }

    /**
     * Récupère le nom du groupe formé à partir de l'orientation, du trimestre et du numéro
     * @return Retourne en chaîne de caractère, le nom du groupe
     */
    public String nom(){
        return orientation + trimestre + "-" + numéro; //Demandé et confirmé par RRH
    }

    /**
     * Récupère le nombre d'étudiants faisant partis du groupe
     * @return Le nombre d'étudiants
     */
    public int nombreEtudiants(){
        return étudiants.size(); //retourner la longueur de la liste
    }

}
