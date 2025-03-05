package com.adrar.Heritage.personnages;

public class Healer extends Personnage {

    private Integer mana;

    public Healer(String nom){
        super(nom,15,3,2,0.1,"healer");
        this.mana = 10;
    }

    public Integer getMana() {
        return mana;
    }

    public void setMana(Integer mana) {
        this.mana = mana;
    }


    public Personnage soigner (Personnage cible){
        double temp = Math.random();
        if(temp<=0.75){
            cible.setVie(cible.getVie()+this.getAttaque());
            System.out.println(this.getNom()+" a soigné "+cible.getNom()+" de "+this.getAttaque()+" en utilisant 1 point de mana.");
            this.setMana(this.getMana()-1);
        }
        return cible;
    }
}
