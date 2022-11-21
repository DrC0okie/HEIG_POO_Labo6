package ch.heig.poo.labo6.école;

import java.util.ArrayList;

/**
 * Représente un professeur avec un nom, prénom et une abréviation. Hérite de la classe Personne
 * @author Kevin Farine, Timothée Van Hove
 */
public class Professeur extends Personne{

    private final String abreviation;

    private final ArrayList<Leçon> leçons = new ArrayList<>();

    static final int NBRE_INITIALES = 3;

    /**
     * Constructeur prenant un nom, un prénom et une abréviation.
     * @param nom Le nom de famille du professeur
     * @param prénom Le prénom du professeur
     * @param abréviation L'acronyme du professeur (par défaut 3 caractères, modifiable)
     * @throws RuntimeException Si l'abréviation du professeur est trop longue
     */
    public Professeur(String nom, String prénom, String abréviation){
        super(nom, prénom);
        if(abréviation.length() > NBRE_INITIALES){
            throw new RuntimeException("Les initiales du professeur ne peuvent pas dépasser" +
                    NBRE_INITIALES + " caractères. Actuellement : " + abréviation.length());
        }
        this.abreviation = abréviation;
    }

    /**
     * Ajoute une leçon à la liste de leçons enseignées.
     * @param leçon La leçon à ajouter
     */
    void définirLeçon(Leçon leçon){
        leçons.add(leçon);
    }

    /**
     * Retourne l'abréviation du professeur
     * @return Un String représentant l'abréviation du Professeur
     */
    public String abréviation(){
        return abreviation;
    }

    /**
     * Convertit et retourne les informations liées au professeur sous forme de String
     * @return Un String représentant les attributs du Professeur
     */
    public String toString(){
        return "Prof. " + super.toString() + " ("+ abreviation + ")";
    }

    /**
     * Fournit la grille horaire du professeur en se basant sur les cours qu'il enseigne
     * @return Un String représentant la grille horaire hebdomadaire du Professeur
     */
    public String horaire(){
        return "-- Horaire Prof. " + getPrénom() + " " + getNom() + " (" + abreviation + ")\n" +
                Leçon.horaire(leçons);
    }
}
