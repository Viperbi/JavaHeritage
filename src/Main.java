public class Main {
    public static void main(String[] args) {
        Assassin kevin = new Assassin("Kévouche",10,4,1,2);
        Guerrier quentin = new Guerrier("Le Q",15,2, 2, 2);
        Partie partie = new Partie(kevin,quentin,5);
        partie.lancerPartie();
    }
}
