import com.adrar.Heritage.personnages.Assassin;
import com.adrar.Heritage.personnages.Guerrier;

public class Main {
    public static void main(String[] args) {
        Assassin kevin = new Assassin("Kévouche",10,6,1,2);
        Guerrier quentin = new Guerrier("Le Q",15,3, 2, 2);
        Partie partie = new Partie(kevin,quentin,5);
        partie.lancerPartie();
    }
}
