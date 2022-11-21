package ch.heig.poo.labo6.école;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Représente un Groupe d'étudiants avec un nom de groupe, une orientation, d'un trimestre et un
 * numéro.
 * @author Kevin Farine, Timothée Van Hove
 */
public class Groupe {

    private final int numéro;

    private final String orientation;

    private final int trimestre;

    private final ArrayList<Etudiant> étudiants;

    private ArrayList<Leçon> leçons;

    /**
     * Constructeur prenant un numéro, une orientation et un trimestre
     * @param numéro Le numéro de groupe
     * @param orientation L'orientation (filière) du groupe
     * @param trimestre Le trimestre auquel il participe
     */
    public Groupe(int numéro, String orientation, int trimestre, Collection<Etudiant> étudiants){
        this.numéro = numéro;
        this.orientation = orientation;
        this.trimestre = trimestre;
        this.étudiants = new ArrayList<>();
        this.étudiants.addAll(étudiants);
        for(Etudiant étudiant : étudiants){
            étudiant.setGroupe(this);
        }
    }

    /**
     * Ajoute une leçon à la liste de leçons du groupe
     * @param leçons La liste de leçons à ajouter
     */
    public void définirLeçons(Collection<Leçon> leçons){
        if(this.leçons == null){
            this.leçons = new ArrayList<>();
        }
        this.leçons.addAll(leçons);
    }

    /**
     * Fournit la grille horaire du groupe en se basant sur les cours suivis.
     * @return Retourne une chaîne de caractères de la grille horaire du groupe
     */
    public String horaire(){
        return "-- Horaire du groupe " + nom() + " (" + nombreEtudiants() + " étudiants)\n" +
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
        return étudiants.size();
    }

}
