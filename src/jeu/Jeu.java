package jeu;

import java.util.ArrayList;

public class Jeu {
	
	private Plateau plateau;
	private ArrayList<Tuile> tuiles;
	
	public Jeu(){
		this.plateau = null;
		this.tuiles = new ArrayList<Tuile>();
	}
	
	public Plateau getPlateau(){
		return this.plateau;
	}
	
	public ArrayList<Tuile> getTuiles(){
		return this.tuiles;
	}

}
