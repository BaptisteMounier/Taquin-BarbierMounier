package jeu;

import application.*;
import exceptions.WinException;

/**
 * Classe gèrant la boucle de jeu et le début de la partie
 */
public class MoteurJeu {
	
	/**
	 * Attribut correspondant au Jeu
	 */
	private Jeu jeu;
	
	/**
	 * Constructeur à partir d un Jeu
	 * @param j Jeu
	 */
	public MoteurJeu(Jeu j){
		this.jeu = j;
	}
	
	/**
	 * Methode de la boucle de jeu
	 */
	public void play(){
		try{
			jeu.initialisation();
			while(true){
				jeu.pas();
			}
		} catch (WinException e) {
			System.out.println("Victoire !");
			this.newGame();
		}
	}
	
	/**
	 * Methode relance une nouvelle partie
	 */
	public void newGame(){
		System.out.println("Nouvelle partie !");
		this.play();
	}
	
}
