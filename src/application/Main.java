package application;
import java.awt.Dimension;

import javax.swing.JFrame;

import application.*;
import jeu.*;

public class Main {

	public static void main(String[] args) {
		if(args.length == 0){
			System.out.println("Lancement du programme sans GUI\n==========\n");
			Jeu jeu = new Jeu();
			MoteurJeu moteurJeu = new MoteurJeu(jeu);
			moteurJeu.play();
		}else{
			MainGUI.main(args);
		}
	}

}
