package jeu;

import application.*;
import exceptions.WinException;

public class MoteurJeu {
	
	public final static int FPS = 60;
	private Jeu jeu;
	
	public MoteurJeu(Jeu j){
		this.jeu = j;
	}
	
	public void play(){
		try{
			jeu.initialisation();
			while(true){
				jeu.pas();
			}
		} catch (WinException e) {
			System.out.println("Victoire !");
			// affichage écran de victoire
			this.newGame();
		}
	}
	
	public void newGame(){
		System.out.println("Nouvelle partie !");
		this.play();
	}
	
}
