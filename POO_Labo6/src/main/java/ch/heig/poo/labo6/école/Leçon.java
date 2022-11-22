package ch.heig.poo.labo6.école;

import java.util.Collection;

/**
 * Représente une leçon contenant la matière
 *
 * @author Kevin Farine, Timothée Van Hove
 */
public class Leçon {
    private enum Jours {Lun, Mar, Mer, Jeu, Ven}

    ;
    final private static String[] HEURES = {"8:30", "9:15", "10:25", "11:15", "12:00", "13:15",
            "14:00", "14:55", "15:45", "16:35", "17:20"};
    final private static char SEP_COL = '|', SEP_LIGNE = '-';
    final private static int LARGEUR_PREMIERE_COL = 5,
            INITIALES_MATIERE = 5, INITIALES_SALLE = 3,
            LARGEUR_COL_JOURS = 2 + Professeur.NBRE_INITIALES + INITIALES_MATIERE + INITIALES_SALLE;
    final private static String BAS_CELLULE = SEP_COL + (SEP_LIGNE + "").repeat(LARGEUR_COL_JOURS),
            CELLULE_VIDE = BAS_CELLULE.replace(SEP_LIGNE, ' '),
            SEP_HEURE = " ".repeat(LARGEUR_PREMIERE_COL),
            SEP_LIGNE_COMPLETE = SEP_HEURE + BAS_CELLULE.repeat(Jours.values().length) + SEP_COL + "\n",
            FORMAT_HEURE = "%" + LARGEUR_PREMIERE_COL + "s",
            FORMAT_CELLULE = SEP_COL + "%-" + INITIALES_MATIERE + "s %" + INITIALES_SALLE + "s %" +
                    Professeur.NBRE_INITIALES + "s";

    private final String matière;
    private final int jourSemaine;
    private final int périodeDébut;
    private final int durée;
    private final String salle;
    private Professeur professeur;

    /**
     * Constructeur de la Leçon
     *
     * @param matière L'acronyme de la matière de la leçon (par défaut 5 caractères maximum)
     * @param jourSemaine Le jour de la semaine 1 (lundi) à 5 (vendredi)
     * @param périodeDébut Le numéro de période à laquelle la leçon commence (1 - 11 par défaut)
     * @param durée La durée (en périodes) de la leçon
     * @param salle L'acronyme de la salle de cours. Par défaut, maximum 3 caractères
     * @throws RuntimeException Si durée, périodeDébut sont inférieurs à 0, si la durée de la
     * leçon dépasse les plages horaires de la semaine, si jourSemaine est hors plage, sila
     * longueur des initiales est trop grande.
     */
    public Leçon(String matière, int jourSemaine, int périodeDébut, int durée, String salle) {
        if (périodeDébut + durée > HEURES.length) {
            throw new RuntimeException("La durée de la leçon excède la longueur de la plage " +
                    "horaire");
        }
        if(durée < 1 || périodeDébut < 1){
            throw new RuntimeException("La durée et la période de début doivent être > 0");
        }
        if(jourSemaine < 1 || jourSemaine > Jours.values().length){
            throw new RuntimeException("Le jour de la semaine doit être entre 1 et " +
                    Jours.values().length);
        }
        if (salle.length() > INITIALES_SALLE) {
            throw new RuntimeException("Les initiales de la salle ne peuvent pas dépasser" +
                    INITIALES_SALLE + " caractères. Actuellement : " + salle.length());
        }
        if (matière.length() > INITIALES_MATIERE) {
            throw new RuntimeException("Les initiales de la matière ne peuvent pas dépasser" +
                    INITIALES_MATIERE + " caractères. Actuellement : " + matière.length());
        }

        this.matière = matière;
        this.jourSemaine = jourSemaine;
        this.périodeDébut = périodeDébut;
        this.durée = durée;
        this.salle = salle;
    }

