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
            HEURES_DEBUT = {"8:30", "9:15", "10:25", "11:15", "12:00", "13:15", "14:00", "14:55",
                    "15:45", "16:35", "17:20"};
    final private static int LARGEUR_COLONNE = 13, LARGEUR_PREMIERE_COLONNE = 5;
    final private static char SEP_COLONNE = '|', SEP_LIGNE = '-';
    final private static String BAS_CELLULE =
            SEP_COLONNE + (SEP_LIGNE + "").repeat(LARGEUR_COLONNE),
            CELLULE_VIDE = BAS_CELLULE.replace(SEP_LIGNE, ' '),
            SEP_HEURE = " ".repeat(LARGEUR_PREMIERE_COLONNE),
            SEP_LIGNE_COMPLETE = SEP_HEURE + BAS_CELLULE.repeat(JOURS.length) + SEP_COLONNE + "\n",
            FORMAT_HEURE = "%"+ LARGEUR_PREMIERE_COLONNE + "s";

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

        //Ajouter tous les jours de la semaine
        for(String jour : JOURS){
            enTête.append(String.format(SEP_COLONNE + " %-" + (LARGEUR_COLONNE - 1) + "s", jour));
        }
        //Ajouter le dernier séparateur, le retour à la ligne et le bas des cellules de l'en-tête
        return enTête.append(SEP_COLONNE + "\n").append(SEP_LIGNE_COMPLETE);
    }

    /**
     * Construit la cellule de la grille horaire
     * @param indiceLigne L'indice du tableau de leçons
     * @param leçon La leçon dont on crée la cellule
     * @return La cellule à afficher de la grille horaire
     */
    private static String créerCellule(int indiceLigne, Leçon leçon){
        boolean estLignePaire = indiceLigne % 2 == 0;

        //Dans le cas ou aucune leçon n'est attribuée, ajouter une cellule vide
        if(leçon == null){
            if(estLignePaire){
                return CELLULE_VIDE;
            }
            return BAS_CELLULE;
        }

        //Calculer la période actuelle (de 1 à n)
        int périodeActuelle = indiceLigne / 2 - leçon.périodeDébut + 2;

        //Première période de la leçon : ajouter les informations dans la cellule
        if(périodeActuelle == 1){
            if(estLignePaire){
                return String.format("|%-5s %3s %3s", leçon.matière, leçon.salle,
                        leçon.professeur != null ? leçon.professeur.abreviation() : "");
            }
            if(leçon.durée > 1){
                return CELLULE_VIDE;
            }
        }
        //Périodes suivantes de la leçon : Cellules vides (lignes paires et impaires)
        if(périodeActuelle < leçon.durée || estLignePaire){
            return CELLULE_VIDE;
        }

        //Cas de la ligne impaire de la dernière période
        return BAS_CELLULE;
    }

    /**
     * Créé l'horaire hebdomadaire en fonction d'une liste de leçons
     * @param leçons Liste de leçons à formater sous forme d'horaire hebdomadaire
     * @return Un String représentant l'horaire
     */
    public static String horaire(ArrayList<Leçon> leçons){
        //Créer un tableau 2d contenant toutes les leçons
        Leçon[][] tableauLeçons = new Leçon[HEURES_DEBUT.length][JOURS.length];
        for(Leçon leçon : leçons){
            for(int i = 0; i < leçon.durée; ++i){
                //Nous ajoutons au tableau les leçons période par période
                tableauLeçons[(leçon.périodeDébut - 1) + i][leçon.jourSemaine - 1] = leçon;
            }
        }

        //Ajout de l'en-tête
        StringBuilder horaire = new StringBuilder(CréerEnTête());

        //Doubler le nombre de lignes pour traiter les séparations
        int nbLignes = (HEURES_DEBUT.length * 2) - 1;

        //ajout de toutes les cellules et interligne dans le StringBuilder
        for(int i = 0; i < nbLignes; ++i){
            //Ajouter la première cellule qui représente l'heure
            horaire.append(i % 2 != 0 ? SEP_HEURE : String.format(FORMAT_HEURE, HEURES_DEBUT[i / 2]));

            for(int j = 0; j < JOURS.length; ++j){
                //Ajouter le contenu des cellules de chaque heure de début de chaque jour
                horaire.append(créerCellule(i, tableauLeçons[i / 2][j]));
            }
            horaire.append(SEP_COLONNE + "\n");
        }
        //Ajouter la dernière ligne
        return horaire.append(SEP_LIGNE_COMPLETE).toString();
    }
}
