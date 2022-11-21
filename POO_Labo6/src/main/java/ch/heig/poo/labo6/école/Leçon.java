package ch.heig.poo.labo6.école;

import java.util.ArrayList;

/**
 * La classe Leçon contient les informations en lien avec la matière, le lieu, l'heure auquel cela a lieu et
 * si un enseignant ou non l'enseigne.
 *
 * @author Kevin Farine, Timothée Von Hove
 */
public class Leçon {
    final private static String[] JOURS = {"Lun", "Mar", "Mer", "Jeu", "Ven"},
            PLAGES_HORAIRE = {"8:30", "9:15", "10:25", "11:15", "12:00", "13:15", "14:00", "14:55",
                    "15:45", "16:35", "17:20"};
    final private static int LARGEUR_COLONNE = 13, LARGEUR_PREMIERE_COLONNE = 5;
    final private static char SEP_COLONNE = '|', SEP_LIGNE = '-';
    final private static String BAS_CELLULE =
            SEP_COLONNE + (SEP_LIGNE + "").repeat(LARGEUR_COLONNE),
            CELLULE_VIDE = BAS_CELLULE.replace(SEP_LIGNE, ' '),
            SEP_HEURE = " ".repeat(LARGEUR_PREMIERE_COLONNE),
            SEP_LIGNE_COMPLETE = SEP_HEURE + BAS_CELLULE.repeat(JOURS.length) + SEP_COLONNE + "\n";

    private String matière;
    private int jourSemaine;
    private int périodeDébut;
    private int durée;
    private String salle;
    private Professeur professeur;

    /**
     * Contruit un objet de classe Leçon en fournissant la matière, le moment du cours, la salle et l'enseignant
     * @param matière
     * @param jourSemaine
     * @param périodeDébut
     * @param durée
     * @param salle
     * @param professeur
     */
    public Leçon(String matière, int jourSemaine, int périodeDébut, int durée, String salle,
                 Professeur professeur){
        this.matière = matière;
        this.jourSemaine = jourSemaine;
        this.périodeDébut = périodeDébut;
        this.durée = durée;
        this.salle = salle;
        this.professeur = professeur;
        if(professeur != null){
            this.professeur.addLeçon(this);
        }
    }

    /**
     * Construit l'en-tête de la grille horaire
     * @return l'en-tête de la grille horaire
     */
    private static StringBuilder CréerEnTête(){
        StringBuilder enTête = new StringBuilder(SEP_HEURE);
        for(String jour : JOURS){
            enTête.append(String.format(SEP_COLONNE + " %-" + (LARGEUR_COLONNE - 1) + "s", jour));
        }
        // Ajouter le dernier séparateur et le retour à la ligne
        enTête.append(SEP_COLONNE + "\n");

        //Ajouter le bas des cellules de l'en-tête
        return enTête.append(SEP_LIGNE_COMPLETE);
    }

    /**
     * Construit la ligne de la grille horaire
     * @param indiceLigne L'indice du tableau de leçons
     * @return La ligne de la grille horaire
     */
    private static StringBuilder créerPlageHoraire(int indiceLigne){
        if(indiceLigne % 2 != 0){
            return new StringBuilder(SEP_HEURE);
        }
        return new StringBuilder(String.format("%"+ LARGEUR_PREMIERE_COLONNE + "s",
                PLAGES_HORAIRE[indiceLigne / 2]));
    }

    /**
     * Construit la cellule de la grille horaire
     * @param indiceLigne L'indice du tableau de leçons
     * @param leçon La leçon dont on crée la cellule
     * @return La cellule à afficher de la grille horaire
     */
    private static StringBuilder créerCellule(int indiceLigne, Leçon leçon){
        StringBuilder cellule = new StringBuilder();
        if(leçon == null){
            if(indiceLigne % 2 != 0){
                return cellule.append(BAS_CELLULE);
            }
            return cellule.append(CELLULE_VIDE);
        }
        if(indiceLigne % 2 != 0){
            return cellule.append(CELLULE_VIDE);
        }
        return cellule.append(String.format("|%-5s %3s %3s", leçon.matière, leçon.salle,
                leçon.professeur != null ? leçon.professeur.abreviation() : ""));
    }

    /**
     * Créé l'horaire hebdomadaire en fonction d'une liste de leçons
     * @param leçons Liste de leçons à formater sous forme d'horaire hebdomadaire
     * @return Un String représentant l'horaire
     */
    public static String horaire(ArrayList<Leçon> leçons){

        //Créer un tableau 2d comportant toutes les leçons
        Leçon[][] tableauLeçons = new Leçon[PLAGES_HORAIRE.length][JOURS.length];
        for(Leçon leçon : leçons){
            tableauLeçons[leçon.périodeDébut - 1][leçon.jourSemaine - 1] = leçon;
        }
        //Ajout de l'en-tête
        StringBuilder horaire = new StringBuilder(CréerEnTête());

        //Double le nombre de lignes pour traiter les séparations
        int nbLignes = (PLAGES_HORAIRE.length * 2) - 1;

        for(int i = 0; i < nbLignes; ++i){
            //Ajouter la première cellule qui représente l'heure
            horaire.append(créerPlageHoraire(i));
            for(int j = 0; j < JOURS.length; ++j){
                //Ajouter le contenu des cellules de chaque jour
                horaire.append(créerCellule(i, tableauLeçons[i/2][j]));
            }
            horaire.append(SEP_COLONNE + "\n");
        }
        //Ajouter la dernière ligne
        return horaire.append(SEP_LIGNE_COMPLETE).toString();
    }
}
