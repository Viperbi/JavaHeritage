package com.adrar.Heritage.monstre;

import com.adrar.Heritage.personnages.Personnage;

public class Cyclope extends Personnage {

    private String capaSpe = "Peur";

    public Cyclope(){
        super("Cyclope",50,50,4,0.2,"monstre");
    }

    @Override
    public Personnage attaquer (Personnage cible){
        double temp = Math.random();
        Integer dmg;
        if(temp <= 0.05) {
            dmg = + this.getAttaque() - cible.getDefense();
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
