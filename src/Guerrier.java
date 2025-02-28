public class Guerrier extends Personnage{



    private Integer bonusDefense;

    public Guerrier(String nom, Integer vie, Integer attaque, Integer defense, Integer bonusDefense){
        super(nom,vie,attaque,defense);
        this.bonusDefense = bonusDefense;
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

