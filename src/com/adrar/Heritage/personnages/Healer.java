package com.adrar.Heritage.personnages;

public class Healer extends Personnage {

    private Integer mana;

    public Healer(String nom, Integer vie, Integer attaque, Integer defense, Integer mana){
        super(nom,vie,attaque,defense);
        this.mana = mana;
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
            System.out.println(this.getNom()+" a soigné "+cible.getNom()+" de "+this.getAttaque());
        }
        return cible;
    }
}
