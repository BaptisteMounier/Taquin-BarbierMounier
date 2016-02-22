import java.awt.Dimension;

import javax.swing.JFrame;

import jeu.*;
import graphique.*;

public class Main {
	
	public final static int WIDTH = Constante.TAILLE_PLATEAU_X * Constante.TAILLE_TUILE_X;
	
	public final static int HEIGHT = Constante.TAILLE_PLATEAU_Y * Constante.TAILLE_TUILE_Y;

	public static void main(String[] args) {
		Jeu jeu = new Jeu();
		MoteurGraphique moteurGraphique = new MoteurGraphique(jeu.getPlateau(), jeu.getTuiles(), Main.WIDTH, Main.HEIGHT);
		
		//JFrame fenetre = new JFrame("Taquin");

		MoteurJeu moteurJeu = new MoteurJeu(jeu, moteurGraphique);
		/*fenetre.setPreferredSize(new Dimension(Main.WIDTH,
				Main.HEIGHT));
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
		fenetre.setResizable(false);
		fenetre.pack();*/
		
		moteurJeu.play();
		jeu.initialisation();
		System.out.println(jeu.getPlateau());
	}

}
