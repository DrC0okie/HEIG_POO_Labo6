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
     * Construit un objet de classe Professeur en fournissant un nom, un prénom et une abréviation.
     * @param nom
     * @param prénom
     * @param abreviation
     */
    public Professeur(String nom, String prénom, String abreviation){
        super(nom, prénom);
        this.abréviation = abreviation;
    }

    /**
     * Ajoute une leçon à la liste de leçons enseignées.
     * @param leçon leçon ajouté à la liste
     */
    void définirLeçon(Leçon leçon){
        leçons.add(leçon);
    }

    /**
     * Récupère l'abréviation du professeur
     * @return Retourne l'abréviation du professeur en chaîne de caractères
     */
    public String abreviation(){
        return abréviation;
    }

    /**
     * Convertit et retourne les informations liées au professeur en chaîne de caractères.
     * @return Retourne les informations liées au professeur.
     */
    @Override
    public String toString(){
        return "Prof. " + super.toString() + " ("+ abréviation + ")";
    }

    /**
     * Fournit la grille horaire du professeur en se basant sur les cours enseignés
     * @return Retourne une chaîne de caractères de la grille horaire
     */
    public String horaire(){
        return "-- Horaire " + this + "\n" + Leçon.horaire(leçons);
    }
}
