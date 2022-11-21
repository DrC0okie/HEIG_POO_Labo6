package ch.heig.poo.labo6.école;

import java.util.ArrayList;

/**
 * La classe Professeur est une sous-classe de Personne qui contient une abréviation et une liste de leçons données.
 *
 * @author Kevin Farine, Timothée Von Hove
 */
public class Professeur extends Personne{
    //Attributs
    private String abreviation;
    private ArrayList<Leçon> leçons = new ArrayList<Leçon>();

    //Méthodes

    /**
     * Construit un objet de classe Professeur en fournissant un nom, un prénom et une abréviation.
     * @param nom
     * @param prénom
     * @param abreviation
     */
    public Professeur(String nom, String prénom, String abreviation){
        super(nom, prénom);
        this.abreviation = abreviation;
    }

    /**
     * Constructeur prenant les informations basiques, l'abréviation et une liste de leçons enseignées.
     * @param nom
     * @param prénom
     * @param abreviation
     * @param leçons
     */
    public Professeur(String nom, String prénom, String abreviation, ArrayList<Leçon> leçons){
        this(nom, prénom, abreviation);
        this.leçons = leçons;
    }

    /**
     * Ajoute une leçon à la liste de leçons enseignées.
     * @param leçon leçon ajouté à la liste
     */
    void addLeçon(Leçon leçon){
        leçons.add(leçon);
    }

    /**
     * Récupère l'abréviation du professeur
     * @return Retourne l'abréviation du professeur en chaîne de caractères
     */
    public String abreviation(){
        return abreviation;
    }

    /**
     * Convertit et retourne les informations liées au professeur en chaîne de caractères.
     * @return Retourne les informations liées au professeur.
     */
    public String toString(){
        return super.toString() + ", Abreviation : " + abreviation;
    }

    /**
     * Fournit la grille horaire du professeur en se basant sur les cours enseignés
     * @return Retourne une chaîne de caractères de la grille horaire
     */
    public String horaire(){
        return "-- Horaire Prof. " + getPrénom() + " " + getNom() + "(" + abreviation + ")\n" + Leçon.horaire(leçons);
    }
}
