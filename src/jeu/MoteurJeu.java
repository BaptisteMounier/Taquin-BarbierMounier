package jeu;

import graphique.*;

public class MoteurJeu {
	
	public final static int FPS = 60;
	private Jeu jeu;
	private MoteurGraphique moteurGraphique;
	
	public MoteurJeu(Jeu j, MoteurGraphique mg){
		this.jeu = j;
		this.moteurGraphique = mg;
	}
	
	public void play(){
		long timeDebut = System.currentTimeMillis();
		long timeFin;
		long timeDebutAction;
		long timeAction;
	}
	
}