    /**
     * Constructeur de la Leçon
     *
     * @param matière L'acronyme de la matière de la leçon (par défaut 5 caractères maximum)
     * @param jourSemaine Le jour de la semaine 1 (lundi) à 5 (vendredi)
     * @param périodeDébut Le numéro de période à laquelle la leçon commence (1 - 11 par défaut)
     * @param durée La durée (en périodes) de la leçon
     * @param salle L'acronyme de la salle de cours. Par défaut, maximum 3 caractères
     * @param professeur Le professeur assigné à cette leçon
     */
    public Leçon(String matière, int jourSemaine, int périodeDébut, int durée, String salle,
                 Professeur professeur) {
        this(matière, jourSemaine, périodeDébut, durée, salle);
        if (this.professeur != null) {
            this.professeur = professeur;
            this.professeur.définirLeçon(this);
        }
    }

    /**
     * Construit l'en-tête de la grille horaire
     *
     * @return l'en-tête de la grille horaire
     */
    private static StringBuilder CréerEnTête() {
        StringBuilder enTête = new StringBuilder(SEP_HEURE);

        //Ajouter tous les jours de la semaine
        for (Jours jour : Jours.values()) {
            enTête.append(String.format(SEP_COL + " %-" + (LARGEUR_COL_JOURS - 1) + "s",
                    jour.name()));
        }
        //Ajouter le dernier séparateur, le retour à la ligne et le bas des cellules de l'en-tête
        return enTête.append(SEP_COL + "\n").append(SEP_LIGNE_COMPLETE);
    }

    /**
     * Construit la cellule de la grille horaire en fonction des lignes paires (contenu de la
     * cellule) et des lignes impaires (séparation entre chaque cellule)
     *
     * @param indiceLigne L'indice de chaque ligne de la grille horaire
     * @param leçon La leçon à traiter
     * @return La représentation sous forme de String de la grille horaire
     */
    private static String créerCellule(int indiceLigne, Leçon leçon) {
        boolean estLignePaire = indiceLigne % 2 == 0;

        //Dans le cas où aucune leçon n'est attribuée, ajouter une cellule vide
        if (leçon == null) {
            if (estLignePaire) {
                return CELLULE_VIDE;
            }
            return BAS_CELLULE;
        }
        //Calculer la période actuelle (de 1 à n)
        int périodeActuelle = indiceLigne / 2 - leçon.périodeDébut + 2;

        //Première période de la leçon : ajouter les informations dans la cellule
        if (périodeActuelle == 1) {
            if (estLignePaire) {
                return String.format(FORMAT_CELLULE, leçon.matière, leçon.salle,
                        leçon.professeur != null ? leçon.professeur.abreviation() : "");
            }
            if (leçon.durée > 1) {
                return CELLULE_VIDE;
            }
        }
        //Périodes suivantes de la leçon : Cellules vides s'il s'agit d'une période intermédiaire
        if (périodeActuelle < leçon.durée || estLignePaire) {
            return CELLULE_VIDE;
        }
        //Cas de la ligne impaire de la dernière période
        return BAS_CELLULE;
    }

    /**
     * Créé l'horaire hebdomadaire en fonction d'une liste de leçons
     *
     * @param leçons Collection de leçons à formater en grille horaire hebdomadaire
     * @return Un String représentant la grille horaire hebdomadaire
     */
    public static String horaire(Collection<Leçon> leçons) {
        //Tableau 2d contenant toutes les leçons
        Leçon[][] tableauLeçons = new Leçon[HEURES.length][Jours.values().length];
        for (Leçon leçon : leçons) {
            for (int i = 0; i < leçon.durée; ++i) {
                tableauLeçons[leçon.périodeDébut - 1 + i][leçon.jourSemaine - 1] = leçon;
            }
        }
        //Construction de la grille horaire
        StringBuilder horaire = new StringBuilder(CréerEnTête());
        for (int i = 0; i < (HEURES.length * 2) - 1; ++i) {
            //Ajout de la première cellule représentant l'heure
            horaire.append(i % 2 != 0 ? SEP_HEURE : String.format(FORMAT_HEURE, HEURES[i / 2]));

            //Ajout du contenu des cellules de chaque heure de début de chaque jour
            for (int j = 0; j < Jours.values().length; ++j) {
                horaire.append(créerCellule(i, tableauLeçons[i / 2][j]));
            }
            horaire.append(SEP_COL + "\n");
        }
        return horaire.append(SEP_LIGNE_COMPLETE).toString();
    }
}
