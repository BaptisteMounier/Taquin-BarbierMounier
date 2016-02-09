import java.awt.Dimension;

import javax.swing.JFrame;

import jeu.*;
import graphique.*;

public class Main {

	public static void main(String[] args) {
		Jeu jeu = new Jeu();
		MoteurGraphique moteur = new MoteurGraphique(jeu.getPlateau(), jeu.getTuiles(), Constante.TAILLE_PLATEAU_X, Constante.TAILLE_PLATEAU_Y);
		
		JFrame fenetre = new JFrame("Taquin");

		MoteurJeu mj = new MoteurJeu(jeu, moteur);

		fenetre.setVisible(true);
	}

}
