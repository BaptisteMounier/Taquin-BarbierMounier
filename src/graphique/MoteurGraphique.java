package graphique;

import java.util.ArrayList;

import jeu.*;

public class MoteurGraphique {
	
	private int largeur;
	private int hauteur;
	private Plateau plateau;
	private ArrayList<Tuile> tuiles;
	
	public MoteurGraphique(Plateau p, ArrayList<Tuile> t, int l, int h){
		this.largeur = l;
		this.hauteur = h;
		this.plateau = p;
		this.tuiles = t;
	}
	
}