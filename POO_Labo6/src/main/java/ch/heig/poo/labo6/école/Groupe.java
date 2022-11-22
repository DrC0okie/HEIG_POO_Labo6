package ch.heig.poo.labo6.école;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Représente un Groupe d'étudiants avec un nom de groupe, une orientation, d'un trimestre et un
 * numéro.
 * Date de création 17.11.2022
 *
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
     *
     * @param numéro Le numéro de groupe
     * @param orientation L'orientation (filière) du groupe
     * @param trimestre Le trimestre auquel il participe
     */
    public Groupe(int numéro, String orientation, int trimestre, Collection<Etudiant> étudiants) {
        this.numéro = numéro;
        this.orientation = orientation;
        this.trimestre = trimestre;
        this.étudiants = new ArrayList<>();
        this.étudiants.addAll(étudiants);
        leçons = new ArrayList<>();
        for (Etudiant étudiant : this.étudiants) {
            étudiant.setGroupe(this);
        }
    }

    /**
     * Ajoute une leçon à la liste de leçons du groupe
     *
     * @param leçons La liste de leçons à ajouter
     */
    public void définirLeçons(Collection<Leçon> leçons) {
        this.leçons.addAll(leçons);
    }

    /**
     * Retourne la grille horaire du groupe en se basant sur les cours suivis.
     *
     * @return Un String représentant la grille horaire du groupe
     */
    public String horaire() {
        return "-- Horaire du groupe " + nom() + " (" + nombreEtudiants() + " étudiants)\n" +
                Leçon.horaire(leçons);
    }

    /**
     * Retourne le nom du groupe, formaté à partir de l'orientation, du trimestre et du numéro
     *
     * @return Un String représentant le nom formaté du groupe
     */
    public String nom() {
        return orientation + trimestre + "-" + numéro;
    }

    /**
     * Retourne le nombre d'étudiants faisant partis du groupe
     *
     * @return Le nombre d'étudiants du groupe
     */
    public int nombreEtudiants() {
        return étudiants.size();
    }

}
