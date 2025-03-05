package com.adrar.Heritage.personnages;

public abstract class Personnage {

    private String nom;
    private Integer vie;
    private Integer attaque;
    private Integer defense;
    private double critical;
    private String classe;

    public Personnage(){}

    public Personnage(String nom, Integer vie, Integer attaque, Integer defense,double critical,String classe){
        this.nom = nom;
        this.vie = vie;
        this. attaque = attaque;
        this.defense = defense;
        this.critical = critical;
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

    public double getCritical() {
        return critical;
    }

    public void setCritical(double critical) {
        this.critical = critical;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public Personnage attaquer(Personnage cible){
        cible.setVie(cible.getVie() -(this.getAttaque()-cible.getDefense()));
        return cible;
    }
}
