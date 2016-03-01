package jeu;

import application.*;

public class MoteurJeu {
	
	public final static int FPS = 60;
	private Jeu jeu;
	
	public MoteurJeu(Jeu j){
		this.jeu = j;
	}
	
	public void play(){
		jeu.initialisation();
		while(true){
			jeu.Pas();
		}
	}
	
}
