package jeu;

import java.util.ArrayList;
import java.util.Scanner;

import exceptions.WinException;

public class Jeu {
	
	private Plateau plateau;
	private int taille;
	private ArrayList<Integer> idTuiles;
	private int nbTuileX;
	private int nbTuileY;
	private int nbMelange;
	
	public Jeu(){
		this.plateau = null;
		this.taille = 4;
		this.nbTuileX = this.taille;
		this.nbTuileY = this.taille;
		this.nbMelange = 100;
		this.idTuiles = new ArrayList<Integer>();
		for(int i = 1;i <= this.nbTuileX*this.nbTuileY;i++){
			this.idTuiles.add(this.idTuiles.size(), i);
		}
	}
	
	public void initialisation(){
		Tuile[][] tuiles = new Tuile[nbTuileX][nbTuileY];
		int id = 1;
		for (int i=0; i < nbTuileX; i++){
			for (int j=0; j < nbTuileY; j++){
				tuiles[j][i]= new Tuile(id);
				id++;
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
		Scanner sc = new Scanner(System.in);
		System.out.println("Quel déplacement souhaitez-vous ?");
		String com = sc.nextLine();
		this.commande(com);
		this.affiche();
		this.end();
	}
	
	public void commande(String c){
		boolean find = false;
		switch(c){
		case "z":
			for(int i = 0;i < this.nbTuileX && !find;i++){
				for(int j = 0;j < this.nbTuileY-1 && !find;j++){
					if(this.plateau.GetTuiles()[i][j].getIndice() == this.nbTuileX*this.nbTuileY){
						this.plateau.switchTuiles(i, j, i, j+1);
						find = true;
					}
				}
			}
			break;
		case "s":
			for(int i = 0;i < this.nbTuileX && !find;i++){
				for(int j = 1;j < this.nbTuileY && !find;j++){
					if(this.plateau.GetTuiles()[i][j].getIndice() == this.nbTuileX*this.nbTuileY){
						this.plateau.switchTuiles(i, j, i, j-1);
						find = true;
					}
				}
			}
			break;
		case "q":
			for(int i = 0;i < this.nbTuileX-1 && !find;i++){
				for(int j = 0;j < this.nbTuileY && !find;j++){
					if(this.plateau.GetTuiles()[i][j].getIndice() == this.nbTuileX*this.nbTuileY){
						this.plateau.switchTuiles(i, j, i+1, j);
						find = true;
					}
				}
			}
			break;
		case "d":
			for(int i = 1;i < this.nbTuileX && !find;i++){
				for(int j = 0;j < this.nbTuileY && !find;j++){
					if(this.plateau.GetTuiles()[i][j].getIndice() == this.nbTuileX*this.nbTuileY){
						this.plateau.switchTuiles(i, j, i-1, j);
						find = true;
					}
				}
			}
			break;
		case "ai":
			break;
		case "aiFull":
			break;
		case "cheat":
			break;
		default:
			break;
		}
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
	
	public int getTailleX(){
		return this.nbTuileX;
	}
	
	public int getTailleY(){
		return this.nbTuileY;
	}
	
	public void end() throws WinException{
		boolean gagne = true;
		int cpt = 1;
		Tuile[][] tuiles = this.getTuiles();
		for(int i = 0;i < tuiles.length;i++){
			for(int j = 0;j < tuiles[i].length;j++){
				if(tuiles[j][i].getIndice()!=cpt)
					gagne = false;
				cpt++;
			}
		}
		if(gagne)
			throw new WinException();
	}
	
	public void affiche(){
		Tuile[][] tuiles = this.getTuiles();
		for(int i = 0;i < tuiles.length;i++){
			for(int j = 0;j < tuiles[i].length;j++){
				System.out.print(tuiles[j][i]+" ");
			}
			System.out.print("\n");
		}
		System.out.print("==========\n");
	}

}