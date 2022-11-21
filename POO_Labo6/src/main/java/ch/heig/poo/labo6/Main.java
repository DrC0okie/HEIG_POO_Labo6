package ch.heig.poo.labo6;

import ch.heig.poo.labo6.école.*;
import java.util.Arrays;

/**
 * La classe Main permet de tester les fonctionnalités demand
 * @author Kevin Farine, Timothée Van Hove
 */
public class Main {
    public static void main(String[] args) {

        //1.
        Professeur dre = new Professeur("Rossier", "Daniel", "DRE");
        Professeur pdo = new Professeur("Donini", "Pier", "PDO");

        //2.
        Leçon poo1 = new Leçon("POO", 3, 6, 2, "H02", pdo);
        Leçon poo2 = new Leçon("POO", 4, 6, 2, "H02", pdo);
        Leçon poo3 = new Leçon("POO", 4, 8, 2, "H02", pdo);
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
        Groupe il61 = new Groupe(1, "IL", 6, Arrays.asList(john, paul, ringo, george));
        Groupe si61 = new Groupe(1, "SI", 6, Arrays.asList(roger, david));

        //5.
        il61.définirLeçons(Arrays.asList(poo1, poo2, poo3, sye1, sye2, tic1));
        si61.définirLeçons(Arrays.asList(poo1, poo2, poo3));

        //6.
        System.out.println("--Membres de l'ecole");
        for (Personne p : new Personne[]{pdo, dre, john, paul, ringo, george, roger, david}){
            System.out.println(p);
        }
        System.out.println();

        //7.
        System.out.println(il61.horaire());

        //8.
        System.out.println(pdo.horaire());
    }
}