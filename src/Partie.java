public class Partie {

    private Personnage joueur1;
    private Personnage joueur2;
    private Integer nbrTour;

    public Partie(Personnage joueur1, Personnage joueur2, Integer nbrTour){
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.nbrTour = nbrTour;
    }

    public Personnage getJoueur1() {
        return joueur1;
    }

    public void setJoueur1(Personnage joueur1) {
        this.joueur1 = joueur1;
    }

    public Personnage getJoueur2() {
        return joueur2;
    }

    public void setJoueur2(Personnage joueur2) {
        this.joueur2 = joueur2;
    }

    public Integer getNbrTour() {
        return nbrTour;
    }

    public void setNbrTour(Integer nbrTour) {
        this.nbrTour = nbrTour;
    }

    public void lancerPartie(){
        while(nbrTour > 0){
            this.getJoueur1().attaquer(this.getJoueur2());
            if (this.getJoueur1().getVie() > 0 && this.getJoueur2().getVie() <=0){
                System.out.println("Le joueur "+this.getJoueur1().getNom()+" remporte la partie.");
                return;
            }
            this.getJoueur2().attaquer(this.getJoueur1());
            if(this.getJoueur2().getVie() > 0 && this.getJoueur1().getVie() <=0){
                System.out.println("Le joueur "+this.getJoueur2().getNom()+" remporte la partie.");
                return;
            }
            this.setNbrTour(this.getNbrTour()-1);
            System.out.println("Plus que "+this.getNbrTour()+" tour restants.");
        }
        System.out.println("Aucun tour restant, le joueur "+ this.getJoueur1().getNom()+" a "+this.getJoueur1().getVie()+" points de vie restants. \n" +
                "Le joueur "+this.getJoueur2().getNom()+" a "+this.getJoueur2().getVie()+" points de vie restans. \n "+
                "La partie est donc terminée avec une égalité entre les 2 joueurs.");
    }

}
