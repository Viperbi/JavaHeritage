import com.adrar.Heritage.monstre.Cyclope;
import com.adrar.Heritage.monstre.Gobelin;
import com.adrar.Heritage.monstre.Ogre;
import com.adrar.Heritage.personnages.Assassin;
import com.adrar.Heritage.personnages.Guerrier;
import com.adrar.Heritage.personnages.Healer;
import com.adrar.Heritage.personnages.Personnage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Partie {

    private List<Personnage> listJoueur = new ArrayList<>();
    private Integer nbrTour;
    private Integer nbrJoueur;

    public Partie(){
    }

    public Integer getNbrTour() {
        return nbrTour;
    }

    public void setNbrTour(Integer nbrTour) {
        this.nbrTour = nbrTour;
    }

    public Integer getNbrJoueur() {
        return nbrJoueur;
    }

    public void setNbrJoueur(Integer nbrJoueur) {
        this.nbrJoueur = nbrJoueur;
    }

    public List<Personnage> getListJoueur() {
        return listJoueur;
    }

    public void addJoueur(Personnage perso){
        this.listJoueur.add(perso);
    }

    public static void promptEnterKey(){
        System.out.println("Appuyer sur \"Entrée\" pour continuer...");
        try {
            //Deux bytes parce que sur Windows la touche Enter sors 2 charactères : "\r" et "\n"
            int read = System.in.read(new byte[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean mort(){
        int mort = 0;
        for (int i = 0; i < this.getNbrJoueur(); i++) {
            if (this.getListJoueur().get(i).getVie()<= 0){
                mort += 1;
            }
        }
        return mort == this.getNbrJoueur();
    }

    public void lancerPartie(){
        System.out.println("LANCEMENT DE LA PARTIE");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Combien de tour va durer la partie ?");
        int nbtour = scanner.nextInt();
        this.setNbrTour(nbtour);
        System.out.println("Combien de joueur vont jouer ?");
        int nbJ = scanner.nextInt();
        this.setNbrJoueur(nbJ);
        for(int i =1;i<=nbJ;i++){
            System.out.println("Nom du joueur"+i);
            scanner.nextLine();
            String nom = scanner.nextLine();
            System.out.println("Selectionnez une classe, 1 pour Guerrier, 2 Pour Assassion, 3 pour Healer.");
            int classe = scanner.nextInt();
            switch (classe){
                case 1:
                    Guerrier guerrier = new Guerrier(nom);
                    this.addJoueur(guerrier);
                    break;

                case 2:
                    Assassin assassin = new Assassin(nom);
                    this.addJoueur(assassin);
                    break;

                case 3:
                    Healer healer = new Healer(nom);
                    this.addJoueur(healer);
                    break;
            }
        }
        System.out.println("La partie va se lancer avec "+this.getNbrJoueur()+" joueurs pour un total de "+this.getNbrTour()+" tours maximum.");
        promptEnterKey();
    }

    public void turn(){
        for(int i = 0; i<this.getNbrTour(); i++){
            System.out.println("## DEBUT DU TOUR "+i+1+" ##");
            Scanner scanner = new Scanner(System.in);
            chemin();
            if(mort()){
                break;
            }
        }
    }

    public void chemin(){
        int temp = (int)(Math.random()*3)+1;
        switch (temp){
            case 1:
                System.out.println("⚠ Vous avancez sur le premier chemin et vous allez vous battre contre un Cyclope ⚠");
                combat(new Cyclope());
                break;

            case 2:
                System.out.println("⚠ Vous avancez sur le deuxième chemin et vous allez vous battre contre un Gobelin ⚠");
                combat(new Gobelin());
                break;

            case 3:
                System.out.println("⚠ Vous avancez sur le troisième chemin et vous allez vous battre contre un Ogre ⚠");
                combat(new Ogre());
                break;
        }
    }

    public void combat(Personnage monstre){
        while(monstre.getVie()>0 && !mort()) {
            mort();
            for (int i = 0; i < this.getNbrJoueur(); i++) {
                System.out.println(this.getNbrJoueur());
                System.out.println(i);
                Personnage personne = this.getListJoueur().get(i);
                Scanner scanner = new Scanner(System.in);
                System.out.println(this.getListJoueur().get(i).getNom() + ", c'est votre tour, que voulez vous faire ? 1 pour attaquer, 2 pour passer votre tour.");
                int choix = scanner.nextInt();
                if (choix == 1 && this.getListJoueur().get(i).getClasse() != "healer") {
                    this.getListJoueur().get(i).attaquer(monstre);
                } else if (choix == 2) {
                    System.out.println("Vous décidez de passer votre tour, quelle décision étrange...");
                } else if (personne instanceof Healer && choix == 3) {
                    System.out.println("Qui voulez vous soigner ? (indiquez le numéro du joueur entre 1 et "+this.getNbrJoueur()+".");
                    int soin = scanner.nextInt();
                    if(soin>this.getNbrJoueur()){
                        System.out.println("Vous n'écoutez pas les consignes et avez choisi un mauvais nombre. Vous terminez votre tour.");
                    }else{
                        ((Healer) personne).soigner(this.getListJoueur().get(soin));
                    }
                }else{
                    System.out.println("Apprenez à lire et choisissez une des valeurs demandées.");
                }
                System.out.println(this.getListJoueur().get(i).getNom() + ", votre tour se termine.");
            }
            System.out.println("Au tour de " + monstre.getNom() + " de jouer.");
            int temp = (int) (Math.random() * this.getNbrJoueur());
            if (this.getListJoueur().get(temp).getVie() <=0){
                System.out.println("Ce con de monstre attaque un cadavre, personne ne perd de point de vie.");
            }else {
                monstre.attaquer(this.getListJoueur().get(temp));
            }
        }
    }

    public void endGame(){
        System.out.println("FIN DE LA PARTIE");
        if (mort()){
            System.out.println("Vous êtes tous mort, vous pouvez être déçus de votre performance..");
        }else {
            System.out.println("Bravo vous avez vaincu tous les monstres face à vous. Ne prenez pas la grosse tête pour autant.");
        }
        System.out.println("Rendez vous pour votre prochaine partie.");
        System.out.println("#####################");
    }

    public void deroulementPartie(){
        lancerPartie();
        turn();
        endGame();
    }

}
