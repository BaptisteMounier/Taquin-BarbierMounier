package jeu;

import java.util.Stack;

public class Ai extends Joueur{
	
	private Stack listeComplete;

	public Plateau aidePartielle(Plateau plateau, int nb) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Plateau aideComplete(Plateau plateau){
		return plateau;
	}
	
	public void setListeComplete(Stack stack){
		this.listeComplete = stack;
	}
	
	public Stack getListeComplete(){
		return this.listeComplete;
	}

	public void aide(Jeu jeu, int nb) {
		for(int iteration = 0;iteration < nb;iteration++){
			int base = jeu.getPlateau().manhattan();
			
		}
	}

}
