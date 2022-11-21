package ch.heig.poo.labo6.école;

import java.util.ArrayList;

/**
 * Représente un professeur avec un nom, prénom et une abréviation. Hérite de la classe Personne
 * @author Kevin Farine, Timothée Van Hove
 */
public class Professeur extends Personne{

    private final String abréviation;

    private final ArrayList<Leçon> leçons = new ArrayList<>();

    static final int NBRE_INITIALES = 3;

    /**
     * Constructeur prenant un nom, un prénom et une abréviation
     * @param nom
     * @param prénom
     * @param abreviation
     */
    public Professeur(String nom, String prénom, String abreviation){
        super(nom, prénom);
        this.abréviation = abreviation;
    }

    /**
     * Ajoute une leçon à la liste de leçons enseignées du professeur
     * @param leçon leçon à ajouter à la liste
     */
    void définirLeçon(Leçon leçon){
        leçons.add(leçon);
    }

    /**
     * retourne l'abréviation du professeur
     * @return L'abréviation du professeur en format String
     */
    public String abreviation(){
        return abréviation;
    }

    /**
     * Convertit et retourne les informations liées au professeur en format String
     * @return Un String représentant les informations liées au professeur
     */
    @Override
    public String toString(){
        return "Prof. " + super.toString() + " ("+ abréviation + ")";
    }

    /**
     * Fournit la grille horaire du professeur en se basant sur les cours enseignés
     * @return Un String représentant la grille horaire
     */
    public String horaire(){
        return "-- Horaire " + this + "\n" + Leçon.horaire(leçons);
    }
}
