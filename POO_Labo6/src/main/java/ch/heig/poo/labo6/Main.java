package ch.heig.poo.labo6;

import ch.heig.poo.labo6.école.Etudiant;
import ch.heig.poo.labo6.école.Groupe;
import ch.heig.poo.labo6.école.Leçon;
import ch.heig.poo.labo6.école.Professeur;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Professeur pdo = new Professeur("Donini", "Pier", "PDO");
        Professeur dre = new Professeur("Rossier", "Daniel", "DRE");

        ArrayList<Leçon> Leçons = new ArrayList<>();
        Leçons.add(new Leçon("POO", 1, 1, 1, "H02"));
        Leçons.add(new Leçon("POO", 1, 2, 2, "H02", pdo));
        Leçons.add(new Leçon("POO", 1, 4, 3, "H02", pdo));
        Leçons.add(new Leçon("SYE", 4, 1, 4, "G01", pdo));
        Leçons.add(new Leçon("SYE", 5, 1, 5, "A09", pdo));


        Etudiant KF = new Etudiant("Farine", "Kévin", 1);
        Etudiant TV = new Etudiant("VanHove", "Timothée", 1);

        ArrayList<Etudiant> étudiants = new ArrayList<>();
        étudiants.add(KF);
        étudiants.add(TV);

        Groupe groupe1 = new Groupe(1, "ISCS", 3, étudiants);
        groupe1.définirLeçons(Leçons);

        System.out.println(groupe1.horaire());


    }
}