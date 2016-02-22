package jeu;

import java.util.ArrayList;

public class Jeu {
	
	private Plateau plateau;
	private Tuile[][] tuiles;
	
	public Jeu(){
		this.plateau = null;
		this.tuiles = new Tuile[4][4];
	}
	
	public Plateau getPlateau(){
		return this.plateau;
	}
	
	public Tuile[][] getTuiles(){
		return this.tuiles;
	}
	
	public void initialisation(){
		this.tuiles[0][0] = new Tuile(1);
		this.tuiles[0][1] = new Tuile(2);
		this.tuiles[0][2] = new Tuile(3);
		this.tuiles[0][3] = new Tuile(4);
		this.tuiles[1][0] = new Tuile(5);
		this.tuiles[1][1] = new Tuile(6);
		this.tuiles[1][2] = new Tuile(7);
		this.tuiles[1][3] = new Tuile(8);
		this.tuiles[2][0] = new Tuile(9);
		this.tuiles[2][1] = new Tuile(10);
		this.tuiles[2][2] = new Tuile(11);
		this.tuiles[2][3] = new Tuile(12);
		this.tuiles[3][0] = new Tuile(13);
		this.tuiles[3][1] = new Tuile(14);
		this.tuiles[3][2] = new Tuile(15);
		this.tuiles[3][3] = new Tuile(16);
		this.plateau = new Plateau(this.tuiles);
	}
	
	public void Pas(){
		
	}

}
