package jeu;

import java.util.Scanner;
import java.util.Stack;

import exceptions.WinException;

public class Jeu {
	
	private Plateau plateau;
	private int taille;
	private int nbMelange;
	private int nbCoups;
	private Ai ai;
	private Joueur joueur;
	
	public Jeu(){
		this.plateau = null;
		this.taille = 4;
		this.nbMelange = 10;
		this.ai = new Ai();
		this.joueur = new Joueur();
	}
	
	public Jeu(Jeu jeu){
		this.plateau = null;
		this.taille = jeu.getTaille();
		this.nbMelange = jeu.getNbMelange();
		this.ai = jeu.getAi();
		this.joueur = jeu.getJoueur();
		Tuile[][] tuiles = new Tuile[this.taille][this.taille];
		for (int j=0; j < this.taille; j++){
			for (int i=0; i < this.taille; i++){
				int id = jeu.getPlateau().GetTuiles()[i][j].getIndice();
				tuiles[i][j] = new Tuile(id,jeu.getPlateau().GetTuiles()[i][j].getXObjectif(),jeu.getPlateau().GetTuiles()[i][j].getYObjectif());
			}
		}
		this.plateau = new Plateau(tuiles);
	}

	public void initialisation(){
		Tuile[][] tuiles = new Tuile[this.taille][this.taille];
		int id = 1;
		for (int j=0; j < this.taille; j++){
			for (int i=0; i < this.taille; i++){
				tuiles[i][j]= new Tuile(id,i,j);
				id++;
				//System.out.println(tuiles[i][j].getIndice()+" "+tuiles[i][j].getXObjectif()+" "+tuiles[i][j].getYObjectif());
			}
		}
		this.plateau = new Plateau(tuiles);
		this.melanger();
		this.affiche();
	}
	
	public void melanger(){
		for(int i = 0;i < this.nbMelange;i++){
			int alea = (int)(Math.random()*4);
			switch (alea){
				case 0:
					this.commande("z");
					break;
				case 1:
					this.commande("s");
					break;
				case 2:
					this.commande("q");
					break;
				case 3:
					this.commande("d");
					break;
			}
		}
	}
	
	public void pas() throws WinException{
		String com = this.joueur.pas();
		this.commande(com);
		this.affiche();
		this.end();
	}
	
	public void commande(String string){
		boolean find = false;
		String[] commande = string.split(" ");
		switch(commande[0]){
		case "z":
			for(int j = 0;j < this.taille-1 && !find;j++){
				for(int i = 0;i < this.taille && !find;i++){
					if(this.plateau.GetTuiles()[i][j].getIndice() == this.taille*this.taille){
						this.plateau.switchTuiles(i, j, i, j+1);
						find = true;
					}
				}
			}
			break;
		case "s":
			for(int i = 0;i < this.taille && !find;i++){
				for(int j = 1;j < this.taille && !find;j++){
					if(this.plateau.GetTuiles()[i][j].getIndice() == this.taille*this.taille){
						this.plateau.switchTuiles(i, j, i, j-1);
						find = true;
					}
				}
			}
			break;
		case "q":
			for(int i = 0;i < this.taille-1 && !find;i++){
				for(int j = 0;j < this.taille && !find;j++){
					if(this.plateau.GetTuiles()[i][j].getIndice() == this.taille*this.taille){
						this.plateau.switchTuiles(i, j, i+1, j);
						find = true;
					}
				}
			}
			break;
		case "d":
			for(int i = 1;i < this.taille && !find;i++){
				for(int j = 0;j < this.taille && !find;j++){
					if(this.plateau.GetTuiles()[i][j].getIndice() == this.taille*this.taille){
						this.plateau.switchTuiles(i, j, i-1, j);
						find = true;
					}
				}
			}
			break;
		case "ai":
			this.aide(Integer.parseInt(commande[1]));
			break;
		case "stop":
			System.out.println("STOP");
			break;
		case "cheat":
			System.out.println("CHEAT");
			break;
		default:
			break;
		}
	}
	
	public void aide(int nb){
		this.ai.aide(this, nb);
	}
	
	public Plateau getPlateau(){
		return this.plateau;
	}
	
	public Tuile[][] getTuiles(){
		return this.plateau.GetTuiles();
	}

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}
	
	public void end() throws WinException{
		boolean gagne = true;
		int cpt = 1;
		Tuile[][] tuiles = this.getTuiles();
		for(int j = 0;j < tuiles.length;j++){
			for(int i = 0;i < tuiles[j].length;i++){
				if(tuiles[i][j].getIndice()!=cpt)
					gagne = false;
				cpt++;
			}
		}
		if(gagne)
			throw new WinException();
	}
	
	public void affiche(){
		Tuile[][] tuiles = this.getTuiles();
		for(int j = 0;j < tuiles.length;j++){
			for(int i = 0;i < tuiles[j].length;i++){
				System.out.print(tuiles[i][j]+" ");
			}
			System.out.print("\n");
		}
		System.out.print("==========\n");
	}

	public int getTaille() {
		return this.taille;
	}

	public int getNbMelange() {
		return nbMelange;
	}

	public void setNbMelange(int nbMelange) {
		this.nbMelange = nbMelange;
	}

	public int getNbCoups() {
		return nbCoups;
	}

	public void setNbCoups(int nbCoups) {
		this.nbCoups = nbCoups;
	}

	public Ai getAi() {
		return ai;
	}

	public void setAi(Ai ai) {
		this.ai = ai;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

}