package graphique;

import java.util.ArrayList;

import jeu.*;

public class MoteurGraphique {
	
	private int largeur;
	private int hauteur;
	private Plateau plateau;
	private Tuile[][] tuiles;
	
	public MoteurGraphique(Plateau plateau, Tuile[][] tuiles, int largeur, int hauteur){
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.plateau = plateau;
		this.tuiles = tuiles;
	}
	
	public void Affiche(){
		
	}
	
	public void AffichePlateau(){
		
	}
	
}