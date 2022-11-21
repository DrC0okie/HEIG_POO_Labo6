package ch.heig.poo.labo6;

import ch.heig.poo.labo6.école.Leçon;
import ch.heig.poo.labo6.école.Professeur;

public class Main {
    public static void main(String[] args) {
        Professeur pdo = new Professeur("Pier", "Donini", "PDO");
        Professeur dre = new Professeur("Daniel", "Rossier", "DRE");

        Leçon poo1 = new Leçon("POO", 1, 1, 1, "H02", pdo);
        Leçon poo2 = new Leçon("POO", 2, 1, 2, "H02", pdo);
        Leçon poo3 = new Leçon("POO", 3, 1, 3, "H02", pdo);
        Leçon sye1 = new Leçon("SYE", 4, 1, 4, "G01", pdo);
        Leçon sye2 = new Leçon("SYE", 5, 1, 5, "A09", pdo);

        System.out.println(pdo.horaire());

        //TODO Kévin : l'affichage du calendrier fonctionne mais que avec des durées de leçons de
        // 2 périodes (c'est codé en dur). Il faudrait gérer l'affichege pour des durées de n
        // periodes. Pour ça il faudrait trouver un moyen d'afficher "---------" ou "         "
        // dans les cellules du dessous en fonction de la durée de chaque leçon.
    }
}