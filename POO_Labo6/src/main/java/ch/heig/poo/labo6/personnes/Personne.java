package ch.heig.poo.labo6.personnes;

public class Personne {
    //Attributs
    private String nom;
    private String prénom;

    //Méthodes
    public Personne(String unNom, String unPrénom){
        nom = unNom;
        prénom = unPrénom;
    }


    public String toString(){
        return "Nom : " + nom + ", Prénom : " + prénom;
    }
}
