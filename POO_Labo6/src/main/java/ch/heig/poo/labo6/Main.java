package ch.heig.poo.labo6;

import ch.heig.poo.labo6.école.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //1.
        Professeur dre = new Professeur("Rossier", "Daniel", "DRE");
        Professeur pdo = new Professeur("Donini", "Pier", "PDO");

        //2.
        Leçon poo1 = new Leçon("POO", 2, 6, 2, "H02", pdo);
        Leçon poo2 = new Leçon("POO", 3, 6, 2, "H02", pdo);
        Leçon poo3 = new Leçon("POO", 3, 8, 1, "H02", pdo);
        Leçon sye1 = new Leçon("SYE", 1, 1, 2, "G01", dre);
        Leçon sye2 = new Leçon("SYE", 4, 3, 2, "A09", dre);
        Leçon tic1 = new Leçon("TIC", 2, 10, 1, "F06");
        
        //3.
        Etudiant john = new Etudiant("Lennon", "John", 1234);
        Etudiant paul = new Etudiant("Mc Cartney", "Paul", 2341);
        Etudiant ringo = new Etudiant("Starr", "Ringo", 3241);
        Etudiant george = new Etudiant("Harisson", "George", 4321);
        Etudiant roger = new Etudiant("Waters", "Roger", 1324);
        Etudiant david = new Etudiant("Gilmour", "David", 4312);

        //4.
        ArrayList<Etudiant> groupe1 = new ArrayList<>();
        groupe1.add(john);
        groupe1.add(paul);
        groupe1.add(ringo);
        groupe1.add(george);
        Groupe il61 = new Groupe(1, "IL", 6, groupe1);

        ArrayList<Etudiant> groupe2 = new ArrayList<>();
        groupe2.add(roger);
        groupe2.add(david);
        Groupe si61 = new Groupe(1, "SI", 6, groupe2);

        //5.
        ArrayList<Leçon> leçons1 = new ArrayList<>();
        leçons1.add(poo1);
        leçons1.add(poo2);
        leçons1.add(poo3);
        leçons1.add(sye1);
        leçons1.add(sye2);
        leçons1.add(tic1);
        il61.définirLeçons(leçons1);

        ArrayList<Leçon> leçons2 = new ArrayList<>();
        leçons1.add(poo1);
        leçons1.add(poo2);
        leçons1.add(poo3);
        si61.définirLeçons(leçons2);

        //6.
        ArrayList<Personne> tableauPersonnes = new ArrayList<>();
        tableauPersonnes.add(pdo);
        tableauPersonnes.add(dre);
        tableauPersonnes.add(john);
        tableauPersonnes.add(paul);
        tableauPersonnes.add(ringo);
        tableauPersonnes.add(george);
        tableauPersonnes.add(roger);
        tableauPersonnes.add(david);
        System.out.println("--Membres de l'ecole");
        for (Personne p : tableauPersonnes){
            System.out.println(p);
        }
        System.out.println();

        //7.
        System.out.println(il61.horaire());

        //8.
        System.out.println(pdo.horaire());
    }
}