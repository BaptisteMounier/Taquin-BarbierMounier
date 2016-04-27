package jeu;

import java.util.ArrayList;

public class Etat {
	
	private Plateau plateau;
	private int cout;
	private int manhattan;
	private int malPlacee;
	private int mini;
	private Etat antecedent;
	
	public Etat(Plateau p, int c, Etat a){
		this.plateau = p;
		this.cout = c;
		this.antecedent = a;
		this.manhattan = this.plateau.manhattan();
		this.malPlacee = this.plateau.malPlacee();
		this.mini = this.cout + this.manhattan + this.malPlacee;
	}
	
	public int getMini(){
		return this.mini;
	}
	
	public ArrayList<Etat> successeur(){
		ArrayList<Etat> successeur = new ArrayList<Etat>();
		Plateau successeurUp = new Plateau(this.plateau);
		if(successeurUp.moveUp())
			successeur.add(new Etat(successeurUp, this.cout+1, this));
		Plateau successeurDown = new Plateau(this.plateau);
		if(successeurDown.moveDown())
			successeur.add(new Etat(successeurDown, this.cout+1, this));
		Plateau successeurLeft = new Plateau(this.plateau);
		if(successeurLeft.moveLeft())
			successeur.add(new Etat(successeurLeft, this.cout+1, this));
		Plateau successeurRight = new Plateau(this.plateau);
		if(successeurRight.moveRight())
			successeur.add(new Etat(successeurRight, this.cout+1, this));
		return successeur;
	}

	public boolean resolu() {
		return this.plateau.resolu();
	}

}
