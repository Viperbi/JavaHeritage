package com.adrar.Heritage.personnages;

public class Assassin extends Personnage {

    private Integer bonusAttaque;

    public Assassin(String nom){
        super(nom,20,3,1,0.1,"healer");
        this.bonusAttaque = 3;
    }

    public Integer getBonusAttaque() {
        return bonusAttaque;
    }

    public void setBonusAttaque(Integer bonusAttaque) {
        this.bonusAttaque = bonusAttaque;
    }

    @Override
    public Personnage attaquer (Personnage cible){
        double temp = Math.random();
        Integer dmg;
        if(temp <= 0.05) {
            dmg = this.getBonusAttaque() + this.getAttaque() - cible.getDefense();
            if (dmg <= 0) {
                dmg = 1;
            }
            cible.setVie(cible.getVie() - dmg);
            System.out.println(this.getNom()+" attaque "+cible.getNom()+" et lui inflige "+dmg+" points de dégats.");
            System.out.println("Coup Critique !");
        }else{
            dmg = this.getAttaque()-cible.getDefense();
            if (dmg <= 0) {
                dmg = 1;
            }
            cible.setVie(cible.getVie() -dmg);
            System.out.println(this.getNom()+" attaque "+cible.getNom()+" et lui inflige "+dmg+" points de dégats.");
        }
        return cible;
    }
}
