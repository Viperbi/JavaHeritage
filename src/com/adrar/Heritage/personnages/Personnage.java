package com.adrar.Heritage.personnages;

public abstract class Personnage {

    private String nom;
    private Integer vie;
    private Integer attaque;
    private Integer defense;

    public Personnage(){}

    public Personnage(String nom, Integer vie, Integer attaque, Integer defense){
        this.nom = nom;
        this.vie = vie;
        this. attaque = attaque;
        this.defense = defense;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getVie() {
        return vie;
    }

    public void setVie(Integer vie) {
        this.vie = vie;
    }

    public Integer getAttaque() {
        return attaque;
    }

    public void setAttaque(Integer attaque) {
        this.attaque = attaque;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public Personnage attaquer(Personnage cible){
        cible.setVie(cible.getVie() -(this.getAttaque()-cible.getDefense()));
        return cible;
    }
}
