package com.adrar.Heritage.personnages;

public class Guerrier extends Personnage {



    private Integer bonusDefense;

    public Guerrier(String nom){
        super(nom,25,2,3,0.1,"healer");
        this.bonusDefense = 3;
    }

    public Integer getBonusDefense() {
        return bonusDefense;
    }

    public void setBonusDefense(Integer bonusDefense) {
        this.bonusDefense = bonusDefense;
    }

    @Override
    public Personnage attaquer (Personnage cible){
        double temp = Math.random();
        Integer dmg = this.getAttaque()-cible.getDefense();
        if (dmg <= 0) {
            dmg = 1;
        }
        if(temp <= 0.05) {
            this.setVie(this.getVie()+this.getBonusDefense());
            System.out.println("En attaquant "+this.getNom()+" récupère  "+this.getBonusDefense()+" points de vie.");
        }
        cible.setVie(cible.getVie() -dmg);
        System.out.println(this.getNom()+" attaque "+cible.getNom()+" et lui inflige "+dmg+" points de dégats.");
        return cible;
    }
}

