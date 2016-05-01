package application;
import jeu.*;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		if(args.length == 0){
			System.out.println("==========");
			System.out.println("Lancement du programme sans GUI");
			Jeu jeu = new Jeu();
			MoteurJeu moteurJeu = new MoteurJeu(jeu);
			moteurJeu.play();
		}else{
			MainGUI.main(args);
		}
	}

}
